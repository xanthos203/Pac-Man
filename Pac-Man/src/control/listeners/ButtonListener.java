package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import view.frames.*;

/**
 * Diese <i>Listener-Klasse</i> namens <b>ButtonListener</b> dient dazu,<b>Knopfdr�cke</b> von den<br>
 * Knopfen des <i>"GameLostFrame"</i>-Fensters und den Knopfen des <i>"GameWonFrame"</i>-Fensters <b>abzufangen</b>.<br>
 * Der Name <i>"ButtonListener"</i> kommt von dem englischen Wort <i>"button"</i> (deutsch Knopf).<br>
 * <br>
 * Die ButtonListener-Klasse <b>implementiert</b> das Interface <b>ActionListener</b>.<br>
 * Dieser ActionListener wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i>
 * 
 * @version 1.0 
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * */
public final class ButtonListener implements ActionListener
{
	/**Die konstante Variable <b><i>REPEAT_GAME</i></b> besagt, dass das <i>Spiel nochmals von vorne beginnt</i>.<br>*/
	public static final int REPEAT_GAME = 1;
	/**Die konstante Variable <b><i>EXIT_GAME</i></b> hingegen ist f�r das <i>Schlie�en des Spiels</i> verantwortlich.<br>*/
	public static final int EXIT_GAME 	= 0;
	/**In der Variable <b>taskOfButton</b> wird festgehalten, <i>welche Aktion bzw. Aufgabe das Spiel als n�chstes tun soll</i>.<br>
	 * Sie dient sozusagen als <i>Zwischenspeicher</i>.<br>*/
	private int taskOfButton;
	/**<b>"referenceFrame"</b> bestimmt das <b>Referenzfenster</b>, <i>auf welches sich der Listener bezieht</i>.<br>
	 * Aslo wenn ein Button in der "GameWonFrame" gedr�ckt wird, wird dies in der Variale "referenceFrame" gespeichert.<br>
	 * Dieses Speichern ist wichtig um das entsprechende Fenster sp�ter zum Beispiel zu schlie�en.<br>*/
	private JFrame referenceFrame;
	
	/**
	 * Der Kontruktor ermittelt, von <b>welchem Fenster</b> sozusagen <i>"der Auftrag des Knopfdruckes"</i> kommt.<br>
	 * Es wird ebenfalls festgehalten, <b>welche Aktion</b> der gedr�ckte Button ausf�hren soll.
	 * @param dialog
	 * Die Variable <i>dialog</i> gibt uns die Auskunft, <b>in welchem Fenster der Button gedr�ckt wurde</b>.<br>
	 * @param task
	 * Die Variable <i>task</i> beinhaltet Auskunft �ber die vom <b>Benutzer gew�nschte n�chstfolgende Aktion</b>, die ausgef�hrt werden soll.<br>*/
	public ButtonListener(JFrame dialog, int task)
	{
		/*In der Variable "referenceFrame" wird der Wert von "dialog" gespeichert.
		 *Somit wird eine Referenz auf das Fenster erstellt, wo der entsprechende Button gedr�ckt wurde.*/
		referenceFrame = dialog;
		/*In der Variable "taskOfButton" wird der Wert von "task" gespeichert.
		 *Mithilfe dieser Variable kann festgeleg werden, welche Aufgabe das Programm als n�chstes ausf�hren soll.*/
		taskOfButton = task;
	}
	
	/**In der Methode <b>actionPerformed</b> werden die entsprechenden <i>"Ma�nahmen"</i> getroffen, <i>um mit dem Spiel fortzufahren</i>.<br>
	 * Sobald der Button <b>"EXIT_GAME"</b> gedr�ckt wurde, wird das gesamte <i>Spiel geschlossen</i>.<br>
	 * Wenn jedoch der Buttton "REPEAT_GAME" bet�tigt wird, <i>startet</i> das <i>Programm</i> wieder <i>von vorne</i>.<br>
	 * 
	 * @param aeEvent Die Variable <i>aeEvent</i> ermittelt ob der entsprechende <b>Button get�tigt</b> wurde.*/
	@Override
	public void actionPerformed(ActionEvent aeEvent)
	{
		/* Wenn der Spieler das Programm gerne beenden m�chte, wird dies ausgef�hrt.
		 * Hierbei wird �berpr�ft, ob in der Variable "taskOfButton" "EXIT_GAME" gespeichert ist.
		 * Ist dies der Fall, so wird das aktuelle Fenster und das Programm geschlossen.*/
		if (taskOfButton == EXIT_GAME)
		{
			/*Fenster schlie�en*/
			referenceFrame.dispose();
			/*Programm beenden*/
			System.exit(0);
		}
		
		/*Wenn der Benutzer hingegen gerne noch eine Runde spielen m�chte, so wird hier �berpr�ft, ob in der VAriable "taskOfButton" "REPEAT_GAME" gespeichert ist.
		 * Ist dies der Fall, so das aktuell ge�ffnete Fenster unsichbargemacht und geschlossen und das Spiel wird neu gestartet.*/
		if (taskOfButton == REPEAT_GAME)
		{
			/*Fenster unsichtbar machen*/
			referenceFrame.setVisible(false);
			/*Hauptfenster �ffnen also Spiel neu starten*/
			new GameMainFrame();
			/*aktuelle Fenster schlie�en*/
			referenceFrame.dispose();
		}
	}
}