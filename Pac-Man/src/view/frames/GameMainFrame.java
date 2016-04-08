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
	
	private Timer oTimer = new Timer();
	
	private ArrayList<String> alSpielfeldArrayList;
	
	private int iGeistX;
	private int iGeistY;
	private int iFeld = -1;
	private int iGeisterZaehler = 1;
	private int iCCoinIndex = 0;
	private int iECoinIndex = 0;
	
	private static Icon oIconGreeny = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private static Icon oIconBlue = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private static Icon oIconOrangy = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private static Icon oIconPinky = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
	private static Icon oIconPacMan = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_small.PNG")));
	private Icon oIconClassicCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/ClassicCoin.PNG")));
	private Icon oIconEatingCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/EatingCoin.PNG")));
	
	private JLabel[] aClassicCoins = new JLabel[1000];
	private JLabel[] aEatingCoins = new JLabel[500];
	public static JLabel lGreeny = new JLabel(oIconGreeny);
	public static JLabel lBlue = new JLabel(oIconBlue);
	public static JLabel lOrangy = new JLabel(oIconOrangy);
	public static JLabel lPinky = new JLabel(oIconPinky);
	public static JLabel lPacMan = new JLabel(oIconPacMan);
	
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
	/**
	 *  In dieser Methode wierd das Fenster erstellt und die einzellnen Labels und TextFelder werden Initiallisiert.
	 */
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
	/**
	 * Hier werden die ClassiCoins auf dem PanelArray zugewiesen, welches die Oberfläche erstellt.
	 * @param iZeile
	 * @param iSpalte
	 */
	private void classicCoinsDarstellen(int iZeile, int iSpalte)
	{
		aClassicCoins[iCCoinIndex] = new JLabel(oIconClassicCoin);
		aPanelArray[iZeile][iSpalte].add(aClassicCoins[iCCoinIndex]);
		iCCoinIndex++;
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die EatingCoins dem PanelArray zugewiesen, welches die Oberfläche erstellt.
	 * @param iZeile
	 * @param iSpalte
	 */
	private void eatingCoinsDarstellen(int iZeile, int iSpalte)
	{
		aEatingCoins[iECoinIndex] = new JLabel(oIconEatingCoin);
		aPanelArray[iZeile][iSpalte].add(aEatingCoins[iECoinIndex]);
		iECoinIndex++;
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird der Default wert auf Schwarz gesetzt.
	 * @param iZeile
	 * @param iSpalte
	 */
	private void guiDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte, Color.BLACK);
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird die von der guiDarstellen Methode geänderte Farbe verwendet um den Hintergrund auf diese Farbe zu setzen.
	 * @param iZeile
	 * @param iSpalte
	 * @param cFarbe
	 */
	private void guiDarstellen(int iZeile, int iSpalte, Color cFarbe)
	{
		aPanelArray[iZeile][iSpalte] = new JPanel();
		aPanelArray[iZeile][iSpalte].addKeyListener(new SteuerungListener());
		aPanelArray[iZeile][iSpalte].setBackground(cFarbe);
		//-----------------------------------------------------------------------
		if (bGeist)
		{
			switch (iGeisterZaehler)
			{
				case 1: aPanelArray[iZeile][iSpalte].add(lGreeny); break;
				case 2:	aPanelArray[iZeile][iSpalte].add(lBlue); break;
				case 3:	aPanelArray[iZeile][iSpalte].add(lOrangy); break;
				case 4:	aPanelArray[iZeile][iSpalte].add(lPinky); break;
			}
			iGeisterZaehler++;
			bGeist = false;
		}
		//-----------------------------------------------------------------------
		pSpielfeldPanel.add(aPanelArray[iZeile][iSpalte]);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird das Spieltfeld dargestellt und die Hintergrundfarben der Panels für die Gänge wird hier gesetzt.
	 */
	private void spielfeldAufbauen()
	{
		for (int iZeile = 0; iZeile < GUI_ROWS; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < GUI_COLUMNS; iSpalte++)
			{
				iFeld++;
				//-----------------------------------------------------------------------
				if (alSpielfeldArrayList.size() > iFeld)
				{
					if (alSpielfeldArrayList.get(iFeld).equals("0"))
					{
						guiDarstellen(iZeile, iSpalte);
						classicCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("1"))
					{
						guiDarstellen(iZeile, iSpalte, Color.BLUE);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("2"))
					{
						guiDarstellen(iZeile, iSpalte);
						bGeist = true;
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("3"))
					{
						guiDarstellen(iZeile, iSpalte);
						aPanelArray[iZeile][iSpalte].add(lPacMan);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("4"))
					{
						guiDarstellen(iZeile, iSpalte);

						/*hier gegebenfalls Quell-Code für Eating-Coins einfügen*/
						
						eatingCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("5"))
					{
						guiDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("6"))
					{
						guiDarstellen(iZeile, iSpalte);
						classicCoinsDarstellen(iZeile, iSpalte);
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
	/**
	 * In dieser Methode wird ausgegeben, dass der Chat erfolgreich ausgeührt wurde oder, dass ein Fehler aufgetreten ist und es wird eine Fehlermeldung geworfen.
	 */
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
	/**
	 * Diese Methode sagt, dass der Sendebutton "Freigegeben" wird, damit eine Nachricht gesendet werden kann.
	 * @return
	 */
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
	/**
	 * In dieser Methode wird der Spieler runter bewegt und ändert somit seinen Position auf der Oberfläche.	
	 */
	public static void spielerRunter()
	{
		iSpielerY = pSpieler.getY();
		iSpielerY = Spieler.SpielerRaufBewegen(iSpielerY);
		pSpieler.setLocation(pSpieler.getX(), iSpielerY);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Klasse wird der Spieler rauf bewegt und ändert somit seinen Position auf der Oberfläche.	
	 */
	public static void spielerRauf()
	{
		iSpielerY = pSpieler.getY();
		iSpielerY = Spieler.SpielerRunterBewegen(iSpielerY);
		pSpieler.setLocation(pSpieler.getX(), iSpielerY);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach links bewegt und ändert somit seinen Position auf der Oberfläche.	
	 */
	public static void spielerLinks()
	{
		iSpielerX = pSpieler.getX();
		iSpielerX = Spieler.SpielerLinksBewegen(iSpielerX);
		pSpieler.setLocation(iSpielerX, pSpieler.getY());
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach rechts bewegt und ändert somit seinen Position auf der Oberfläche.	
	 */
	public static void spielerRechts()
	{
		iSpielerX = pSpieler.getX();
		iSpielerX = Spieler.SpielerRechtsBewegen(iSpielerX);
		pSpieler.setLocation(iSpielerX, pSpieler.getY());
		bSpielerAktiv = true;
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird der chattext Angezeigt mit Username, Platzhalter und dem StartOfMessage.
	 * 
	 */
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
	/**
	 * Hier werden die Punkte und die Leben des Spielers angezeigt.
	 * @param iLeben
	 * @param dPunkte
	 */
	public static void setSpielstandlabelText(int iLeben, double dPunkte)
	{
		Spieler.setLeben(iLeben);
		Spieler.setPunktestand(dPunkte);
		lSpielstandlabel.setText(getSpielstandlabelText());
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird der Spielstand angezeigt.
	 * @return
	 */
	public static String getSpielstandlabelText()
	{
		return "Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + Spieler.getLeben() + "  ||  Punkte: " + String.format("%,.0f", Spieler.getPunktestand());
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird die Chatnachricht returniert.
	 * @return
	 */
	public static JTextField getChatnachrichtTextfeld()
	{
		return tfTextField;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird die Text Area returniert welche weiter oben Bearbeitet wurde.
	 * @return
	 */
	public static JTextArea getChatverlaufTextarea()
	{
		return taTextArea;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird das Panel Spieler returniert.		
	 */
	public static JPanel getSpieler()
	{
		return pSpieler;
	}
		
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird das jfFrame zurückgeliefert.	
	 * @return
	 */
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
		private Geister oGeist = new Geister();
		
		public void run()
		{			
			if(!tfTextField.getText().isEmpty() && !tfTextField.getText().equals("Nachricht eingeben"))
			{
				oClient.senden();
				Server.allenWeitersagen(tfTextField.getText());
			}			
			
			if(bSpielerAktiv)
			{ 
				
				Random zufallsZahl = new Random();	// zufallszahl für die Bewegung des Geistes generiern 
				int index = zufallsZahl.nextInt(8) + 1;
				
				for(int iZaehler = 0; iZaehler <= 4; iZaehler++)
				{
					switch(index)
					{
						case 1:	oGeist.GeisterRaufBewegen(iGeistY); break;
						case 2:	oGeist.GeisterRunterBewegen(iGeistY); break;
						case 3:	oGeist.GeisterRechtsBewegen(iGeistX); break;
						case 4:	oGeist.GeisterLinksBewegen(iGeistX); break;
						case 5:	oGeist.GeisterRaufBewegen(iGeistY); break;
						case 6:	oGeist.GeisterRunterBewegen(iGeistY); break;
						case 7:	oGeist.GeisterRechtsBewegen(iGeistX); break;
						case 8:	oGeist.GeisterLinksBewegen(iGeistX); break;
					}
				}
				
				repaint();
								
				setBackground(Color.WHITE);
				

			}
			
		}
	}
}