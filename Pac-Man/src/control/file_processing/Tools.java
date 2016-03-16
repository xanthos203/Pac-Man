package control.file_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Thomas Mader-Ofer
 * @version 1.0
 * 
 * In dieser Klasse wierd die Textdatei mithilfe des BufferedReaders eingelesen und der Klasse CLogDB übergebben, damit diese die Daten verwenden kann.
 */

public final class Tools 
{
	/**
	 * 
	 * @param sPath
	 * @return
	 * 
	 * In dieser Methode wird Mithilfe des BufferedReaders eingelesen und verwendet.
	 * 
	 */
	public ArrayList<String> readGuiCSV(String sPath) 
	{
		ArrayList<String> alLog = new ArrayList<String>();
		
		try 
		{
			// Hier wird der BufferedReader erzeugt und die einzulesende Datei wird Hinzugefügt.
			BufferedReader brReader = new BufferedReader(new FileReader(sPath));
			String sZeile = null;
			
			// Hier wird mit readLine die entsprechende Zeile eingelesen und der Variable zeile zugewuiesen.
			while ((sZeile = brReader.readLine()) != null) 
			{
				// Hier wird die Zeile der ArrayList log geaddet
				alLog.add(sZeile);
			}
			// Dies Beendet das Einlesen der Datei
			brReader.close();
		}
		// Dies wird aufgerufen, wenn das try nicht ausgeführt werden kann
		catch (IOException ioException) 
		{
			// Hier wird die Exception geworfen, wenn das catch aufgerufen wierd
			ioException.printStackTrace();
		}
		
		// wird die ArrayList log zurückgegeben
		return alLog;
	}
}