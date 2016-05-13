package control.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.frames.GameMainFrame;
import view.frames.LogInFrame;

/**Diese <i>Listener-Klasse</i> namens <b>TextfieldListener</b> �berpr�ft,<br>
 * ob der <b>eingegebene gew�nschte Spielername bestimmten Kriterien entspricht</b>.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>KeyAdapter</b>.
 * Dieser "KeyAdapter" wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class TextfieldListener extends KeyAdapter
{
	/**Die <b>maxZeichenLaenge</b> bestimmt, <b>wie viele Zeichen maximal im Textfeld</b> des "LogInFrames" <b>eingegeben werden k�nnen</b>.<br>
	 * In diesem Fall wird die <i>maxZeichenLaenge</i> auf <i>18 Zeichen begrenzt</i>.<br>
	 * Das hei�t, dass man als gew�nschten Spielernamen maximal 18 Buchstaben bzw. Zahlen eingeben kann.<br>*/
	private int		maxZeichenLaenge = 18;
	/**Die Variable <b>referenceFrame</b> speichert die Information, von <b>welchem Fenster aus der Listener aufgerufen wurde</b>.*/
	private JFrame 	referenceFrame;
	/**Die Variable <b>referenceTextField</b> speichert die Information, von <b>welchem Textfeld aus der Listener aufgerufen wurde</b>.*/
	private JTextField  referenceTextField;
	
	/**Im Konstruktor wird festgehalten, auf <b>welches Fenster</b> und auf <b>welches Textfeld</b> sich der Listener bezieht.
	 * 
	 * @param dialog Die Referenzvariable <i>dialog</i> ist vom Typ <i>JDialog</i>.
	 * @param textField Die Referenzvariable <i>textField</i> ist vom Typ <i>JTextField</i>.*/
	public TextfieldListener(JFrame dialog, JTextField textField)
	{
		/*Die Variable "referenceDialog" speichert den Wert der Variable "dialog"
		 *und erstellt so eine Referenz auf die jeweilige Klasse, die den Konstruktor bzw. den Listener aufruft.*/
		referenceFrame = dialog;
		/*Die Variable "referenceTextField" speichert den Wert der Variable "textField".
		 *und erstellt so eine Referenz auf das jeweilige Textfeld, das den Konstruktor bzw. den Listener aufruft.*/
		referenceTextField = textField;
	}
	
	/**Die <b>keyPressed-Methode</b> f�ngt alle <b>Tastendr�cke</b>, die bei der <i>Eingabe des Benutzernamens bet�tigt werden</i>, ab und <b>ergreift entsprechende Ma�nahmen</b>.<br>
	 * Solche Ma�nahmen w�ren zum Beispiel, wenn das <i>Textfeld leer</i> bleibt wird ein <i>Fehler</i> ausgegeben oder<br>
	 * wenn ein <i>Leerzeichen eingegeben</i> wurde wird eine <i>Fehlermeldung</i> ausgegeben.<br>
	 * 
	 * @param keyEvent Die Variable "<b>keyEvent</b>" speichert die <b>bereits gedr�ckten Tastendr�cke</b>.*/
	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		/*Wenn die "ENTER-Taste" gedr�ckt wurde, werden entsprechende Abfragen get�tigt.*/
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*Wenn sich kein Text im Textfeld befindet wird follgendes ausgef�hrt.*/
			if (referenceTextField.getText().isEmpty())
			{
				/*Eine sog. Fehlermeldung wird ausgegeben, um den Benutzer auf seinen Fehler aufmerksam zu machen.*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021\n"
												  + "Der Spielername darf nur Buchstaben und Zahlen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*Der bereits eingegebene Text im Textfeld wird gel�scht.*/
				referenceTextField.setText(null);
				/*Das Programm startet von Vorne.*/
				return;
			}
			/*Wenn der gew�nschte Benutzername Leerzeichen enth�lt, wird follgendes ausgef�hrt.*/
			if (referenceTextField.getText().contains(" ") && (referenceTextField.getText().length() < maxZeichenLaenge))
			{
				/*Eine sog. Fehlermeldung wird ausgegeben, um den Benutzer auf seinen Fehler aufmerksam zu machen.*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Leerzeichen ein\u0021\n"
												  + "Der Spielername darf keine Leerzeichen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*Der bereits eingegebene Text im Textfeld wird gel�scht.*/
				referenceTextField.setText(null);
				/*Das Programm startet von Vorne.*/
				return;
			}
			/*Wenn die maximale Zeichenl�nge des eingegebenen Benutzernamens �berschritten ist, wird follgendes ausgef�hrt.*/
			if (referenceTextField.getText().length() > maxZeichenLaenge)
			{
				/*Eine sog. Fehlermeldung wird ausgegeben, um den Benutzer auf seinen Fehler aufmerksam zu machen.*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\n"
												  + "Der Spielername darf maximal " + maxZeichenLaenge+ " Zeichen lang sein\u002E",
													"Zu langer Name", JOptionPane.WARNING_MESSAGE);
				/*Der bereits eingegebene Text im Textfeld wird gel�scht.*/
				referenceTextField.setText(null);
				/*Das Programm startet von Vorne.*/
				return;
			}
			/*Wenn der gew�nschte Benutzername Sonderzeichen enth�lt, wird follgendes ausgef�hrt.*/
			if (!referenceTextField.getText().matches("[a-zA-Z[0-9]]+") && (referenceTextField.getText().length() < maxZeichenLaenge))
			{
				/*Eine sog. Fehlermeldung wird ausgegeben, um den Benutzer auf seinen Fehler aufmerksam zu machen.*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Sonderzeichen ein\u0021\n"
												  + "Der Spielername darf keine Sonderzeichen enthalten\u002E",
													"Ung\u00FCltige Zeichen", JOptionPane.ERROR_MESSAGE);
				/*Der bereits eingegebene Text im Textfeld wird gel�scht.*/
				referenceTextField.setText(null);
				/*Das Programm startet von Vorne.*/
				return;
			}
			/*Wenn dr eingegebene Benutzername allen Anforderungen entspricht, wird follgendes ausgef�hrt.*/
			if (referenceTextField.getText().matches("[a-zA-Z[0-9]]+"))
			{
				/*Der eingegebene Spielername wird gespeichert.*/
				LogInFrame.setUsername(referenceTextField.getText());
				/*Das aktuelle Fenster wird unsichtbar gemacht.*/
				referenceFrame.setVisible(false);
				/*Das Hauptfenster wird ge�ffnet.*/
				new GameMainFrame();
				/*Das aktuelle Fenster wird geschlossen*/
				referenceFrame.dispose();
			}
		}
	}
}