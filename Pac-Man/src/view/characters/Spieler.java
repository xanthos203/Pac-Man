package view.characters;

import view.frames.GameLostFrame;
import view.frames.GameMainFrame;
import view.frames.GameWonFrame;

/**
 * 
 * @author Thomas
 * @version 1.0
 */
public final class Spieler 
{
	private static int iSpielerX;
	private static int iSpielerY;
	private static int iLeben = 3;
	private static double dPunktestand = 0;
	
	
	/**
	 * 
	 * Diese Methode hei�t zwar Spieler rauf bewegen, jedoch bewegt sich hier der Spieler hinunter.<br>
	 * Der Name der Methode bezieht sich hierbei auf die Koordinaten des Hauptcharakters.<br>
	 * Wenn der Spieler sich hinunterbewegt, wird also die jeweilige Koordinate (in diesem Fall die y-Koordinate) erh�ht.<br>
	 * 
	 * @param iRaufY
	 * @return
	 */
	public static int SpielerRaufBewegen(int iRaufY)
	{				
		// Hier wird �berpr�ft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		if ((iRaufY + GameMainFrame.getSpieler()
				.getHeight() < (GameMainFrame.getGameMainFrame().getContentPane().getBounds().getHeight()) - 18))
		{
//			if (GameMainFrame.getSpielfeld() == GameMainFrame.getGaengeFarbe())
			{
				iRaufY += 4;
				iSpielerY = iRaufY;
			}
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
	public static int SpielerRunterBewegen(int iRunterY)
	{
		//  Hier wird �berpr�ft ober der Spieler noch weiter hinauf bewegt werden darf
		if (iRunterY > 16)
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
	 * Hier wird �berpr�ft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu k�nnen
	 */
	public static int SpielerRechtsBewegen(int iRunterX)
	{
		
//		// Hier wird nur �berpr�ft, ob der Spieler noch weiter nach rechts fahren darf
//		if((iRunterX + GameMainFrame.getSpieler().getHeight()) + /*Hier wierd die Dicke des Pandels angegeben*/ < GameMainFrame.getGameMainFrame().getContentPane().getBounds().getWidth())
//		{
//			iRunterX += 4;
//			iSpielerX = iRunterX;
//		}
//		
//		// Hier wird �berpr�ft, ob der Spieler sich zwischen den Koordinaten f�r den Seitenwechsel befindet oder nicht
//		if((iRunterX < /*Hier wierd die Dicke des Pandels angegeben*/ + GameMainFrame.getGameMainFrame().getContentPane().getBounds().getWidth()) && (((iSpielery > /*Hier wird eine koordinate anggegben f�r den Seiten wechsel des Spielers*/) && (iSpielery < /*Hier wird eine koordinate anggegben f�r den Seiten wechsel des Spielers*/))))
//		{
//			iRunterX += 4;
//			
//			// Hier wird nur �berpr�ft, ob der Spieler den linken a��eren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
//			if((iRunterX) >= GameMainFrame.getGameMainFrame().getContentPane().getBounds().getWidth())
//			{
//				iRunterX = 0;
//			}
//			
//			iSpielerX = iRunterX;
//		}
		return iSpielerX;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRunterX
	 * @return
	 * 
	 * Hier wird �berpr�ft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu k�nnen
	 */
	public static int SpielerLinksBewegen(int iRunterX)
	{
//		// Hier wird abegefragt, ob sich der Spieler am Rande des Spielfedes befindet oder nicht
//		if(iRunterX > /*Hier wird abgefragt ob der Spieler den Rand des Pandels erreicht hat, in Koordinaten anggegeben*/)
//		{
//			iRunterX -= 4;
//			iSpielerX = iRunterX;
//		}
//		
//		// Hier wird �berpr�ft ob sich der Spieler zwischen den Koordinaten befinden wo er die Wand durch fahren darf um die Seite zu wechseln
//		if((iRunterx < /*das selbe wie in zeile 68*/) && ((iSpielery > /*selbe wie in Zeile 51*/) && (iSpielery/*Selbe wie in Zeile 51*/)))
//		{
//			iRunterX -=4;
//			
//			// Hier wird nur �berpr�ft, ob der Spieler den linken a��eren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
//			if(iRunterX <= 0)
//			{
//				iRunterX = (int) GameMainFrame.getGameMainFrame().getContentPane().getBounds().getWidth();	
//			}
//			
//			iSpielerX = iRunterX;
//		}
		return iSpielerX;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public static void setLeben(int iLeben)
	{
		if (iLeben <= 0)
		{
			GameMainFrame.getGameMainFrame().dispose();
			new GameLostFrame();
		}
		if (iLeben >= 3)
		{
			Spieler.iLeben = 3;
			GameMainFrame.setSpielstandlabelText(getLeben(), getPunktestand());
		}
		else
		{
			Spieler.iLeben = iLeben;
			GameMainFrame.setSpielstandlabelText(getLeben(), getPunktestand());
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	public static void setPunktestand(double dPunktestand)
	{
		if ((dPunktestand >= 999999999999999L) && (iLeben > 0))
		{
			GameMainFrame.getGameMainFrame().dispose();
			new GameWonFrame();
		}
		if (dPunktestand <= 0)
		{
			Spieler.dPunktestand = 0;
			GameMainFrame.setSpielstandlabelText(getLeben(), getPunktestand());
		}
		else
		{
			Spieler.dPunktestand = dPunktestand;
			GameMainFrame.setSpielstandlabelText(getLeben(), getPunktestand());
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	public static int getLeben()
	{
		return iLeben;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public static double getPunktestand()
	{
		return dPunktestand;
	}
}