package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable 
{
	private BufferedReader brReader;
	private Socket soSocket;
	
	public ClientHandler(Socket soClientSocket)
	{
		try
		{
			soSocket = soClientSocket;
			InputStreamReader isrReader = new InputStreamReader(soSocket.getInputStream());
			brReader = new BufferedReader(isrReader);
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	} 
	
	public void run() 
	{
		String sNachricht;
		try
		{
			while ((sNachricht = brReader.readLine()) != null) 
			{
//				System.out.println("gelesen: " + sNachricht);
				Server.esAllenWeitersagen(sNachricht);		
			}
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	}
}