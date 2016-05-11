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
	private int iGreeny = 410;
	private int iBlue = 411;
	private int iOrangy = 412;
	private int iPinky = 413;
	private int iGeistHor;
	private int iGeistVer;
	private static final int GANG_INDEX = Integer.parseInt(GameMainFrame.GANG);
	private static final int PAC_MAN_INDEX = Integer.parseInt(GameMainFrame.PAC_MAN);
	private static final int EATING_COIN_INDEX = Integer.parseInt(GameMainFrame.EATING_COIN);
	private static final int TELEPORTER_INDEX = Integer.parseInt(GameMainFrame.TELEPORTER);
	private static final int SPAWN_POINT = 2;
	
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	/*
	 * Hier wird die rauf Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	public int raufBewegen(int iPosY, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistVer = moveUp(iPosY, iGreeny); 
			
		if (sName.equals("iBlue"))
			iGeistVer = moveUp(iPosY, iBlue);
					
		if (sName.equals("iOrangy"))
			iGeistVer = moveUp(iPosY, iOrangy);
		
		if (sName.equals("iPinky"))
			iGeistVer = moveUp(iPosY, iPinky);
		
		return iGeistVer;
	}
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	/*
	 * Hier wird die runter Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	public int runterBewegen(int iPosY, String sName)
	{ 
		if (sName.equals("Greeny"))
			iGeistVer = moveDown(iPosY, iGreeny);
		
		if (sName.equals("iBlue"))
			iGeistVer = moveDown(iPosY, iBlue);
		
		if (sName.equals("iOrangy"))
			iGeistVer = moveDown(iPosY, iOrangy);
		
		if (sName.equals("iPinky"))
			iGeistVer = moveDown(iPosY, iPinky);
		
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	/*
	 * Hier wird die links Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	public int linksBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistHor = moveLeft(iPosX, iGreeny);
		
		if (sName.equals("iBlue"))
			iGeistHor = moveLeft(iPosX, iBlue);
		
		if (sName.equals("iOrangy"))
			iGeistHor = moveLeft(iPosX, iOrangy);
		
		if (sName.equals("iPinky"))
			iGeistHor = moveLeft(iPosX, iPinky);
		
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	@Override
	/*
	 * Hier wird die rechts Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	public int rechtsBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistHor = moveRight(iPosX, iGreeny);
		
		if (sName.equals("iBlue"))
			iGeistHor = moveRight(iPosX, iBlue);
		
		if (sName.equals("iOrangy"))
			iGeistHor = moveRight(iPosX, iOrangy);
		
		if (sName.equals("iPinky"))
			iGeistHor = moveRight(iPosX, iPinky);
		
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach oben Beweget.
	 */
	private int moveUp(int iPosY, int iGeist)
	{
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT)
		{
			
			System.out.println("w");
			iGeistVer = iPosY;
			if (iPosY >= 2)
				iPosY--;
			
			iGeistVer = iPosY;
		}
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach unten Bewegt.
	 */
	private int moveDown(int iPosY, int iGeist)
	{
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT)
		{
			System.out.println("s");
			iGeistVer = iPosY;
			if (iPosY < (GameMainFrame.GUI_ROWS - 2))
				iPosY++;
			
			iGeistVer = iPosY; 
		}
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister links Bewegt.
	 */
	private int moveLeft(int iPosX, int iGeist)
	{
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT)
		{
			System.out.println("a");
			iGeistHor = iPosX;
			if (iPosX >= 2)
				iPosX--;
			
			iGeistHor = iPosX;
		}
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach rechts Bewegt.
	 */
	private int moveRight(int iPosX, int iGeist)
	{
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT)
		{
			System.out.println("d");
			iGeistHor = iPosX;
			if (iPosX < (GameMainFrame.GUI_COLUMNS -2 ))
				iPosX++;
			
			iGeistHor = iPosX;
		}
		return iGeistHor;
	}
}