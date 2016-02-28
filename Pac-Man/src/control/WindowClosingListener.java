package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**Diese <i>Listener</i>-Klasse wird ausgeführt, wenn der Benutzer das <b>Fenster schließen</b> möchte.<br>
 * Er wird dabei gefragt, ob er das Spiel wirklich beenden möchte.<br>
 * Diese Klasse <b>erbt von der Klasse WindowAdapter</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class WindowClosingListener extends WindowAdapter
{
	/**Die Variable <i>dialogReference</i> bestimmt die <b>Referenz auf den JDialog</b>.*/
	private JDialog dialogReference;
	/**Die Variable <i>frameReference</i> bestimmt die <b>Referenz auf das JFrame</b>.*/
	private JFrame frameReference;
	
	/**Dieser Konstruktor verlangt als Parameter eine <b>Referenz auf einen JDialog</b>.
	 * @param dialog <i>Referenz</i> auf den <b>JDialog</b>*/
	public WindowClosingListener(JDialog dialog)
	{
		/*der Variable dialogReference wird der Wert von dialog zugewiesen
		 *und somit eine Referenz auf das Fenster erstellt, das den Konstruktor aufruft*/
		dialogReference = dialog;
		/*beim Schließen des JDialogs soll gar nichts passieren*/
		dialogReference.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	/**Dieser Konstruktor verlangt als Parameter eine <b>Referenz auf ein JFrame</b>.
	 * @param frame <i>Referenz</i> auf das <b>JFrame</b>*/
	public WindowClosingListener(JFrame frame)
	{
		/*der Variable frameReference wird der Wert von frame zugewiesen
		 *und somit eine Referenz auf das Fenster erstellt, das den Konstruktor aufruft*/
		frameReference = frame;
		/*beim Schließen des JFrames soll gar nichts passieren*/
		frameReference.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	/**Diese Methode wird ausgeführt, wenn der Benutzer das <b>Spiel beenden</b> will.<br>
	 * Es erscheint ein <i>kleines Fenster</i> am Bildschirm.
	 * @param e das Fenster <i>wird geschlossen</i>*/
	@Override
	public void windowClosing(WindowEvent e)
	{
		/*hier wird ein neues JOptionPane erstellt, das den Benutzer fragt, ob er das Spiel wirklich beenden möchte*/
		int optionPane = JOptionPane.showConfirmDialog(null, "M\u00F6chten Sie das Spiel wirklich beenden\u003F", "Spiel beenden\u003F", JOptionPane.YES_NO_OPTION);
		
		/*wird ausgeführt, wenn der Benutzer auf JA klickt*/
		if(optionPane == JOptionPane.YES_OPTION)
		{
			/*das Programm wird beendet*/
			System.exit(0);
		}
	}
}