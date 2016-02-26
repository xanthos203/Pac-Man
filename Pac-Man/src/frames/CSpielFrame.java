package frames;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;

import characters.*;
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
	private int iSpielery;
	private int iSpielerx;
	
	private static int zaehler = 0;
	private static int iZaehler =1;
	
	private boolean fenster = false;
	private boolean bSpielerAktiv = false;
	public boolean bWand = true;
	
	//private CLogDB oCLog = new CLogDB();
	
	private static JPanel pSpieler = new JPanel();
	private JPanel pGeist = new JPanel();
	
	private CGeister oGeist = new CGeister();
	private CSpieler oSpieler = new CSpieler();
	
	private Timer oTimer = new Timer();
	private JPanel[] aPanel = new JPanel[800];
	
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
		if((fenster == true))
		{
			jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jFrame.setTitle("Pac-Man");
			jFrame.setSize(frameWidth, frameHeight);
			jFrame.setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
			jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(CSpielFrame.class.getResource("/images/Pac-Man_icon.PNG")));
			jFrame.setLayout(null);
			jFrame.setVisible(true);
			jFrame.addKeyListener(new CSteuerungListener());
			
			if(bWand)
			{
				System.out.println(""+aPanel[zaehler]);
				
				aPanel[zaehler].setSize(laenge, breite);
				aPanel[zaehler].setLocation( zaehlerX, zaehlerY);
				aPanel[zaehler].setBackground(Color.BLUE);
				jFrame.add(aPanel[zaehler]);
				zaehler++;
				
				jPanelOben1.setSize(laenge, breite);
				jPanelOben1.setLocation(zaehlerX, zaehlerY);
				jPanelOben1.setBackground(Color.BLUE);
				add(jPanelOben1);
				System.out.println("HALLO");
				
				iZaehler++;
			}
			
			if(iZaehler == 33)
			{
				iZaehler = 0;
				zaehlerX = 200;
				zaehlerY = zaehlerY + 25;
				zaehlerX = zaehler+laenge;
			}
			
			zaehlerX = zaehler+laenge;
			fenster = false;
		}
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
		TimerTask oTimerTask = new Task();		// Hier wird ein Obejkt der Classe Task welche von der Classe Timerrask erbt erzeugt.
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
		
	/**
	 * In dieser Klasse befindet sich die Methode run, welche f�r die Bewegung des Geistes zust�ndig ist.
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
				
				Random zufallsZahl = new Random();	// zufallszahl f�r die Bewegung des Geistes generiern 
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

//-------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Diese Listener-Klasse dient zur Steuerung des Hauptcharakters Pac-Man.
	 * @author Manuel Glantschnig
	 * @version 1.0
	 */
	private final class CSteuerungListener implements KeyListener
	{
		/**
		 * Hier wird der Spieler mit hilfe der Pfeiltasten zu Steuern.
		 * @param eTastendruck Taste gedr�ckt
		 */
		public void keyPressed(KeyEvent eTastendruck)
		{
		// F�r Spieler welche lieber mit "WASD" spielen
			if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
			{
				iSpielery = pSpieler .getY();
				iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(), iSpielery);
				bSpielerAktiv = true;
			}
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
			{
				iSpielery = pSpieler.getY();
				iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(), iSpielery);
				bSpielerAktiv = true;
			}		
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;
			}
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;
			}
			// F�r Spieler welche lieber mit den Pfeiltasten spielen
			if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
			{
				iSpielery = pSpieler .getY();
				iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(), iSpielery);
				bSpielerAktiv = true;
			}
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
			{
				iSpielery = pSpieler.getY();
				iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(), iSpielery);
				bSpielerAktiv = true;
			}		
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;
			}
				
			if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;
			}
			
			pSpieler.repaint();
		}

	//=================================================================\\
		
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
	}
}

