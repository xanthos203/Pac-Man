package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import view.frames.GameMainFrame;

public class Server
{
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
				
				GameMainFrame.getArea().setText(GameMainFrame.getArea().getText() + "\n\n+++habe eine Verbindung+++");
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
}

class ClientHandler implements Runnable 
{
	BufferedReader brReader;
	Socket soSocket;
	
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