package frames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.CLogDB;

public class CSpielFrame 
{
	
	protected JFrame oFrame = new JFrame();
	
	static int zaehler =0;
	
	protected boolean fenster = false;

	public CSpielFrame()
	{
	}
//----------------------------------------------	
	public CSpielFrame( boolean bFenster)
	{
		fenster = bFenster;
		if(fenster == true)
		{
			System.out.println("HALLO");
			oFrame.setBounds(300,100 , 500, 500);
			//oFrame.setLayout(new FlowLayout());	
			oFrame.setVisible(true);
			fenster = false;
		}
	}
	
//---------------------------------------------------------	
	
	public void Muenzendarstellen() 
	{
			CMuenzendarstellen oMuenzen = new CMuenzendarstellen();
	}
		
//---------------------------------------------------------
		
	public void Darstellen()
	{	CDarstellen oDarstellen = new CDarstellen();
	}
}
