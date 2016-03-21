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
public final class LogDB 
{
	private ArrayList<String> alZeilenString = new ArrayList<String>();
	
	/**
	 * 
	 * @param sPath
	 * 
	 * Hier wierd der Text in aufgespalten, wenn ein ; sich inerhalb der Textdatei befindet.
	 * Die Strings werden dem entsprechendem Konstruktor in der Klasse CLogzeile übergeben.
	 * 
	 */
	public LogDB(String sPath) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> alLogString = Tools.readGuiCSV(sPath);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzufügen
		for (String sZeile : alLogString) 
		{	
			// Hier werden die Texteile "erzeugt" da diese mit dem Befehl split() aufgespalten werden
			String[] sTeile = sZeile.split(";");
			
			//Hier wierd überprüft, ob die länge größer oder kleiner wie 6 ist
			if (sTeile.length >= 6) 
			{
				//Hier wierd der Hauptkonstruktor der Klasse CLogzeile aufgerufen und die Teile werden dem Kosnturkor übergeben
				for(int i = 0; i < sTeile.length - 1; i++)
				{
					alZeilenString.add(sTeile[i]);
				}				
			}		
			// hier wird der ArrayList log die Werte mit Hilfe eine Objektes der Klasse CLogzeile hinzugefügt		
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getArrayList()
	{
		return alZeilenString;
	}
}