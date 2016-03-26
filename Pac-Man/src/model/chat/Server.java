package model.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import view.frames.GameMainFrame;

public final class Server
{
	private static boolean bIsConnected = false;
	private static ArrayList<PrintWriter> alClientAusgabeStroeme;
	
	public static void serverStarten()
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
//				GameMainFrame.getChatverlaufTextarea().setText(GameMainFrame.getChatverlaufTextarea().getText() + "\n\n+++habe eine Verbindung+++\n\n");
//				System.out.println("habe eine Verbindung");
			}
			// wenn wir hier angelangt sind, haben wir eine Verbindung
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	}

	public static void esAllenWeitersagen(String sNachricht) 
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