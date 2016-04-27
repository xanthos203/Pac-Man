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
	public int raufBewegen(int iRauf)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRauf += 8;
				iGeistVer = iRauf;
			}
		}
		return iGeistVer;
	}
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int runterBewegen(int iRunter)
	{ 
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunter -= 8;
				iGeistVer = iRunter;
			}
		}
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public int rechtsBewegen(int iRechts)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRechts += 8;
				iGeistHor = iRechts;
			}
		}
		return iGeistHor;
	}
//------------------------------------------------------------------------------------------------------------------------
	@Override
	public int linksBewegen(int iLinks)
	{
//		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iLinks -= 8;
				iGeistHor = iLinks;
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