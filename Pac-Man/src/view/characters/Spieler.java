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
	@Override
	public int raufBewegen(int iPosY)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerVer = iPosY;
			if (iSpielerVer > 0)
				iSpielerVer--;
			else
				iSpielerVer = iPosY;
		}
		return iSpielerVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int runterBewegen(int iPosY)
	{				
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerVer = iPosY;
			if (iSpielerVer < (GameMainFrame.GUI_ROWS - 1))
				iSpielerVer++;
			else
				iSpielerVer = iPosY;
		}
		return iSpielerVer;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	@Override
	public int linksBewegen(int iPosX)
	{
//		if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerHor = iPosX;
			if (iSpielerHor > 0)
				iSpielerHor--;
			else
				iSpielerHor = iPosX;
		}
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int rechtsBewegen(int iPosX)
	{
		// Hier wird überprüft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		//if  (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals(GameMainFrame.GANG))
		{
			iSpielerHor = iPosX;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1))
				iSpielerHor++;
			else
				iSpielerHor = iPosX;
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