package control.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.frames.CSpielFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendr�cke abzufangen</b>.<br>
 * Au�erdem <b>�berpr�ft</b> diese Klasse, ob das Chatnachrichten-Feld im Fokus (=Cursor) steht, oder nicht.<br>
 * Sie <b>implementiert</b> die Interfaces <b>KeyListener</b> und <b>FocusListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public class ChatNachrichtfeldListener implements KeyListener, FocusListener
{
	/**Die <i>focusGained</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld im Fokus steht.*/
	@Override
	public void focusGained(FocusEvent e)
	{
		CSpielFrame.getTextfeld().setText(null);
	}

	/**Die <i>focusLost</i>-Methode wird aufgerufen, wenn das Chatnachrichten-Feld den Fokus verliert.*/
	@Override
	public void focusLost(FocusEvent e)
	{
		CSpielFrame.chattextAnzeigen();
		CSpielFrame.getTextfeld().setText("Nachricht eingeben");
	}

	/**Die <i>keyPressed</i>-Methode f�ngt <b>Tastendr�cke</b> auf und verarbeitet diese.
	 * @param e Tastendruck*/
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			CSpielFrame.chattextAnzeigen();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}