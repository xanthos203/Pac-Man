package control.file_processing;

import java.io.*;
import java.util.*;

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
	 * @param path
	 * @return
	 * 
	 * In dieser Methode wird Mithilfe des BufferedReaders eingelesen und verwendet.
	 * 
	 */
	public ArrayList<String> readLogCSV(String path) 
	{
		ArrayList<String> log = new ArrayList<String>();
		
		try 
		{
			// Hier wird der BufferedReader erzeugt und die einzulesende Datei wird Hinzugefügt.
			BufferedReader in = new BufferedReader(new FileReader(path));
			String zeile = null;
			
			// Hier wird mit readLine die entsprechende Zeile eingelesen und der Variable zeile zugewuiesen.
			while ((zeile = in.readLine()) != null) 
			{
				// Hier wierd die Zeile der ArrayList log geaddet
				log.add(zeile);
			}
			// Dies Beendet das Einlesen der Datei
			in.close();
		}
		// Dies wird aufgerufen, wenn das try nicht ausgeführt werden kann
		catch (IOException e) 
		{
			// Hier wierd die Exception geworfen, wenn das catch aufgerufen wierd
			e.printStackTrace();
		}
		
		// wird die ArrayList log zurückgegeben
		return log;
	}
}