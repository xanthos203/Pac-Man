package view.characters;

import java.util.ArrayList;

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
	private ArrayList<String> alSpielfeldArrayList  = GameMainFrame.getSpielfeldAL();
	
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int raufBewegen(int iPosY)
	{
//		if (sName == "Greeny")
		{
			if ((alSpielfeldArrayList).equals(GameMainFrame.GANG))
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
	@Override
	public int runterBewegen(int iPosY)
	{ 
//		if (sName == "Greeny")
		{
//			if (GameMainFrame.getSpielfeldAL().get(GameMainFrame.getArrayListIndex()).equals(GameMainFrame.GANG))
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
	@Override
	public int linksBewegen(int iPosX)
	{
//		if (sName == "Greeny")
		{
//			if (GameMainFrame.getSpielfeldAL().get(GameMainFrame.getArrayListIndex()).equals(GameMainFrame.GANG))
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
	@Override
	public int rechtsBewegen(int iPosX)
	{
//		if (sName == "Greeny")
		{
//			if (GameMainFrame.getSpielfeldAL().get(GameMainFrame.getArrayListIndex()).equals(GameMainFrame.GANG))
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