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
	 * @param keyEvent Taste gedr�ckt*/
	public void keyPressed(KeyEvent keyEvent)
	{
		// F�r Spieler die mit "WASD" spielen m�chten
		if((keyEvent.getKeyCode() == KeyEvent.VK_W))
		{
			System.out.println("rauf");
			GameMainFrame.spielerRauf();
		}
		//----------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_A))
		{
			System.out.println("links");
			GameMainFrame.spielerLinks();
		}
		//----------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_S))
		{
			System.out.println("runter");
			GameMainFrame.spielerRunter();
		}
		//----------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_D))
		{
			System.out.println("rechts");
			GameMainFrame.spielerRechts();
		}
//============================================================\\
		// F�r Spieler die mit den Pfeiltasten spielen m�chten
		if((keyEvent.getKeyCode() == KeyEvent.VK_UP))
		{
			GameMainFrame.spielerRauf();
		}
		//--------------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_LEFT))
		{
			GameMainFrame.spielerLinks();
		}
		//--------------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_DOWN))
		{
			GameMainFrame.spielerRunter();
		}
		//--------------------------------------------------
		if((keyEvent.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			GameMainFrame.spielerRechts();
		}
//============================================================\\
		GameMainFrame.getSpieler().repaint();
	}
}