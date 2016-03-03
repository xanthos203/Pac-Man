package Chat;

import frames.CSpielFrame;

public class EigehendReader implements Runnable {
	public void run() {
		String nachricht;
		try {
			
			while ((nachricht = Client.getReader().readLine()) != null) {
				System.out.println("gelesen: " + nachricht);
				((Appendable) CSpielFrame.getSchreibFeld()).append(nachricht + "\n");	
				
			}
		} catch(Exception ex) {ex.printStackTrace();}
	}
}
