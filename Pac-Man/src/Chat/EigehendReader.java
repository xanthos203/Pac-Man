package Chat;

import frames.CSpielFrame;

public class EigehendReader implements Runnable 
{
	public void run()
	{
		String nachricht;
		try
		{			
			while ((nachricht = Client.getReader().readLine()) == null) 
			{
				System.out.println("1gelesen: " + nachricht);
				CSpielFrame.getArea().append(nachricht + "\n");		
			}
		} 
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
