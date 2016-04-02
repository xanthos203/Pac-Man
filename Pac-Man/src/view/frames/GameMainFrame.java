package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import control.file_processing.GuiDB;
import control.listeners.ChatNachrichtfeldListener;
import control.listeners.ChatSendenButtonListener;
import control.listeners.SteuerungListener;
import control.listeners.WindowClosingListener;
import model.chat.Client;
import model.chat.ClientHandler;
import model.chat.EigehendReader;
import model.chat.Server;
import model.interfaces.IWindowProperties;
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
	private static JTextArea taChatverlaufTextarea = new JTextArea();
	private static JTextField tfChatnachrichtTextfeld = new JTextField("Nachricht eingeben");
	private static JPanel pSpieler = new JPanel();
	private static JLabel lSpielstandlabel = new JLabel();
	private static JButton jbTextSendenButton = new JButton("SENDEN");
	
	private static int iSpielerX;
	private static int iSpielerY;
	
	private static boolean bSpielerAktiv = false;
	
	private Timer oTimer = new Timer();
	
	private ArrayList<String> alSpielfeldArrayList;
	
	private int iGeistX;
	private int iGeistY;
	private int iFeld = -1;
	private int iGeisterZaehler = 0;
	private int iCcoinIndex = 0;
	private int iEcoinIndex = 0;
	
	private Icon oIconGreeny = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private Icon oIconBlue = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private Icon oIconOrangy = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private Icon oIconPinky = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
	private Icon oIconPacMan = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_small.PNG")));
	private Icon oIconClassicCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/ClassicCoin.PNG")));
	private Icon oIconEatingCoin = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/EatingCoin.PNG")));
	
	private JLabel[] aClassicCoins = new JLabel[1000];
	private JLabel[] aEatingCoins = new JLabel[500];
	private JLabel lGreeny = new JLabel(oIconGreeny);
	private JLabel lBlue = new JLabel(oIconBlue);
	private JLabel lOrangy = new JLabel(oIconOrangy);
	private JLabel lPinky = new JLabel(oIconPinky);
	private JLabel lPacMan = new JLabel(oIconPacMan);
	
	private JPanel[][] aSpielfeldArray = new JPanel[50][50];
	private JPanel pGeist = new JPanel();
	private JPanel pSpielfeldPanel = new JPanel();
	private JPanel pChatPanel = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	
	private GuiDB oLogDB = new GuiDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	
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
		
		taChatverlaufTextarea.setEditable(false);
		taChatverlaufTextarea.setLineWrap(true);
		taChatverlaufTextarea.setWrapStyleWord(true);
		taChatverlaufTextarea.setFont(defaultFont);
		
		JScrollPane scrollPane = new JScrollPane(taChatverlaufTextarea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		pChatKomponentenPanel.add(tfChatnachrichtTextfeld);
		pChatKomponentenPanel.add(jbTextSendenButton);

		pChatPanel.setLayout(new BorderLayout());
		pChatPanel.add(scrollPane, BorderLayout.CENTER);
		pChatPanel.add(pChatKomponentenPanel, BorderLayout.SOUTH);
		
		add(lSpielstandlabel, BorderLayout.NORTH);
		add(pSpielfeldPanel, BorderLayout.CENTER);
		add(pChatPanel, BorderLayout.WEST);
		
		tfChatnachrichtTextfeld.setHorizontalAlignment(SwingConstants.LEADING);
		tfChatnachrichtTextfeld.setFont(defaultFont);
		tfChatnachrichtTextfeld.addKeyListener(new ChatNachrichtfeldListener());
		tfChatnachrichtTextfeld.addFocusListener(new ChatNachrichtfeldListener());
		
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
	 * Hier werden die ClassiCoins auf dem PanelArray zugewiesen, welches die Oberfl�che erstellt.
	 * @param iZeile
	 * @param iSpalte
	 */
	private void classicCoinsDarstellen(int iZeile, int iSpalte)
	{
		aClassicCoins[iCcoinIndex] = new JLabel(oIconClassicCoin);
		aSpielfeldArray[iZeile][iSpalte].add(aClassicCoins[iCcoinIndex]);
		iCcoinIndex++;
	}

	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die EatingCoins dem PanelArray zugewiesen, welches die Oberfl�che erstellt.
	 * @param iZeile
	 * @param iSpalte
	 */
	private void eatingCoinsDarstellen(int iZeile, int iSpalte)
	{
		aEatingCoins[iEcoinIndex] = new JLabel(oIconEatingCoin);
		aSpielfeldArray[iZeile][iSpalte].add(aEatingCoins[iEcoinIndex]);
		iEcoinIndex++;
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	private void geisterDarstellen(int iZeile, int iSpalte)
	{
		switch (iGeisterZaehler)
		{
			case 1: aSpielfeldArray[iZeile][iSpalte].add(lGreeny); break;
			case 2:	aSpielfeldArray[iZeile][iSpalte].add(lBlue); break;
			case 3:	aSpielfeldArray[iZeile][iSpalte].add(lOrangy); break;
			case 4:	aSpielfeldArray[iZeile][iSpalte].add(lPinky); break;
		}
		iGeisterZaehler++;
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
	 * Hier wird die von der guiDarstellen Methode ge�nderte Farbe verwendet um den Hintergrund auf diese Farbe zu setzen.
	 * @param iZeile
	 * @param iSpalte
	 * @param cFarbe
	 */
	private void guiDarstellen(int iZeile, int iSpalte, Color cFarbe)
	{
		aSpielfeldArray[iZeile][iSpalte] = new JPanel();
		aSpielfeldArray[iZeile][iSpalte].addKeyListener(new SteuerungListener());
		aSpielfeldArray[iZeile][iSpalte].setBackground(cFarbe);
		pSpielfeldPanel.add(aSpielfeldArray[iZeile][iSpalte]);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird das Spieltfeld dargestellt und die Hintergrundfarben der Panels f�r die G�nge wird hier gesetzt.
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
						geisterDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("3"))
					{
						guiDarstellen(iZeile, iSpalte);
						aSpielfeldArray[iZeile][iSpalte].add(lPacMan);
					}
					//---------------------------------------------
					if (alSpielfeldArrayList.get(iFeld).equals("4"))
					{
						guiDarstellen(iZeile, iSpalte);
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
	 * In dieser Methode wird ausgegeben, dass der Chat erfolgreich ausge�hrt wurde oder, 
	 * dass ein Fehler aufgetreten ist und es wird eine Fehlermeldung geworfen.
	 */
	private void chatInformation()
	{
		Component cParentComponent;
		String sInfoTest;
		String sTitel;
		int iOptionType;
		int iMessageType;
		Icon icIcon;
		int iOptionPane;
		//-----------------------------------------------------------------------
		if (hasSuccessfulChatConnection())
		{
			cParentComponent = getGameMainFrame();
			//---------------------------------
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
			icIcon = null;
			//---------------------------------
			Object[] oOptionen = {"OK"};
			//---------------------------------
			iOptionPane = JOptionPane.showOptionDialog(cParentComponent, sInfoTest, sTitel, iOptionType, iMessageType,
					icIcon, oOptionen, oOptionen[0]);
		}
		//-----------------------------------------------------------------------
		else
		{
			cParentComponent = getGameMainFrame();
			//---------------------------------
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
			icIcon = null;
			//---------------------------------
			Object[] oOptionen = {"Neu starten", "Beenden", "Abbrechen"};
			//---------------------------------
			iOptionPane = JOptionPane.showOptionDialog(cParentComponent, sInfoTest, sTitel, iOptionType, iMessageType,
					icIcon, oOptionen, oOptionen[0]);
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
			tfChatnachrichtTextfeld.setEnabled(true);
			jbTextSendenButton.setEnabled(true);
			return true;
		}
		//-----------------------------------------------------------------------
		else
		{
			tfChatnachrichtTextfeld.setEnabled(false);
			jbTextSendenButton.setEnabled(false);
			return false;
		}
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler runter bewegt und �ndert somit seinen Position auf der Oberfl�che.	
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
	 * In dieser Klasse wird der Spieler rauf bewegt und �ndert somit seinen Position auf der Oberfl�che.	
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
	 * In dieser Methode wird der Spieler nach links bewegt und �ndert somit seinen Position auf der Oberfl�che.	
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
	 * In dieser Methode wird der Spieler nach rechts bewegt und �ndert somit seinen Position auf der Oberfl�che.	
	 */
	public static void spielerRechts()
	{
		iSpielerX = pSpieler.getX();
		iSpielerX = Spieler.SpielerRechtsBewegen(iSpielerX);
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
		String  message = startOfMessage + username + placeholder + tfChatnachrichtTextfeld.getText() + placeholder;
		//---------------------------------------------------------------------------
		if (!tfChatnachrichtTextfeld.getText().isEmpty() && !tfChatnachrichtTextfeld.getText().equals("Nachricht eingeben"))
		{
			if(taChatverlaufTextarea.getText().isEmpty())
			{
				taChatverlaufTextarea.setText(message);
				tfChatnachrichtTextfeld.setText(null);
			}
			//-----------------------------------------------------------------------
			else
			{
				taChatverlaufTextarea.setText(taChatverlaufTextarea.getText() + keepSpace + message);
				tfChatnachrichtTextfeld.setText(null);
			}
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
		return "Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + Spieler.getLeben() + "  ||  Punkte: "
				+ String.format("%,.0f", Spieler.getPunktestand());
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextField getChatnachrichtTextfeld()
	{
		return tfChatnachrichtTextfeld;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static JTextArea getChatverlaufTextarea()
	{
		return taChatverlaufTextarea;
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
	 * In dieser Klasse befindet sich die Methode run, welche f�r die Bewegung des Geistes zust�ndig ist.
	 * @author Thomas Mader-Ofer
	 *
	 */
	private class Task extends TimerTask
	{
		
		public void run()
		{			
			if(!tfChatnachrichtTextfeld.getText().isEmpty() && !tfChatnachrichtTextfeld.getText().equals("Nachricht eingeben"))
			{
				oClient.senden();
				Server.allenWeitersagen(tfChatnachrichtTextfeld.getText());
			}			
			/*
			if(bSpielerAktiv)
			{ 
				
				Random zufallsZahl = new Random();	// zufallszahl f�r die Bewegung des Geistes generiern 
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

			}
			*/
		}
	}
}