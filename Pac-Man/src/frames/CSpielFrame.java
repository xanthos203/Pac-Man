package frames;

import java.awt.*;

import javax.swing.*;

import control.*;

public class CSpielFrame extends JFrame
{
	private JPanel jPanel;
	private int zaehlerY = 20;
	private int zaehlerX = 0;
	private int laenge = 20;
	private int breite = 5;
	private int screenWidth	= Toolkit.getDefaultToolkit().getScreenSize().width;
	private int	screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int	frameWidth = 1100;
	private int	frameHeight	= 735;
	
	private static int zaehler =0;
	
	private boolean fenster = false;
	
	private CLogDB oCLog = new CLogDB();

	public CSpielFrame()
	{
		
	}
//----------------------------------------------	
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
			setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
			setVisible(true);
			
			
			jPanel = new JPanel();
			jPanel.setBounds(zaehlerX, zaehlerY, laenge, breite);
			jPanel.setBackground(Color.BLUE);
			getContentPane().add(jPanel);
			
			fenster = false;
		}
	}
	
	public void Darstellen()
	{
		
	}
}
