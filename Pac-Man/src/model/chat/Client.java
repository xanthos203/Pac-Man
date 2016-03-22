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
//			System.out.println("IP-Adresse gesendet");
			GameMainFrame.getChatverlaufTextarea().setText("------IP-Adresse gesendet------");
			PrintWriter pwWriter_1 = new PrintWriter(soSocket.getOutputStream());
//			System.out.println("Netzwerkverbindung steht");
			GameMainFrame.getChatverlaufTextarea().setText(GameMainFrame.getChatverlaufTextarea().getText() + "\n---Netzwerkverbindung steht---");
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
			if(GameMainFrame.getChatnachrichtTextfeld().getText() != null || GameMainFrame.getChatnachrichtTextfeld().getText() != "")
			{
				pwWriter.println(GameMainFrame.getChatnachrichtTextfeld().getText());
				pwWriter.flush();
			}
			else
			{
				GameMainFrame.getChatverlaufTextarea().setText(GameMainFrame.getChatverlaufTextarea().getText() + "\n\n----Nichts zum austauschen!----");
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