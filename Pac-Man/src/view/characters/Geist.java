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
	private static final int SPAWN_POINT_INDEX = Integer.parseInt(GameMainFrame.SPAWN_POINT);
	
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier wird die rauf Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	@Override
	public int raufBewegen(int iPosY, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistVer = moveUp(iPosY, sName); 
					
		if (sName.equals("iBlue"))
			iGeistVer = moveUp(iPosY, sName);

		if (sName.equals("iOrangy"))
			iGeistVer = moveUp(iPosY, sName);
		
		if (sName.equals("iPinky"))
			iGeistVer = moveUp(iPosY, sName);
		
		return iGeistVer;
	}
//--------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier wird die runter Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	@Override
	public int runterBewegen(int iPosY, String sName)
	{ 
		if (sName.equals("Greeny"))
			iGeistVer = moveDown(iPosY, sName);
		
		if (sName.equals("iBlue"))
			iGeistVer = moveDown(iPosY, sName);
		
		if (sName.equals("iOrangy"))
			iGeistVer = moveDown(iPosY, sName);
		
		if (sName.equals("iPinky"))
			iGeistVer = moveDown(iPosY, sName);
		
		
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier wird die links Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	@Override
	public int linksBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistHor = moveLeft(iPosX, sName);
		
		if (sName.equals("iBlue"))
			iGeistHor = moveLeft(iPosX, sName);
		
		if (sName.equals("iOrangy"))
			iGeistHor = moveLeft(iPosX, sName);
		
		if (sName.equals("iPinky"))
			iGeistHor = moveLeft(iPosX, sName);
		
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier wird die rechts Bewegen der Geister aufgerufen. Diese Methode ist die Schnittstelle zwischen GaimMainFrame und Geist Klasse.
	 */
	@Override
	public int rechtsBewegen(int iPosX, String sName)
	{
		if (sName.equals("Greeny"))
			iGeistHor = moveRight(iPosX, sName);
		
		if (sName.equals("iBlue"))
			iGeistHor = moveRight(iPosX, sName);
		
		if (sName.equals("iOrangy"))
			iGeistHor = moveRight(iPosX, sName);
		
		if (sName.equals("iPinky"))
			iGeistHor = moveRight(iPosX, sName);
		
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach oben Bewegt.
	 */
	private int moveUp(int iPosY, String sName)
	{
		int iGeist = 0;
		if(sName.equals("Greeny"))
		{
			iGreeny -= 33;
			iGeist = iGreeny;
		}
		
		if(sName.equals("Blue"))
		{
			iBlue -= 33;
			iGeist = iBlue;
		}
		
		if(sName.equals("Orangy"))
		{
			iOrangy -= 33;
			iGeist = iOrangy;
		}
		
		if(sName.equals("Pinky"))
		{
			iPinky -= 33;
			iGeist = iPinky;
		}
		
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT_INDEX)
		{
			
			System.out.println("w");
			iGeistVer = iPosY;
			if (iPosY >= 2)
				iPosY--;
			
			iGeistVer = iPosY;
		}
		else
		{
			if(sName.equals("Greeny"))
				iGreeny += 33;
			
			if(sName.equals("Blue"))
				iBlue += 33;
			
			if(sName.equals("Orangy"))
				iOrangy += 33;
			
			if(sName.equals("Pinky"))
				iPinky += 33;
		}
		
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach unten Bewegt.
	 */
	private int moveDown(int iPosY, String sName)
	{
		int iGeist = 0;
		
		if(sName.equals("Greeny"))
		{
			iGreeny += 33;
			iGeist = iGreeny;
		}
		
		if(sName.equals("Blue"))
		{
			iBlue += 33;
			iGeist = iBlue;
		}
		
		if(sName.equals("Orangy"))
		{
			iOrangy += 33;
			iGeist = iOrangy;
		}
		
		if(sName.equals("Pinky"))
		{
			iPinky += 33;
			iGeist = iOrangy;
		}
			
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT_INDEX)
		{
			System.out.println("s");
			
			iGeistVer = iPosY;
			if (iPosY < (GameMainFrame.GUI_ROWS - 2))
				iPosY++;
			
			iGeistVer = iPosY; 
		}
		else
		{
			if(sName.equals("Greeny"))
				iGreeny -= 33;
			
			if(sName.equals("Blue"))
				iBlue -= 33;
			
			if(sName.equals("Orangy"))
				iOrangy -= 33;
			
			if(sName.equals("Pinky"))
				iPinky -= 33;
		}
		
		return iGeistVer;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister links Bewegt.
	 */
	private int moveLeft(int iPosX, String sName)
	{
		int iGeist = 0;
		
		if(sName.equals("Greeny"))
		{
			iGreeny -= 1;
			iGeist = iGreeny;
		}
		
		if(sName.equals("Blue"))
		{
			iBlue -= 1;
			iGeist = iBlue;
		}
		
		if(sName.equals("Orangy"))
		{
			iOrangy -= 1;
			iGeist = iOrangy;
		}
		
		if(sName.equals("Pinky"))
		{
			iPinky -= 1;
			iGeist = iPinky;
		}
		
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT_INDEX)
		{
			System.out.println("a");
			iGeistHor = iPosX;
			if (iPosX >= 2)
				iPosX--;
			
			iGeistHor = iPosX;
		}
		else
		{
			if(sName.equals("Greeny"))
				iGreeny += 1;
			
			if(sName.equals("Blue"))
				iBlue += 1;
			
			if(sName.equals("Orangy"))
				iOrangy += 1;
			
			if(sName.equals("Pinky"))
				iPinky += 1;
		}
		return iGeistHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * In dieser Methode werden die Geister nach rechts Bewegt.
	 */
	private int moveRight(int iPosX, String sName)
	{
		int iGeist = 0;
		
		if(sName.equals("Greeny"))
		{
			iGreeny += 1;
			iGeist = iGreeny;
		}
		
		if(sName.equals("Blue"))
		{
			iBlue += 1;
			iGeist = iBlue;
		}
	
		if(sName.equals("Orangy"))
		{
			iOrangy += 1;
			iGeist = iOrangy;
		}
	
		if(sName.equals("Pinky"))
		{
			iPinky += 1;
			iGeist = iPinky;
		}
		
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == TELEPORTER_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iGeist)) == SPAWN_POINT_INDEX)
		{
			System.out.println("d");
			iGeistHor = iPosX;
			if (iPosX < (GameMainFrame.GUI_COLUMNS - 2))
				iPosX++;
			
			iGeistHor = iPosX;
		}
		else
		{
			if(sName.equals("Greeny"))
				iGreeny -= 1;
			
			if(sName.equals("Blue"))
				iBlue -= 1;
			
			if(sName.equals("Orangy"))
				iOrangy -= 1;
			
			if(sName.equals("Pinky"))
				iPinky -= 1;
		}
		return iGeistHor;
	}
}