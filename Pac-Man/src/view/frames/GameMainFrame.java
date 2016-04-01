package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import model.chat.ClientHandler;
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
@SuppressWarnings("serial")
public final class GameMainFrame extends JFrame implements IWindowProperties
{
	private static JFrame jfFrame;
	private static JTextArea taTextArea = new JTextArea();
	private static JTextField tfTextField = new JTextField("Nachricht eingeben");
	private static JPanel pSpieler = new JPanel();
	private static JLabel lSpielstandlabel = new JLabel();
	private static JButton jbTextSendenButton = new JButton("SENDEN");
	
	private static int iSpielerX;
	private static int iSpielerY;
	
	private static boolean bSpielerAktiv = false;
	private static boolean bGeist = false;
	private static boolean bPacMan = false;
	private static boolean bClassicCoin = false;
	private static boolean bEatingCoin = false;
	
	private static Spieler oSpieler = new Spieler();
	
	private Geister oGeist = new Geister();
	
	private Timer oTimer = new Timer();
	
	private ArrayList<String> alSpielfeldArrayList;
	
	private int iGeistX;
	private int iGeistY;
	private int iFeld = -1;
	private int iZaehler = 1;
	
	private Icon oIconGreeny = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private Icon oIconBlue = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private Icon oIconOrangy = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private Icon oIconPinky = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
	private Icon oIconPacMan = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_small.PNG")));
	private Icon oIconClassicCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/ClassicCoin.PNG")));
	private Icon oIconEatingCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/EatingCoin.PNG")));
	
	private JLabel lGreeny = new JLabel(oIconGreeny);
	private JLabel lBlue = new JLabel(oIconBlue);
	private JLabel lOrangy = new JLabel(oIconOrangy);
	private JLabel lPinky = new JLabel(oIconPinky);
	private JLabel lPacMan = new JLabel(oIconPacMan);
	private JLabel lClassicCoin = new JLabel(oIconClassicCoin);
	private JLabel lEatingCoin = new JLabel(oIconEatingCoin);
	
	private JPanel[][] aPanelArray = new JPanel[50][50];
	private JPanel pGeist = new JPanel();
	private JPanel pSpielfeldPanel = new JPanel();
	private JPanel pChatPanel = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	
	private LogDB oLogDB = new LogDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	
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
	
	private void initialize()
	{
		jfFrame = this;
		
		Font defaultFont = new Font("Segoe UI", Font.PLAIN, 15);
		
		setTitle("Pac-Man");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(WINDOW_POSITION);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowClosingListener(this));
		
		timerStarten();
		
		oClient.netzwerkEinrichten();
		
		Thread readerThread = new Thread(new EigehendReader());
		readerThread.start();
		
		alSpielfeldArrayList = oLogDB.getArrayList();
		
		GridLayout oSpielFeldLayout = new GridLayout(GUI_ROWS, GUI_COLUMNS);
		pSpielfeldPanel.setLayout(oSpielFeldLayout);
		pSpielfeldPanel.addKeyListener(new SteuerungListener());
		
		lSpielstandlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lSpielstandlabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		lSpielstandlabel.setForeground(Color.BLUE);
		lSpielstandlabel.setText(getSpielstandlabelText());
		
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

		pChatPanel.setLayout(new BorderLayout());
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
		
		spielfeldAufbauen();
		chatInformation();
	}

	//-------------------------------------------------------------------------------------------------------------------

	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll gestartet
	 */
	private void timerStarten()
	{
		TimerTask oTimerTask = new Task();		// Hier wird ein Objekt der Klasse Task, welche von der Klasse Timertask erbt, erzeugt.
		oTimer.schedule(oTimerTask, 0, 150);	// Hier wird angegeben, wie oft die Methode run in der Unterklasse pro Sekunde aufgerufen werden soll.
	}
	
	//-------------------------------------------------------------------------------------------------------------------

	private void guiDarstellen(int iZeilenAnz, int iSpaltenAnz)
	{
		guiDarstellen(iZeilenAnz, iSpaltenAnz, Color.BLACK);
	}

	//-------------------------------------------------------------------------------------------------------------------

	private void guiDarstellen(int iZeilenAnz, int iSpaltenAnz, Color cFarbe)
	{
		aPanelArray[iZeilenAnz][iSpaltenAnz] = new JPanel();
		aPanelArray[iZeilenAnz][iSpaltenAnz].addKeyListener(new SteuerungListener());
		aPanelArray[iZeilenAnz][iSpaltenAnz].setBackground(cFarbe);
		//-----------------------------------------------------------------------
		if (bGeist)
		{
			switch (iZaehler)
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
		pSpielfeldPanel.add(aPanelArray[iZeilenAnz][iSpaltenAnz]);
	}
	
	//-------------------------------------------------------------------------------------------------------------------

	private void spielfeldAufbauen()
	{
		for (int iZeile = 0; iZeile < GUI_ROWS; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < GUI_COLUMNS; iSpalte++)
			{
				iFeld++;
				//-----------------------------------------------------------------------
				if(alSpielfeldArrayList.size() > iFeld)
				{
					if(alSpielfeldArrayList.get(iFeld).equals("0"))
					{
						guiDarstellen(iZeile, iSpalte);
						bClassicCoin = true;
					}
					//---------------------------------------------
					if(alSpielfeldArrayList.get(iFeld).equals("1"))
					{
						guiDarstellen(iZeile, iSpalte, Color.BLUE);
					}
					//---------------------------------------------
					if(alSpielfeldArrayList.get(iFeld).equals("2"))
					{
						guiDarstellen(iZeile, iSpalte);
						bGeist = true;
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("3"))
					{
						guiDarstellen(iZeile, iSpalte);
						aPanelArray[iZeile][iSpalte].add(lPacMan);
						bPacMan = true;
					}
					// ---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("4"))
					{
						guiDarstellen(iZeile, iSpalte);
						/*hier gegebenfalls Quell-Code für Eating-Coins einfügen*/
						
						bEatingCoin = true;
					}
				}
				//-----------------------------------------------------------------------
				else
				{
					break;
				}
			}
		}
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	private void chatInformation()
	{
		String sInfoTest;
		String sTitel;
		int iOptionType;
		int iMessageType;
		int iOptionPane;
		//-----------------------------------------------------------------------
		if (hasSuccessfulChatConnection())
		{
			sInfoTest = "Der Chat wurde erfolgreich eingerichtet\u0021\n"
					  + "\n"
					  + "Sie k\u00F6nnen nun mit anderen Spielteilnehmern kommunizieren\u002E";
			//---------------------------------
			sTitel = "Chat\u00ADInformation";
			//---------------------------------
			iOptionType = JOptionPane.OK_OPTION;
			//---------------------------------
			iMessageType = JOptionPane.INFORMATION_MESSAGE;
			//---------------------------------
			Object[] oOptionen = {"OK"};
			//---------------------------------
			iOptionPane = JOptionPane.showOptionDialog(this, sInfoTest, sTitel, iOptionType, iMessageType, null, oOptionen, oOptionen[0]);
		}
		//-----------------------------------------------------------------------
		else
		{
			sInfoTest = "Beim Einrichten des Chats ist ein Fehler aufgetreten\u0021\n"
					  + "Wenn Sie den Chat nutzen m\u00F6chten\u002C starten Sie das Spiel bitte neu\u002E\n"
					  + "\n"
					  + "M\u00F6chten Sie das Spiel jetzt neu starten oder beenden\u003F";
			//---------------------------------
			sTitel = "Fehler bei Chat\u00ADVerbindung";
			//---------------------------------
			iOptionType = JOptionPane.YES_NO_CANCEL_OPTION;
			//---------------------------------
			iMessageType = JOptionPane.WARNING_MESSAGE;
			//---------------------------------
			Object[] oOptionen = {"Neu starten", "Beenden", "Abbrechen"};
			//---------------------------------
			iOptionPane = JOptionPane.showOptionDialog(this, sInfoTest, sTitel, iOptionType, iMessageType, null, oOptionen, oOptionen[0]);
			//=================================
			if (iOptionPane == JOptionPane.YES_OPTION)
			{
				getGameMainFrame().dispose();
				new GameMainFrame();
			}
			//=================================
			if (iOptionPane == JOptionPane.NO_OPTION)
			{
				getGameMainFrame().dispose();
				System.exit(0);
			}
		}
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	private boolean hasSuccessfulChatConnection()
	{
		if (Server.isConnected() && Client.hasIPsuccessfullySent() && Client.hasNetzworkConnection() && ClientHandler.hasInitialized())
		{
			tfTextField.setEnabled(true);
			jbTextSendenButton.setEnabled(true);
			return true;
		}
		else
		{
			tfTextField.setEnabled(false);
			jbTextSendenButton.setEnabled(false);
			return false;
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

	//-------------------------------------------------------------------------------------------------------------------
	
	public static void chattextAnzeigen()
	{
		String  keepSpace = "\n\n";
		String  placeholder = "\n====================\n";
		String  username = LogInFrame.getUsername() + ":";
		String  startOfMessage = "---------------------------------\n";
		String  message = startOfMessage + username + placeholder + tfTextField.getText() + placeholder;
		
		if (!tfTextField.getText().isEmpty() && !tfTextField.getText().equals("Nachricht eingeben"))
		{
			taTextArea.setText(taTextArea.getText() + message + keepSpace);
			tfTextField.setText(null);
		}
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static void setSpielstandlabelText(int iLeben, double dPunkte)
	{
		Spieler.setLeben(iLeben);
		Spieler.setPunktestand(dPunkte);
		lSpielstandlabel.setText(getSpielstandlabelText());
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static String getSpielstandlabelText()
	{
		return "Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + Spieler.getLeben() + "  ||  Punkte: " + String.format("%,.0f", Spieler.getPunktestand());
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextField getChatnachrichtTextfeld()
	{
		return tfTextField;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextArea getChatverlaufTextarea()
	{
		return taTextArea;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
			
	public static JPanel getSpieler()
	{
		return pSpieler;
	}
		
	//-------------------------------------------------------------------------------------------------------------------
		
	public static GameMainFrame getGameMainFrame()
	{
		return (GameMainFrame) jfFrame;
	}

	//-------------------------------------------------------------------------------------------------------------------

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
				Server.allenWeitersagen(tfTextField.getText());
			}			
			/*
			if(bSpielerAktiv)
			{ 
				
				Random zufallsZahl = new Random();	// zufallszahl für die Bewegung des Geistes generiern 
				int index = zufallsZahl.nextInt(8) + 1;
				/*
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
				for (int iZeile = 0; iZeile < iLayoutZeilen; iZeile++)
				{
					for (int iSpalte = 0; iSpalte < iLayoutSpalten; iSpalte++)
					{
						iFeld++;
						if(alSpielfeldArrayList.size() > iFeld)
						{
							if(aPanelArray[iLayoutZeilen][iLayoutSpalten].getBackground() == Color.black)
							{
								
							}
							
						}
						else
						{
							break;
						}
					}
				}
				repaint();
				
				if((oGeist.getPosX() == iSpielerx) && (oGeist.getPosY() == iSpielery))
				{
					GameLostFrame oFrame = new GameLostFrame();	
				}
				
				setBackground(Color.WHITE);
				pGeist.setLocation(oGeist.getPosX(), oGeist.getPosY());
				pGeist.repaint();

			}*/
			
		}
	}
}