package control.file_processing;

import java.util.ArrayList;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class GuiDB 
{
	private ArrayList<String> alZeilenString = new ArrayList<String>();
	
	/**
	 * Hier wird der Text in aufgespalten, wenn ein ";" sich inerhalb der Textdatei befindet.
	 * 
	 * @param sPath
	 */
	public GuiDB(String sPath) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> alGuiString = Tools.readGuiCSV(sPath);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzuf�gen
		for (String sZeile : alGuiString) 
		{	
			// Hier werden die Textteile "erzeugt", da diese mit dem Befehl split() aufgespalten werden
			String[] sTeile = sZeile.split(";");
			
			//Hier wird �berpr�ft, ob die L�nge gr��er als 6 ist
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