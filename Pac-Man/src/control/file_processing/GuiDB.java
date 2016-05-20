package control.file_processing;

import java.util.ArrayList;

/**
 * Diese Klasse namens <b>GuiDB verarbeitet</b> die <b>Datei</b> der <i>"Tools-Klasse"</i>.<br>
 * Diese <i>Datei</i> wird nun in <b>28 Zeilen aufgesplittet</b> und in <i>einer ArrayList gespeichert</i>.<br>
 *
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class GuiDB 
{
	/**Eine ArrayList von Datentyp "String" mit dem Namen <b>"alZeilenString"</b> wird <b>erstellt</b>.*/
	private ArrayList<String> alZeilenString = new ArrayList<String>();
	
	/**
	 * Hier wird die <b>Datei der "Toolsklasse"</b> in einer <b>ArrayList gespeichert</b>.
	 * Diese Datei wird <b>aufgespalten</b>, sobald sich ein <i>";" innerhalb der Textdatei</i> befindet.
	 * 
	 * @param sPath<br>
	 * In der Variable <i>"sPath"</i> ist die <b>"csv-Datei"</b> der Toolsklasse <b>gespeichert</b>.
	 */
	public GuiDB(String sPath) 
	{
		/*Die für das Spielfeld relevante Datei (von der "Tools-Klasse") wird in der zuvor erstellten ArrayList gespeichert.*/
		ArrayList<String> alGuiString = Tools.readGuiCSV(sPath);
		
		/*Diese Arraylist wird nun in der Variable "sZeile" gespeichert.*/
		for (String sZeile : alGuiString)
		{
			/*Immer, wenn sich ein ";" in einer Zeile befindet wird dieser Teil gesplittet.
			 *Diese aufgespaltenen Zeilen werden anschließend in dem Array "sTeile" gespeichert.*/
			String[] sTeile = sZeile.split(";");
			
			/*Wenn die Länge dieser Zeilen größer als 6 ist wird folgendes ausgeführt.*/
			if (sTeile.length >= 6) 
			{
				/*Immer, wenn die Länge der Zeile kleiner als die Variable "i" ist, wird folgendes ausgeführt.
				 * Die Variable "i" erhöht sich jedes Mal um 1.
				 * "i" hat als Startwert 0.*/
				for (int i = 0; i < sTeile.length - 1; i++)
				{
					/*Der ArrayIist "alZeilenString" wird das Array "sTeile" hinzugefügt.*/
					alZeilenString.add(sTeile[i]);
				}				
			}
		}
	}
	
	/**In der folgenden Methode wird die <b>ArrayList "alZeilenString" zurückgegeben</b>.
	 * 
	 * @return alZeilenString <br>
	 * In der ArrayList <i>"alZeilenString"</i> ist das Array <i>"sTeile" gespeichert</i>.*/
	public ArrayList<String> getArrayList()
	{
		/*Die ArrayList "alZeilenString" wird zurückgegeben.*/
		return alZeilenString;
	}
}