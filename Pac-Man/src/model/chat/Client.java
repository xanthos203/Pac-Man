package model.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import view.frames.GameMainFrame;

public final class Client 
{
	private static BufferedReader brReader;
	private PrintWriter pwWriter;
	
	public void netzwerkEinrichten()
	{  
		try
		{
			Socket soSocket = new Socket("127.0.0.1", 5000);
			InputStreamReader isrStreamReader = new InputStreamReader(soSocket.getInputStream());
			brReader = new BufferedReader(isrStreamReader);
			pwWriter = new PrintWriter(soSocket.getOutputStream());
			GameMainFrame.getArea().setText("------IP-Adresse gesendet------");
//			System.out.println("IP-Adresse gesendet");
			PrintWriter pwWriter_1 = new PrintWriter(soSocket.getOutputStream());
			GameMainFrame.getArea().setText(GameMainFrame.getArea().getText() + "\n---Netzwerkverbindung steht---");
//			System.out.println("Netzwerkverbindung steht");
		} 
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
	
	public void senden()
	{
		try
		{
			if(GameMainFrame.getTextfeld().getText() != null || GameMainFrame.getTextfeld().getText() != "")
			{
				pwWriter.println(GameMainFrame.getTextfeld().getText());
				pwWriter.flush();
			}
			else
			{
				GameMainFrame.getArea().setText(GameMainFrame.getArea().getText() + "\n\n++Nichts zum austauschen!++");
//				System.out.println("Nichts zum austauschen!");
			}
			
		}
		catch(Exception exException)
		{
			exException.printStackTrace();
		}
	}
	
	public static BufferedReader getReader()
	{
		return brReader;
	}
}