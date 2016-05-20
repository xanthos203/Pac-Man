package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Diese Klasse namens <b>ClientHandler</b> wird vom <b>Server aus aufgerufen<b> und <b>erh�lt die gesendeten Nachrichten der Spielerteilnehmer</b> von ihm.<br>
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class ClientHandler implements Runnable 
{
	private static boolean bInitCH = false;
	private BufferedReader brReader;
	private Socket soSocket;
	
	/**
	 * In dieser Methode names <b>ClientHandler</b> befindet sich der <b>InputStreamReader</b>.<br>
	 * Dieser <i>erh�lt</i> die <i>gesendeten Nachrichten der Clients</i> und <i>gibt diese weiter</i>.<br>
	 * 
	 * @param soClientSocket
	 */
	public ClientHandler(Socket soClientSocket)
	{
		try
		{
			bInitCH = true;
			soSocket = soClientSocket;
			InputStreamReader isrReader = new InputStreamReader(soSocket.getInputStream());
			brReader = new BufferedReader(isrReader);
		}
		catch(Exception exException)
		{
			bInitCH = false;
			exException.printStackTrace();
		}
	} 
	
	/**
	 * Die untenstehende Methode namens <b>run</b> wird nur <b>ausgef�hrt</b>,<br>
	 * wenn auch wirklich etwas <b>gesendet wurde</b>.
	 */
	public void run() 
	{
		String sNachricht;
		try
		{
			while ((sNachricht = brReader.readLine()) != null) 
			{
				Server.allenWeitersagen(sNachricht);		
			}
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	}
	
	/**
	 * In der untenstehenden Methode names <b>bInitCH</b> wird die Variable <b>bInitCH zur�ckgegeben</b>.<br>
	 * 
	 * @return bInitCH<br>
	 * Die Variable "bInitCH" wird zur�ckgegeben.
	 */
	public static boolean hasInitialized()
	{
		return bInitCH;
	}
}