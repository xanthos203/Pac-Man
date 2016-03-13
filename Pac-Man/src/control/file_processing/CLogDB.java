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
	private ArrayList<String> zeilenString = new ArrayList<String>();
	private Tools tool = new Tools();
	
	public CLogDB() {}
	
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
		ArrayList<String> logString = tool.readGuiCSV(path);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzuf�gen
		for (String zeile : logString) 
		{	
			// Hier werden die Texteile "erzeugt" da diese mit dem Befehl split() aufgespalten werden
			String[] teile = zeile.split(";");
			
			//Hier wierd �berpr�ft, ob die l�nge gr��er oder kleiner wie 6 ist
			if (teile.length >= 6) 
			{
				//Hier wierd der Hauptkonstruktor der Klasse CLogzeile aufgerufen und die Teile werden dem Kosnturkor �bergeben
				for(int i = 0; i < teile.length - 1; i++)
				{
					zeilenString.add(teile[i]);
				}				
			}		
			// hier wird der ArrayList log die Werte mit Hilfe eine Objektes der Klasse CLogzeile hinzugef�gt		
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getArrayList()
	{
		return zeilenString;
	}
}