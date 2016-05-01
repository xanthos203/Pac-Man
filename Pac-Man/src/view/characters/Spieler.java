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
	private static final int GANG_INDEX = Integer.parseInt(GameMainFrame.GANG);
	private int iSpielerHor;
	private int iSpielerVer=0;
	private int iLeben = 3;
	private double dPunktestand = 0;
	private static int iPacManPos = 610;

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
		iPacManPos-=33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos))== 0)
		{
			if (iPosY > 0)
				iPosY--;
		}
		else
		{
			iPacManPos+=33;
		}
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int runterBewegen(int iPosY)
	{	
		iPacManPos+=33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos))== 0)
		{
			if (iPosY < (GameMainFrame.GUI_ROWS - 1))
				iPosY++;
		}
		else
		{
			iPacManPos-=33;
		}
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	@Override
	public int linksBewegen(int iPosX)
	{
		iPacManPos--;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos))== 0)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor > 0)
				iSpielerHor--;
			else
				iSpielerHor = iPosX;
		}
		else
		{
			iPacManPos++;
		}
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int rechtsBewegen(int iPosX)
	{
		iPacManPos++;
		System.out.println(iPacManPos);
		// Hier wird überprüft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos))== 0)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1))
			{
				iSpielerHor++;
			}
			else
				iSpielerHor = iPosX;
		}
		else
		{
			iPacManPos--;
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


