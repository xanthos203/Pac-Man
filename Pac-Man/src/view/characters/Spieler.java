package view.characters;

import model.interfaces.ICharakterBewegen;
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
public class Spieler implements ICharakterBewegen
{
	private int iSpielerHor;
	private int iSpielerVer;
	private int iLeben = 3;
	private double dPunktestand = 0;

//-------------------------------------------------------------------------------------------------------------------------
	public void setLeben(int iLeben)
	{
		if (iLeben <= 0)
		{
			GameMainFrame.getGameMainFrame().setVisible(false);
			new GameLostFrame();
			GameMainFrame.getGameMainFrame().dispose();
		}
		if (iLeben >= 3)
		{
			this.iLeben = 3;
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			this.iLeben = iLeben;
			GameMainFrame.updateSpielstandlabelText();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	public void setPunktestand(double dPunktestand)
	{
		if ((dPunktestand >= 999999999999999L) && (iLeben > 0))
		{
			GameMainFrame.getGameMainFrame().setVisible(false);
			new GameWonFrame();
			GameMainFrame.getGameMainFrame().dispose();
		}
		if (dPunktestand <= 0)
		{
			this.dPunktestand = 0;
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			this.dPunktestand = dPunktestand;
			GameMainFrame.updateSpielstandlabelText();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * Diese Methode bewegt den Spieler hinauf allerdings nur, wenn der Spierler den Oberenerand noch nicht erreicht hat.
	 * @param iRauf
	 * @return
	 */
	@Override
	public int raufBewegen(int iRauf)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerVer = iRauf;
			if (iSpielerVer > 0)
				iSpielerVer--;
			else
				iSpielerVer = iRauf;
		}
		return iSpielerVer;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese größer und deshalb wird 
	 * @param iRunter
	 * @return
	 */
	@Override
	public int runterBewegen(int iRunter)
	{				
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerVer = iRunter;
			if (iSpielerVer < (GameMainFrame.GUI_ROWS - 1))
				iSpielerVer++;
			else
				iSpielerVer = iRunter;
		}
		return iSpielerVer;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 * @param iLinks
	 * @return
	 */
	@Override
	public int linksBewegen(int iLinks)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerHor = iLinks;
			if (iSpielerHor > 0)
				iSpielerHor--;
			else
				iSpielerHor = iLinks;
		}
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * Hier wird überprüft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu können
	 * @param iRechts
	 * @return
	 */
	@Override
	public int rechtsBewegen(int iRechts)
	{
		// Hier wird überprüft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerHor = iRechts;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1))
				iSpielerHor++;
			else
				iSpielerHor = iRechts;
		}
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int getX()
	{
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int getY()
	{
		return iSpielerVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public int getLeben()
	{
		return iLeben;
	}
//-------------------------------------------------------------------------------------------------------------------------
	public double getPunktestand()
	{
		return dPunktestand;
	}
}