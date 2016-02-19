package Figuren;

import java.awt.Component;

import frames.CSpielFrame;

/**
 * @author Thomas
 * @version 1.0
 */
public class CGeister 
{
	private int iGeisty;
	private int iGeistx;
	
	public int GeisterRaufBewegen(int iRaufy)
	{
		if(iRaufy+CSpielFrame.getSpieler().getHeight()<CSpielFrame.getFrame().getContentPane().getBounds().getHeight())
		{
			iRaufy+=8;
			iGeisty = iRaufy;
		}
		return iGeisty;
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	
	public int GeisterRunterBewegen(int iRuntery)
	{ 
		if(iRuntery>+16) 
		{
			iRuntery-=8;
			iGeisty=iRuntery;
		}
		return iGeisty;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public int GeisterRechtsBewegen(int iRunterx)
	{
		if(iRunterx+CSpielFrame.getSpieler().getHeight()<CSpielFrame.getFrame().getContentPane().getBounds().getWidth()-/*Randkoordinaten des JPanels angeben*/)
		{
			iRunterx+=8;
			iGeistx = iRunterx;
		}
		return iGeistx;
	}
//------------------------------------------------------------------------------------------------------------------------	
	public int GeisterLinksBewegen(int iRunterx)
	{
		if(iRunterx>16)
		{
			iRunterx-=8;
			iGeistx=iRunterx;
		}
		return iGeistx;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public int getPosY() 
	{
		return iGeisty;
	}
//--------------------------------------------------------------------------------------------------------------------------
	
	public int getPosX() 
	{
		return iGeistx;
	}
}

