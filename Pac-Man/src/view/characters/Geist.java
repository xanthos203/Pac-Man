package view.characters;

import model.interfaces.ICharakterBewegen;
import view.frames.GameMainFrame;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class Geist implements ICharakterBewegen
{
	private int iGreeny;
	private int iBlue;
	private int iOrangy;
	private int iPinky;
	private int iGeistHor;
	private int iGeistVer;
	private static final int GANG_INDEX = Integer.parseInt(GameMainFrame.GANG);
	private static final int PAC_MAN_INDEX = Integer.parseInt(GameMainFrame.PAC_MAN);
	private static final int EATING_COIN_INDEX = Integer.parseInt(GameMainFrame.EATING_COIN);
	private static final int TELEPORTER_INDEX = Integer.parseInt(GameMainFrame.TELEPORTER);
	
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int raufBewegen(int iPosY, String sName)
	{
		if (sName.equals("Greeny"))
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == GANG_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == PAC_MAN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == EATING_COIN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == TELEPORTER_INDEX)
			{
				iGeistVer = iPosY;
				if (iGeistVer > 0)
					iGeistVer--;
				else
					iGeistVer = iPosY;
			}
		}
		return iGeistVer;
	}
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int runterBewegen(int iPosY, String sName)
	{ 
		if (sName.equals("Greeny"))
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == GANG_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == PAC_MAN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == EATING_COIN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == TELEPORTER_INDEX)
			{
				iGeistVer = iPosY;
				if (iGeistVer < (GameMainFrame.GUI_ROWS - 1))
					iGeistVer--;
				else
					iGeistVer = iPosY;
			}
		}
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int linksBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == GANG_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == PAC_MAN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == EATING_COIN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == TELEPORTER_INDEX)
			{
				iGeistHor = iPosX;
				if (iGeistHor > 0)
					iGeistHor--;
				else
					iGeistHor = iPosX;
			}
		}
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int rechtsBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == GANG_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == PAC_MAN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == EATING_COIN_INDEX ||
				Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny)) == TELEPORTER_INDEX)
			{
				iGeistHor = iPosX;
				if (iGeistHor < (GameMainFrame.GUI_COLUMNS - 1))
					iGeistHor--;
				else
					iGeistHor = iPosX;
			}
		}
		return iGeistHor;
	}
}