package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;

import Figuren.CGeister;
import Figuren.CSpieler;
import control.*;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public final class CSpielFrame extends JFrame
{
	private JPanel jPanelOben1 = new JPanel();
	private JPanel jPanelOben2 = new JPanel();
	private JPanel jPanelOben3 = new JPanel();
	private JPanel jPanelOben4 = new JPanel();
	private JPanel jPanelOben5 = new JPanel();
	private JPanel jPanelOben6 = new JPanel();
	private JPanel jPanelOben7 = new JPanel();
	private JPanel jPanelOben8 = new JPanel();
	private JPanel jPanelOben9 = new JPanel();
	private JPanel jPanelOben10= new JPanel();
	private JPanel jPanelOben11= new JPanel();
	private JPanel jPanelOben12= new JPanel();
	private JPanel jPanelOben13= new JPanel();
	private JPanel jPanelOben14= new JPanel();
	private JPanel jPanelOben15= new JPanel();
	private JPanel jPanelOben16= new JPanel();
	private JPanel jPanelOben17= new JPanel();
	private JPanel jPanelOben18= new JPanel();
	private JPanel jPanelOben19= new JPanel();
	private JPanel jPanelOben20= new JPanel();
	private JPanel jPanelOben21= new JPanel();
	private JPanel jPanelOben22= new JPanel();
	private JPanel jPanelOben23= new JPanel();
	private JPanel jPanelOben24= new JPanel();
	private JPanel jPanelOben25= new JPanel();
	private JPanel jPanelOben26= new JPanel();
	private JPanel jPanelOben27= new JPanel();
	private JPanel jPanelOben28= new JPanel();
	private JPanel jPanelOben29= new JPanel();
	private JPanel jPanelOben30= new JPanel();
	private JPanel jPanelOben31= new JPanel();
	private JPanel jPanelOben32= new JPanel();
	private JPanel jPanelOben33= new JPanel();
	
	private int zaehlerY = 0;
	private int zaehlerX = 200;
	private int laenge = 50;
	private int breite = 10;
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
	private JPanel[] aPanel = new JPanel[800];
	
	public CSpielFrame()
	{
		for(int i=1; i<34; i++)
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
	}
	
//----------------------------------------------	
	
	/**
	 * 
	 * @param bFenster
	 * 
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
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
			setLayout( null);
			setVisible(true);
			
			/*for(int i=1; i<34; i++)
			{
				aPanel[i].setSize(laenge, breite);
				aPanel[i].setLocation( zaehlerX, zaehlerY);
				aPanel[i].setBackground(Color.BLUE);
				add(aPanel[i]);
				zaehlerX = zaehler+laenge;
			}*/
			jPanelOben1.setSize(laenge, breite);
			jPanelOben1.setLocation(zaehlerX, zaehlerY);
			jPanelOben1.setBackground(Color.BLUE);
			add(jPanelOben1);
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
	
	/**
	 * In dieser Klasse befindet sich die Methode run, welche für die Bewegung des Geistes zuständig ist.
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
				
				Random zufallsZahl = new Random();	// zufallszahl für die Bewegung des Geistes generiern 
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
	 * Hier wird der Spieler mit hilfe der Pfeiltasten zu Steuern.
	 */
	public void keyPressed(KeyEvent arg0) 
	{
		// Für Spieler welche lieber mit wasd Spielen.		
		if(arg0.getKeyCode()== KeyEvent.VK_S)
		{
			iSpielery = pSpieler .getY();
			iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(),iSpielery);
			bSpielerAktiv = true;
				
		}
			
		if(arg0.getKeyCode()== KeyEvent.VK_W)
		{
			iSpielery = pSpieler.getY();
			iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(),iSpielery);
			bSpielerAktiv = true;
		}		
			
		if(arg0.getKeyCode()== KeyEvent.VK_A)
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;		
			
		}
			
		if(arg0.getKeyCode()== KeyEvent.VK_D)
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}		
		
//=================================================================\\
		
		// für Benutzer, welche lieber mit den Pfeiltasten arbeiten.
		if(arg0.getKeyCode()== KeyEvent.VK_DOWN)
		{
			iSpielery = pSpieler.getY();
			iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(),iSpielery);
			bSpielerAktiv = true;
		}
			
		if(arg0.getKeyCode()== KeyEvent.VK_UP)
		{
			iSpielery = pSpieler.getY();
			iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(),iSpielery);
			bSpielerAktiv = true;
		}		
			
		if(arg0.getKeyCode()== KeyEvent.VK_LEFT)
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;		
			
		}
			
		if(arg0.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}		
		 pSpieler.repaint();
	}
}