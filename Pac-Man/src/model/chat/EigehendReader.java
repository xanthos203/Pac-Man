package model.chat;

import view.frames.GameMainFrame;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class EigehendReader implements Runnable 
{
	public void run()
	{
		String sNachricht;
		
		try
		{			
			while ((sNachricht = Client.getReader().readLine()) == null) 
			{
				GameMainFrame.getChatverlaufTextarea().append(sNachricht + "\n");		
			}
		}
		catch(Exception exException) 
		{
			exException.printStackTrace();
		}
	}
}