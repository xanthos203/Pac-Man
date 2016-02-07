package control;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CLogzeile extends JFrame
{
	JFrame oFrame = new JFrame();
	JPanel contantPane = new JPanel();
	
	int zaehlerY=20;
	int zaehlerX=0;
	int laenge=20;
	int breite=5;
	
	static int zaehler =0;
	JPanel jPanel = new JPanel();
	
	public CLogzeile()
	{
		System.out.println("HALLO");
		oFrame.setBounds(300,100 , 500, 500);
		//oFrame.setLayout(new FlowLayout());
		contantPane.setMaximumSize(oFrame.getSize());
		oFrame.add(contantPane);		
		oFrame.setVisible(true);
	}
	
//------------------------------------------------------------------	
	

	public CLogzeile(String string1, String string2, String string3,
					 String string4, String string5, String string6)
	{
		System.out.printf("   " + string1 + " " + string2 + " " + string3 + " " + string4 + " " + string5 + " " + string6);
		
		if(string1.equals("0") )
		{
			Muenzendarstellen();
		}
		
		if(string2.equals("0") )
		{
			Muenzendarstellen();
		}
		
		if(string3.equals("0") )
		{
			Muenzendarstellen();
		}
		
		if(string4.equals("0") )
		{
			Muenzendarstellen();
		}
		
		if(string5.equals("0") )
		{
			Muenzendarstellen();
		}
		
		if(string6.equals("0") )
		{
			Muenzendarstellen();
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
	
	private void Muenzendarstellen() 
	{
		
	}
	
//---------------------------------------------------------
	
	public void Darstellen()
	{		
		jPanel.setBounds(zaehlerX,zaehlerY,laenge, breite);
		jPanel.setBackground(Color.BLUE);
		contantPane.add(jPanel);
		clear();
		System.out.println("1");
	}
	
	public void clear() 
	{
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                oFrame.removeAll();
                //oFrame.setLayout(new FlowLayout());
                oFrame.add(jPanel);
                oFrame.validate();
            }
        });
	}
}
