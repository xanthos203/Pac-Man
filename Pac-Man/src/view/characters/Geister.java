package view.characters;

import view.frames.GameMainFrame;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public final class Geister 
{
	private static int iGeistHor;
	private static int iGeistVer;
	
	public static int raufBewegen(int iRauf, String sName)
	{
		if (sName == "Greeny")
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
	public static int runterBewegen(int iRunter, String sName)
	{ 
		if (sName == "Greeny")
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
	public static int rechtsBewegen(int iRechts, String sName)
	{
		if (sName == "Greeny")
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
	public static int linksBewegen(int iLinks, String sName)
	{
		if (sName == "Greeny")
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
	public static int getGeistX()
	{
		return iGeistHor;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static int getGeistY()
	{
		return iGeistVer;
	}
}