package model.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public final class Server
{
	private static boolean bIsConnected = false;
	private static ArrayList<PrintWriter> alClientAusgabeStroeme;
	
	@SuppressWarnings("resource")
	public static void start()
	{
		alClientAusgabeStroeme = new ArrayList<PrintWriter>();
		
		try
		{
			ServerSocket ssServerSocket = new ServerSocket(5000);
			while (true)
			{
				Socket soClientSocket = ssServerSocket.accept();
				PrintWriter pwWriter = new PrintWriter(soClientSocket.getOutputStream());         
				alClientAusgabeStroeme.add(pwWriter);
				
				Thread thThread = new Thread(new ClientHandler(soClientSocket));
				thThread.start();
				
				bIsConnected = true;
			}
			// wenn wir hier angelangt sind, haben wir eine Verbindung
		}
		/* Funktioniert dies nicht, so wird folgende Teil ausgef�hrt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.*/
		catch (Exception exException)
		{
			bIsConnected = false;
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	}

	public static void allenWeitersagen(String sNachricht) 
	{
		Iterator<PrintWriter> itIterator = alClientAusgabeStroeme.iterator();
		
		while(itIterator.hasNext()) 
		{
			try
			{
				PrintWriter pwWriter = (PrintWriter) itIterator.next();
				pwWriter.println(sNachricht);
				pwWriter.flush();
			} 
			catch(Exception exException)
			{
				exException.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected()
	{
		return bIsConnected;
	}
}