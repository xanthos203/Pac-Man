package view.characters;

import view.frames.GameMainFrame;

/**
 * 
 * @author Thomas
 * @version 1.0
 */
public class Spieler 
{
	private int iSpielerX = 0;
	private int iSpielerY = 0;
	private int iLeben = 3;		// <-- Testwert
	private double dPunktestand = 999999999999999L; // <-- Testwert
	
	public int getLeben()
	{
		return iLeben;
	}
	
	public void setPunktestand(double dPunktestand)
	{
		if(dPunktestand > 999999999999999L)
			dPunktestand = 999999999999999L;
		else
			this.dPunktestand = dPunktestand;
	}
	
	public double getPunktestand()
	{
		return dPunktestand;
	}
	
	/**
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese größer und deshalb wird 
	 * @param iRaufY
	 * @return
	 */
	public int SpielerRaufBewegen(int iRaufY)
	{				
		// Hier wird überprüft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		if((iRaufY + GameMainFrame.getSpieler().getHeight() < (GameMainFrame.getFrame().getContentPane().getBounds().getHeight()) - 18))
		{
			iRaufY += 4;
			iSpielerY = iRaufY;
		}
		return iSpielerY;
	}
	
//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param iRunterY
	 * @return
	 * 
	 * Diese Methode bewegt den Spieler hinauf allerdings nur, wenn der Spierler den Oberenerand noch nicht erreicht hat.
	 */
	public int SpielerRunterBewegen(int iRunterY)
	{
		//  Hier wird überprüft ober der Spieler noch weiter hinauf bewegt werden darf
		if(iRunterY > 16)
		{
			iRunterY -= 4;
			iSpielerY = iRunterY;
		}
		return iSpielerY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRunterX
	 * @return
	 * 
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 */
	public int SpielerRechtsBewegen(int iRunterX)
	{
		
//		// Hier wird nur überprüft, ob der Spieler noch weiter nach rechts fahren darf
//		if((iRunterx+CSpielFrame.getSpieler().getHeight())+/*Hier wierd die Dicke des Pandels angegeben*/<CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
//		{
//			iRunterx+=4;
//			iSpielerx = iRunterx;
//		}
//		
//		// Hier wird überprüft, ob der Spieler sich zwischen den Koordinaten für den Seitenwechsel befindet oder nicht
//		if((iRunterx</*Hier wierd die Dicke des Pandels angegeben*/+CSpielFrame.getFrame().getContentPane().getBounds().getWidth())&&(((iSpielery>/*Hier wird eine koordinate anggegben für den Seiten wechsel des Spielers*/) && (iSpielery</*Hier wird eine koordinate anggegben für den Seiten wechsel des Spielers*/))))
//		{
//			iRunterx+=4;
//			
//			// Hier wird nur überprüft, ob der Spieler den linken aüßeren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
//			if((iRunterx)>=CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
//			{
//				iRunterx = 0;
//			}
//			
//			iSpielerx = iRunterx;
//		}
		
		return iSpielerX;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRunterX
	 * @return
	 * 
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 */
	public int SpielerLinksBewegen(int iRunterX)
	{
//		// Hier wird abegefragt, ob sich der Spieler am Rande des Spielfedes befindet oder nicht
//		if(iRunterx>/*Hier wird abgefragt ob der Spieler den Rand des Pandels erreicht hat, in Koordinaten anggegeben*/)
//		{
//			iRunterx-=4;
//			iSpielerx=iRunterx;
//		}
//		
//		// Hier wird überprüft ob sich der Spieler zwischen den Koordinaten befinden wo er die Wand durch fahren darf um die Seite zu wechseln
//		if((iRunterx</*das selbe wie in zeile 68*/)&& ((iSpielery>/*selbe wie in Zeile 51*/) && (iSpielery/*Selbe wie in Zeile 51*/)))
//		{
//			iRunterx -=4;
//			
//			// Hier wird nur überprüft, ob der Spieler den linken aüßeren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
//			if(iRunterx<=0)
//			{
//				iRunterx = (int) CSpielFrame.getFrame().getContentPane().getBounds().getWidth();	
//			}
//			
//			iSpielerx = iRunterx;
//		}
		return iSpielerX;
	}
}