package control.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.frames.GameMainFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendrücke abzufangen</b>.<br>
 * Außerdem <b>überprüft</b> diese Klasse, ob das Chatnachrichten-Feld im Fokus (=Cursor) steht, oder nicht.<br>
 * Sie <b>implementiert</b> die Interfaces <b>KeyListener</b> und <b>FocusListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public class ChatNachrichtfeldListener implements KeyListener, FocusListener
{
	/**Die <i>focusGained</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld im Fokus steht.*/
	@Override
	public void focusGained(FocusEvent feEvent)
	{
		/*der Text des Textfeldes wird auf "" gesetzt*/
		GameMainFrame.getTextfeld().setText(null);
	}

	/**Die <i>focusLost</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld den Fokus verliert.*/
	@Override
	public void focusLost(FocusEvent feEvent)
	{
		/*der im Textfeld eingegebene Text wird im Chatverlauf angezeigt*/
		GameMainFrame.chattextAnzeigen();
		/*der Text des Textfeldes wird auf "Nachricht eingeben" gesetzt*/
		GameMainFrame.getTextfeld().setText("Nachricht eingeben");
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

	@Override
	public void keyTyped(KeyEvent keEvent) {}
	@Override
	public void keyReleased(KeyEvent keEvent) {}
}