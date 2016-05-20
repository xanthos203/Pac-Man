package control.file_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Diese Klasse namens <b>Tools liest</b> mithilfe eines sog. BufferedReader eine <b>csv-Datei ein</b>.<br>
 * Diese <i>csv-Datei</i> wird anschließend der <i>Klasse</i> <b>"CLogDB"</b> zur <i>Weiterverarbeitung</i> <b>übergeben</b>.
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
	 * In der nachstehenden Methode namens <b>ArrayList<String> readGuiCSV</b> wird die für den Spielbereich<br>
	 * relevante <b>csv-Datei eingelesen</b> und <b>für</b> die <b>weitere Verarbeitung vorbereitet</b>.<br>
	 * 
	 * @param sPath<br>
	 * In der Variable <i>"sPath"</i> ist die <b>"csv-Datei"</b> gespeichert.
	 * 
	 * @return alGui<br>
	 * In der Variable <i>"alGui</i> ist die <b>verarbeitete csv-Datei</b> gespeichert.
	 */
	public static ArrayList<String> readGuiCSV(String sPath)
	{
		/*Die ArrayList "alGui" (vom Datentyp "String") wird erstellt.*/
		ArrayList<String> alGui = new ArrayList<String>();
		
		/* Im folgenden Abschnitt wird ein sogenannter "BufferedReader" mit dem Namen "brReader" erzeugt.
		 * Dieser Reader liest die "csv-Datei" ein und verarbeitet diese so, dass man mit dieser Datei wieter Maßnahmen ergreifen kann.*/
		try (BufferedReader brReader = new BufferedReader(new FileReader(sPath)))
		{
			/* Eine Variable namens "sZeile" (vom Datentyp "String") wird erstellt.
			 * In dieser Variable ist der Wert "null" gespeichert.*/
			String sZeile = null;
			
			/* Die eingelesene Datei wird in der Variable "sZeile" gespeichert.
			 * Solange "sZeile" nicht den Wert "null" hat, wird "sZeile" in der ArrayList "alGui" gespeichert. 
			 * Also immer, wenn sich etwas neues in der eingelesenen Datei befindet, wird dieses "Teil" der ArrayList "alGui" hizugefügt.*/
			while ((sZeile = brReader.readLine()) != null) 
			{
				/* Der ArrayList "alGui" wird die Variable "sZeile" hinzugefügt.*/
				alGui.add(sZeile);
			}
		}
		/* Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.
		 * Eine Exception ist im Grunde genommen nichts anderes als eine Fehlermeldung, die am Bildschirm sichtbar angezeigt wird.
		 * Diese Fehlermeldung wird also auch für den Benutzer des Spiels sichtbar.*/
		catch (IOException ioException) 
		{
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			ioException.printStackTrace();
		}
		
		/* Die ArrayList "alGui" wird zurückgegeben.*/
		return alGui;
	}
}