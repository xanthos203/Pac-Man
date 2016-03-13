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
	 * @param eTastendruck Taste gedr�ckt*/
	public void keyPressed(KeyEvent eTastendruck)
	{
		// F�r Spieler die mit "WASD" spielen m�chten
		if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
			CSpielFrame.spielerRunter();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
			CSpielFrame.spielerRauf();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
			CSpielFrame.spielerLinks();
		//----------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
			CSpielFrame.spielerRechts();
//============================================================\\
		// F�r Spieler die mit den Pfeiltasten spielen m�chten
		if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
			CSpielFrame.spielerRunter();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
			CSpielFrame.spielerRauf();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
			CSpielFrame.spielerLinks();
		//--------------------------------------------------
		if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
			CSpielFrame.spielerRechts();
//============================================================\\
		CSpielFrame.getSpieler().repaint();
	}

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}