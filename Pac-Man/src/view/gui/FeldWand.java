package view.gui;

/**
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public class FeldWand
{
	private int iPosX = 0;
	private int iPosY = 0;
	private int iFarbe = 0;

	public FeldWand(int iPosX, int iPosY, int iFarbe)
	{
		this.iPosX = iPosX;
		this.iPosY = iPosY;
		this.iFarbe = iFarbe;
	}

	public int getFeldX()
	{
		return this.iPosX;
	}

	public int getFeldY()
	{
		return this.iPosY;
	}

	public int getFarbe()
	{
		return this.iFarbe;
	}
}