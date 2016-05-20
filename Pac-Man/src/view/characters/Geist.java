package view.characters;

import model.interfaces.ICharakterBewegen;

/**
 * In dieser Klasse namens <b>Geist</b> werden die <i>derzeitigen</i> <b>Positionen</b> <i>der vier verschiedenen Geister</i>,<br>
 * <b>ermittelt</b> sowie <b>gespeichert</b>.<br>
 * Nebenbei wird auch für die <b>zufällige Bewegung</b> <i>der Geister</i> <b>gesorgt</b>.<br>.
 * <br>
 * Die <i>Spieler-Klasse</i> implementiert das Inderface <b>ICharakterBewegen</b>.<br>
 * Das Interface <i>ICharakterBewegen</i> schreibt die Methoden für die Positionierung und Bewegung der Charaktere vor</b>.<br>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class Geist implements ICharakterBewegen
{
	private int iPosX = 0;
	private int iPosY = 0;

	/**
	 * 
	 * @param iPosX
	 */
	public void setPosX(int iPosX)
	{
		this.iPosX = iPosX;
	}

	/**
	 * 
	 * @param iPosY
	 */
	public void setPosY(int iPosY)
	{
		this.iPosY = iPosY;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosX()
	{
		return iPosX;
	}

	/**
	 * 
	 * @return
	 */
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