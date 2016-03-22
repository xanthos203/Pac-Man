package control.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.frames.GameMainFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendr�cke abzufangen</b>.<br>
 * Au�erdem <b>�berpr�ft</b> diese Klasse, ob das Chatnachrichten-Feld im Fokus (=Cursor) steht, oder nicht.<br>
 * Sie <b>implementiert</b> die Interfaces <b>KeyListener</b> und <b>FocusListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class ChatNachrichtfeldListener implements KeyListener, FocusListener
{
	/**Die <i>focusGained</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld im Fokus steht.*/
	@Override
	public void focusGained(FocusEvent feEvent)
	{
		/*der Text des Textfeldes wird auf "" gesetzt*/
		GameMainFrame.getChatnachrichtTextfeld().setText(null);
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

	/**Die <i>keyPressed</i>-Methode f�ngt <b>Tastendr�cke</b> auf und verarbeitet diese.
	 * @param keEvent Tastendruck*/
	@Override
	public void keyPressed(KeyEvent keEvent)
	{
		/*wird ausgef�hrt, wenn die ENTER-Taste gedr�ckt wurde*/
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