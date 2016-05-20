package control.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.frames.GameMainFrame;

/**In der <i>Listener-Klasse</i> namens <b>ChatNachrichtfeldListener</b> wird der eingegebene Text des Beutzers verarbeitet.<br>
 * Diese Klasse ermittelt die eingegebene Zeichenkombination,die der Benutzer eingibt.<br>
 * Ebenfalls wird <b>überprüft</b>, ob das <b>Nachrichtenfeld im Fokus steht</b>.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>KeyAdapter</b> und <b>implementiert</b> das Interface <b>FocusListener</b>.
 * Diese <i>"KeyAdapter-Klasse"</i> und der <i>"FocusListener"</i> wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class ChatNachrichtfeldListener extends KeyAdapter implements FocusListener
{
	/**Die <b>focusGained-Methode</b> wird aufgerufen, wenn das Nachrichtenfeld im Fokus steht.
	 * Hier wird das Textfeld des Chats geleert und der Spieler deaktiviert.<br>
	 * 
	 * @param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der <b>Fokus auf dem Chat</ib> liegt.*/
	@Override
	public void focusGained(FocusEvent feEvent)
	{
		/*Der Text des Textfeldes wird auf 0 gesetzt.
		 * Also wird dafür gesorgt, dass nichts im Textfeld steht.*/
		GameMainFrame.getChatnachrichtTextfeld().setText(null);
		/*Der Spieler wird hierbei deaktiviert den Spieler bzw. startet das Spiel.*/
		GameMainFrame.setSpielerAktiv(false);
	}

	/**Die <b>focusLost-Methode</b> schaut, ob der <B>Chat aktiv benutzt wird</b>,<br>
	 *  oder ob Pac-Man (der Hauptcharakter) gesteuert wird.
	 *  Wird der <b>Fokus auf Pac-Man</b> gerichtet, so wird diese <b>Methode ausgeführt</b>.<br>
	 *  <br>
	 *  Dem <b>Textfeld</b> wird der <b>Text "Nachricht eingeben" hinzugefügt</b>.<br>
	 *  Dieser Text ist nur <i>sichtbar</i>, wenn der Spieler im <i>Textfeld nichts eingibt</i>.<br>
	 *  Wenn der <i>Benutzer</i> jedoch einen <i>Text verfasst</i>, <br>
	 *  so wird die Methode <b>"chattextAnzeigen()"</b> in der Klasse "GameMainFrame" <b>aufgerufen</b>.<br>
	 *  
	 *  @param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der <b>Fokus auf dem Chat</b> liegt.*/
	@Override
	public void focusLost(FocusEvent feEvent)
	{
		/*Der im Textfeld eingegebene Text wird im Chatverlauf angezeigt.
		 * Nun wird der eingegebene Text für andere Spielteilnehmer lesbar.*/
		GameMainFrame.chattextAnzeigen();
		/*Dem Textfeld wird der Text "Nachricht eingben" hinzugefügt.
		 * Dieser Text verschwindet, sobald der Benutzer seinen gewünschten Nachrichtentext eingibt.*/
		GameMainFrame.getChatnachrichtTextfeld().setText("Nachricht eingeben");
	}

	/**Die <b>keyPressed-Methode fängt</b> die <b>Tastendrücke</b> des Benutzers <b>auf</b> der Tastatur auf und verarbeitet diese.<br>
	 * Durch das <b>Verarbeiten</b> der Tastendrücke ergibt sich ein <b>zusammenhängender Text</b> (der gewünschte Text des Benutzers),<br>
	 * welcher von <i>anderen Spielteilnehmern gelesen</i> werden kann, sobald der Benutzer auf <i>"ENTER" drückt</i>.<br>
	 *  
	 *@param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der <b>Button betätigt</b> wurde.*/
	@Override
	public void keyPressed(KeyEvent keEvent)
	{
		/*Wenn die "ENTER-Taste" betätigt wird, wird follgendes ausgeführt.*/
		if(keEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*Die im Textfeld sich befindliche Nachricht wird im Chatverlauf angezeigt.*/
			GameMainFrame.chattextAnzeigen();
		}
	}
}