package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import view.frames.*;

/**Diese <i>Listener</i>-Klasse dient dazu, um <b>Knopfdr�cke abzufangen</b>.<br>
 * Sie <b>implementiert</b> das Interface <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public final class ButtonListener implements ActionListener
{
	/**Die Konstante <b><i>REPEAT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, nochmal ge�ffnet werden soll.*/
	public static final int REPEAT_GAME = 1;
	/**Die Konstante <b><i>EXIT_GAME</i></b> bestimmt, dass das Spiel, bei ihrem Aufruf, geschlossen werden soll.*/
	public static final int EXIT_GAME 	= 0;
	/**Die <i>taskOfButton</i> bestimmt, welche <b>Aktion</b> der Button ausf�hren soll.*/
	private int 	taskOfButton;
	/**Das <i>referenceFrame</i> bestimmt das <b>Referenzfenster</b>, auf welches sich der Listener bezieht.*/
	private JFrame referenceFrame;
	
	/**Im Konstruktor wird festgelegt, auf <b>welches Fenster</b> sich der Listener bezieht.<br>
	 * Au�erdem wird festgelegt, <b>welche Aktion</b> der gedr�ckte Button ausf�hren soll.
	 * @param dialog Referenz auf das <i>Fenster</i>
	 * @param task <i>Aktion</i>, welche der Button ausf�hren soll*/
	public ButtonListener(JFrame dialog, int task)
	{
		/*der Variable referenceFrame wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf das Fenster erstellt, das den Konstruktor aufruft*/
		referenceFrame = dialog;
		/*der Variable taskOfButton wird der Wert von task zugewiesen
		 *und somit festgelegt, welche Aktion der gedr�ckte Button ausf�hrt*/
		taskOfButton = task;
	}
	
	/**Die <i>actionPerformed</i>-Methode f�ngt <b>Knopfdr�cke</b> auf und verarbeitet diese.
	 * @param aeEvent Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/*wird ausgef�hrt, wenn der Benutzer das Spiel beenden will*/
		if (taskOfButton == EXIT_GAME)
		{
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();
			/*das Programm wird beendet*/
			System.exit(0);
		}
		/*wird ausgef�hrt, wenn der Benutzer nochmal spielen will*/
		if (taskOfButton == REPEAT_GAME)
		{
			/*das aktuelle Fenster verschwindet*/
			referenceFrame.setVisible(false);
			/*=========Hauptfenster �ffnen=========*/
			new GameMainFrame();
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();
		}
	}
}