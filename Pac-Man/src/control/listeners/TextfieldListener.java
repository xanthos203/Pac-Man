package control.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import view.frames.*;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Tastendr�cke abzufangen</b>.<br>
 * Au�erdem <b>�berpr�ft</b> diese Klasse den <b>eingegebenen Text</b> im <i>JTextField</i>.<br>
 * Sie <b>implementiert</b> das Interface <b>KeyListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class TextfieldListener implements KeyListener
{
	/**Die <i>maxZeichenLaenge</i> bestimmt, <b>wie viele Zeichen maximal</b> im Textfeld <b>eingegeben werden k�nnen</b>.*/
	private int			maxZeichenLaenge = 19;
	/**Das <i>referenceDialog</i> bestimmt das <b>Referenzfenster</b>, auf welches sich der Listener bezieht.*/
	private JDialog 	referenceDialog;
	/**Im <i>sonderzeichen</i>-Array werden <b>alle Sonderzeichen</b> gespeichert, welche im <i>usernameFeld nicht eingegeben</i> werden k�nnen.*/
	private	String[]	sonderzeichen 	 = new String[] {"^","�","!","\"","�","�","�","$","%","&","/","{","(","[",")","]","=","}","?","\\","�","`","*","~",
														 "#","'",".", ":",",",";","<",">","|","-","+","_","@","�","�","�","�","�","�", "�","�","�","�","�"};
	
	/**Im Konstruktor wird festgelegt, auf <b>welches Fenster</b> sich der Listener bezieht.
	 * @param dialog Referenzvariable vom Typ <i>JDialog</i>*/
	public TextfieldListener(JDialog dialog)
	{
		/*der Variable referenceDialog wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf die Klasse erstellt, die den Konstruktor aufruft*/
		referenceDialog = dialog;
	}
	
	/**Die <i>keyPressed</i>-Methode f�ngt <b>Tastendr�cke</b> auf und verarbeitet diese.
	 * @param e Tastendruck*/
	@Override
	public void keyPressed(KeyEvent e)
	{
		/*Wird nur ausgef�hrt, wenn die ENTER-Taste gedr�ckt wurde*/
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*wird ausgef�hrt, wenn kein Text eingegeben wurde*/
			if (LogInFrame.getUsernameFeld().getText().isEmpty())
			{
				/*ein Dialogfeld mit der Meldung, dass ein ung�ltiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021\nDer Spielername darf nur Buchstaben und Zahlen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zur�ckgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zur�ck*/
				return;
			}
			/*wird ausgef�hrt, wenn der eingegebene Text Leerzeichen enth�lt und k�rzer als 21 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().contains(" ") && (LogInFrame.getUsernameFeld().getText().length() < maxZeichenLaenge))
			{
				/*ein Dialogfeld mit der Meldung, dass ein ung�ltiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Leerzeichen ein\u0021\nDer Spielername darf keine Leerzeichen enthalten\u002E",
													"Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zur�ckgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zur�ck*/
				return;
			}
			/*wird ausgef�hrt, wenn der eingegebene Text l�nger als 20 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().length() > maxZeichenLaenge)
			{
				/*ein Dialogfeld mit der Meldung, dass ein zu langer Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\nDer Spielername darf maximal " + maxZeichenLaenge+ " Zeichen lang sein\u002E",
													"Zu langer Name", JOptionPane.WARNING_MESSAGE);
				/*der Text im Textfeld wird zur�ckgesetzt*/
				LogInFrame.getUsernameFeld().setText(null);
				/*das Programm kehrt wieder zum Fenster zur�ck*/
				return;
			}
			/*wird ausgef�hrt, wenn der eingegebene Text k�rzer als 21 Zeichen ist*/
			if (LogInFrame.getUsernameFeld().getText().length() < maxZeichenLaenge)
			{
				/*diese Schleife l�uft so oft durch, so lang wie das sonderzeichen-Array ist*/
				for (int i = 0; i < sonderzeichen.length; i++)
				{
					/*wird ausgef�hrt, wenn der eingegebene Text Sonderzeichen enth�lt und k�rzer als 21 Zeichen ist*/
					if (LogInFrame.getUsernameFeld().getText().contains(sonderzeichen[i]))
					{
						/*ein Dialogfeld mit der Meldung, dass ein ung�ltiger Name eingegeben wurde, erscheint*/
						JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Spielernamen ohne Sonderzeichen ein\u0021\nDer Spielername darf keine Sonderzeichen enthalten\u002E",
															"Ung\u00FCltige Zeichen", JOptionPane.ERROR_MESSAGE);
						/*der Text im Textfeld wird zur�ckgesetzt*/
						LogInFrame.getUsernameFeld().setText(null);
						/*das Programm kehrt wieder zum Fenster zur�ck*/
						return;
					}
				}
			}
			/*wird ausgef�hrt, wenn keine der oben stehenden Bedingungen zutrifft*/
			for (int i = 0; i < sonderzeichen.length;)
			{
				/*wird ausgef�hrt, wenn der eingegebene Text keine Sonderzeichen enth�lt und k�rzer als 21 Zeichen ist*/
				if (!LogInFrame.getUsernameFeld().getText().contains(sonderzeichen[i]))
				{
					/*der eingegebene Spielername wird gespeichert*/
					LogInFrame.setUsername(LogInFrame.getUsernameFeld().getText());
					/*das aktuelle Fenster wird geschlossen*/
					referenceDialog.dispose();
					
					/*=========Hauptfenster �ffnen=========*/
					CSpielFrame oSpielFrame = new CSpielFrame();
				}
				/*die Schleife wird abgebrochen, wenn die oben stehende Bedingung zutrifft*/
				break;
			}
		}
	}
	//-------------------------------------------------------------------------------------	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}