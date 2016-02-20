package control;

import javax.swing.*;

import frames.*;
import view.*;

/**
 * 
 * @author Thomas Mader-Ofer, Manuel Glantschnig, Cristina Erhart 
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
					 String string4, String string5, String string6, String string7, String string8, String string9,
					 String string10, String string11, String string12, String string13, String string14, String string15,
					 String string16, String string17, String string18, String string19, String string20, String string21,
					 String string22, String string23, String string24, String string25, String string26, String string27,
					 String string28, String string29, String string30, String string31, String string32, String string33)
	{
		oMuenzendarstellen = new CMuenzendarstellen();
		oDarstellen = new CSpielFrame();
		
		String[] sString1bis33 = new String[33];
		
		sString1bis33[0]= string1;
		sString1bis33[1]= string2;
		sString1bis33[2]= string3;
		sString1bis33[3]= string4;
		sString1bis33[4]= string5;
		sString1bis33[5]= string6;
		sString1bis33[6]= string7;
		sString1bis33[7]= string8;
		sString1bis33[8]= string9;
		sString1bis33[9]= string10;
		sString1bis33[10]= string11;
		sString1bis33[11]= string12;
		sString1bis33[12]= string13;
		sString1bis33[13]= string14;
		sString1bis33[14]= string15;
		sString1bis33[15]= string16;
		sString1bis33[16]= string17;
		sString1bis33[17]= string18;
		sString1bis33[18]= string19;
		sString1bis33[19]= string20;
		sString1bis33[20]= string21;
		sString1bis33[21]= string22;
		sString1bis33[22]= string23;
		sString1bis33[23]= string24;
		sString1bis33[24]= string25;
		sString1bis33[25]= string26;
		sString1bis33[26]= string27;
		sString1bis33[27]= string28;
		sString1bis33[28]= string29;
		sString1bis33[29]= string30;
		sString1bis33[30]= string31;
		sString1bis33[31]= string32;
		sString1bis33[32]= string33;

		
		for(int i =0; i< sString1bis33.length;i++)
		{
			if(sString1bis33[i].equals("1"))
			{
				oDarstellen.Darstellen();
			}
			else
			{
				if(sString1bis33[i].equals("0"))
				{
					
				}
			}
		}
		
	}
}