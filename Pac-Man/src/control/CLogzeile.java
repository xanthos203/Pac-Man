package control;

import javax.swing.*;

import frames.*;
import view.*;

public class CLogzeile extends JFrame
{

	CMuenzendarstellen oMuenzendarstellen;
	CSpielFrame oDarstellen;
	
public CLogzeile()
{
	
}
	
//----------------------------------------------------------------------
	
	public CLogzeile(String string1, String string2, String string3,
					 String string4, String string5, String string6)
	{
		oMuenzendarstellen = new CMuenzendarstellen();
		oDarstellen = new CSpielFrame();
		
		//Test zum Sehen ob richtig eingelesen wurde
		//System.out.printf("   " + string1 + " " + string2 + " " + string3 + " " + string4 + " " + string5 + " " + string6);
		
		if(string1.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		if(string2.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		if(string3.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		if(string4.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		if(string5.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		if(string6.equals("0") )
		{
			oMuenzendarstellen.Muenzendarstellen();
		}
//-------------------------------\\			
		if(string1.equals("1") )
		{
			oDarstellen.Darstellen();
		}
		
		if(string2.equals("1") )
		{
			oDarstellen.Darstellen();
		}
		
		if(string3.equals("1") )
		{
			oDarstellen.Darstellen();
		}
		
		if(string4.equals("1") )
		{
			oDarstellen.Darstellen();
		}
		if(string5.equals("1") )
		{
			oDarstellen.Darstellen();
		}
		
		if(string6.equals("1") )
		{
			oDarstellen.Darstellen();
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

