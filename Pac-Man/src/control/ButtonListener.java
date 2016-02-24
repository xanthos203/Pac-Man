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
	/**Das <i>referenceFrame</i> bestimmt das <b>Referenzfenster</b> auf welche sich die Klasse bezieht.*/
	private JDialog referenceFrame;
	/**Der <i>referenceButton</i> bestimmt den <b>Referenzbutton</b> auf welchen sich der Listener bezieht.*/
	private JButton referenceButton;
	
	/**Im Konstruktor wird die <b>Referenz auf das Fensters</b> und den <b>Button, auf den der Listener reagiert</b>, festgelegt.
	 * @param dialog Referenz auf das <i>Fenster</i>
	 * @param button Referenz auf den <i>Button</i>*/
	public ButtonListener(JDialog dialog, JButton button)
	{
		/*der Variable referenceFrame wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf die Klasse erstellt, die den Konstruktor aufruft*/
		referenceFrame = dialog;
		/*der Variable referenceButton wird der Wert von button zugewiesen
		 *und somit eine Referenz auf den Button erstellt, der auf den Listener reagieren soll*/
		referenceButton = button;
	}
	
	/**Die <i>actionPerformed</i>-Methode fängt <b>Knopfdrücke</b> auf und verarbeitet diese.
	 * @param e Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		/*wird ausgeführt, wenn der Knopf zum Wiederholen des Spiels gedrückt wurde*/
		if(e.getSource() == referenceButton)
		{
			/*das aktuelle Fenster wird geschlossen*/
			referenceFrame.dispose();
			
			/*========Hauptfenster öffnen========*/
			CSpielFrame oSpielFrame = new CSpielFrame(true);
		}
		/*andernsfalls wird das Programm verlassen*/
		else System.exit(0);
	}
}