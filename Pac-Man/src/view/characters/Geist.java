package view.characters;

import model.interfaces.ICharakterBewegen;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class Geist implements ICharakterBewegen
{
	private int iPosX = 0;
	private int iPosY = 0;

	public void setPosX(int iPosX)
	{
		this.iPosX = iPosX;
	}

	public void setPosY(int iPosY)
	{
		this.iPosY = iPosY;
	}

	public int getPosX()
	{
		return iPosX;
	}

	public int getPosY()
	{
		return iPosY;
	}

	@Override
	public int raufBewegen(int iPosX, int iPosY)
	{
		iPosY -= 1;
		setPosY(iPosY);
		return iPosY;
	}

	@Override
	public int runterBewegen(int iPosX, int iPosY)
	{
		iPosY += 1;
		setPosY(iPosY);
		return iPosY;
	}

	@Override
	public int linksBewegen(int iPosX, int iPosY)
	{
		iPosX -= 1;
		setPosX(iPosX);
		return iPosY;
	}

	@Override
	public int rechtsBewegen(int iPosX, int iPosY)
	{
		iPosX += 1;
		setPosX(iPosX);
		return iPosY;
	}
}