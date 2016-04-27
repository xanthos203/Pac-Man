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
	
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int raufBewegen(int iPosY)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iPosY += 8;
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
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iPosY -= 8;
				iGeistVer = iPosY;
			}
		}
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int rechtsBewegen(int iPosX)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iPosX += 8;
				iGeistHor = iPosX;
			}
		}
		return iGeistHor;
	}
//------------------------------------------------------------------------------------------------------------------------
	@Override
	public int linksBewegen(int iPosX)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iPosX -= 8;
				iGeistHor = iPosX;
			}
		}
		return iGeistHor;
	}
//--------------------------------------------------------------------------------------------------------------------------
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