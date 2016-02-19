package control;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeMap;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 *
 * In dieser Klasse wird der eingelesene Text gesplittet und in eine ArrayList von dem Datentype CLogzeile() gespeichert.
 *
 */

public class CLogDB 
{
	public ArrayList<CLogzeile> log = new ArrayList<CLogzeile>();
	private CLogzeile logzeile = new CLogzeile();
	
	/**
	 * 
	 * @param path
	 * 
	 * Hier wierd der Text in aufgespalten, wenn ein ; sich inerhalb der Textdatei befindet.
	 * Die Strings werden dem entsprechendem Konstruktor in der Klasse CLogzeile übergeben.
	 * 
	 */
	public CLogDB(String path) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> logString = Tools.readLogCSV(path);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzufügen
		for (String zeile : logString) 
		{
			String[] teile = zeile.split(";");
			
			//Manchmal fehlt die letzte Spalte (Information)
			logzeile = null;
			
			if (teile.length >= 6) 
			{
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], teile[5]); 
			}
			
			else 
			{
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], " ");
			}
			
			log.add(logzeile);
		}
	}
//--------------------------------------------------------
	public CLogDB() 
	{
		// TODO Auto-generated constructor stub
	}
}
