package view.characters;

import view.frames.GameMainFrame;

/**
 * @author Thomas
 * @version 1.0
 */
public class Geister 
{
	private int iGeistX;
	private int iGeistY;
	
	public int GeisterRaufBewegen(int iRaufY)
	{
		if(iRaufY + GameMainFrame.getSpieler().getHeight() < GameMainFrame.getFrame().getContentPane().getBounds().getHeight())
		{
			iRaufY += 8;
			iGeistY = iRaufY;
		}
		return iGeistY;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public int GeisterRunterBewegen(int iRunterY)
	{ 
		if(iRunterY >+ 16) 
		{
			iRunterY -= 8;
			iGeistY = iRunterY;
		}
		return iGeistY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public int GeisterRechtsBewegen(int iRunterX)
	{
//		if(iRunterx+CSpielFrame.getSpieler().getHeight()<CSpielFrame.getFrame().getContentPane().getBounds().getWidth()-/*Randkoordinaten des JPanels angeben*/)
//		{
//			iRunterx+=8;
//			iGeistx = iRunterx;
//		}
		return iGeistX;
	}
//------------------------------------------------------------------------------------------------------------------------	
	public int GeisterLinksBewegen(int iRunterX)
	{
		if(iRunterX > 16)
		{
			iRunterX -= 8;
			iGeistX = iRunterX;
		}
		return iGeistX;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public int getPosY() 
	{
		return iGeistY;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public int getPosX() 
	{
		return iGeistX;
	}
}