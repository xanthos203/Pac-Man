package control.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.frames.GameMainFrame;

/**Diese <i>Listener-Klasse</i> namens <b>SteuerungListener</b> dient zur <b>Steuerung des Hauptcharakters namens Pac-Man</b>.<br>
 * Der Benutzer hat dabei die Wahl, ob er <i>Pac-Man</i> mit den Tasten <b>WASD</b> oder den <b>Pfeiltasten</b> bedienen möchte.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>KeyAdapter</b>.<br>
 * Diese <i>"KeyAdapter-Klasse"</i> wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class SteuerungListener extends KeyAdapter
{
	/**Hier wird geschaut <b>welche Tasten der Spieler zum Steuern des Hauptcharakters verwendet</b>.<br>
	 * Mittels dieser Ermittlung werden entsprechende <b>Methoden</b> der <i>"GameMainFrame-Klasse"</i> <b>aufgerufen</b>.<br>
	 * 
	 * @param keyEvent In <i>"keyEvent"</i> wird die <i>gedrückte Taste gespeichert</i>.*/
	public void keyPressed(KeyEvent keyEvent)
	{
		/*Überprüfung der Tasten für die Option "WASD"
		 * Wenn der Benutzer die Taste "W" drückt, wird die Methode "spielerRauf()" in der Klasse "GameMainFrame" geöffnet.*/
		if((keyEvent.getKeyCode() == KeyEvent.VK_W) || (keyEvent.getKeyCode() == KeyEvent.VK_UP))
		{
			GameMainFrame.spielerRauf();
		}
		/* Wenn der Benutzer die Taste "A" drückt, wird die Methode "spielerLinks()" in der Klasse "GameMainFrame" geöffnet.*/
		if((keyEvent.getKeyCode() == KeyEvent.VK_A) || (keyEvent.getKeyCode() == KeyEvent.VK_LEFT))
		{
			GameMainFrame.spielerLinks();
		}
		/* Wenn der Benutzer die Taste "S" drückt, wird die Methode "spielerRunter()" in der Klasse "GameMainFrame" geöffnet.*/
		if((keyEvent.getKeyCode() == KeyEvent.VK_S) || (keyEvent.getKeyCode() == KeyEvent.VK_DOWN))
		{
			GameMainFrame.spielerRunter();
		}
		/* Wenn der Benutzer die Taste "D" drückt, wird die Methode "spielerRechts()" in der Klasse "GameMainFrame" geöffnet.*/
		if((keyEvent.getKeyCode() == KeyEvent.VK_D) || (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			GameMainFrame.spielerRechts();
		}
		
		
		if ((keyEvent.getKeyCode() == KeyEvent.VK_J) || (keyEvent.getKeyCode() == KeyEvent.VK_T))
		{
			GameMainFrame.getChatnachrichtTextfeld().requestFocus();
		}
	}
}