package view.characters;

import view.frames.GameMainFrame;

/**
 * @author Thomas
 * @version 1.0
 */
public final class Geister 
{
	private static int iGeistX;
	private static int iGeistY;
	
	public static int GeisterRaufBewegen(int iRaufY, String sName)
	{
		
		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRaufY += 8;
				iGeistY = iRaufY;
			}
			
		}
		
		return iGeistY;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static int GeisterRunterBewegen(int iRunterY, String sName)
	{ 
		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunterY -= 8;
				iGeistY = iRunterY;
			}
			
		}
		return iGeistY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public static int GeisterRechtsBewegen(int iRunterX, String sName)
	{
		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunterX += 8;
				iGeistY = iRunterX;
			}
			
		}
		return iGeistX;
	}
//------------------------------------------------------------------------------------------------------------------------	
	public static int GeisterLinksBewegen(int iRunterX, String sName)
	{
		if (sName == "Greeny")
		{
			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				iRunterX -= 8;
				iGeistY = iRunterX;
			}
			
		}
		return iGeistX;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static int getPosY() 
	{
		return iGeistY;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static int getPosX() 
	{
		return iGeistX;
	}
}