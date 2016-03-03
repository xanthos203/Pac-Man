package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Chat.*;

import characters.*;
import control.*;
import control.file_processing.CLogDB;
import control.listeners.*;
import interfaces.*;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 */
public class CSpielFrame extends JFrame implements IWindowProperties
{
	private static JFrame frame;
	private ArrayList<String> spielFeldArray;
	
	private int iGeisty;
	private int iGeistx;
	private int iLayoutZeilen = 28;
	private int iLayoutSpalten = 33;
	private static int iSpielery;
	private static int iSpielerx;
	
	private static boolean bSpielerAktiv = false;
	
	private static JPanel pSpieler = new JPanel();
	private JPanel pGeist = new JPanel();
	
	private CGeister oGeist = new CGeister();
	private static CSpieler oSpieler = new CSpieler();
	
	private Timer oTimer = new Timer();
	
	private JPanel[][] panelFeld;
	
	private CLogDB logdb = new CLogDB(System.getProperty("user.dir") + "\\src\\view\\GUI.csv");
	private int feld = -1;
	
	private JPanel centerPanel = new JPanel();
	private JPanel chatPanel = new JPanel();
	
	private JLabel textlabel = new JLabel("               CHAT               ");
	private JPanel panel = new JPanel();
	private static JTextArea area = new JTextArea();
	private static JTextField field = new JTextField();
	private Server serv;
	private Client client=new Client();
	
	/**
	 * Hier wird das Fenster erstellt und Sichtbargeschalten
	 */
	public CSpielFrame()
	{			
		client.netzwerkEinrichten();
		Thread readerThread = new Thread(new EigehendReader());
		readerThread.start();
		Darstellen();
		
		
		frame = this;
		spielFeldArray = logdb.getArrayList();
		
		setTitle("Pac-Man");
		setSize(frameWidth, frameHeight);
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CSpielFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowClosingListener(this));
		setLayout(new BorderLayout());
		
		GridLayout oSpielFeldLayout = new GridLayout(iLayoutZeilen, iLayoutSpalten);
		centerPanel.setLayout(oSpielFeldLayout);
		add(centerPanel, BorderLayout.CENTER);
		
		chatPanel.setSize(200,200);	
		chatPanel.setLayout(new BorderLayout());
		
		area.setEditable(false);
		panel.add(field);
		JScrollPane scrollPane = new JScrollPane(area);
		chatPanel.add(textlabel, BorderLayout.NORTH);
		field.setSize(panel.getWidth(),panel.getHeight());
		field.setColumns(10);
		field.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(!field.getText().equals(null))
					{
						area.setText(area.getText() + "\n" + field.getText());
						field.setText(null);
					}
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		chatPanel.add(panel, BorderLayout.SOUTH);
		chatPanel.add(scrollPane, BorderLayout.CENTER);
		
		add(chatPanel, BorderLayout.WEST);
		
		setVisible(true);
		centerPanel.addKeyListener(new SteuerungListener());
		panelFeld = new JPanel[50][50];

		for (int iZeile = 0; iZeile < iLayoutZeilen; iZeile++)
		{
			for (int iSpalte = 0; iSpalte < iLayoutSpalten; iSpalte++)
			{
				feld++;
				if(spielFeldArray.size() > feld)
				{
					if(spielFeldArray.get(feld).equals("1"))
					{
						panelFeld[iZeile][iSpalte] = new JPanel();
						panelFeld[iZeile][iSpalte].addKeyListener(new SteuerungListener());
						panelFeld[iZeile][iSpalte].setBackground(Color.blue);
						centerPanel.add(panelFeld[iZeile][iSpalte]);
					}
					
					if(spielFeldArray.get(feld).equals("0"))
					{
						panelFeld[iZeile][iSpalte] = new JPanel();
						panelFeld[iZeile][iSpalte].addKeyListener(new SteuerungListener());
						panelFeld[iZeile][iSpalte].setBackground(Color.lightGray);
						centerPanel.add(panelFeld[iZeile][iSpalte]);
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
	
	public static JTextField getSchreibFeld()
	{
		return field;
	}
	
	public static JTextArea getArea()
	{
		return area;
	}
	
	//----------------------------------------------------------------------------------
	
	/**
	 * Hier wird der Timer der sagt wie oft der Geist pro Sekunde aufgerufen werden soll gestartet
	 */
	public void Darstellen()
	{
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
		return (CSpielFrame) frame;
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
			if(!field.getText().equals(null))
			{
				client.senden();
				Server.esAllenWeitersagen(field.getText());
			}			
			
			if(bSpielerAktiv == true)
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
				}
				
				setBackground(Color.WHITE);
				pGeist.setLocation(oGeist.getPosX(), oGeist.getPosY());
				pGeist.repaint();*/
			}
		}
	}
}