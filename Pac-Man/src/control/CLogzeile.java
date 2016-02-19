package control;

import javax.swing.*;

import frames.*;
import view.*;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 0.1
 * 
 * In dieser Klasse werden nur die Stringinhalte im Konstruktor überprüft und die entsprechenden Methoden werden aufgerufen.
 *
 */
public class CLogzeile extends JFrame
{
	private CMuenzendarstellen oMuenzendarstellen;
	private CSpielFrame oDarstellen;
	// dient nur zu Erstellen von Objekten ohne Parameter. 
	public CLogzeile()	{}
	
//----------------------------------------------------------------------
	/**
	 * 
	 * @param string1
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 * @param string6
	 * 
	 * Hier in diesem Konstruktor wird überprüft, welcher wert in den Strings 1-6 steht,
	 *  und dann wird damit die Entsprechende Methode aufgerufen.
	 */
	// Hier werden die Eingelesenen Werte übergeben und dann auf ihren Inhalt überprüft.
	public CLogzeile(String string1, String string2, String string3,
					 String string4, String string5, String string6)
	{
		oMuenzendarstellen = new CMuenzendarstellen();
		oDarstellen = new CSpielFrame();
		
		//Test zum Sehen ob richtig eingelesen wurde
		//System.out.printf("   " + string1 + " " + string2 + " " + string3 + " " + string4 + " " + string5 + " " + string6);
		
		// Hier wird geschaut ob 0 im String steht.
		if(string1.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string2.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string3.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string4.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string5.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string6.equals("0") )
		{
			// Hier wird die Münzendarstellen Methode in der Klasse CSpielFrame aufgerufen.
			oMuenzendarstellen.Muenzendarstellen();
		}
//-------------------------------\\		
		
		// Hier wird geschaut ob 0 im String steht.
		if(string1.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
			oDarstellen.Darstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string2.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
			oDarstellen.Darstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string3.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
			oDarstellen.Darstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string4.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
			oDarstellen.Darstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string5.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
			oDarstellen.Darstellen();
		}
		
		// Hier wird geschaut ob 0 im String steht.
		if(string6.equals("1") )
		{
			// Hier wird die Darstellen Methode in der Klasse CSpielFrame aufgerufen.
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