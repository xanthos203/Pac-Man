package control;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import frames.CSpielFrame;

public class CLogzeile extends JFrame
{

	CSpielFrame oSpielFrame;
	
public CLogzeile()
{
	
}
	
//----------------------------------------------------------------------
	
	public CLogzeile(String string1, String string2, String string3,
					 String string4, String string5, String string6)
	{
		oSpielFrame = new CSpielFrame();
		
		//Test zum Sehen ob richtig eingelesen wurde
		//System.out.printf("   " + string1 + " " + string2 + " " + string3 + " " + string4 + " " + string5 + " " + string6);
		
		if(string1.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
		
		if(string2.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
		
		if(string3.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
		
		if(string4.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
		
		if(string5.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
		
		if(string6.equals("0") )
		{
			oSpielFrame.Muenzendarstellen();
		}
//-------------------------------\\			
		if(string1.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		
		if(string2.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		
		if(string3.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		
		if(string4.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		if(string5.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		
		if(string6.equals("1") )
		{
			oSpielFrame.Darstellen();
		}
		
//-------------------------------\\	
		
		if(string1.equals("2") )
		{
			
		}
		
		if(string2.equals("2") )
		{
			
		}
		
		if(string3.equals("2") )
		{
			
		}
		
		if(string4.equals("2") )
		{
			
		}
		if(string5.equals("2") )
		{
			
		}
		
		if(string6.equals("2") )
		{
			
		}

//-------------------------------\\	
		
		if(string1.equals("3") )
		{
			
		}
				
		if(string2.equals("3") )
		{
			
		}
				
		if(string3.equals("3") )
		{
			
		}
				
		if(string4.equals("3") )
		{
			
		}
		
		if(string5.equals("3") )
		{
			
		}
		
		if(string6.equals("3") )
		{
			
		}
	
	}
}

