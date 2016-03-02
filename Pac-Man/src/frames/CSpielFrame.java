package frames;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import characters.CGeister;
import characters.CSpieler;
import control.listeners.SteuerungListener;
import control.listeners.WindowClosingListener;
import interfaces.ILabyrinth;
import interfaces.IWindowProperties;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public class CSpielFrame extends JFrame implements ILabyrinth, IWindowProperties
{
	private static CSpielFrame jFrame = new CSpielFrame();
	
	private int zaehlerY = 0;
	private int zaehlerX = 200;
	private int laenge = 50;
	private int breite = 10;
	
	private int iGeisty;
	private int iGeistx;
	private static int iSpielery;
	private static int iSpielerx;
	
	private static int zaehler = 0;
	private static int iZaehler = 1;
	
	private boolean fenster = false;
	private static boolean bSpielerAktiv = false;
	// Achtung PUBLIC
	public boolean bWand = true;
	
	//private CLogDB oCLog = new CLogDB();
	
	private static JPanel pSpieler = new JPanel();
	private JPanel pGeist = new JPanel();
	
	private CGeister oGeist = new CGeister();
	private static CSpieler oSpieler = new CSpieler();
	
	private Timer oTimer = new Timer();
	private JPanel[] aPanel = new JPanel[800];
	
	private JPanel[][] panelFeld;
	
	public CSpielFrame()
	{
	
	}
	
//----------------------------------------------	
	
	/**
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
	 * @param bFenster
	 */
	public CSpielFrame(boolean bFenster)
	{
		fenster = bFenster;

		jFrame.setTitle("Pac-Man");
		jFrame.setSize(frameWidth, frameHeight);
		jFrame.setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(CSpielFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		jFrame.addWindowListener(new WindowClosingListener(this));
		GridLayout oSpielFeldLayout = new GridLayout(50, 50);
		jFrame.setLayout(oSpielFeldLayout);
		jFrame.setVisible(true);
		jFrame.addKeyListener(new SteuerungListener());
		panelFeld = new JPanel[50][50];

		for (int iZeile = 0; iZeile < 50; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < 50; iSpalte++)
			{
				panelFeld[iZeile][iSpalte] = new JPanel();
				panelFeld[iZeile][iSpalte].addKeyListener(new SteuerungListener());
				panelFeld[iZeile][iSpalte].setBackground(Color.blue);
				jFrame.add(panelFeld[iZeile][iSpalte]);
			}
		}
		repaint();
		/*
		 * if(bWand)
		 * {
		 * 		System.out.println(""+aPanel[zaehler]);
		 * 
		 * 		aPanel[zaehler].setSize(laenge, breite);
		 * 		aPanel[zaehler].setLocation(zaehlerX, zaehlerY);
		 * 		aPanel[zaehler].setBackground(Color.BLUE);
		 * 		jFrame.add(aPanel[zaehler]);
		 * 		zaehler++;
		 * 
		 * 		jPanelOben1.setSize(laenge, breite);
		 * 		jPanelOben1.setLocation(zaehlerX, zaehlerY);
		 * 		jPanelOben1.setBackground(Color.BLUE);
		 * 		add(jPanelOben1);
		 * 		System.out.println("HALLO");
		 * 
		 * 		iZaehler++;
		 * }
		 * 
		 * if(iZaehler == 33)
		 * {
		 * 		iZaehler = 0;
		 * 		zaehlerX = 200;
		 * 		zaehlerY = zaehlerY + 25;
		 * 		zaehlerX = zaehler + laenge;
		 * }
		 * 
		 * zaehlerX = zaehler + laenge;
		 */
		fenster = false;
	}
	
//----------------------------------------------------------------------------------
	
	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll gestartet
	 */
	public void Darstellen()
	{
		System.out.println("MLG");
		for(int i = 0; i < 34; i++)
		{
			aPanel[i] = jPanelOben1;
			aPanel[i] = jPanelOben2;
			aPanel[i] = jPanelOben3;
			aPanel[i] = jPanelOben4;
			aPanel[i] = jPanelOben5;
			aPanel[i] = jPanelOben6;
			aPanel[i] = jPanelOben7;
			aPanel[i] = jPanelOben8;
			aPanel[i] = jPanelOben9;
			aPanel[i] = jPanelOben10;
			aPanel[i] = jPanelOben11;
			aPanel[i] = jPanelOben12;
			aPanel[i] =	jPanelOben13;
			aPanel[i] = jPanelOben14;
			aPanel[i] = jPanelOben15;
			aPanel[i] =	jPanelOben16;
			aPanel[i] = jPanelOben17;
			aPanel[i] = jPanelOben18;
			aPanel[i] = jPanelOben19;
			aPanel[i] = jPanelOben20;
			aPanel[i] = jPanelOben21;
			aPanel[i] = jPanelOben22;
			aPanel[i] = jPanelOben23;
			aPanel[i] = jPanelOben24;
			aPanel[i] = jPanelOben25;
			aPanel[i] = jPanelOben26;
			aPanel[i] = jPanelOben27;
			aPanel[i] = jPanelOben28;
			aPanel[i] = jPanelOben29;
			aPanel[i] = jPanelOben30;
			aPanel[i] = jPanelOben31;
			aPanel[i] = jPanelOben32;
			aPanel[i] = jPanelOben33;
		}
		TimerTask oTimerTask = new Task();		// Hier wird ein Obejkt der Klasse Task, welche von der Klasse Timertask erbt, erzeugt.
		oTimer.schedule(oTimerTask, 0, 150);	// Hier wird angegeben, wie oft die Methode run in der Unterclasse pro Sekunde aufgerufen werden soll.
	}

	//-------------------------------------------------------------------------------------------------------------------
			
	public static JPanel getSpieler()
	{
		return pSpieler;
	}
		
	//-------------------------------------------------------------------------------------------------------------------
		
	public static CSpielFrame getFrame()
	{
		return jFrame;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
		
	public static void spielerRunter()
	{
		iSpielery = pSpieler.getY();
		iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
		pSpieler.setLocation(pSpieler.getX(), iSpielery);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerRauf()
	{
		iSpielery = pSpieler.getY();
		iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
		pSpieler.setLocation(pSpieler.getX(), iSpielery);
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerLinks()
	{
		iSpielerx = pSpieler.getX();
		iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
		pSpieler.setLocation(iSpielerx, pSpieler.getY());
		bSpielerAktiv = true;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public static void spielerRechts()
	{
		iSpielerx = pSpieler.getX();
		iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
		pSpieler.setLocation(iSpielerx, pSpieler.getY());
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
			if(bSpielerAktiv == true)
			{
				iGeisty = pGeist.getY();
				iGeistx = pGeist.getX();
				
				Random zufallsZahl = new Random();	// zufallszahl für die Bewegung des Geistes generiern 
				int index = zufallsZahl.nextInt(8)+1;
					
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
					pSpieler.setBackground(Color.WHITE);
				}
			}
				
			setBackground(Color.WHITE);
			pGeist.setLocation(oGeist.getPosX(), oGeist.getPosY());
			pGeist.repaint();
		}
	}
}