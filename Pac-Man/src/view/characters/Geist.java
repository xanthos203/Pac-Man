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
	private int iGeistHor;
	private int iGeistVer;
	private static final int GANG_INDEX = Integer.parseInt(GameMainFrame.GANG);
	private int iGreeny;
	private int iBlue;
	private int iOrangy;
	private int iPinky;
	
//--------------------------------------------------------------------------------------------------------------------------
	public int raufBewegen(int iPosY, String sName)
	{
//		if (sName == "Greeny")
		{
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))== 0||
			(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(3)||
			(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(4)||
			(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(6)))))
			{
				System.out.println("ra");
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
	public int runterBewegen(int iPosY, String sName)
	{ 
//		if (sName == "Greeny")
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))== 0||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(3)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(4)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(6)))))
			{
				System.out.println(GameMainFrame.getArrayListIndex());
				System.out.println("ru");
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
	public int linksBewegen(int iPosX, String sName)
	{
//		if (sName == "Greeny")
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))== 0||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(3)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(4)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(6)))))
			{
				System.out.println("l");
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
	public int rechtsBewegen(int iPosX, String sName)
	{
		if (sName == "Greeny")
		{
			if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))== 0||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(3)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(4)||
					(Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGreeny))==(6)))))
			{
				System.out.println("r");
				iGeistHor = iPosX;
				if (iGeistHor < (GameMainFrame.GUI_COLUMNS - 1))
					iGeistHor--;
				else
					iGeistHor = iPosX;
			}
		}
		return iGeistHor;
	}
//------------------------------------------------------------------------------------------------------------------------
	@Override
	public int getX()
	{
		return iGeistHor;
	}
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int getY()
	{
		return iGeistVer;
	}
}