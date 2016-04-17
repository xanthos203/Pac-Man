package view.characters;

import view.frames.GameLostFrame;
import view.frames.GameMainFrame;
import view.frames.GameWonFrame;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public final class Spieler 
{
	private static int iSpielerX = GameMainFrame.getSpielerX();
	private static int iSpielerY = GameMainFrame.getSpielerY();
	private static int iLeben = 3;
	private static double dPunktestand = 0;
	
	/**
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese größer und deshalb wird 
	 * @param iRunter
	 * @return
	 */
	public static int runterBewegen(int iRunter)
	{				
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			if (iSpielerY < (GameMainFrame.GUI_ROWS - 1))
			{
				iSpielerY++;
			}
			else
			{
				iSpielerY = iRunter;
			}
		}
		return iSpielerY;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param iRauf
	 * @return
	 * 
	 * Diese Methode bewegt den Spieler hinauf allerdings nur, wenn der Spierler den Oberenerand noch nicht erreicht hat.
	 */
	public static int raufBewegen(int iRauf)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			if (iSpielerY >= 1)
			{
				iSpielerY--;
			}
			else
			{
				iSpielerY = iRauf;
			}
		}
		return iSpielerY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRechts
	 * @return
	 * 
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 */
	public static int rechtsBewegen(int iRechts)
	{
		// Hier wird überprüft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			if (iSpielerX < (GameMainFrame.GUI_COLUMNS - 1))
			{
				iSpielerX++;
			}
			else
			{
				iSpielerX = iRechts;
			}
		}
		return iSpielerX;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iLinks
	 * @return
	 * 
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 */
	public static int linksBewegen(int iLinks)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			if (iSpielerX >= 1)
			{
				iSpielerX--;
			}
			else
			{
				iSpielerX = iLinks;
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
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			Spieler.iLeben = iLeben;
			GameMainFrame.updateSpielstandlabelText();
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
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			Spieler.dPunktestand = dPunktestand;
			GameMainFrame.updateSpielstandlabelText();
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