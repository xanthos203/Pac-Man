package frames;

import java.awt.*;

import javax.swing.*;

import control.*;

public class CSpielFrame extends JFrame
{
	JPanel jPanel;
	int zaehlerY=20;
	int zaehlerX=0;
	int laenge=20;
	int breite=5;
	int screenWidth	= Toolkit.getDefaultToolkit().getScreenSize().width;
	int	screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int	frameWidth = 1100;
	int	frameHeight	= 735;
	
	static int zaehler =0;
	
	protected boolean fenster = false;
	
	CLogDB oCLog = new CLogDB();

	public CSpielFrame()
	{
		
	}
//----------------------------------------------	
	public CSpielFrame( boolean bFenster)
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
			jPanel.setBounds(zaehlerX,zaehlerY,laenge, breite);
			jPanel.setBackground(Color.BLUE);
			getContentPane().add(jPanel);
			
			fenster = false;
		}
	}
	
	public void Darstellen()
	{
		
	}
}
