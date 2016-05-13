package model.main;

import model.chat.Server;
import view.frames.LogInFrame;

/**
 * 
 * Dies ist die allererste Klasse, die aufgerufen, gestartet bzw. durchlaufen wird.<br>
 * <br>
 * In der sog. <b>'TestClass'</b> (diese Klasse) wird die Klasse bzw. das Fenster <b>'LogInFrame'</b> und der <b>Server</b> in der 'Server-Klasse' <b>aufgerufen</b>.<br>
 * Die <i>'LogInFrame'</i> erm�glicht dann zum Beispiel eine Eingabe des gew�nschten Spielernamens. (weitere Details sp�ter)<br>
 * Der <i>Server</i> hingegen ist wichtig f�r eine Kommunikation mit anderen Spielteilnehmern via Chat. (weitere Informationen sp�ter)<br>
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 * 
 */
public final class TestClass
{
	public static void main(String[] args)
	{
		/*Die Klasse bzw. das Fenster "LogInFrame" wird aufgerufen.<br>*/
		new LogInFrame();
		
		/*Der "Server" wird gestartet.*/
		Server.start();
	}
}