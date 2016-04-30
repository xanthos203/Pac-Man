package control.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.frames.GameMainFrame;
import view.frames.LogInFrame;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendrücke abzufangen</b>.<br>
 * Außerdem <b>überprüft</b> diese Klasse den <b>eingegebenen Text</b> im <i>JTextField</i>.<br>
 * Sie <b>erbt</b> von der Klasse <b>KeyAdapter</b>.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public final class TextfieldListener extends KeyAdapter
{
	/**Die <i>maxZeichenLaenge</i> bestimmt, <b>wie viele Zeichen maximal</b> im Textfeld <b>eingegeben werden können</b>.*/
	private int		maxZeichenLaenge = 18;
	/**Das <i>referenceFrame</i> bestimmt das <b>Referenz-Fenster</b>, auf welches sich der Listener bezieht.*/
	private JFrame 	referenceFrame;
	/**Das <i>referenceTextField</i> bestimmt das <b>Referenz-Textfeld</b>, auf welches sich der Listener bezieht.*/
	private JTextField  referenceTextField;
	
	/**Im Konstruktor wird festgelegt, auf <b>welches Fenster</b> und auf <b>welches Textfeld</b> sich der Listener bezieht.
	 * @param frame Referenzvariable vom Typ <i>JDialog</i>
	 * @param textField Referenzvariable vom Typ <i>JTextField</i>*/
	public TextfieldListener(JFrame frame, JTextField textField)
	{
		/*der Variable referenceDialog wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf die Klasse erstellt, die den Konstruktor aufruft*/
		referenceFrame = frame;
		/*der Variable referenceTextField wird der Wert von textField zugewiesen
		 *und somit eine Referenz auf das Textfeld erstellt, welches der Listener überwachen soll*/
		referenceTextField = textField;
	}
	
	/**Die <i>keyPressed</i>-Methode fängt <b>Tastendrücke</b> auf und verarbeitet diese.
	 * @param keyEvent Tastendruck*/
	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		/*Wird nur ausgeführt, wenn die ENTER-Taste gedrückt wurde*/
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*wird ausgeführt, wenn kein Text eingegeben wurde*/
			if (referenceTextField.getText().isEmpty())
			{
				/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021\n"
												  + "Der Spielername darf nur Buchstaben und Zahlen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				referenceTextField.setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text Leerzeichen enthält und kürzer als maxZeichenLaenge ist*/
			if (referenceTextField.getText().contains(" ") && (referenceTextField.getText().length() < maxZeichenLaenge))
			{
				/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Leerzeichen ein\u0021\n"
												  + "Der Spielername darf keine Leerzeichen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				referenceTextField.setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text länger als maxZeichenLaenge ist*/
			if (referenceTextField.getText().length() > maxZeichenLaenge)
			{
				/*ein Dialogfeld mit der Meldung, dass ein zu langer Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\n"
												  + "Der Spielername darf maximal " + maxZeichenLaenge+ " Zeichen lang sein\u002E",
													"Zu langer Name", JOptionPane.WARNING_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				referenceTextField.setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text Sonderzeichen enthält und kürzer als maxZeichenLaenge ist*/
			if (!referenceTextField.getText().matches("[a-zA-Z[0-9]]+") && (referenceTextField.getText().length() < maxZeichenLaenge))
			{
				/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Sonderzeichen ein\u0021\n"
												  + "Der Spielername darf keine Sonderzeichen enthalten\u002E",
													"Ung\u00FCltige Zeichen", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				referenceTextField.setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text keine Sonderzeichen enthält und kürzer als maxZeichenLaenge ist*/
			if (referenceTextField.getText().matches("[a-zA-Z[0-9]]+"))
			{
				/*der eingegebene Spielername wird gespeichert*/
				LogInFrame.setUsername(referenceTextField.getText());
				/*das aktuelle Fenster verschwindet*/
				referenceFrame.setVisible(false);
				/*=========Hauptfenster öffnen=========*/
				new GameMainFrame();
				/*das aktuelle Fenster wird geschlossen*/
				referenceFrame.dispose();
			}
		}
	}
}