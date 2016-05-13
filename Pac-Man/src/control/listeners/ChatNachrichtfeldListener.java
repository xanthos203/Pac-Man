package control.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.frames.GameMainFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendrücke abzufangen</b>.<br>
 * Außerdem <b>überprüft</b> diese Klasse, ob das Chatnachrichten-Feld im Fokus (=Cursor) steht, oder nicht.<br>
 * Sie <b>erbt</b> von der Klasse <b>KeyAdapter</b> und <b>implementiert</b> das Interface <b>FocusListener</b>.
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public final class ChatNachrichtfeldListener extends KeyAdapter implements FocusListener
{
	/**Die <i>focusGained</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld im Fokus steht.*/
	@Override
	public void focusGained(FocusEvent feEvent)
	{
		/*der Text des Textfeldes wird auf "" gesetzt*/
		GameMainFrame.getChatnachrichtTextfeld().setText(null);
		/*die Aktivität des Spielers im GameMainFrame wird auf false gesetzt*/
		GameMainFrame.setSpielerAktiv(false);
	}

	/**Die <i>focusLost</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld den Fokus verliert.*/
	@Override
	public void focusLost(FocusEvent feEvent)
	{
		/*der im Textfeld eingegebene Text wird im Chatverlauf angezeigt*/
		GameMainFrame.chattextAnzeigen();
		/*der Text des Textfeldes wird auf "Nachricht eingeben" gesetzt*/
		GameMainFrame.getChatnachrichtTextfeld().setText("Nachricht eingeben");
	}

	/**Die <i>keyPressed</i>-Methode fängt <b>Tastendrücke</b> auf und verarbeitet diese.
	 * @param keEvent Tastendruck*/
	@Override
	public void keyPressed(KeyEvent keEvent)
	{
		/*wird ausgeführt, wenn die ENTER-Taste gedrückt wurde*/
		if(keEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*der im Textfeld eingegebene Text wird im Chatverlauf angezeigt*/
			GameMainFrame.chattextAnzeigen();
		}
	}
}