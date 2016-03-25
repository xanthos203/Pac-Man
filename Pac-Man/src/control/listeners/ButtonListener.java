package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

import view.characters.Spieler;
import view.frames.*;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Knopfdrücke abzufangen</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class ButtonListener implements ActionListener
{
	/**Die Konstante <b><i>REPEAT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, nochmal geöffnet werden soll.*/
	public static final int REPEAT_GAME = 1;
	/**Die Konstante <b><i>EXIT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, geschlossen werden soll.*/
	public static final int EXIT_GAME 	= 0;
	/**Die <i>taskOfButton</i> bestimmt, welche <b>Aktion</b> der Button ausführen soll.*/
	private int 	taskOfButton;
	/**Das <i>referenceFrame</i> bestimmt das <b>Referenzfenster</b>, auf welches sich der Listener bezieht.*/
	private JDialog referenceFrame;
	
	/**Im Konstruktor wird festgelegt, auf <b>welches Fenster</b> sich der Listener bezieht.<br>
	 * Außerdem wird festgelegt, <b>welche Aktion</b> der gedrückte Button ausführen soll.
	 * @param dialog Referenz auf das <i>Fenster</i>
	 * @param task <i>Aktion</i>, welche der Button ausführen soll*/
	public ButtonListener(JDialog dialog, int task)
	{
		/*der Variable referenceFrame wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf das Fenster erstellt, das den Konstruktor aufruft*/
		referenceFrame = dialog;
		/*der Variable taskOfButton wird der Wert von task zugewiesen
		 *und somit festgelegt, welche Aktion der gedrückte Button ausführt*/
		taskOfButton = task;
	}
	
	/**Die <i>actionPerformed</i>-Methode fängt <b>Knopfdrücke</b> auf und verarbeitet diese.
	 * @param aeEvent Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*wird ausgeführt, wenn der Benutzer das Spiel beenden will*/
		if (taskOfButton == EXIT_GAME)
		{
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();
			/*das Programm wird beendet*/
			System.exit(0);
		}
		/*wird ausgeführt, wenn der Benutzer nochmal spielen will*/
		if (taskOfButton == REPEAT_GAME)
		{
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();
			/*die Anzahl der Leben des Spielers wird auf 3 gesetzt*/
			Spieler.setLeben(3);
			/*der Punktestand des Spielers wird auf 0 gesetzt*/
			Spieler.setPunktestand(0);
			
			/*=========Hauptfenster öffnen=========*/
			new GameMainFrame();
		}
	}
}