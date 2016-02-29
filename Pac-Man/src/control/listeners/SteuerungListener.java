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
	/***/
	CSpielFrame oFrame = new CSpielFrame();
	
	/**Hier wird der Spieler mit Hilfe der <i>Pfeiltasten</i> oder den Tasten "<i>WASD</i>" gesteuert.
	 * @param eTastendruck Taste gedrückt*/
	public void keyPressed(KeyEvent eTastendruck)
	{
		// Für Spieler welche lieber mit "WASD" spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
		{
			oFrame.spielerRunter();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
		{
			oFrame.spielerRauf();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
		{
			oFrame.spielerLinks();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
		{
			oFrame.spielerRechts();
		}
		// Für Spieler welche lieber mit den Pfeiltasten spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
		{
			oFrame.spielerRunter();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
		{
			oFrame.spielerRauf();
		}		
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
		{
			oFrame.spielerLinks();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			oFrame.spielerRechts();
		}
		
		oFrame.getSpieler().repaint();
	}

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}