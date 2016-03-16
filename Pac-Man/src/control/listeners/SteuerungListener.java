package control.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.frames.*;

/**Diese <i>Listener</i>-Klasse dient zur <b>Steuerung des Hauptcharakters Pac-Man</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>KeyListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class SteuerungListener implements KeyListener
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

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent keEvent) {}
	@Override
	public void keyReleased(KeyEvent keEvent) {}
}