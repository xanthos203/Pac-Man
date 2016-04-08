package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import view.frames.GameMainFrame;

public class Client 
{
	private static boolean bIPgesendet = false;
	private static boolean bNetzwerkSteht = false;
	private static BufferedReader brReader;
	private PrintWriter pwWriter;
	
	@SuppressWarnings("resource")
	public void netzwerkEinrichten()
	{  
		try
		{
			Socket soSocket = new Socket("127.0.0.1", 5000);
			InputStreamReader isrStreamReader = new InputStreamReader(soSocket.getInputStream());
			brReader = new BufferedReader(isrStreamReader);
			pwWriter = new PrintWriter(soSocket.getOutputStream());
			bIPgesendet = true;
			new PrintWriter(soSocket.getOutputStream());
			bNetzwerkSteht = true;
		}
		catch(Exception exException)
		{
			bIPgesendet = false;
			bNetzwerkSteht = false;
			exException.printStackTrace();
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
				JOptionPane.showMessageDialog(null, "Nichts zum Austauschen\u0021", "Achtung", JOptionPane.WARNING_MESSAGE);
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
	
	public static boolean hasIPsuccessfullySent()
	{
		return bIPgesendet;
	}
	
	public static boolean hasNetzworkConnection()
	{
		return bNetzwerkSteht;
	}
}