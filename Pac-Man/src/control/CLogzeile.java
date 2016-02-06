package control;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CLogzeile 
{
	JFrame oFrame = new JFrame();
	JPanel contantPane = new JPanel();
	
	int zaehlerY=20;
	int zaehlerX=0;
	int laenge=20;
	int breite=5;
	static int zaehler =0;
	
	public CLogzeile()
	{
		oFrame.add(contantPane);
		oFrame.setLayout(new FlowLayout());
		oFrame.setBounds(300,100 , 500, 500);
		oFrame.setVisible(true);
	}
	
//------------------------------------------------------------------	
	
	public CLogzeile(String string1, String string2, String string3,
					 String string4, String string5, String string6)
	{
		if(string1.equals("0") )
		{
			
		}
		
		if(string2.equals("0") )
		{
			
		}
		
		if(string3.equals("0") )
		{
			
		}
		
		if(string4.equals("0") )
		{
			
		}
		
		if(string5.equals("0") )
		{
			Darstellen();
		}
		
		if(string6.equals("0") )
		{
		
		}
//-------------------------------\\			
		if(string1.equals("1") )
		{
			Darstellen();
		}
		
		if(string2.equals("1") )
		{
			Darstellen();
		}
		
		if(string3.equals("1") )
		{
			Darstellen();
		}
		
		if(string4.equals("1") )
		{
			Darstellen();
		}
		if(string5.equals("1") )
		{
			Darstellen();
		}
		
		if(string6.equals("1") )
		{
			Darstellen();
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
	
//---------------------------------------------------------	
	
	public void Darstellen()
	{
		JPanel jPanel = new JPanel();
		jPanel.setBounds(zaehlerX,zaehlerY,laenge, breite);
		jPanel.setBackground(Color.BLUE);
		contantPane.add(jPanel);
		oFrame.repaint();
		
	}
}
