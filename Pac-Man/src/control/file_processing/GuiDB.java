package control.file_processing;

import java.util.ArrayList;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 *
 * In dieser Klasse wird der eingelesene Text gesplittet und in eine ArrayList von dem Datentype CLogzeile() gespeichert.
 *
 */
public class GuiDB 
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
	public GuiDB(String sPath) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> alGuiString = Tools.readGuiCSV(sPath);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzufügen
		for (String sZeile : alGuiString) 
		{	
			// Hier werden die Textteile "erzeugt", da diese mit dem Befehl split() aufgespalten werden
			String[] sTeile = sZeile.split(";");
			
			//Hier wird überprüft, ob die Länge größer als 6 ist
			if (sTeile.length >= 6) 
			{
				for (int i = 0; i < sTeile.length - 1; i++)
				{
					alZeilenString.add(sTeile[i]);
				}				
			}
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getArrayList()
	{
		return alZeilenString;
	}
}