package control.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import frames.*;

/**Diese <i>Listener</i>-Klasse dient zur <b>Steuerung des Hauptcharakters Pac-Man</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>KeyListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class SteuerungListener implements KeyListener
{
	/**Das Objekt <i>oSpielFrame</i> wird benötigt, um den <b>Hauptcharakter Pac-Man steuern</b> zu können, da dessen <i>Bewegungen in der Klasse CSpielFrame definiert</i> werden.*/
	CSpielFrame oSpielFrame = new CSpielFrame();
	
	/**Hier wird der Spieler mit Hilfe der <i>Pfeiltasten</i> oder den Tasten "<i>WASD</i>" gesteuert.
	 * @param eTastendruck Taste gedrückt*/
	public void keyPressed(KeyEvent eTastendruck)
	{
		// Für Spieler die mit "WASD" spielen möchten
		if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
			oSpielFrame.spielerRunter();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
			oSpielFrame.spielerRauf();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
			oSpielFrame.spielerLinks();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
			oSpielFrame.spielerRechts();
//============================================================\\
		// Für Spieler die mit den Pfeiltasten spielen möchten
		if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
			oSpielFrame.spielerRunter();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
			oSpielFrame.spielerRauf();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
			oSpielFrame.spielerLinks();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
			oSpielFrame.spielerRechts();
//============================================================\\
		CSpielFrame.getSpieler().repaint();
	}

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}