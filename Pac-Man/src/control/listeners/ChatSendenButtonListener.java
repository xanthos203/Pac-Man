package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frames.GameMainFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um den <b>Knopfdruck des "SENDEN" abzufangen</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public class ChatSendenButtonListener implements ActionListener
{
	/**Die <i>actionPerformed</i>-Methode f�ngt den <b>Knopfdruck</b> auf und verarbeitet diesen.
	 * @param aeEvent Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*der im Textfeld eingegebene Text wird im Chatverlauf angezeigt*/
		GameMainFrame.chattextAnzeigen();
		/*der Fokus (Cursor) wird zur�ck auf das Textfeld gesetzt*/
		GameMainFrame.getTextfeld().requestFocus();
	}
}