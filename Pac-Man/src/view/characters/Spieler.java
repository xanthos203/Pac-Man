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
	private static final int PAC_MAN_INDEX = Integer.parseInt(GameMainFrame.PAC_MAN);
	private static final int EATING_COIN_INDEX = Integer.parseInt(GameMainFrame.EATING_COIN);
	private static final int TELEPORTER_INDEX = Integer.parseInt(GameMainFrame.TELEPORTER);
	private static int iPacManPos = 610;
	private double dPunktestand = 0;
	private int iSpielerHor;
	private int iLeben = 3;

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
	/**
	 * Hier in der Methode raufBewegen  wird als erstes die Position vom Pac-Man ge�ndert und danach wird abgefragt, ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	public int raufBewegen(int iPosY, String sName)
	{
		iPacManPos -= 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == TELEPORTER_INDEX)
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
	@Override
	/**
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man ge�ndert und danach wird abgefragt, ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	public int runterBewegen(int iPosY, String sName)
	{	
		iPacManPos += 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == TELEPORTER_INDEX)
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
	@Override
	/**
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man ge�ndert und danach wird abgefragt, ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	public int linksBewegen(int iPosX, String sName)
	{
		iPacManPos--;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor > -1) {
				iSpielerHor--;
			} else {
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
	@Override
	/**
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man ge�ndert und danach wird abgefragt, ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	public int rechtsBewegen(int iPosX, String sName)
	{
		iPacManPos++;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1)) {
				iSpielerHor++;
			} else {
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