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
	 * Die Strings werden dem entsprechendem Konstruktor in der Klasse CLogzeile �bergeben.
	 * 
	 */
	public CLogDB(String path) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> logString = Tools.readLogCSV(path);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzuf�gen
		for (String zeile : logString) 
		{
			
			// Hier werden die Texteile "erzeugt" da diese mit dem Befehl split() aufgespalten werden
			String[] teile = zeile.split(";");
			
			
			//Manchmal fehlt die letzte Spalte (Information)
			logzeile = null;
			
			//Hier wierd �berpr�ft, ob die l�nge gr��er wie 6 ist
			if (teile.length >= 6) 
			{
				//Hier wierd der Hauptkonstruktor der Klasse CLogzeile aufgerufen und die Teile werden dem Kosnturkor �bergeben
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], teile[5]); 
			}
			else 
			{
				// Hier wierd der Zweite Konstruktor der Klasse CLogzeile auf gerufen, welcher weniger Parameter hat als der Haupkonstruktor
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], " ");
			}
			
			// hier wird der ArrayList log die Werte mit Hilfe eine Objektes der Klasse CLogzeile hinzugef�gt
			log.add(logzeile);
			
		}
	}
//--------------------------------------------------------
	public CLogDB() {}
}
