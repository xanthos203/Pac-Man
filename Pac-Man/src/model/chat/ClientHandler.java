package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public final class ClientHandler implements Runnable 
{
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
		catch(Exception exException)
		{
			bInitCH = false;
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
				Server.allenWeitersagen(sNachricht);		
			}
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	}
	
	public static boolean hasInitialized()
	{
		return bInitCH;
	}
}