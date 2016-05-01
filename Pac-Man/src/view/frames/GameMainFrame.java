package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import control.file_processing.GuiDB;
import control.listeners.ChatNachrichtfeldListener;
import control.listeners.ChatSendenButtonListener;
import control.listeners.SteuerungListener;
import control.listeners.WindowListener;
import model.chat.Client;
import model.chat.ClientHandler;
import model.chat.EigehendReader;
import model.chat.Server;
import model.interfaces.IWindowProperties;
import view.characters.Geist;
import view.characters.Spieler;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class GameMainFrame extends JFrame implements IWindowProperties
{
	public static final String GANG					 = "0";
	public static final String WAND					 = "1";
	public static final String GEIST				 = "2";
	public static final String PAC_MAN				 = "3";
	public static final String EATING_COIN			 = "4";
	public static final String GEISTER_AUSGANG		 = "5";
	public static final String TELEPORTER			 = "6";
	public static final Color  GAENGE_FARBE			 = Color.BLACK;
	public static final Color  WAENDE_FARBE			 = Color.BLUE;
	public static final Color  GEISTER_AUSGANG_FARBE = Color.WHITE;

	private static GameMainFrame	 oGameMainFrame;
	private static GuiDB  			 oGuiDB					 = new GuiDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	private static Spieler			 oSpieler				 = new Spieler();
	private static Geist			 oGeist					 = new Geist();
	private static JTextArea		 taChatverlaufTextarea	 = new JTextArea();
	private static JTextField		 tfChatnachrichtTextfeld = new JTextField("Nachricht eingeben");
	private static JButton			 jbTextSendenButton		 = new JButton("SENDEN");
	private static Icon				 oIconClassicCoin		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/ClassicCoin.PNG")));
	private static Icon				 oIconEatingCoin		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/EatingCoin.PNG")));
	private static Icon				 oIconGreeny			 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Greeny.PNG")));
	private static Icon				 oIconBlue				 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Blue.PNG")));
	private static Icon				 oIconOrangy			 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Orangy.PNG")));
	private static Icon				 oIconPinky				 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pinky.PNG")));
//	private static Icon				 oIconEatableGhost		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Eatable_Ghost.PNG")));
//	private static Icon				 oIconPacManUp			 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_up.PNG")));
//	private static Icon				 oIconPacManDown		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_down.PNG")));
//	private static Icon				 oIconPacManLeft		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_left.PNG")));
	private static Icon 			 oIconPacManRight		 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameMainFrame.class.getResource("/view/images/Pac-Man_right.PNG")));
	private static ArrayList<String> alSpielfeldArrayList;
	private static JPanel[][]		 aSpielfeldArray		 = new JPanel[50][50];
	private static JPanel[]			 aClassicCoins			 = new JPanel[2500];
	private static JPanel[]			 aEatingCoins			 = new JPanel[1250];
	private static JLabel			 lSpielstandlabel		 = new JLabel(getSpielstandlabelText());
	private static JLabel			 lGreeny				 = new JLabel(oIconGreeny);
	private static JLabel			 lBlue					 = new JLabel(oIconBlue);
	private static JLabel			 lOrangy				 = new JLabel(oIconOrangy);
	private static JLabel			 lPinky					 = new JLabel(oIconPinky);
//	private static JLabel			 lEatableGhost			 = new JLabel(oIconEatableGhost);
//	private static JLabel			 lPacManUp				 = new JLabel(oIconPacManUp);
//	private static JLabel			 lPacManDown			 = new JLabel(oIconPacManDown);
//	private static JLabel			 lPacManLeft			 = new JLabel(oIconPacManLeft);
	private static JLabel			 lPacManRight			 = new JLabel(oIconPacManRight);
	private static JLabel			 lPacMan;
	private static boolean			 bSpielerAktiv			 = false;
//	private static double			 iSpielerPunkte			 = oSpieler.getPunktestand();
//	private static int				 iSpielerLeben			 = oSpieler.getLeben();
	private static int				 iDelayIntervall		 = 40;
	private static int				 iArrayListIndex		 = -1;
	private static int				 iCcoinIndex			 = 0;
	private static int 	 			 iEcoinIndex			 = 0;
	/**<i>iSpielerHor</i> z�hlt die gefahrenen Felder in <b>horizontaler Richtung</b>.*/
	private static int				 iSpielerHor;
	/**<i>iSpielerVer</i> z�hlt die gefahrenen Felder in <b>vertikatler Richtung</b>.*/
	private static int				 iSpielerVer;
	/**<i>iGeistHor</i> z�hlt die gefahrenen Felder in <b>horizontaler Richtung</b>.*/
	private static int				 iGeistHor;
	/**<i>iGeistVer</i> z�hlt die gefahrenen Felder in <b>vertikatler Richtung</b>.*/
	private static int				 iGeistVer;

	private int    iGeisterZaehler		 = 0;
	private JPanel pSpielfeldPanel		 = new JPanel();
	private JPanel pChatPanel			 = new JPanel();
	private JPanel pChatKomponentenPanel = new JPanel();
	private Timer  oTimer				 = new Timer();
	private Client oClient				 = new Client();

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
		oTimer.schedule(oTimerTask, 0, 150); // Hier wird angegeben, wie oft die Methode run in der Unterklasse pro Sekunde aufgerufen werden soll.
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die ClassiCoins auf dem PanelArray zugewiesen, welches die
	 * Oberfl�che erstellt.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 */
	private void classicCoinsDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte);
		aClassicCoins[iCcoinIndex] = new JPanel();
		aClassicCoins[iCcoinIndex].add(new JLabel(oIconClassicCoin));
		aClassicCoins[iCcoinIndex].setBackground(GAENGE_FARBE);
		aSpielfeldArray[iZeile][iSpalte].add(aClassicCoins[iCcoinIndex]);
		iCcoinIndex++;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier werden die EatingCoins dem PanelArray zugewiesen, welches die
	 * Oberfl�che erstellt.
	 * 
	 * @param iZeile
	 * @param iSpalte
	 */
	private void eatingCoinsDarstellen(int iZeile, int iSpalte)
	{
		guiDarstellen(iZeile, iSpalte);
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
			case 1: aSpielfeldArray[iZeile][iSpalte].add(lGreeny); break;
			case 2: aSpielfeldArray[iZeile][iSpalte].add(lBlue); break;
			case 3: aSpielfeldArray[iZeile][iSpalte].add(lOrangy); break;
			case 4: aSpielfeldArray[iZeile][iSpalte].add(lPinky); break;
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
	 * Hier wird die von der guiDarstellen Methode ge�nderte Farbe verwendet um
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
	 * f�r die G�nge wird hier gesetzt.
	 */
	private void spielfeldAufbauen()
	{
		for (int iZeile = 0; iZeile < GUI_ROWS; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < GUI_COLUMNS; iSpalte++)
			{
				iArrayListIndex++;
				//-----------------------------------------------------------------------
				if (getSpielfeldAL().size() > iArrayListIndex)
				{
					if (getSpielfeldAL().get(iArrayListIndex).equals(GANG))
					{
						classicCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(WAND))
					{
						guiDarstellen(iZeile, iSpalte, WAENDE_FARBE);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(GEIST))
					{
						geisterDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(PAC_MAN))
					{
						lPacMan = lPacManRight;
						
						guiDarstellen(iZeile, iSpalte);
						aSpielfeldArray[iZeile][iSpalte].add(lPacMan);
						iSpielerVer = iZeile;
						iSpielerHor = iSpalte;
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(EATING_COIN))
					{
						eatingCoinsDarstellen(iZeile, iSpalte);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(GEISTER_AUSGANG))
					{
						guiDarstellen(iZeile, iSpalte, GEISTER_AUSGANG_FARBE);
					}
					//---------------------------------------------
					if (getSpielfeldAL().get(iArrayListIndex).equals(TELEPORTER))
					{
						classicCoinsDarstellen(iZeile, iSpalte);
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
	 * In dieser Methode wird ausgegeben, dass der Chat erfolgreich ausge�hrt
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
	/**
	 * Je kleiner der Wert, desto gr��er die Verz�gerung.
	 * @param iFramesPerSecond Bilder pro Sekunde
	 */
	public static void delay(int iFramesPerSecond)
	{
		if (iFramesPerSecond == 0)
			iFramesPerSecond = 1;
		if (iFramesPerSecond < 0)
			iFramesPerSecond *= (-1);
		try {
			Thread.sleep(1000 / iFramesPerSecond);
		} catch (InterruptedException e) {}
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	/**
	 * In dieser Methode wird der Spieler rauf bewegt und �ndert somit seinen
	 * Position auf der Oberfl�che.
	 */
	public static void spielerRauf() 
	{
		delay(iDelayIntervall);
		lPacMan = lPacManRight;
		iSpielerVer = oSpieler.raufBewegen(iSpielerVer);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler runter bewegt und �ndert somit seinen
	 * Position auf der Oberfl�che.
	 */
	public static void spielerRunter()
	{
		delay(iDelayIntervall);
		lPacMan = lPacManRight;
		iSpielerVer = oSpieler.runterBewegen(iSpielerVer);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach links bewegt und �ndert somit
	 * seinen Position auf der Oberfl�che.
	 */
	public static void spielerLinks()
	{
		delay(iDelayIntervall);
		lPacMan = lPacManRight;
		iSpielerHor = oSpieler.linksBewegen(iSpielerHor);
		aSpielfeldArray[iSpielerVer][iSpielerHor].removeAll();
		aSpielfeldArray[iSpielerVer][iSpielerHor].add(lPacMan);
		bSpielerAktiv = true;
	}

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * In dieser Methode wird der Spieler nach rechts bewegt und �ndert somit
	 * seinen Position auf der Oberfl�che.
	 */
	public static void spielerRechts()
	{
		delay(iDelayIntervall);
		lPacMan = lPacManRight;
		iSpielerHor = oSpieler.rechtsBewegen(iSpielerHor);
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
				taChatverlaufTextarea.setText(message);
				tfChatnachrichtTextfeld.setText(null);
			}
			// -----------------------------------------------------------------------
			else
			{
				taChatverlaufTextarea.setText(taChatverlaufTextarea.getText() + keepSpace + message);
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
		return iArrayListIndex;
	}
	
	// -------------------------------------------------------------------------------------------------------------------

	public static GameMainFrame getGameMainFrame()
	{
		return oGameMainFrame;
	}

	// -------------------------------------------------------------------------------------------------------------------

	/**
	 * In dieser Klasse befindet sich die Methode run, welche f�r die Bewegung des Geistes zust�ndig ist.
	 * @author Manuel Glantschnig
	 * @author Thomas Mader-Ofer
	 * @author Cristina Erhart
	 * @version 1.0
	 */
	private class Task extends TimerTask 
	{
//		private String sName;
		
		@Override
		public void run()
		{
			if (!tfChatnachrichtTextfeld.getText().isEmpty() && !tfChatnachrichtTextfeld.getText().equals("Nachricht eingeben")) 
			{
				oClient.senden();
				Server.allenWeitersagen(tfChatnachrichtTextfeld.getText());
			}
			
			if (bSpielerAktiv)
			{
				Random zufallsZahl = new Random(); // zufallszahl f�r die Bewegung des Geistes generiern
				int iIndex = zufallsZahl.nextInt(8) + 1;

				for (int iZaehler = 0; iZaehler <= 8; iZaehler++)
				{
//					switch (iZaehler)
//					{
//						case 0: sName = "Greeny"; break;
//						case 1: sName = "Greeny"; break;
//						case 2: sName = "Blue"; break;
//						case 3: sName = "Blue"; break;
//						case 4: sName = "Orangy"; break;
//						case 5: sName = "Orangy"; break;
//						case 6: sName = "Pinky"; break;
//						case 7: sName = "Pinky"; break;
//					}
					switch (iIndex)
					{
						case 1: oGeist.raufBewegen(iGeistHor); break;
						case 2: oGeist.runterBewegen(iGeistHor); break;
						case 3: oGeist.rechtsBewegen(iGeistVer); break;
						case 4: oGeist.linksBewegen(iGeistVer); break;
						case 5: oGeist.raufBewegen(iGeistHor); break;
						case 6: oGeist.runterBewegen(iGeistHor); break;
						case 7: oGeist.rechtsBewegen(iGeistVer); break;
						case 8: oGeist.linksBewegen(iGeistVer); break;
					}
				}
			}

//			if ((iGeistVer == iSpielerVer) && (iGeistHor == iSpielerHor))
//			{
//				oSpieler.setLeben(iSpielerLeben--);
//			}
			repaint();
		}
	}
}