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
import control.listeners.SpielenButtonListener;
import control.listeners.SteuerungListener;
import control.listeners.WindowListener;
import model.chat.Client;
import model.chat.ClientHandler;
import model.chat.EigehendReader;
import model.chat.Server;
import model.interfaces.IWindowProperties;
import view.characters.Geist;
import view.characters.Spieler;
import view.gui.FeldWand;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @author Andrea Mader-Ofer
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class GameMainFrame extends JFrame implements IWindowProperties
{
	public static final String GANG					 = "0";
	public static final String WAND					 = "1";
	public static final String SPAWN_POINT			 = "2";
	public static final String PAC_MAN				 = "3";
	public static final String EATING_COIN			 = "4";
	public static final String GEISTER_AUSGANG		 = "5";
	public static final String TELEPORTER			 = "6";
	public static final Color  GAENGE_FARBE			 = Color.BLACK;
	public static final Color  WAENDE_FARBE			 = Color.BLUE;
	public static final Color  GEISTER_AUSGANG_FARBE = Color.BLACK;
	public static final Color  TELEPORTER_FARBE		 = Color.YELLOW;
	
	public static final int    GANG_INDEX			 = Integer.parseInt(GANG);
	public static final int    WAND_INDEX			 = Integer.parseInt(WAND);
	public static final int    SPAWN_POINT_INDEX	 = Integer.parseInt(SPAWN_POINT);
	public static final int    PAC_MAN_INDEX		 = Integer.parseInt(PAC_MAN);
	public static final int	   EATING_COIN_INDEX	 = Integer.parseInt(EATING_COIN);
	public static final int    GEISTER_AUSGANG_INDEX = Integer.parseInt(GEISTER_AUSGANG);
	public static final int    TELEPORTER_INDEX		 = Integer.parseInt(TELEPORTER);

	private static GameMainFrame	 oGameMainFrame;
	private static Geist 			 oGreeny				  = new Geist();
	private static Geist 			 oBlue					  = new Geist();
	private static Geist 			 oOrangy				  = new Geist();
	private static Geist 			 oPinky					  = new Geist();
	private static GuiDB  			 oGuiDB					  = new GuiDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	private static Spieler			 oSpieler				  = new Spieler();
	private static JTextArea		 taChatverlaufTextarea	  = new JTextArea();
	private static JTextField		 tfChatnachrichtTextfeld  = new JTextField("Nachricht eingeben");
	private static JButton			 jbTextSendenButton		  = new JButton("SENDEN");
	private static JButton			 jbSpielenButton		  = new JButton("SPIELEN");
	private static Icon				 oIconClassicCoin		  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/ClassicCoin.PNG")));
	private static Icon				 oIconEatingCoin		  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/EatingCoin.PNG")));
	private static Icon				 oIconGreeny			  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private static Icon				 oIconBlue				  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private static Icon				 oIconOrangy			  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private static Icon				 oIconPinky				  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
	private static Icon				 oIconPacManUp			  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_up.PNG")));
	private static Icon				 oIconPacManDown		  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_down.PNG")));
	private static Icon				 oIconPacManLeft		  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_left.PNG")));
	private static Icon 			 oIconPacManRight		  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_right.PNG")));
	private static Icon 			 oIconEatableGreeny	      = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Eatable_Ghost.PNG")));
	private static Icon 			 oIconEatableBlue	  	  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Eatable_Ghost.PNG")));
	private static Icon 			 oIconEatableOrangy 	  = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Eatable_Ghost.PNG")));
	private static Icon 			 oIconEatablePinky        = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Eatable_Ghost.PNG")));
	private static ArrayList<String> alSpielfeldArrayList;
	private static Boolean[][]		 aClassicCoinsBool		  = new Boolean[50][50];
	private static Boolean[][]		 aEatingCoinsBool		  = new Boolean[50][50];
	private static JPanel[][]		 aSpielfeldArray 		  = new JPanel[50][50];
	private static JPanel[]			 aClassicCoins	 		  = new JPanel[2500];
	private static JPanel[]			 aEatingCoins	 	      = new JPanel[1250];
	private static JLabel			 lSpielstandlabel		  = new JLabel(getSpielstandlabelText());
	private static JLabel			 lGreeny				  = new JLabel();
	private static JLabel 			 lIconGreeny			  = new JLabel(oIconGreeny);
	private static JLabel			 lBlue					  = new JLabel();
	private static JLabel			 lIconBlue				  = new JLabel(oIconBlue);
	private static JLabel			 lOrangy				  = new JLabel();
	private static JLabel			 lIconOrangy			  = new JLabel(oIconOrangy);
	private static JLabel			 lPinky					  = new JLabel();
	private static JLabel			 lIconPinky				  = new JLabel(oIconPinky);
	private static JLabel			 lPacManUp				  = new JLabel(oIconPacManUp);
	private static JLabel			 lPacManDown			  = new JLabel(oIconPacManDown);
	private static JLabel			 lPacManLeft			  = new JLabel(oIconPacManLeft);
	private static JLabel			 lPacManRight			  = new JLabel(oIconPacManRight);
	private static JLabel			 lEatableGreeny	 		  = new JLabel(oIconEatableGreeny);
	private static JLabel			 lEatableBlue			  = new JLabel(oIconEatableBlue);
	private static JLabel			 lEatableOrangy			  = new JLabel(oIconEatableOrangy);
	private static JLabel			 lEatablePinky			  = new JLabel(oIconEatablePinky);
	private static JLabel			 lPacMan;
	private static boolean			 bSpielerAktiv			  = false;
	private static boolean 			 bSpielerLebt 			  = true;
	private static boolean			 bGeisterFressen 		  = false;
	private static double			 iSpielerPunkte			  = oSpieler.getPunktestand();
	private static int				 iSpielfeldIndex		  = -1;
	private static int				 iCcoinIndex			  = 0;
	private static int 	 			 iEcoinIndex			  = 0;
	private static int   			 iGeisterZaehler		  = 1;
	private static int				 iGeistFressen			  = 0;
	private static int    			 iGreenyHor				  = 0;
	private static int   			 iGreenyVer				  = 0;
	private static int   			 iBlueHor				  = 0;
	private static int    			 iBlueVer				  = 0;
	private static int   			 iOrangyHor				  = 0;
	private static int   			 iOrangyVer				  = 0;
	private static int	 			 iPinkyHor				  = 0;
	private static int	  		     iPinkyVer				  = 0;
	private static int				 iSpielerHor;
	private static int				 iSpielerVer;
	
	private ArrayList<FeldWand> alWaende = new ArrayList<FeldWand>();
	
	private JPanel pSpielfeldPanel		 = new JPanel();
	private JPanel pChatPanel			 = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	private Timer  oTimer				 = new Timer();
	private Client oClient				 = new Client();
	private int	   zufallszahlPinky		 = 0;
	private int    zufallszahlGreeny	 = 0;
	private int    zufallszahlBlue		 = 0;
	private int    zufallszahlOrangy	 = 0;
	
	/**
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
	 */
	public GameMainFrame()
	{
		initialize();
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wierd das Fenster erstellt und die einzellnen Labels
	 * und TextFelder werden Initiallisiert.
	 */
	private void initialize()
	{
		oGameMainFrame = this;
		
		Font foDefaultFont = new Font("Segoe UI", Font.PLAIN, 15);
		
		setTitle("Pac-Man");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(WINDOW_POSITION);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		setResizable(false);
		setFocusable(true);
		setVisible(true);
		addKeyListener(new SteuerungListener());
		addWindowListener(new WindowListener(this));

		timerStarten();

		oClient.netzwerkEinrichten();

		Thread thReaderThread = new Thread(new EigehendReader());
		thReaderThread.start();

		GridLayout oSpielfeldLayout = new GridLayout(GUI_ROWS, GUI_COLUMNS);
		pSpielfeldPanel.setLayout(oSpielfeldLayout);

		lSpielstandlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lSpielstandlabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		lSpielstandlabel.setForeground(Color.BLUE);

		jbTextSendenButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbTextSendenButton.addActionListener(new ChatSendenButtonListener());
		
		jbSpielenButton.setIcon(new ImageIcon(GameMainFrame.class.getResource("/view/images/Pac-Man_right.PNG")));
		jbSpielenButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbSpielenButton.addActionListener(new SpielenButtonListener(this));

		taChatverlaufTextarea.setEditable(false);
		taChatverlaufTextarea.setLineWrap(true);
		taChatverlaufTextarea.setWrapStyleWord(true);
		taChatverlaufTextarea.setFont(foDefaultFont);

		JScrollPane jspScrollPane = new JScrollPane(taChatverlaufTextarea);
		jspScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pChatKomponentenPanel.add(tfChatnachrichtTextfeld);
		pChatKomponentenPanel.add(jbTextSendenButton);

		pChatPanel.setLayout(new BorderLayout());
		pChatPanel.add(jbSpielenButton, BorderLayout.NORTH);
		pChatPanel.add(jspScrollPane, BorderLayout.CENTER);
		pChatPanel.add(pChatKomponentenPanel, BorderLayout.SOUTH);

		add(lSpielstandlabel, BorderLayout.NORTH);
		add(pSpielfeldPanel, BorderLayout.CENTER);
		add(pChatPanel, BorderLayout.WEST);

		tfChatnachrichtTextfeld.setHorizontalAlignment(SwingConstants.LEADING);
		tfChatnachrichtTextfeld.setFont(foDefaultFont);
		tfChatnachrichtTextfeld.addKeyListener(new ChatNachrichtfeldListener());
		tfChatnachrichtTextfeld.addFocusListener(new ChatNachrichtfeldListener());

		spielfeldAufbauen();
		showChatInformation();
	}

	// -------------------------------------------------------------------------------------------------------------------

	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen
	 * werden soll gestartet
	 */
	private void timerStarten()
	{
		TimerTask oTimerTask = new Task(); // Hier wird ein Objekt der Klasse Task, welche von der Klasse Timertask erbt, erzeugt.
		oTimer.schedule(oTimerTask, 0, 200); // Hier wird angegeben, wie oft die Methode run in der Unterklasse pro Sekunde aufgerufen werden soll.
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die ClassiCoins auf dem PanelArray zugewiesen, welches die
	 * Oberfläche erstellt.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 */
	private void classicCoinsDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte);
		aClassicCoinsBool[iZeile][iSpalte] = true;
		
		aClassicCoins[iCcoinIndex] = new JPanel();
		aClassicCoins[iCcoinIndex].add(new JLabel(oIconClassicCoin));
		aClassicCoins[iCcoinIndex].setBackground(GAENGE_FARBE);
		
		aSpielfeldArray[iZeile][iSpalte].add(aClassicCoins[iCcoinIndex]);
		iCcoinIndex++;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die EatingCoins dem PanelArray zugewiesen, welches die
	 * Oberfläche erstellt.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 */
	private void eatingCoinsDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte);
		aEatingCoinsBool[iZeile][iSpalte] = true;
		
		aEatingCoins[iEcoinIndex] = new JPanel();
		aEatingCoins[iEcoinIndex].add(new JLabel(oIconEatingCoin));
		aEatingCoins[iEcoinIndex].setBackground(GAENGE_FARBE);
		
		aSpielfeldArray[iZeile][iSpalte].add(aEatingCoins[iEcoinIndex]);
		iEcoinIndex++;
	}

	// -------------------------------------------------------------------------------------------------------------------

	private void geisterDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte);
		switch (iGeisterZaehler)
		{
			case 1:
				lGreeny = lIconGreeny;
				aSpielfeldArray[iZeile][iSpalte].add(lGreeny);
				iGreenyHor = iSpalte;
				iGreenyVer = iZeile;
				oGreeny.setPosY(iGreenyVer);
				oGreeny.setPosX(iGreenyHor);
				break;
			// ---------------------------------------------------
			case 2:
				lBlue = lIconBlue;
				aSpielfeldArray[iZeile][iSpalte].add(lBlue);
				iBlueHor = iSpalte;		
				iBlueVer = iZeile;
				oBlue.setPosY(iBlueVer);
				oBlue.setPosX(iBlueHor);
				break;
			// ---------------------------------------------------
			case 3:
				lOrangy = lIconOrangy;
				aSpielfeldArray[iZeile][iSpalte].add(lOrangy);
				iOrangyHor = iSpalte;
				iOrangyVer = iZeile;
				oOrangy.setPosY(iOrangyVer);
				oOrangy.setPosX(iOrangyHor);
				break;
			// ---------------------------------------------------
			case 4:
				lPinky = lIconPinky;
				aSpielfeldArray[iZeile][iSpalte].add(lPinky);
				iPinkyHor = iSpalte;
				iPinkyVer = iZeile;
				oPinky.setPosY(iPinkyVer);
				oPinky.setPosX(iPinkyHor);
				break;
			// ---------------------------------------------------
		}
		iGeisterZaehler++;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird der Default wert auf Schwarz gesetzt.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 */
	private void guiDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte, GAENGE_FARBE);
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird die von der guiDarstellen Methode geänderte Farbe verwendet um
	 * den Hintergrund auf diese Farbe zu setzen.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 * @param cFarbe
	 */
	private void guiDarstellen(int iZeile, int iSpalte, Color cFarbe)
	{
		aSpielfeldArray[iZeile][iSpalte] = new JPanel();
		aSpielfeldArray[iZeile][iSpalte].setBackground(cFarbe);
		pSpielfeldPanel.add(aSpielfeldArray[iZeile][iSpalte]);
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird das Spieltfeld dargestellt und die Hintergrundfarben der Panels
	 * für die Gänge wird hier gesetzt.
	 */
	private void spielfeldAufbauen()
	{
		for (int iZeile = 0; iZeile < GUI_ROWS; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < GUI_COLUMNS; iSpalte++)
			{
				iSpielfeldIndex++;
				//-----------------------------------------------------------------------
				if (getSpielfeldAL().size() > iSpielfeldIndex)
				{
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(GANG))
					{
						classicCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(WAND))
					{
						FeldWand oWand = new FeldWand(iSpalte, iZeile, WAND_INDEX);
						alWaende.add(oWand);
						guiDarstellen(iZeile, iSpalte, WAENDE_FARBE);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(SPAWN_POINT))
					{
						FeldWand oWand = new FeldWand(iSpalte, iZeile, SPAWN_POINT_INDEX);
						alWaende.add(oWand);
						geisterDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(PAC_MAN))
					{
						lPacMan = lPacManRight;
						guiDarstellen(iZeile, iSpalte);
						aSpielfeldArray[iZeile][iSpalte].add(lPacMan);
						iSpielerVer = iZeile;
						iSpielerHor = iSpalte;
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(EATING_COIN))
					{
						eatingCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(GEISTER_AUSGANG))
					{
						FeldWand oWand = new FeldWand(iSpalte, iZeile, GEISTER_AUSGANG_INDEX);
						alWaende.add(oWand);
						guiDarstellen(iZeile, iSpalte, GEISTER_AUSGANG_FARBE);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iSpielfeldIndex).equals(TELEPORTER))
					{
						FeldWand oWand = new FeldWand(iSpalte, iZeile, TELEPORTER_INDEX);
						alWaende.add(oWand);
						guiDarstellen(iZeile, iSpalte, TELEPORTER_FARBE);
					}
				}
				// -----------------------------------------------------------------------
				else
				{
					break;
				}
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird ausgegeben, dass der Chat erfolgreich ausgeührt
	 * wurde oder, dass ein Fehler aufgetreten ist und es wird eine
	 * Fehlermeldung geworfen.
	 */
	private void showChatInformation()
	{
		Component cParentComponent = getGameMainFrame();
		String sMessageText;
		String sTitle;
		int iOptionType;
		int iMessageType;
		Icon icIcon = null;
		Object[] oOptions;
		Object oInitialValue;
		int iOptionPane;
		// -----------------------------------------------------------------------
		if (hasSuccessfulChatConnection())
		{
			sMessageText = "Der Chat wurde erfolgreich eingerichtet\u0021\n"
						 + "\n"
						 + "Sie k\u00F6nnen nun mit anderen Spielteilnehmern kommunizieren\u002E";
			sTitle = "Chat\u00ADInformation";
			iOptionType = JOptionPane.OK_OPTION;
			iMessageType = JOptionPane.INFORMATION_MESSAGE;
			oOptions = new Object[] { "OK" };
			oInitialValue = oOptions[0];
			iOptionPane = JOptionPane.showOptionDialog(cParentComponent, sMessageText, sTitle, iOptionType,
														iMessageType, icIcon, oOptions, oInitialValue);
		}
		// -----------------------------------------------------------------------
		else
		{
			sMessageText = "Beim Einrichten des Chats ist ein Fehler aufgetreten\u0021\n"
						 + "Wenn Sie den Chat nutzen m\u00F6chten\u002C starten Sie das Spiel bitte neu\u002E\n"
						 + "\n"
						 + "M\u00F6chten Sie das Spiel jetzt neu starten oder beenden\u003F";
			sTitle = "Fehler bei Chat\u00ADVerbindung";
			iOptionType = JOptionPane.YES_NO_CANCEL_OPTION;
			iMessageType = JOptionPane.WARNING_MESSAGE;
			oOptions = new Object[] { "Neu starten", "Beenden", "Abbrechen" };
			oInitialValue = oOptions[0];
			iOptionPane = JOptionPane.showOptionDialog(cParentComponent, sMessageText, sTitle, iOptionType,
														iMessageType, icIcon, oOptions, oInitialValue);
			// =======================================
			if (iOptionPane == JOptionPane.YES_OPTION)
			{
				getGameMainFrame().setVisible(false);
				new GameMainFrame();
				this.dispose();
			}
			// =======================================
			if (iOptionPane == JOptionPane.NO_OPTION)
			{
				getGameMainFrame().dispose();
				System.exit(0);
			}
		}
	}
	
	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Diese Methode sagt, dass der Sendebutton "Freigegeben" wird, damit eine
	 * Nachricht gesendet werden kann.
	 * 
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
		// -----------------------------------------------------------------------
		tfChatnachrichtTextfeld.setEnabled(false);
		jbTextSendenButton.setEnabled(false);
		return false;
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	private static void checkCoins(int iPosY, int iPosX)
	{
		if (aClassicCoinsBool[iPosY][iPosX] != null)
		{
			if (aClassicCoinsBool[iPosY][iPosX] && (aSpielfeldArray[iPosY][iPosX].getBackground() == GAENGE_FARBE))
			{
				oSpieler.setPunktestand(iSpielerPunkte += 500);
				aClassicCoinsBool[iPosY][iPosX] = false;
			} 
		}
		if (aEatingCoinsBool[iPosY][iPosX] != null)
		{
			if (aEatingCoinsBool[iPosY][iPosX] && (aSpielfeldArray[iPosY][iPosX].getBackground() == GAENGE_FARBE))
			{
				bGeisterFressen = true;
				
				lGreeny = lEatableGreeny;
				lIconGreeny.setVisible(false);
				aSpielfeldArray[oGreeny.getPosY()][oGreeny.getPosX()].add(lGreeny);
				
				lBlue = lEatableBlue;
				aSpielfeldArray[oBlue.getPosY()][oBlue.getPosX()].add(lBlue);
				lIconBlue.setVisible(false);
				
				lOrangy = lEatableOrangy;
				aSpielfeldArray[oOrangy.getPosY()][oOrangy.getPosX()].add(lOrangy);
				lIconOrangy.setVisible(false);
				
				lPinky = lEatablePinky;
				aSpielfeldArray[oPinky.getPosY()][oPinky.getPosX()].add(lPinky);
				lIconPinky.setVisible(false);
				
				oSpieler.setPunktestand(iSpielerPunkte += 2000);
				aEatingCoinsBool[iPosY][iPosX] = false;
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler rauf bewegt und ändert somit seinen
	 * Position auf der Oberfläche.
	 */
	public static void spielerRauf() 
	{
		lPacManDown.setVisible(false);
		lPacManUp.setVisible(true);
		lPacManLeft.setVisible(false);
		lPacManRight.setVisible(false);
		
		lPacMan = lPacManUp;
		iSpielerVer = oSpieler.raufBewegen(iSpielerHor, iSpielerVer);
		checkCoins(iSpielerVer, iSpielerHor);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler runter bewegt und ändert somit seinen
	 * Position auf der Oberfläche.
	 */
	public static void spielerRunter()
	{
		lPacManDown.setVisible(true);
		lPacManUp.setVisible(false);
		lPacManLeft.setVisible(false);
		lPacManRight.setVisible(false);
		
		lPacMan = lPacManDown;
		iSpielerVer = oSpieler.runterBewegen(iSpielerHor, iSpielerVer);
		checkCoins(iSpielerVer, iSpielerHor);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach links bewegt und ändert somit
	 * seinen Position auf der Oberfläche.
	 */
	public static void spielerLinks()
	{
		lPacManDown.setVisible(false);
		lPacManUp.setVisible(false);
		lPacManRight.setVisible(false);
		lPacManLeft.setVisible(true);
		
		lPacMan = lPacManLeft;
		iSpielerHor = oSpieler.linksBewegen(iSpielerHor, iSpielerVer);
		checkCoins(iSpielerVer, iSpielerHor);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach rechts bewegt und ändert somit
	 * seinen Position auf der Oberfläche.
	 */
	public static void spielerRechts()
	{
		lPacManDown.setVisible(false);
		lPacManUp.setVisible(false);		
		lPacManLeft.setVisible(false);
		lPacManRight.setVisible(true);
		
		lPacMan = lPacManRight;
		iSpielerHor = oSpieler.rechtsBewegen(iSpielerHor, iSpielerVer);
		checkCoins(iSpielerVer, iSpielerHor);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static void chattextAnzeigen()
	{
		String keepSpace = "\n\n";
		String placeholder = "\n====================\n";
		String username = LogInFrame.getUsername() + ":";
		String startOfMessage = "---------------------------------\n";
		String message = startOfMessage + username + placeholder + tfChatnachrichtTextfeld.getText() + placeholder;
		// ---------------------------------------------------------------------------
		if (!tfChatnachrichtTextfeld.getText().isEmpty() && !tfChatnachrichtTextfeld.getText().equals("Nachricht eingeben"))
		{
			if (taChatverlaufTextarea.getText().isEmpty())
			{
				taChatverlaufTextarea.append(message);
				tfChatnachrichtTextfeld.setText(null);
			}
			// -----------------------------------------------------------------------
			else
			{
				taChatverlaufTextarea.append(keepSpace + message);
				tfChatnachrichtTextfeld.setText(null);
			}
		}
	}
	
	// -------------------------------------------------------------------------------------------------------------------

	public static void updateSpielstandlabelText()
	{
		lSpielstandlabel.setText(getSpielstandlabelText());
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static void setSpielerAktiv(boolean bSpielerAktiv)
	{
		GameMainFrame.bSpielerAktiv = bSpielerAktiv;
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static void setSpielerLebt(boolean bSpielerLebt)
	{
		GameMainFrame.bSpielerLebt = bSpielerLebt;
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static String getSpielstandlabelText()
	{
		return "Spieler: " + LogInFrame.getUsername() + "  ||  Leben: " + oSpieler.getLeben() + "  ||  Punkte: "
				+ String.format("%,.0f", oSpieler.getPunktestand());
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static JTextField getChatnachrichtTextfeld()
	{
		return tfChatnachrichtTextfeld;
	}

	// -------------------------------------------------------------------------------------------------------------------

	public static JTextArea getChatverlaufTextarea()
	{
		return taChatverlaufTextarea;
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	public static ArrayList<String> getSpielfeldAL()
	{
		GameMainFrame.alSpielfeldArrayList = oGuiDB.getArrayList();
		return alSpielfeldArrayList;
	}
	
	// -------------------------------------------------------------------------------------------------------------------
	
	public static int getArrayListIndex()
	{
		return iSpielfeldIndex;
	}
	
	// -------------------------------------------------------------------------------------------------------------------

	public static GameMainFrame getGameMainFrame()
	{
		return oGameMainFrame;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Klasse befindet sich die Methode run, welche für die Bewegung des Geistes zuständig ist.
	 * @author Manuel Glantschnig
	 * @author Thomas Mader-Ofer
	 * @author Cristina Erhart
	 * @version 1.0
	 */
	private class Task extends TimerTask 
	{
		@Override
		public void run()
		{
			if (!tfChatnachrichtTextfeld.getText().isEmpty() && !tfChatnachrichtTextfeld.getText().equals("Nachricht eingeben")) 
			{
				oClient.senden();
				Server.allenWeitersagen(tfChatnachrichtTextfeld.getText());
			}
			// ----------------------------------------------------------------------------------------------------------------
			if (bSpielerAktiv)
			{					
				int iPosYaltPinky = oPinky.getPosY();
				int iPosXaltPinky = oPinky.getPosX();

				int iPosYaltGreeny = oGreeny.getPosY();
				int iPosXaltGreeny = oGreeny.getPosX();

				int iPosYaltBlue = oBlue.getPosY();
				int iPosXaltBlue = oBlue.getPosX();

				int iPosYaltOrangy = oOrangy.getPosY();
				int iPosXaltOrangy = oOrangy.getPosX();

				zufallszahlPinky = (int) ((Math.random() * 40) + 1);
				zufallszahlGreeny = (int) ((Math.random() * 40) + 1);
				zufallszahlBlue = (int) ((Math.random() * 40) + 1);
				zufallszahlOrangy = (int) ((Math.random() * 40) + 1);
				//===========================================================================
				/////////////PINKY/////////////
				if (zufallszahlPinky <= 10)
				{
					lPinky.setVisible(false);
					oPinky.linksBewegen(oPinky.getPosX(), oPinky.getPosY());
					ausfuehren(iPosYaltPinky, iPosXaltPinky, oPinky, lPinky);
				}
				else
				{
					if (zufallszahlPinky <= 20)
					{
						lPinky.setVisible(false);
						oPinky.rechtsBewegen(oPinky.getPosX(), oPinky.getPosY());
						ausfuehren(iPosYaltPinky, iPosXaltPinky, oPinky, lPinky);
					}
					else
					{
						if (zufallszahlPinky <= 30)
						{
							lPinky.setVisible(false);
							oPinky.runterBewegen(oPinky.getPosX(), oPinky.getPosY());
							ausfuehren(iPosYaltPinky, iPosXaltPinky, oPinky, lPinky);
						}
						else
						{
							if (zufallszahlPinky <= 40)
							{
								lPinky.setVisible(false);
								oPinky.raufBewegen(oPinky.getPosX(), oPinky.getPosY());
								ausfuehren(iPosYaltPinky, iPosXaltPinky, oPinky, lPinky);
							}
						}
					}
				}
				//===========================================================================
				/////////////GREENY/////////////
				if (zufallszahlGreeny <= 10)
				{
					lGreeny.setVisible(false);
					oGreeny.linksBewegen(oGreeny.getPosX(), oGreeny.getPosY());
					ausfuehren(iPosYaltGreeny, iPosXaltGreeny, oGreeny, lGreeny);
				}
				else
				{
					if (zufallszahlGreeny <= 20)
					{
						lGreeny.setVisible(false);
						oGreeny.rechtsBewegen(oGreeny.getPosX(), oGreeny.getPosY());
						ausfuehren(iPosYaltGreeny, iPosXaltGreeny, oGreeny, lGreeny);
					}
					else
					{
						if (zufallszahlGreeny <= 30)
						{
							lGreeny.setVisible(false);
							oGreeny.runterBewegen(oGreeny.getPosX(), oGreeny.getPosY());
							ausfuehren(iPosYaltGreeny, iPosXaltGreeny, oGreeny, lGreeny);
						}
						else
						{
							if (zufallszahlGreeny <= 40)
							{
								lGreeny.setVisible(false);
								oGreeny.raufBewegen(oGreeny.getPosX(), oGreeny.getPosY());
								ausfuehren(iPosYaltGreeny, iPosXaltGreeny, oGreeny, lGreeny);
							}
						}
					}
				}
				//===========================================================================
				/////////////BLUE/////////////
				if (zufallszahlBlue <= 10)
				{
					lBlue.setVisible(false);
					oBlue.linksBewegen(oBlue.getPosX(), oBlue.getPosY());
					ausfuehren(iPosYaltBlue, iPosXaltBlue, oBlue, lBlue);
				}
				else
				{
					if (zufallszahlBlue <= 20)
					{
						lBlue.setVisible(false);
						oBlue.rechtsBewegen(oBlue.getPosX(), oBlue.getPosY());
						ausfuehren(iPosYaltBlue, iPosXaltBlue, oBlue, lBlue);
					}
					else
					{
						if (zufallszahlBlue <= 30)
						{
							lBlue.setVisible(false);
							oBlue.runterBewegen(oBlue.getPosX(), oBlue.getPosY());
							ausfuehren(iPosYaltBlue, iPosXaltBlue, oBlue, lBlue);
						}
						else
						{
							if (zufallszahlBlue <= 40)
							{
								lBlue.setVisible(false);
								oBlue.raufBewegen(oBlue.getPosX(), oBlue.getPosY());
								ausfuehren(iPosYaltBlue, iPosXaltBlue, oBlue, lBlue);
							}
						}
					}
				}
				//===========================================================================
				/////////////ORANGY/////////////
				if (zufallszahlOrangy <= 10)
				{
					lOrangy.setVisible(false);
					oOrangy.linksBewegen(oOrangy.getPosX(), oOrangy.getPosY());
					ausfuehren(iPosYaltOrangy, iPosXaltOrangy, oOrangy, lOrangy);
				}
				else
				{
					if (zufallszahlOrangy <= 20)
					{
						lOrangy.setVisible(false);
						oOrangy.rechtsBewegen(oOrangy.getPosX(), oOrangy.getPosY());
						ausfuehren(iPosYaltOrangy, iPosXaltOrangy, oOrangy, lOrangy);
					}
					else
					{
						if (zufallszahlOrangy <= 30)
						{
							lOrangy.setVisible(false);
							oOrangy.runterBewegen(oOrangy.getPosX(), oOrangy.getPosY());
							ausfuehren(iPosYaltOrangy, iPosXaltOrangy, oOrangy, lOrangy);
						}
						else
						{
							if (zufallszahlOrangy <= 40)
							{
								lPinky.setVisible(false);
								oOrangy.raufBewegen(oOrangy.getPosX(), oOrangy.getPosY());
								ausfuehren(iPosYaltOrangy, iPosXaltOrangy, oOrangy, lOrangy);
							}
						}
					}
				}
				//===========================================================================
				lGreeny.setVisible(true);
				lPinky.setVisible(true);
				lBlue.setVisible(true);
				lOrangy.setVisible(true);
				
				if ((oGreeny.getPosY() == iSpielerVer) && (oGreeny.getPosX() == iSpielerHor) ||
					(oBlue.getPosY()   == iSpielerVer) && (oBlue.getPosX()   == iSpielerHor) ||
					(oOrangy.getPosY() == iSpielerVer) && (oOrangy.getPosX() == iSpielerHor) ||
					(oPinky.getPosY()  == iSpielerVer) && (oPinky.getPosX()  == iSpielerHor))
				{
					if (bSpielerLebt && !bGeisterFressen)
					{
						oSpieler.setLeben(oSpieler.getLeben() - 1);
					} 
					else
					{
						if ((oGreeny.getPosY() == iSpielerVer) && (oGreeny.getPosX() == iSpielerHor))
						{
							aSpielfeldArray[oGreeny.getPosY()][oGreeny.getPosX()].removeAll();
							oGreeny.setPosY(12);
							oGreeny.setPosX(13);
							lGreeny = lIconGreeny;
							lEatableGreeny.setVisible(false);
							aSpielfeldArray[oGreeny.getPosY()][oGreeny.getPosX()].add(lGreeny);
							oSpieler.setPunktestand(iSpielerPunkte += 50000);
						}
						else
						{
							if ((oBlue.getPosY() == iSpielerVer) && (oBlue.getPosX() == iSpielerHor))
							{
								aSpielfeldArray[oBlue.getPosY()][oBlue.getPosX()].removeAll();
								oBlue.setPosY(12);
								oBlue.setPosX(13);
								lBlue = lIconBlue;
								lEatableBlue.setVisible(false);
								aSpielfeldArray[oBlue.getPosY()][oBlue.getPosX()].add(lBlue);
								oSpieler.setPunktestand(iSpielerPunkte += 50000);
							}
							else
							{
								if ((oOrangy.getPosY() == iSpielerVer) && (oOrangy.getPosX() == iSpielerHor))
								{
									aSpielfeldArray[oOrangy.getPosY()][oOrangy.getPosX()].removeAll();
									oOrangy.setPosY(12);
									oOrangy.setPosX(13);
									lOrangy = lIconOrangy;
									lEatableOrangy.setVisible(false);
									aSpielfeldArray[oOrangy.getPosY()][oOrangy.getPosX()].add(lOrangy);
									oSpieler.setPunktestand(iSpielerPunkte += 50000);
								}
								else
								{
									if ((oPinky.getPosY() == iSpielerVer) && (oPinky.getPosX() == iSpielerHor))
									{
										aSpielfeldArray[oPinky.getPosY()][oPinky.getPosX()].removeAll();
										oPinky.setPosY(12);
										oPinky.setPosX(13);
										lPinky = lIconPinky;
										lEatablePinky.setVisible(false);
										aSpielfeldArray[oPinky.getPosY()][oPinky.getPosX()].add(lPinky);
										oSpieler.setPunktestand(iSpielerPunkte += 50000);
									}
								}
							}
						}
					}
				}
				
				if (iGeistFressen == 45)
				{
					bGeisterFressen = false;
					iGeistFressen = 0;

					lIconGreeny.setVisible(true);
					lGreeny = lIconGreeny;
					lEatableGreeny.setVisible(false);
					aSpielfeldArray[oGreeny.getPosY()][oGreeny.getPosX()].add(lGreeny);

					lIconBlue.setVisible(true);
					lBlue = lIconBlue;
					aSpielfeldArray[oBlue.getPosY()][oBlue.getPosX()].add(lBlue);
					lEatableBlue.setVisible(false);

					lIconOrangy.setVisible(true);
					lOrangy = lIconOrangy;
					lEatableOrangy.setVisible(false);
					aSpielfeldArray[oOrangy.getPosY()][oOrangy.getPosX()].add(lOrangy);

					lIconPinky.setVisible(true);
					lPinky = lIconPinky;
					lEatablePinky.setVisible(false);
					aSpielfeldArray[oPinky.getPosY()][oPinky.getPosX()].add(lPinky);
				}
				
				if (bGeisterFressen)
				{
					iGeistFressen++;
				}
			
				aSpielfeldArray[11][16].removeAll();
				aSpielfeldArray[11][16].setBackground(GAENGE_FARBE);
				repaint();
				repaint();
				repaint();
			}
		}
		
		public void ausfuehren(int iPosYalt, int iPosXalt, Geist oGeist, JLabel lFarbe)
		{
			boolean darfInSpawnPointFahren = false;

			int i;
			for (i = 0; i < alWaende.size(); i++)
			{
				if (alWaende.get(i).getFeldX() == iPosXalt && alWaende.get(i).getFeldY() == iPosYalt && alWaende.get(i).getFarbe() == SPAWN_POINT_INDEX)
				{
					darfInSpawnPointFahren = true;
					break;
				}
			}

			if (i >= alWaende.size() - 1)
			{
				darfInSpawnPointFahren = false;
			}

			for (i = 0; i < alWaende.size(); i++)
			{
				if (!darfInSpawnPointFahren)
				{
					if ((alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == WAND_INDEX) ||
						(alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == SPAWN_POINT_INDEX) ||
						(alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == TELEPORTER_INDEX) ||
						(alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == GEISTER_AUSGANG_INDEX))
					{
						oGeist.setPosY(iPosYalt);
						oGeist.setPosX(iPosXalt);
						break;
					}
				}
				else
				{
					if (alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == WAND_INDEX ||
					   (alWaende.get(i).getFeldX() == oGeist.getPosX() && alWaende.get(i).getFeldY() == oGeist.getPosY() && alWaende.get(i).getFarbe() == TELEPORTER_INDEX))
					{
						oGeist.setPosY(iPosYalt);
						oGeist.setPosX(iPosXalt);
						break;
					}
				}
			}

			if (i >= alWaende.size() - 1)
			{
				if (!darfInSpawnPointFahren)
				{
					if (aClassicCoinsBool[iPosYalt][iPosXalt] != null || aClassicCoinsBool[iPosYalt][iPosXalt] == null)
					{
						JLabel icon = new JLabel(oIconClassicCoin);
						aSpielfeldArray[iPosYalt][iPosXalt].setVisible(false);
						aSpielfeldArray[iPosYalt][iPosXalt].add(icon);
						aSpielfeldArray[iPosYalt][iPosXalt].setBackground(GAENGE_FARBE);
						aSpielfeldArray[iPosYalt][iPosXalt].setVisible(true);
						aSpielfeldArray[oGeist.getPosY()][oGeist.getPosX()].removeAll();
						aSpielfeldArray[oGeist.getPosY()][oGeist.getPosX()].add(lFarbe);
					}
				}
				else
				{
					aSpielfeldArray[oGeist.getPosY()][oGeist.getPosX()].add(lFarbe);
				}
			}
		}
	}
}