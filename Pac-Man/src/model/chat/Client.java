package model.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import view.frames.GameMainFrame;

/**
 * In dieser Klasse namens <b>Client</i> wird eine Verbindung zum Server (= Server-Klasse) aufgebaut.<br>
 * Geschieht dies erfolgreich, so werden von anderen Spielern die eingegebenen Nachrichten empfangen und<br>
 * meine Nachrichten (= Messages vom jeweiligen Benutzer) werden für andere Spielteilnehmer sichtbar gemacht.<br>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class Client 
{
	/**Eine neue Variable namens "biPgesendet" wird erstellt.
	 * Diese Variable speichert den aktuellen Status der IP-Adresse.
	 * Also ob die IP-Adresse schon gesendet wurde, oder nicht.*/
	private static boolean bIPgesendet = false;
	/**Die Variable namens "biNetzwerkSteht" überprüft, ob eine Netzwerkverbindung schon erfolgreich aufgebaut wurde.*/
	private static boolean bNetzwerkSteht = false;
	/***/
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
		/* Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.
		 * Eine Exception ist im Grunde genommen nichts anderes als eine Fehlermeldung, die am Bildschirm sichtbar angezeigt wird.
		 * Diese Fehlermeldung wird also auch für den Benutzer des Spiels sichtbar.*/
		catch(Exception exException)
		{
			bIPgesendet = false;
			
			bNetzwerkSteht = false;
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	}
	
	public void senden()
	{
		try
		{
			/*Wenn im Textfeld zum Eingeben seiner gewünschten Nachricht (im Chatbereich) etwas steht, so wird der eingegebene Twxt dort angezeigt.
			 * Ansonsten wird dort nichts angezeigt. */
			if(GameMainFrame.getChatnachrichtTextfeld().getText() != null || GameMainFrame.getChatnachrichtTextfeld().getText() != "")
			{
				pwWriter.println(GameMainFrame.getChatnachrichtTextfeld().getText());
				pwWriter.flush(); 
			}
			/*Ansonsten wird folgendes ausgeführt.*/
			else
			{
				/*Funktioniert dies nicht, so wird eine Fehlermeldung bzgl.
				 *des Austauschens der entsprechenden Daten am BIldschirm angezeigt.*/
				JOptionPane.showMessageDialog(null, "Nichts zum Austauschen\u0021", "Achtung", JOptionPane.WARNING_MESSAGE);
			}
		}
		/* Funktioniert dies nicht, so wird folgende Teil ausgeführt.
		 * Im kommenden Abschnitt wird eine Exception geworfen.*/
		catch(Exception exException)
		{
			/* Eine Exception wird geworfen bzw. angezeigt.*/
			exException.printStackTrace();
		}
	}
	
	/**
	 * In der folgenden Methode namens <b>"BufferedReader getReader()"<b> wird der Wert der Variable <b>"brReader"</b> zurückgegeben.
	 * 
	 * @return brReader<br>
	 * Die Variable "brReader" wird zurückgegeben.
	 */
	public static BufferedReader getReader()
	{
		return brReader;
	}
	
	/**
	 * In der folgenden Methode namens <b>hasIPsuccessfullySent()<b> wird der Wert der Variable <b>bIPgesendet</b> zurückgegeben.
	 * 
	 * @return bIPgesendet<br>
	 * Die Variable "bIPgesendet" wird zurückgegeben.*/
	public static boolean hasIPsuccessfullySent()
	{
		return bIPgesendet;
	}
	
	/**
	 * In der folgenden Methode namens <b>hasNetzworkConnection()<b> wird der Wert der Variable <b>bNetzwerkSteht</b> zurückgegeben.
	 * 
	 * @return bNetzwerkSteht<br>
	 * Die Variable "bNetzwerkSteht" wird zurückgegeben.*/
	public static boolean hasNetzworkConnection()
	{
		return bNetzwerkSteht;
	}
}