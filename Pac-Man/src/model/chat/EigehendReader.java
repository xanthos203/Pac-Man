package model.chat;

import view.frames.GameMainFrame;

/**
 *Diese Klasse namens <b>EigehendReader schreibt</b> den eingegebenen <b>Text</b> des Benutzers </b>in</b> den <b>Chatverlauf</b>.<br>
 *<i>Dieser Text</i> ist dann <b>für andere Spielteilnehmer sichtbar<b/> (also auch lesbar).<br>
 *<br>
 *Die Eingehend-Klasse <b>implementiert<b> das Interface <b>Runnable</b>.
 *Runnable wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 *
 * @version 1.0
 *
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class EigehendReader implements Runnable 
{
	/**Die Methode <b>"run" schreibt</b> den gewünschten <b>Text in</b> den <b>Chatverlauf</b>.*/
	public void run()
	{
		/*Die Variable "sNachricht" sorgt dafür, dass die Nachricht des Benutzers auch im Chatverlauf sichtbar wird,
		 *so dass ihn andere Sppielteilnehmer sehen können.*/
		String sNachricht;
		
		try
		{
			/*In der Variable "sNachricht" wird die entscprechende Nachricht gespeichert.
			 * Wenn der Wert der Nachricht nicht 0 ist,
			 * so wird diese Nachricht im Chatverlauf für mich und andere Benutzer sichtbar.*/
			while ((sNachricht = Client.getReader().readLine()) == null) 
			{
				/*Die gewünschte Message wird im Verlauf angezeigt.*/
				GameMainFrame.getChatverlaufTextarea().append(sNachricht + "\n");		
			}
		}
		/*Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.*/
		catch(Exception exException) 
		{
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	}
}