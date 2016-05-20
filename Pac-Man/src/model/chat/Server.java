package model.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * In dieser Klasse namens <b>Server</b> wird der Server ausgeführt über welchen die Spieler später miteinander komunizieren können.
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public final class Server
{
	private static boolean bIsConnected = false;
	private static ArrayList<PrintWriter> alClientAusgabeStroeme;
	
	/**
	 * Diese Methode namens <b>start</b> wird aus der Hauptklasse aus aufgerufen;<br>
	 * in welcher der Server gestartet wird.<br>
	 * Das Socket stellt die Grundlage für die spätere Komunikation dar.<br>
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
	 * In der untenstehenden Methode namens <b>allenWeitersagen</b> werden die Nachrichten,<br>
	 * die die Spieler verfasst haben an alle weiter gegeben.<br>
	 * 
	 * @param sNachricht<br>
	 * Die Variable "sNachricht" speichert die vom Benutzer eingegebene Nachricht.<br>
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
	 * In der untenstehenden Methode namens <b>isConnected</b> wird die Variable "bIsConnected" zurückgegeben.<br> 
	 * @return bIsConnected<br>
	 * Die Variable "bIsConnected" wird zurückgegeben.<br>
	 */
	public static boolean isConnected()
	{
		return bIsConnected;
	}
}