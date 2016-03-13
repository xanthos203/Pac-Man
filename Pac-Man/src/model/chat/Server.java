package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server
{
	private static ArrayList<PrintWriter> clientAusgabeStroeme;
	public static void serverStarten()
	{
		clientAusgabeStroeme = new ArrayList<PrintWriter>();
		try 
		{
			ServerSocket serverSock = new ServerSocket(5000);
			while(true) 
			{
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());         
				clientAusgabeStroeme.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				
				System.out.println("habe eine Verbindung");
			}
			// wenn wir hier angelangt sind, haben wir eine Verbindung
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void esAllenWeitersagen(String nachricht) 
	{
		Iterator<PrintWriter> it = clientAusgabeStroeme.iterator();
		while(it.hasNext()) 
		{
			try 
			{
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(nachricht);
				writer.flush();
			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	} 
}

class ClientHandler implements Runnable 
{
	BufferedReader reader;
	Socket sock;	
	public ClientHandler(Socket clientSocket)
	{
		try
		{
			sock = clientSocket;
			InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(isReader);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	} 
	
	public void run() 
	{
		String nachricht;
		try
		{
			while ((nachricht = reader.readLine()) != null) 
			{
				System.out.println("gelesen: " + nachricht);
				Server.esAllenWeitersagen(nachricht);		
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}