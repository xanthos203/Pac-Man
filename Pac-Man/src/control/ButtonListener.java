package control;

import java.awt.event.*;

import javax.swing.*;

import frames.*;

/**Diese <i>Klasse</i> dient dazu, um <b>Knopfdrücke abzufangen</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class ButtonListener implements ActionListener
{
	/**Das <i>referenceFrame</i> bestimmt das <b>Referenzfenster</b> auf welche sich der Listener bezieht.*/
	private JDialog referenceFrame;
	/**Die <i>taskOfButton</i> bestimmt welche <b>Aktion</b> der Button ausführen soll.*/
	private int taskOfButton;
	/**Die Konstante <b><i>EXIT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, geschlossen werden soll.*/
	public static final int EXIT_GAME = 0;
	/**Die Konstante <b><i>REPEAT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, nochmal geöffnet werden soll.*/
	public static final int REPEAT_GAME = 1;
	
	/**Im Konstruktor wird festgelegt auf <b>welches Fenster</b> sich der Listener bezieht.<br>
	 * Außerdem wird festgelegt, <b>welche Aktion</b> der gedrückte Button ausführen soll.
	 * @param dialog Referenz auf das <i>Fenster</i>
	 * @param task <i>Aktion</i>, welche der Button ausführen soll*/
	public ButtonListener(JDialog dialog, int task)
	{
		/*der Variable referenceFrame wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf die Klasse erstellt, die den Konstruktor aufruft*/
		referenceFrame = dialog;
		/*der Variable taskOfButton wird der Wert von task zugewiesen
		 *und somit festgelegt, welche Aktion der gedrückte Button ausführt*/
		taskOfButton = task;
	}
	
	/**Die <i>actionPerformed</i>-Methode fängt <b>Knopfdrücke</b> auf und verarbeitet diese.
	 * @param e Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		/*wird ausgeführt, wenn der Benutzer das Spiel beenden will*/
		if (taskOfButton == EXIT_GAME)
		{
			/*andernsfalls wird das Programm verlassen*/
			System.exit(0);
		}
		/*wird ausgeführt, wenn der Benutzer nochmal spielen will*/
		if (taskOfButton == REPEAT_GAME)
		{
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();

			/*=========Hauptfenster öffnen=========*/
			CSpielFrame oSpielFrame = new CSpielFrame(true);
		}
	}
}