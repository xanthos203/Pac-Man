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
			jPanel = new JPanel();
			jPanel.setBounds(zaehlerX,zaehlerY,laenge, breite);
			jPanel.setBackground(Color.BLUE);
			getContentPane().add(jPanel);
			
			System.out.println("HALLO");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(300,100 , 500, 500);
			setVisible(true);
			fenster = false;
		}
	}
	
	public void Darstellen()
	{
		
	}
}
