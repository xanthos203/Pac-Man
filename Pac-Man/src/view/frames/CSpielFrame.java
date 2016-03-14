package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import control.file_processing.CLogDB;
import control.listeners.SteuerungListener;
import control.listeners.WindowClosingListener;
import model.chat.Client;
import model.chat.EigehendReader;
import model.chat.Server;
import model.interfaces.IWindowProperties;
import view.characters.CGeister;
import view.characters.CSpieler;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public class CSpielFrame extends JFrame implements IWindowProperties
{
	private static JFrame jfFrame;
	private static JTextArea taTextArea = new JTextArea();
	private static JTextField tfTextField = new JTextField();
	private static JPanel pSpieler = new JPanel();
	
	private static int iSpielerX;
	private static int iSpielerY;
	
	private static boolean bSpielerAktiv = false;
	
	private static CSpieler oSpieler = new CSpieler();
	
	private CGeister oGeist = new CGeister();
	
	private ArrayList<String> alSpielfeldArrayList;
	
	private int iGeistX;
	private int iGeistY;
	private int iLayoutZeilen = 28;
	private int iLayoutSpalten = 33;
	private int iFeld = -1;
	
	private JPanel[][] aPanelArray;
	private JPanel pGeist = new JPanel();
	private JPanel pSpielfeldPanel = new JPanel();
	private JPanel pChatPanel = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	private JLabel lSpielstandlabel = new JLabel();
	private JButton jbTextSendenButton = new JButton("SENDEN");
	
	private Timer oTimer = new Timer();
	
	private CLogDB oLogdb = new CLogDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	
	private Server oServer;
	private Client oClient = new Client();
	
	/**
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
	 */
	public CSpielFrame()
	{
		Font defaultFont = new Font("Segoe UI", Font.PLAIN, 15);
		oClient.netzwerkEinrichten();
		Thread readerThread = new Thread(new EigehendReader());
		readerThread.start();
		Darstellen();
		
		jfFrame = this;
		alSpielfeldArrayList = oLogdb.getArrayList();
		
		setTitle("Pac-Man");
		setSize(frameWidth, frameHeight);
		setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CSpielFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowClosingListener(this));
		
		GridLayout oSpielFeldLayout = new GridLayout(iLayoutZeilen, iLayoutSpalten);
		pSpielfeldPanel.setLayout(oSpielFeldLayout);
		
		lSpielstandlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lSpielstandlabel.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		lSpielstandlabel.setForeground(Color.blue);
		lSpielstandlabel.setText("Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + oSpieler.getLeben() + "  ||  Punkte: " + String.format("%,.0f", oSpieler.getPunktestand()));
		
		add(lSpielstandlabel, BorderLayout.NORTH);
		add(pSpielfeldPanel, BorderLayout.CENTER);
		
		pChatPanel.setSize(200, 200);	
		pChatPanel.setLayout(new BorderLayout());
		jbTextSendenButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		taTextArea.setEditable(false);
		taTextArea.setLineWrap(true);
		taTextArea.setWrapStyleWord(true);
		taTextArea.setFont(defaultFont);
		pChatKomponentenPanel.add(tfTextField);
		pChatKomponentenPanel.add(jbTextSendenButton);
		JScrollPane scrollPane = new JScrollPane(taTextArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tfTextField.setSize(pChatKomponentenPanel.getWidth(), pChatKomponentenPanel.getHeight());
		tfTextField.setColumns(10);
		tfTextField.setFont(defaultFont);
		tfTextField.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					chattextAnzeigen();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		//-------------------------------------------------------
		jbTextSendenButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				chattextAnzeigen();
				tfTextField.requestFocus();
			}
		});
		//-------------------------------------------------------
		pChatPanel.add(scrollPane, BorderLayout.CENTER);
		pChatPanel.add(pChatKomponentenPanel, BorderLayout.SOUTH);
		
		add(pChatPanel, BorderLayout.WEST);
		
		setVisible(true);
		pSpielfeldPanel.addKeyListener(new SteuerungListener());
		aPanelArray = new JPanel[50][50];

		for (int iZeile = 0; iZeile < iLayoutZeilen; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < iLayoutSpalten; iSpalte++)
			{
				iFeld++;
				if(alSpielfeldArrayList.size() > iFeld)
				{
					if(alSpielfeldArrayList.get(iFeld).equals("0"))
					{
						guiDarstellen(iZeile, iSpalte, Color.black);
					}
					if(alSpielfeldArrayList.get(iFeld).equals("1"))
					{
						guiDarstellen(iZeile, iSpalte, Color.blue);
					}
					if(alSpielfeldArrayList.get(iFeld).equals("2"))
					{
						guiDarstellen(iZeile, iSpalte, Color.gray);
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

	//----------------------------------------------------------------------------------

	public void guiDarstellen(int iZeilenAnz, int iSpaltenAnz, Color cFarbe)
	{
		aPanelArray[iZeilenAnz][iSpaltenAnz] = new JPanel();
		aPanelArray[iZeilenAnz][iSpaltenAnz].addKeyListener(new SteuerungListener());
		aPanelArray[iZeilenAnz][iSpaltenAnz].setBackground(cFarbe);
		pSpielfeldPanel.add(aPanelArray[iZeilenAnz][iSpaltenAnz]);
	}
	
	//----------------------------------------------------------------------------------

	public void chattextAnzeigen()
	{
		String placeholder = "====================\n";
		String endOfMessage = "\n---------------------------------";
		String username = placeholder + LogInFrame.getUsername() + ":\n" + placeholder;
		
		if(!(tfTextField.getText().isEmpty()))
		{
			if(taTextArea.getText().isEmpty())
			{
				taTextArea.setText(username + taTextArea.getText() + tfTextField.getText() + endOfMessage);
				tfTextField.setText(null);
			}
			else
			{
				taTextArea.setText(taTextArea.getText() + "\n\n" + username + tfTextField.getText() + endOfMessage);
				tfTextField.setText(null);
			}
		}
	}
	
	//----------------------------------------------------------------------------------
	
	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll gestartet
	 */
	public void Darstellen()
	{
		TimerTask oTimerTask = new Task();		// Hier wird ein Objekt der Klasse Task, welche von der Klasse Timertask erbt, erzeugt.
		oTimer.schedule(oTimerTask, 0, 150);	// Hier wird angegeben, wie oft die Methode run in der Unterklasse pro Sekunde aufgerufen werden soll.
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextField getSchreibFeld()
	{
		return tfTextField;
	}
	
	//----------------------------------------------------------------------------------
	
	public static JTextArea getArea()
	{
		return taTextArea;
	}
	
	//----------------------------------------------------------------------------------
			
	public static JPanel getSpieler()
	{
		return pSpieler;
	}
		
	//-------------------------------------------------------------------------------------------------------------------
		
	public static CSpielFrame getFrame()
	{
		return (CSpielFrame) jfFrame;
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
			if(!tfTextField.getText().isEmpty())
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