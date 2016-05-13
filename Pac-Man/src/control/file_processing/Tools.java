package control.file_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * In dieser Klasse wird die Textdatei mithilfe des BufferedReaders eingelesen und der Klasse CLogDB übergebben, damit diese die Daten verwenden kann.
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
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
	public static ArrayList<String> readGuiCSV(String sPath)
	{
		ArrayList<String> alGui = new ArrayList<String>();
		
		// Hier wird der BufferedReader erzeugt und die einzulesende Datei wird hinzugefügt.
		try (BufferedReader brReader = new BufferedReader(new FileReader(sPath)))
		{
			String sZeile = null;
			// Hier wird mit readLine die entsprechende Zeile eingelesen und der Variable sZeile zugewuiesen.
			while ((sZeile = brReader.readLine()) != null) 
			{
				// Hier wird die Zeile der ArrayList alGui geaddet
				alGui.add(sZeile);
			}
		}
		// Dies wird aufgerufen, wenn das try nicht ausgeführt werden kann
		catch (IOException ioException) 
		{
			// Hier wird die Exception geworfen, wenn das catch aufgerufen wird
			ioException.printStackTrace();
		}
		
		// wird die ArrayList alGui zurückgegeben
		return alGui;
	}
}