package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Diese Methode wird vom Server aus Aufgerufen und erh�lt die gesendeten Nachrichten der Spieler.
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
	 *  In dieser Methode befindet sich der InputStreamReader welcher die gesendeten Nachrichten der Claients erh�lt und weiter gibt.
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
	 * Diese Methode wird nur ausgef�hrt, wenn auch wirklich etwas gesendet wird.
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
	 * Hier wrid nur angegeben ob die Inizialisierung erfolg reich war oder nicht dies erfollgt �ber eine Boolische Variable mit true oder false.
	 * @return
	 */
	public static boolean hasInitialized()
	{
		return bInitCH;
	}
}