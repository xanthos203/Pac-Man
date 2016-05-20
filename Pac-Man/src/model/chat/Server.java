package model.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * In dieser Klasse Server wird der Server ausgef�hrt �ber welchen die Spieler sp�ter miteinander Komunizieren k�nnen.
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public final class Server
{
	private static boolean bIsConnected = false;
	private static ArrayList<PrintWriter> alClientAusgabeStroeme;
	
	/**
	 * Diese Methode wird aus der Hauptklasse aufegrufen, in welcher der Server gestartet wird.
	 * Das Socket stellt die Grundlage f�r die sp�tere Komunikatin da.
	 */
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
		catch (Exception exException)
		{
			bIsConnected = false;
			exException.printStackTrace();
		}
	}
	/**
	 * Hier �ber diese Methode werden die Nachrichten, welche die Spieler geschrieben haben an alle weiter gegeben.
	 * 
	 * @param sNachricht
	 */
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
	
	/**
	 * Hier wird nur true oder false �ber geben welche sagt ob die Verbindung erfolgreich war oder nicht.
	 * @return
	 */
	public static boolean isConnected()
	{
		return bIsConnected;
	}
}