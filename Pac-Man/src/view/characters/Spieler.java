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
	private static int iPacManPos = 610;
	private int iLeben = 3;
	private int iSpielerHor;
	private double dPunktestand = 0;
	
//-------------------------------------------------------------------------------------------------------------------------
	public void setLeben(int iLeben)
	{
		if (iLeben <= 0)
		{
			GameMainFrame.setSpielerLebt(false);
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
	/*
	 * Hier in der Methode raufBewegen wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int raufBewegen(int iPosX, int iPosY)
	{
		iPacManPos -= 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			if (iPosY > 0)
			{
				iPosY--;
			}
		}
		else
		{
			iPacManPos += 33;
		}
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int runterBewegen(int iPosX, int iPosY)
	{	
		iPacManPos += 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			if (iPosY < (GameMainFrame.GUI_ROWS - 1))
			{
				iPosY++;
			}
		}
		else
		{
			iPacManPos -= 33;
		}
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int linksBewegen(int iPosX, int iPosY)
	{
		iPacManPos--;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor > -1) 
			{
				iSpielerHor--;
			} 
			else
			{
				iSpielerHor = iPosX;
			}
		}
		else
		{
			iPacManPos++;
		}
		if (iSpielerHor == 0)
		{
			iSpielerHor = (GameMainFrame.GUI_COLUMNS - 2);
		}	
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int rechtsBewegen(int iPosX, int iPosY)
	{
		iPacManPos++;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1)) 
			{
				iSpielerHor++;
			}
			else 
			{
				iSpielerHor = iPosX;
			}
		}
		else
		{
			iPacManPos--;
		}
		if (iSpielerHor == (GameMainFrame.GUI_COLUMNS - 1))
		{
			iSpielerHor = 1;
		}
		return iSpielerHor;
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