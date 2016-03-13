package model.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import view.frames.CSpielFrame;

public class Client 
{
	private static BufferedReader reader;
	private PrintWriter writer;
	
	public void netzwerkEinrichten()
	{  
		try 
		{
			Socket sock = new Socket("127.0.0.1", 5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());		
			System.out.println("IP-Adresse gesendet");
			PrintWriter writer = new PrintWriter(sock.getOutputStream());			
			System.out.println("Netzwerkverbindung steht");
		} 
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static BufferedReader getReader()
	{
		return reader;
	}
	
	public void senden()
	{
		try
		{
			if(CSpielFrame.getSchreibFeld().getText()!=null||CSpielFrame.getSchreibFeld().getText()!="")
			{
				writer.println(CSpielFrame.getSchreibFeld().getText());
				writer.flush();
			}
			else
			{
				System.out.println("Nichts zum austauschen!");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}	
}