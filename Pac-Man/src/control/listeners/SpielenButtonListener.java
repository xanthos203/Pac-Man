package control.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**Diese <i>Listener</i>-Klasse wird ausgeführt, wenn der Benutzer auf den Button "<b>SPIELEN</b>" klickt.<br>
 * Er wird dabei darüber informiert, dass das Spiel bereit zum Weiterspielen ist.<br>
 * Diese Klasse <b>implementiert</b> das Interface <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public final class SpielenButtonListener implements ActionListener
{
	/**Die Variable <i>frameReference</i> bestimmt die <b>Referenz auf das JFrame</b>.*/
	private JFrame frameReference;
	
	/**Dieser Konstruktor verlangt als Parameter eine <b>Referenz auf ein JFrame</b>.
	 * @param frame <i>Referenz</i> auf das <b>JFrame</b>*/
	public SpielenButtonListener(JFrame frame)
	{
		/*der Variable frameReference wird der Wert von frame zugewiesen
		 *und somit eine Referenz auf das Fenster erstellt, das den Konstruktor aufruft*/
		frameReference = frame;
	}
	
	/**Die <i>actionPerformed</i>-Methode fängt den <b>Knopfdruck</b> auf und verarbeitet diesen.
	 * @param aeEvent Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*in parentComponent wird gespeichert, auf welchem Fenster der Dialog angezeigt wird*/
		Component parentComponent = frameReference;
		/*in warning wird die Warnmeldung, die am optionPane angezeigt wird, gespeichert*/
		String warning = "Bereit zum Weiterspielen\u002E";
		/*in titel wird der Text, der in der Titelleiste des JOptionPane's angezeigt wird, gespeichert*/
		String titel = "Spiel\u00ADInformation";
		/*in optionType wird gespeichert, um welche "Art" von Auswahlmöglichkeiten es sich handelt*/
		int optionType = JOptionPane.OK_OPTION;
		/*in messageType wird die Art der Nachricht des JOptionPane's gespeichert*/
		int messageType = JOptionPane.INFORMATION_MESSAGE;
		/*in optionen werden die Möglichkeiten, die dem Benutzer zur Auswahl stehen, gespeichert*/
		Object[] optionen = { "OK" };
		
		/*hier wird der Input-Fokus für frameReference angefordert*/
		frameReference.requestFocusInWindow();
		
		/*hier wird ein neues JOptionPane erstellt, das den Benutzer fragt, ob er das Spiel wirklich beenden möchte*/
		JOptionPane.showOptionDialog(parentComponent, warning, titel, optionType, messageType, null, optionen, optionen[0]);
	}
}