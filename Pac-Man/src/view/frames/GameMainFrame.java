package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import control.file_processing.LogDB;
import control.listeners.ChatNachrichtfeldListener;
import control.listeners.ChatSendenButtonListener;
import control.listeners.SteuerungListener;
import control.listeners.WindowClosingListener;
import model.chat.Client;
import model.chat.EigehendReader;
import model.chat.Server;
import model.interfaces.IWindowProperties;
import view.characters.Geister;
import view.characters.Spieler;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public final class GameMainFrame extends JFrame implements IWindowProperties
{
	private static JFrame jfFrame;
	private static JTextArea taTextArea = new JTextArea();
	private static JTextField tfTextField = new JTextField("Nachricht eingeben");
	private static JPanel pSpieler = new JPanel();
	
	private static int iSpielerX;
	private static int iSpielerY;
	
	private static boolean bSpielerAktiv = false;
	private static boolean bGeist = false;
	private static boolean bPacMan = false;
	
	private static Spieler oSpieler = new Spieler();
	
	private Geister oGeist = new Geister();
	
	private Timer oTimer = new Timer();
	
	private ArrayList<String> alSpielfeldArrayList;
	
	private int iGeistX;
	private int iGeistY;
	private int iLayoutZeilen = 28;
	private int iLayoutSpalten = 33;
	private int iFeld = -1;
	private int iZaehler = 0;
	
	private Icon oIconGreeny = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private Icon oIconBlue = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private Icon oIconOrangy = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private Icon oIconPinky = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
	private Icon oIconPacMan = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_small.PNG")));
	
	private JLabel lGreeny = new JLabel(oIconGreeny);
	private JLabel lBlue = new JLabel(oIconBlue);
	private JLabel lOrangy = new JLabel(oIconOrangy);
	private JLabel lPinky = new JLabel(oIconPinky);
	private JLabel lPacMan = new JLabel(oIconPacMan);
	
	private JPanel[][] aPanelArray = new JPanel[50][50];
	private JPanel pGeist = new JPanel();
	private JPanel pSpielfeldPanel = new JPanel();
	private JPanel pChatPanel = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	private JLabel lSpielstandlabel = new JLabel();
	private JButton jbTextSendenButton = new JButton("SENDEN");
	
	private LogDB oLogdb = new LogDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	
	private Server oServer;
	private Client oClient = new Client();

	/**
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
	 */
	public GameMainFrame()
	{
		initialize();
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public void initialize()
	{
		jfFrame = this;
		
		Font defaultFont = new Font("Segoe UI", Font.PLAIN, 15);
		
		setTitle("Pac-Man");
		setSize(frameWidth, frameHeight);
		setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowClosingListener(this));
		
		timerStarten();
		
		oClient.netzwerkEinrichten();
		
		Thread readerThread = new Thread(new EigehendReader());
		readerThread.start();
		
		alSpielfeldArrayList = oLogdb.getArrayList();
		
		GridLayout oSpielFeldLayout = new GridLayout(iLayoutZeilen, iLayoutSpalten);
		pSpielfeldPanel.setLayout(oSpielFeldLayout);
		pSpielfeldPanel.addKeyListener(new SteuerungListener());
		
		lSpielstandlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lSpielstandlabel.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		lSpielstandlabel.setForeground(Color.blue);
		lSpielstandlabel.setText(getSpielstandlabelText());
		
		pChatPanel.setSize(200, 200);	
		pChatPanel.setLayout(new BorderLayout());
		
		jbTextSendenButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbTextSendenButton.addActionListener(new ChatSendenButtonListener());
		
		taTextArea.setEditable(false);
		taTextArea.setLineWrap(true);
		taTextArea.setWrapStyleWord(true);
		taTextArea.setFont(defaultFont);
		
		JScrollPane scrollPane = new JScrollPane(taTextArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		pChatKomponentenPanel.add(tfTextField);
		pChatKomponentenPanel.add(jbTextSendenButton);
		
		pChatPanel.add(scrollPane, BorderLayout.CENTER);
		pChatPanel.add(pChatKomponentenPanel, BorderLayout.SOUTH);
		
		add(lSpielstandlabel, BorderLayout.NORTH);
		add(pSpielfeldPanel, BorderLayout.CENTER);
		add(pChatPanel, BorderLayout.WEST);
		
		tfTextField.setHorizontalAlignment(SwingConstants.LEADING);
		tfTextField.setColumns(10);
		tfTextField.setFont(defaultFont);
		tfTextField.addKeyListener(new ChatNachrichtfeldListener());
		tfTextField.addFocusListener(new ChatNachrichtfeldListener());
		
		for (int iZeile = 0; iZeile < iLayoutZeilen; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < iLayoutSpalten; iSpalte++)
			{
				iFeld++;
				if(alSpielfeldArrayList.size() > iFeld)
				{
					if(alSpielfeldArrayList.get(iFeld).equals("0"))
					{
						guiDarstellen(iZeile, iSpalte);
					}
					if(alSpielfeldArrayList.get(iFeld).equals("1"))
					{
						guiDarstellen(iZeile, iSpalte, Color.blue);
					}
					if(alSpielfeldArrayList.get(iFeld).equals("2"))
					{
						guiDarstellen(iZeile, iSpalte);
						bGeist = true;
					}
					if(alSpielfeldArrayList.get(iFeld).equals("3"))
					{
						guiDarstellen(iZeile, iSpalte);
						bPacMan = true;
					}
				}
				else
				{
					break;
				}
			}
		}
		repaint();
	}
	
	//-------------------------------------------------------------------------------------------------------------------

	public void guiDarstellen(int iZeilenAnz, int iSpaltenAnz)
	{
		guiDarstellen(iZeilenAnz, iSpaltenAnz, Color.black);
	}

	//-------------------------------------------------------------------------------------------------------------------

	public void guiDarstellen(int iZeilenAnz, int iSpaltenAnz, Color cFarbe)
	{
		aPanelArray[iZeilenAnz][iSpaltenAnz] = new JPanel();
		aPanelArray[iZeilenAnz][iSpaltenAnz].addKeyListener(new SteuerungListener());
		aPanelArray[iZeilenAnz][iSpaltenAnz].setBackground(cFarbe);
		//-----------------------------------------------------------------------
		if(bGeist)
		{
			switch(iZaehler)
			{
				case 1: aPanelArray[iZeilenAnz][iSpaltenAnz].add(lGreeny); break;
				case 2:	aPanelArray[iZeilenAnz][iSpaltenAnz].add(lBlue); break;
				case 3:	aPanelArray[iZeilenAnz][iSpaltenAnz].add(lOrangy); break;
				case 4:	aPanelArray[iZeilenAnz][iSpaltenAnz].add(lPinky); break;
			}
			iZaehler++;
			bGeist = false;
		}
		//-----------------------------------------------------------------------
		if(bPacMan)
		{
			aPanelArray[iZeilenAnz][iSpaltenAnz].add(lPacMan);
			bPacMan = false;
		}
		//-----------------------------------------------------------------------
		pSpielfeldPanel.add(aPanelArray[iZeilenAnz][iSpaltenAnz]);
	}
	
	//-------------------------------------------------------------------------------------------------------------------

	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll gestartet
	 */
	public void timerStarten()
	{
		TimerTask oTimerTask = new Task();		// Hier wird ein Objekt der Klasse Task, welche von der Klasse Timertask erbt, erzeugt.
		oTimer.schedule(oTimerTask, 0, 150);	// Hier wird angegeben, wie oft die Methode run in der Unterklasse pro Sekunde aufgerufen werden soll.
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static String getSpielstandlabelText()
	{
		return "Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + oSpieler.getLeben() + "  ||  Punkte: " + String.format("%,.0f", oSpieler.getPunktestand());
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextField getTextfeld()
	{
		return tfTextField;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextArea getArea()
	{
		return taTextArea;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
			
	public static JPanel getSpieler()
	{
		return pSpieler;
	}
		
	//-------------------------------------------------------------------------------------------------------------------
		
	public static GameMainFrame getFrame()
	{
		return (GameMainFrame) jfFrame;
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static void chattextAnzeigen()
	{
		String placeholder = "====================\n";
		String startOfMessage = "---------------------------------\n";
		String username = startOfMessage + LogInFrame.getUsername() + ":\n" + placeholder;
		
		if(!(tfTextField.getText().isEmpty()) && !tfTextField.getText().equals("Nachricht eingeben"))
		{
			if(taTextArea.getText().contains("IP-Adresse gesendet") &&
			   taTextArea.getText().contains("Netzwerkverbindung steht") &&
			   taTextArea.getText().contains("habe eine Verbindung"))
			{
				taTextArea.setText(null);
				taTextArea.setText(username + taTextArea.getText() + tfTextField.getText() + "\n" + placeholder);
				tfTextField.setText(null);
			}
			else
			{
				taTextArea.setText(taTextArea.getText() + "\n\n" + username + tfTextField.getText() + "\n" + placeholder);
				tfTextField.setText(null);
			}
		}
	}
	
	//-------------------------------------------------------------------------------------------------------------------
		
	public static void spielerRunter()
	{
		iSpielerY = pSpieler.getY();
		iSpielerY = oSpieler.SpielerRaufBewegen(iSpielerY);
		pSpieler.setLocation(pSpieler.getX(), iSpielerY);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerRauf()
	{
		iSpielerY = pSpieler.getY();
		iSpielerY = oSpieler.SpielerRunterBewegen(iSpielerY);
		pSpieler.setLocation(pSpieler.getX(), iSpielerY);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerLinks()
	{
		iSpielerX = pSpieler.getX();
		iSpielerX = oSpieler.SpielerLinksBewegen(iSpielerX);
		pSpieler.setLocation(iSpielerX, pSpieler.getY());
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerRechts()
	{
		iSpielerX = pSpieler.getX();
		iSpielerX = oSpieler.SpielerRechtsBewegen(iSpielerX);
		pSpieler.setLocation(iSpielerX, pSpieler.getY());
		bSpielerAktiv = true;
	}
	
	/**
	 * In dieser Klasse befindet sich die Methode run, welche für die Bewegung des Geistes zuständig ist.
	 * @author Thomas Mader-Ofer
	 *
	 */
	private class Task extends TimerTask
	{
		public void run()
		{			
			if(!tfTextField.getText().isEmpty() && !tfTextField.getText().equals("Nachricht eingeben"))
			{
				oClient.senden();
				Server.esAllenWeitersagen(tfTextField.getText());
			}			
			
			if(bSpielerAktiv)
			{
				/*
				iGeisty = pGeist.getY();
				iGeistx = pGeist.getX();
				
				Random zufallsZahl = new Random();	// zufallszahl für die Bewegung des Geistes generiern 
				int index = zufallsZahl.nextInt(8) + 1;
				
				for(int iZaehler = 0; iZaehler <= 4; iZaehler++)
				{
					switch(index)
					{
						case 1:	oGeist.GeisterRaufBewegen(iGeisty); break;
						case 2:	oGeist.GeisterRunterBewegen(iGeisty); break;
						case 3:	oGeist.GeisterRechtsBewegen(iGeistx); break;
						case 4:	oGeist.GeisterLinksBewegen(iGeistx); break;
						case 5:	oGeist.GeisterRaufBewegen(iGeisty); break;
						case 6:	oGeist.GeisterRunterBewegen(iGeisty); break;
						case 7:	oGeist.GeisterRechtsBewegen(iGeistx); break;
						case 8:	oGeist.GeisterLinksBewegen(iGeistx); break;
					}
				}
				
				if((oGeist.getPosX() == iSpielerx) && (oGeist.getPosY() == iSpielery))
				{
					GameLostFrame oFrame = new GameLostFrame();	
				}
				
				setBackground(Color.WHITE);
				pGeist.setLocation(oGeist.getPosX(), oGeist.getPosY());
				pGeist.repaint();*/
			}
		}
	}
}