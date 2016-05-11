package control.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.frames.GameMainFrame;

/**Diese <i>Listener</i>-Klasse dient zur <b>Steuerung des Hauptcharakters Pac-Man</b>.<br>
 * Sie <b>erbt</b> von der Klasse <b>KeyAdapter</b>.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public final class SteuerungListener extends KeyAdapter
{
	/**Hier wird der Spieler mit Hilfe der <i>Pfeiltasten</i> oder den Tasten "<i>WASD</i>" gesteuert.
	 * @param keyEvent Taste gedrückt*/
	public void keyPressed(KeyEvent keyEvent)
	{
	//  Für Spieler die mit "WASD" spielen möchten ODER Für Spieler die mit den Pfeiltasten spielen möchten
		if ((keyEvent.getKeyCode() == KeyEvent.VK_W) || (keyEvent.getKeyCode() == KeyEvent.VK_UP))
		{
			GameMainFrame.spielerRauf();
		}
		//-------------------------------------------------------------------------------------------
		if ((keyEvent.getKeyCode() == KeyEvent.VK_A) || (keyEvent.getKeyCode() == KeyEvent.VK_LEFT))
		{
			GameMainFrame.spielerLinks();
		}
		//-------------------------------------------------------------------------------------------
		if ((keyEvent.getKeyCode() == KeyEvent.VK_S) || (keyEvent.getKeyCode() == KeyEvent.VK_DOWN))
		{
			GameMainFrame.spielerRunter();
		}
		//-------------------------------------------------------------------------------------------
		if ((keyEvent.getKeyCode() == KeyEvent.VK_D) || (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			GameMainFrame.spielerRechts();
		}
//===========================================================================================================\\
		if ((keyEvent.getKeyCode() == KeyEvent.VK_T) || (keyEvent.getKeyCode() == KeyEvent.VK_J))
		{
			/*der Focus wird auf das Textfeld für Chatnachrichten gesetzt*/
			GameMainFrame.getChatnachrichtTextfeld().requestFocus();
		}
	}
}