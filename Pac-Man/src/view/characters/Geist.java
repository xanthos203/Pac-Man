package view.characters;

import java.util.ArrayList;

import control.file_processing.GuiDB;
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
	private GuiDB oGuiDB = new GuiDB(System.getProperty("user.dir") + "\\src\\view\\gui\\GUI.csv");
	private ArrayList<String> alSpielfeldArrayList  = oGuiDB.getArrayList();
	
//--------------------------------------------------------------------------------------------------------------------------
	@Override
	public int raufBewegen(int iPosY)
	{
//		if (sName == "Greeny")
		{
			if ((alSpielfeldArrayList).equals("0"))
			{
				System.out.println("ra");
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
//			 if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				System.out.println(GameMainFrame.getFeldindex());
				System.out.println("ru");
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
//			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				System.out.println("r");
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
//			if (GameMainFrame.getSpielfeldArrayList().get(GameMainFrame.getFeldindex()).equals("0"))
			{
				System.out.println("l");
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