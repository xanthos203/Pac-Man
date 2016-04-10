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
	 * @param keEvent Taste gedrückt*/
	public void keyPressed(KeyEvent keEvent)
	{
		// Für Spieler die mit "WASD" spielen möchten
		if((keEvent.getKeyCode() == KeyEvent.VK_S))
			GameMainFrame.spielerRunter();
		//----------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_W))
			GameMainFrame.spielerRauf();
		//----------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_A))
			GameMainFrame.spielerLinks();
		//----------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_D))
			GameMainFrame.spielerRechts();
//============================================================\\
		// Für Spieler die mit den Pfeiltasten spielen möchten
		if((keEvent.getKeyCode() == KeyEvent.VK_DOWN))
			GameMainFrame.spielerRunter();
		//--------------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_UP))
			GameMainFrame.spielerRauf();
		//--------------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_LEFT))
			GameMainFrame.spielerLinks();
		//--------------------------------------------------
		if((keEvent.getKeyCode() == KeyEvent.VK_RIGHT))
			GameMainFrame.spielerRechts();
//============================================================\\
		GameMainFrame.getSpieler().repaint();
	}
}