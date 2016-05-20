package control.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**Diese <i>Listener-Klasse</i> namens <b>SpielernButtonListener</b> wird ausgeführt, sobald der Benutzer auf den Button <b>"SPIELEN" betätigt</b>.<br>
 * Der Benutzer bekommt dabei die <b>Information</b>, dass das <b>Spiel zum Weiterspielen bereit</b> ist.<br>
 * <br>
 * Diese Klasse <b>implementiert</b> das Interface <b>ActionListener</b>.
 * Dieser ActionListener wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0 
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class SpielenButtonListener implements ActionListener
{
	/**In der Variable <b>frameReference</b> wird das Fenster gespeichert, von welchem der Knopfdruck kommt.</b>.*/
	private JFrame frameReference;
	
	/**Dieser Konstruktor <b>speichert den Wert</b> der Variable <b>"frame" in</b> der Variable <b>"frameReference"</b>.
	 * 
	 * @param frame Die Variable <i>frame</i> erstellt eine <b>Referenz</b> auf das <b>JFrame</b>, von dem der Knopfdruck kommt.*/
	public SpielenButtonListener(JFrame frame)
	{
		/*In der Variable "frameReference" wird der Wert von "frame" gespeichert
		 *und somit wird eine Referenz auf das jeweilige Fenster erstellt, das den Konstruktor aufruft.*/
		frameReference = frame;
	}
	
	/**Die <b>actionPerformed-Methode</b> wird aufgerufen, sobald der Button <b>"SPIELEN" betätigt</b> wurde.<br>
	 * Diese Methode entscheidet auch was als <b>nächstes im Programm passieren soll</b> <br>
	 * und <b>ergreift</b> dementsprechend die dafür <b>erforderlichen Maßnahmen</b>.<br>
	 * <br>
	 * Sobald der Benutzer diesen <b>Knopf betätigt</b>, geht eine <b>Hinweismeldung</b> auf.<br>
	 * Diese Hinweismeldung beinhaltet den <i>Nachrichtentext "Bereit zum Weiterspielen."</i>.<br>
	 * Danach kann der Benutzer ganz normal seinem <i>Spielfortschritt folgen</i>.<br>
	 * 
	 *@param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der <b>Button betätigt</b> wurde.*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*In der Variable "parentComponent" wird gespeichert, auf welchem Fenster die Hinweismeldung angezeigt werden soll.*/
		Component parentComponent = frameReference;
		/*Die Variable "warning" speichert den Text der bei der Hinweismeldung ausgegeben wird.
		 *Diese Nachricht leutet "Bereit zum Weiterspielen.".*/
		String warning = "Bereit zum Weiterspielen\u002E";
		/*Die Variable "titel" speichert den Text der in der Titelleiste steht.*/
		String titel = "Spiel\u00ADInformation";
		/*In der Variable "optionType" wird gespeichert, um welche "Art" von Auswahlmöglichkeiten es sich handelt.
		 *In diesem Fall kann man die Antwort "OK" mittels Knopfdruck eines Buttons geben.*/
		int optionType = JOptionPane.OK_OPTION;
		/*In der Variable "messageType" wird die Art der Nachricht des JOptionPanes gespeichert.
		 *In diesem Fall wird eine Informationsnachricht ausgegeben.*/
		int messageType = JOptionPane.INFORMATION_MESSAGE;
		/*Die Variable "optionen" speichert alle Möglichkeiten, die dem Benutzer zur Antwort zur Auswahl stehen.*/
		Object[] optionen = { "OK" };
		
		/*Hier wird der "Input-Fokus" für die Variable "frameReference" angefordert*/
		frameReference.requestFocusInWindow();
		
		/*Ein neues JOptionPane wird erstellt. Dieses fragt den Benutzer, ob er das Spiel wirklich beenden möchte.*/
		JOptionPane.showOptionDialog(parentComponent, warning, titel, optionType, messageType, null, optionen, optionen[0]);
	}
}