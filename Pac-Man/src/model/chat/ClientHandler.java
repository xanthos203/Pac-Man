package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class ClientHandler implements Runnable 
{
/**/	/**Die Variable namens "bInitCH" überprüft, ob ....*/
	private static boolean bInitCH = false;
	private BufferedReader brReader;
	private Socket soSocket;
	
	public ClientHandler(Socket soClientSocket)
	{
		try
		{
			bInitCH = true;
			soSocket = soClientSocket;
			InputStreamReader isrReader = new InputStreamReader(soSocket.getInputStream());
			brReader = new BufferedReader(isrReader);
		}
		/* Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.*/
		catch(Exception exException)
		{
			bInitCH = false;
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	} 
	
	public void run() 
	{
		/*Die neue Variable namens "sNachricht" wird erstellt.*/
		String sNachricht;
		try
		{
			/*In der Variable "sNachricht" wird der vom Benutzer eingegebene Text gespeichert.
			 * Solange dieser Text nicht auf den Wert 0 geht wird diese Nachricht an den Server geschickt.
			 * Also wird nur etwas an den Server geschickt, wenn der jeweilige Benutzer eine Nachricht eingibt.*/
			while ((sNachricht = brReader.readLine()) != null) 
			{
				/*Die entsprechende achricht wird an den Server geschickt.*/
				Server.allenWeitersagen(sNachricht);		
			}
		}
		/* Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.*/
		catch(Exception exException)
		{
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	}
	
	public static boolean hasInitialized()
	{
		return bInitCH;
	}
}