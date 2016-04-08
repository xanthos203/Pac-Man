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
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese gr��er und deshalb wird 
	 * @param iRaufY
	 * @return
	 */
	public static int SpielerRaufBewegen(int iRaufY)
	{				
		// Hier wird �berpr�ft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		if ((iRaufY + GameMainFrame.getSpieler()
				.getHeight() < (GameMainFrame.getGameMainFrame().getContentPane().getBounds().getHeight()) - 18))
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
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
		if ((iRunterY + GameMainFrame.getSpieler()
		.getHeight() < (GameMainFrame.getGameMainFrame().getContentPane().getBounds().getHeight()) - 18))
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunterY += 4;
				iSpielerY = iRunterY;
			}
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
		if ((iRunterX + GameMainFrame.getSpieler()
		.getHeight() < (GameMainFrame.getGameMainFrame().getContentPane().getBounds().getHeight()) - 18))
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunterX += 4;
				iSpielerX = iRunterX;
			}
		}
		return iSpielerX;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRaufX
	 * @return
	 * 
	 * Hier wird �berpr�ft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu k�nnen
	 */
	public static int SpielerLinksBewegen(int iRaufX)
	{
		if ((iRaufX + GameMainFrame.getSpieler()
		.getHeight() < (GameMainFrame.getGameMainFrame().getContentPane().getBounds().getHeight()) - 18))
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRaufX += 4;
				iSpielerX = iRaufX;
			}
		}
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