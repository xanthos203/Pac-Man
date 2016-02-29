package control.file_processing;

import java.util.ArrayList;

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
			
			// Hier werden die Texteile "erzeugt" da diese mit dem Befehl split() aufgespalten werden
			String[] teile = zeile.split(";");
			
			
			//Manchmal fehlt die letzte Spalte (Information)
			logzeile = null;
			
			//Hier wierd überprüft, ob die länge größer oder kleiner wie 6 ist
			if (teile.length >= 6) 
			{
				//Hier wierd der Hauptkonstruktor der Klasse CLogzeile aufgerufen und die Teile werden dem Kosnturkor übergeben
				logzeile = new CLogzeile(teile[0],  teile[1],  teile[2],  teile[3],  teile[4],  teile[5], 
										 teile[6],  teile[7],  teile[8],  teile[9],  teile[10], teile[11],
										 teile[12], teile[13], teile[14], teile[15], teile[16], teile[17],
										 teile[18], teile[19], teile[20], teile[21], teile[22], teile[23],
										 teile[24], teile[25], teile[26], teile[27], teile[28], teile[29],
										 teile[30], teile[31], teile[32]); 
			}
						
			// hier wird der ArrayList log die Werte mit Hilfe eine Objektes der Klasse CLogzeile hinzugefügt
			log.add(logzeile);
			
		}
	}
//--------------------------------------------------------
	public CLogDB() {}
}
