package control.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.frames.GameMainFrame;

/**Diese <i>Listener-Klasse</i> namens <b>WindowListener</b> wird aufgerufen, wenn der Benutzer das <b>Programm schließen</b> möchte.<br>
 * Hierbei wird der Benutzer nocheinmal gefragt, ob er das Spiel wirklich beenden möchte.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>WindowAdapter</b>.
 * Diese <i>"KeyAdapter-Klasse"</i> wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 *
 * @version 1.0 
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class WindowListener extends WindowAdapter
{
	/**In der Variable <B>frameReference</B> wird gespeichert um <b>welches Fenster</b> es sich handelt, wenn diese Klasse aufgerufen wird.*/
	private JFrame frameReference;
	
	/**Im follgenden <b>Konstruktor</b> wird der <b>Wert der Variable "frame" in der Variable "frameReference" gespeichert</b>.
	 * @param frame Die Variable <i>frame</i> erstellt eine <i>Referenz</i> auf das <b>JFrame</b>.*/
	public WindowListener(JFrame frame)
	{
		/*In der Variable "frameReference" wird der Wert von der Variable "frame" gespeichert
		 und somit wird eine Referenz auf die jeweilige Klasse, die den Konstruktor bzw. den Listener aufruft, erstellt.*/
		frameReference = frame;
		/*Wenn man auf das "X" in der rechten oberern Ecke klickt, soll nichts passieren.*/
		frameReference.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	/**Die <b>"windowClosing-Methode" kommt immer dann zum Vorschein, wenn ein Benutzer das Programm schleißen möchte..<br>
	 * Es erscheint dann ein <i>"kleines Fenster"</i> am Bildschirm.
	 * @param weEvent Die Variable "<i>weEvent</i>" speichert, wenn ein Fenster geschlossen werden soll.*/
	@Override
	public void windowClosing(WindowEvent weEvent)
	{
		/*Die Variable "warning" speichert einen kleinen Warnhinweiß.*/
		String warning = "M\u00F6chten Sie das Spiel wirklich beenden\u003F";
		/*Die Variable "title" speichert den Text in der oberen (meist eingefärbten) Leiste.*/
		String titel = "Spiel beenden\u003F";
		/*In der Variable "optionPane" wird gespeichert, welchen Typ dieses optionPane hat.*/
		int optionType = JOptionPane.YES_NO_OPTION;
		/*In  der Variable "messageType" wird die Art der Nachricht des JOptionPanes gespeichert.*/
		int messageType = JOptionPane.QUESTION_MESSAGE;
		/*"optionen" speichert die Möglichkeiten, die dem Benutzer zur Auswahl stehen, wenn er das Programm beendet.*/
		Object[] optionen = { "Beenden", "Abbrechen" };
		
		/*Wenn die Variable "frameReference" nicht null ist, wird follgendes ausgeführt.*/
		if(frameReference instanceof GameMainFrame)
		{
			/*Zu dem Text der Variable "warning" wird noch ein Teil hinzugefügt.*/
			warning += "\n\nDadurch geht Ihr gesamter Spielfortschritt verloren\u0021";
		}
		
		/*Ein neues JOptionPane wird erstellt. Dieses fragt den Benutzer, ob er das Spiel wirklich beenden möchte.*/
		int optionPane = JOptionPane.showOptionDialog(null, warning, titel, optionType, messageType, null, optionen, optionen[0]);
		
		/*Follgendes wird ausgeführt, wenn der Benutzer auf "Beenden" klickt.*/
		if(optionPane == JOptionPane.YES_OPTION)
		{
			/*Das Programm wird beendet*/
			System.exit(0);
		}
	}
}