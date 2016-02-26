package control;

import java.awt.event.*;
import frames.CSpielFrame;

/**Diese Listener-Klasse dient zur Steuerung des Hauptcharakters Pac-Man.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class SteuerungListener implements KeyListener
{
	/**Hier wird der Spieler mit Hilfe der Pfeiltasten oder den Tasten "WASD" gesteuert.
	 * @param eTastendruck Taste gedrückt*/
	public void keyPressed(KeyEvent eTastendruck)
	{
		// Für Spieler welche lieber mit "WASD" spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
		{
			CSpielFrame.spielerRunter();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
		{
			CSpielFrame.spielerRauf();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
		{
			CSpielFrame.spielerLinks();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
		{
			CSpielFrame.spielerRechts();
		}
		// Für Spieler welche lieber mit den Pfeiltasten spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
		{
			CSpielFrame.spielerRunter();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
		{
			CSpielFrame.spielerRauf();
		}		
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
		{
			CSpielFrame.spielerLinks();
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			CSpielFrame.spielerRechts();
		}
		
		CSpielFrame.getSpieler().repaint();
	}

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}