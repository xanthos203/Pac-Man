package model.chat;

import view.frames.GameMainFrame;

public final class EigehendReader implements Runnable 
{
	public void run()
	{
		String sNachricht;
		
		try
		{			
			while ((sNachricht = Client.getReader().readLine()) == null) 
			{
//				System.out.println("gelesen: " + sNachricht);
				GameMainFrame.getArea().append(sNachricht + "\n");		
			}
		} 
		catch(Exception exException) 
		{
			exException.printStackTrace();
		}
	}
}