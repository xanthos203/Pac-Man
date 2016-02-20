package frames;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;

import Figuren.*;
import control.*;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public final class CSpielFrame extends JFrame
{
	private JPanel jPanel;
	private int zaehlerY = 20;
	private int zaehlerX = 0;
	private int laenge = 20;
	private int breite = 5;
	private int screenWidth	= Toolkit.getDefaultToolkit().getScreenSize().width;
	private int	screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int	frameWidth = 1100;
	private int	frameHeight	= 745;
	
	private int iGeisty;
	private int iGeistx;
	private int iSpielery;
	private int iSpielerx;
	
	private static int zaehler = 0;
	
	private boolean fenster = false;
	private boolean bSpielerAktiv = false;
	
	private CLogDB oCLog = new CLogDB();
	
	private static JPanel pSpieler = new JPanel();
	private JPanel pGeist = new JPanel();
	
	private CGeister oGeist = new CGeister();
	private CSpieler oSpieler = new CSpieler();
	
	private Timer oTimer = new Timer();
	
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
			System.out.println("HALLO");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Pac-Man");
			setSize(frameWidth, frameHeight);
			setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
			setIconImage(Toolkit.getDefaultToolkit().getImage(CSpielFrame.class.getResource("/images/Pac-Man_icon.PNG")));
			setVisible(true);
			addKeyListener(new CSteuerungListener());
			
			jPanel = new JPanel();
			jPanel.setSize(laenge, breite);
			jPanel.setLocation(zaehlerX, zaehlerY);
			jPanel.setBackground(Color.BLUE);
			add(jPanel);
			
			fenster = false;
		}
	}
//----------------------------------------------------------------------------------
	
	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll
	 */
	public void Darstellen()
	{
		TimerTask oTimerTask=new Task();		// Hier wird ein Obejkt der Classe Task welche von der Classe Timerrask erbt erzeugt.
		oTimer.schedule(oTimerTask,0, 150);		// Hier wird angegeben, wie oft die Methode run in der Unterclasse pro Sekunde aufgerufen werden soll.
	}

	//-------------------------------------------------------------------------------------------------------------------
			
		public static JPanel getSpieler()
		{
			return pSpieler;
		}
		
	//-------------------------------------------------------------------------------------------------------------------
		
		public static CSpielFrame getFrame()
		{
			return getFrame();
		}

			
	//-------------------------------------------------------------------------------------------------------------------
		
	/**
	 * In dieser Klasse befindet sich die Methode run, welche f�r die Bewegung des Geistes zust�ndig ist.
	 * @author Thomas Mader-Ofer
	 *
	 */
	class Task extends TimerTask
	{

		public void run()
		{
			if(bSpielerAktiv == true)
			{
				iGeisty = pGeist.getY();
				iGeistx = pGeist.getX();
				
				Random zufallsZahl = new Random();	// zufallszahl f�r die Bewegung des Geistes generiern 
				int index = zufallsZahl.nextInt(8)+1;
					
				for(int iZaehler=0; iZaehler<=4; iZaehler++)
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
									
				if((oGeist.getPosX()== iSpielerx)&&(oGeist.getPosY()== iSpielery))
				{
					pSpieler.setBackground(Color.WHITE);
				}
			
			}
				
			setBackground(Color.WHITE);
			pGeist.setLocation(oGeist.getPosX(),oGeist.getPosY());
			pGeist.repaint();
		 }
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Diese Listener-Klasse dient zur Steuerung des Hauptcharakters Pac-Man.
	 * @author Manuel Glantschnig
	 * @version 1.0
	 */
	class CSteuerungListener implements KeyListener
	{
		/**
		 * Hier wird der Spieler mit hilfe der Pfeiltasten zu Steuern.
		 * @param eTastendruck Taste gedr�ckt
		 */
		public void keyPressed(KeyEvent eTastendruck)
		{
	// F�r Spieler welche lieber mit wasd Spielen.		
			if(eTastendruck.getKeyCode()== KeyEvent.VK_S)
			{
				iSpielery = pSpieler .getY();
				iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(),iSpielery);
				bSpielerAktiv = true;
					
			}
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_W)
			{
				iSpielery = pSpieler.getY();
				iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(),iSpielery);
				bSpielerAktiv = true;
			}		
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_A)
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;		
				
			}
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_D)
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;
			}		
	//=================================================================\\
	// f�r Benutzer, welche lieber mit den Pfeiltasten arbeiten.
			if(eTastendruck.getKeyCode()== KeyEvent.VK_DOWN)
			{
				iSpielery = pSpieler.getY();
				iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(),iSpielery);
				bSpielerAktiv = true;
			}
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_UP)
			{
				iSpielery = pSpieler.getY();
				iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
				pSpieler.setLocation(pSpieler.getX(),iSpielery);
				bSpielerAktiv = true;
			}		
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_LEFT)
			{
				iSpielerx = pSpieler.getX();
				iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
				pSpieler.setLocation(iSpielerx, pSpieler.getY());
				bSpielerAktiv = true;		
				
			}
				
			if(eTastendruck.getKeyCode()== KeyEvent.VK_RIGHT)
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