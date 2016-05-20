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
	/**Die Variable <b>iPosX</b> speichert die aktuelle <b>Postition der Geister auf der X-Achse</b>.*/
	private int iPosX = 0;
	/**Die Variable <b>iPosY</b> speichert die aktuelle <b>Postition der Geister auf der Y-Achse</b>.*/
	private int iPosY = 0;

	/**
	 * Die untenstehende Methode namens <b>setPosX ermittelt</b> die <b>Position des entsprechenden Geistes</b><br>
	 * auf der <b>X-Achse</b> und <b>speichert</b> diesen Wert in der Variable <b>"iPosX"</b>.
	 * 
	 * @param iPosX<br>
	 * Diese Variable speichert die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>X-Achse</b>.
	 */
	public void setPosX(int iPosX)
	{
		/*Die Position des entsprechenden Geistes auf der X-Achse wird in iPosX gespeichert.*/
		this.iPosX = iPosX;
	}

	/**
	 * Die untenstehende Methode namens <b>setPosY ermittelt</b> die <b>Position des entsprechenden Geistes</b><br>
	 * auf der <b>Y-Achse</b> und <b>speichert</b> diesen Wert in der Variable <b>"iPosY"</b>.
	 * 
	 * @param iPosY<br>
	 * Diese Variable speichert die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>Y-Achse</b>.
	 */
	public void setPosY(int iPosY)
	{
		/*Die Position des entsprechenden Geistes auf der Y-Achse wird in iPosX gespeichert.*/
		this.iPosY = iPosY;
	}

	/**
	 * Die untenstehende Methode namens <b>getPosX</b> gibt die Variable <b>iPosX</b> zurück.
	 * 
	 * @return iPosX<br>
	 * Diese Variable <b>gibt</b> die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>X-Achse zurück</b>.
	 */
	public int getPosX()
	{
		/*Die Position des Geistes auf der X-Achse wird zurückgegeben.*/
		return iPosX;
	}

	/**
	 * Die untenstehende Methode namens <b>getPosY</b> gibt die Variable <b>iPosY</b> zurück.
	 * 
	 * @return iPosX<br>
	 * Diese Variable <b>gibt</b> die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>Y-Achse zurück</b>.
	 */
	public int getPosY()
	{
		/*Die Position des Geistes auf der Y-Achse wird zurückgegeben.*/
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