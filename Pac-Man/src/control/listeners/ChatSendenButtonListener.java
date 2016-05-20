package control.listeners;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frames.GameMainFrame;

/**Diese <i>Listener-Klasse</i> namens <b>ChatSendenButtonListener</b> wird aufgerufen,<br>
 * sobald der Button <b>"SENDEN" des Chats betätigt wird</b>.<br>
 * Diese Klasse ist dafür verantwortlich, dass der <b>eingegebene Text</b> (im Chat) <b>für andere Spielteinehmer sichtbar</b> wird.<br>
 * Somit können die <i>verschiedensten Spieler miteinander kommunizieren</i>.<br>
 * Nebenbei wird der "<b>Fokus</b>" des Cursors wieder <b>auf</b> das <b>Textfeld</b>,<br>
 * wo der <i>Spieler die Möglichkeit hat mit anderen Benutzern zu kommunizieren</i>, <b>gelegt</b>.<br>
 * <br>
 * Diese Klasse <b>implementiert</b> das Interface namens <b>ActionListener</b>.
 * Dieser ActionListener wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class ChatSendenButtonListener implements ActionListener
{
	/**Die <b>actionPerformed-Methode fängt</b> die getätigten <b>Tastendrücke des "SENDEN-Button" ab</b>.<br>
	 * Diese Methode <b>ergreift</b> auch die <b>entsprechenden Maßnahmen</b>.<br>
	 * Solche Maßnahmen wären ,wie oben bereits angesprochen, den eingegebenen <i>Text im Chatverlauf sichtbar machen</i> <br>
	 * (so, dass ihn andere Spielteilnehmer sehen bzw. lesen können),<br>
	 * oder dass der <i>Fokus</i> wieder auf das jeweilige <i>Textfeld gelegt</i> wird.<br>
	 * <br>
	 * @param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der <b>Button betätigt</b> wurde.*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*Der im Textfeld eingegebene Text wird im Chatverlauf sichtbar gemacht.
		 * Andere Spieler können nun diese Nachricht lesen und auch darauf antworten, wenn Sie dies erwünschen.*/
		GameMainFrame.chattextAnzeigen();
		/*Der Fokus des Cursors wird auf das Textfeld gelegt.*/
		GameMainFrame.getChatnachrichtTextfeld().requestFocus();
	}
}