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
	
	public static int GeisterRaufBewegen(int iRaufY)
	{
		if(GameMainFrame.lGreeny.getY() != GameMainFrame.lPacMan.getY())
		{
			iRaufY += 8;
			iGeistY = iRaufY;
		}
		
		if(GameMainFrame.lBlue.getY() != GameMainFrame.lPacMan.getY())
		{
			iRaufY += 8;
			iGeistY = iRaufY;
		}
		
		if(GameMainFrame.lOrangy.getY() != GameMainFrame.lPacMan.getY())
		{
			iRaufY += 8;
			iGeistY = iRaufY;
		}
		
		if(GameMainFrame.lPinky.getY() != GameMainFrame.lPacMan.getY())
		{
			iRaufY += 8;
			iGeistY = iRaufY;
		}
		
		return iGeistY;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static int GeisterRunterBewegen(int iRunterY)
	{ 
		if(GameMainFrame.lGreeny.getY() != GameMainFrame.lPacMan.getY())
		{
			iRunterY -= 8;
			iGeistY = iRunterY;
		}
		
		if(GameMainFrame.lBlue.getY() != GameMainFrame.lPacMan.getY())
		{
			iRunterY -= 8;
			iGeistY = iRunterY;
		}
		
		if(GameMainFrame.lOrangy.getY() != GameMainFrame.lPacMan.getY())
		{
			iRunterY -= 8;
			iGeistY = iRunterY;
		}
		
		if(GameMainFrame.lPinky.getY() != GameMainFrame.lPacMan.getY())
		{
			iRunterY -= 8;
			iGeistY = iRunterY;
		}
		return iGeistY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public static int GeisterRechtsBewegen(int iRunterX)
	{
//		if(iRunterX + GameMainFrame.getSpieler().getHeight() < GameMainFrame.getGameMainFrame().getContentPane().getBounds().getWidth() - /*Randkoordinaten des JPanels angeben*/)
//		{
//			iRunterX += 8;
//			iGeistX = iRunterX;
//		}
		return iGeistX;
	}
//------------------------------------------------------------------------------------------------------------------------	
	public static int GeisterLinksBewegen(int iRunterX)
	{
		if(iRunterX > 16)
		{
			iRunterX -= 8;
			iGeistX = iRunterX;
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