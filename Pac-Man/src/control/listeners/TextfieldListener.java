package control.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import view.frames.*;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendrücke abzufangen</b>.<br>
 * Außerdem <b>überprüft</b> diese Klasse den <b>eingegebenen Text</b> im <i>JTextField</i>.<br>
 * Sie <b>implementiert</b> das Interface <b>KeyListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class TextfieldListener implements KeyListener
{
	/**Die <i>maxZeichenLaenge</i> bestimmt, <b>wie viele Zeichen maximal</b> im Textfeld <b>eingegeben werden können</b>.*/
	private int			maxZeichenLaenge = 18;
	/**Das <i>referenceDialog</i> bestimmt das <b>Referenzfenster</b>, auf welches sich der Listener bezieht.*/
	private JDialog 	referenceDialog;
	/**Im <i>sonderzeichen</i>-Array werden <b>alle Sonderzeichen</b> gespeichert, welche im <i>usernameFeld nicht eingegeben</i> werden können.*/
	private	String[]	sonderzeichen 	 = new String[] {"^","°","!","\"","²","§","³","$","%","&","/","{","(","[",")","]","=","}","?","\\","´","`","*","~",
														 "#","'",".", ":",",",";","<",">","|","-","+","_","@","€","µ","©","®","ß","ä", "Ä","ö","Ö","ü","Ü"};
	
	/**Im Konstruktor wird festgelegt, auf <b>welches Fenster</b> sich der Listener bezieht.
	 * @param dialog Referenzvariable vom Typ <i>JDialog</i>*/
	public TextfieldListener(JDialog dialog)
	{
		/*der Variable referenceDialog wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf die Klasse erstellt, die den Konstruktor aufruft*/
		referenceDialog = dialog;
	}
	
	/**Die <i>keyPressed</i>-Methode fängt <b>Tastendrücke</b> auf und verarbeitet diese.
	 * @param keEvent Tastendruck*/
	@Override
	public void keyPressed(KeyEvent keEvent)
	{
		/*Wird nur ausgeführt, wenn die ENTER-Taste gedrückt wurde*/
		if (keEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*wird ausgeführt, wenn kein Text eingegeben wurde*/
			if (LogInFrame.getUsernameFeld().getText().isEmpty())
			{
				/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021\nDer Spielername darf nur Buchstaben und Zahlen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text Leerzeichen enthält und kürzer als 21 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().contains(" ") && (LogInFrame.getUsernameFeld().getText().length() < maxZeichenLaenge))
			{
				/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Leerzeichen ein\u0021\nDer Spielername darf keine Leerzeichen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text länger als 20 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().length() > maxZeichenLaenge)
			{
				/*ein Dialogfeld mit der Meldung, dass ein zu langer Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\nDer Spielername darf maximal " + maxZeichenLaenge+ " Zeichen lang sein\u002E",
													"Zu langer Name", JOptionPane.WARNING_MESSAGE);
				/*der Text im Textfeld wird zurückgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zurück*/
				return;
			}
			/*wird ausgeführt, wenn der eingegebene Text kürzer als 21 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().length() < maxZeichenLaenge)
			{
				/*diese Schleife läuft so oft durch, so lang wie das sonderzeichen-Array ist*/
				for (int i = 0; i < sonderzeichen.length; i++)
				{
					/*wird ausgeführt, wenn der eingegebene Text Sonderzeichen enthält und kürzer als 21 Zeichen ist*/
					if (LogInFrame.getUsernameFeld().getText().contains(sonderzeichen[i]))
					{
						/*ein Dialogfeld mit der Meldung, dass ein ungültiger Name eingegeben wurde, erscheint*/
						JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Sonderzeichen ein\u0021\nDer Spielername darf keine Sonderzeichen enthalten\u002E",
															"Ung\u00FCltige Zeichen", JOptionPane.ERROR_MESSAGE);
						/*der Text im Textfeld wird zurückgesetzt*/
						LogInFrame.getUsernameFeld().setText(null);
						/*das Programm kehrt wieder zum Fenster zurück*/
						return;
					}
				}
			}
			/*wird ausgeführt, wenn keine der oben stehenden Bedingungen zutrifft*/
			for (int i = 0; i < sonderzeichen.length;)
			{
				/*wird ausgeführt, wenn der eingegebene Text keine Sonderzeichen enthält und kürzer als 21 Zeichen ist*/
				if (!LogInFrame.getUsernameFeld().getText().contains(sonderzeichen[i]))
				{
					/*der eingegebene Spielername wird gespeichert*/
					LogInFrame.setUsername(LogInFrame.getUsernameFeld().getText());
					/*das aktuelle Fenster wird geschlossen*/
					referenceDialog.dispose();
					
					/*=========Hauptfenster öffnen=========*/
					new GameMainFrame();
				}
				/*die Schleife wird abgebrochen, wenn die oben stehende Bedingung zutrifft*/
				break;
			}
		}
	}
	//-------------------------------------------------------------------------------------	
	@Override
	public void keyTyped(KeyEvent keEvent) {}
	@Override
	public void keyReleased(KeyEvent keEvent) {}
}