package view.gui;

/**
 * Diese Klasse namens <b>FeldWand vergleicht</b> die aktuelle <b>Position des Hauptcharakters</b><br>
 * <b>mit dem Feld auf dem Pac-Man als nächstes fahren möchte</b>.<br>
 * Wenn es sich bei dem folgenden Feld um eine <b>Wand</b> handelt, kann Pac-Man <b>nicht darauf fahren</b>.<br>
 * Wenn es sich jedoch bei dem folgenden Feld um einen <b>Gang</b> handelt, kann sich PAc-Man <b>darauf fortbewegen</b>.<br>
 * Bei der <i>"csv-Datei"</i> kennzeichnet ein <i>1er</i> die <i>Wände</i> und <i>0er</i> kennzeichnen <i>Gänge</i>.<br>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class FeldWand
{
	/**Die Variable <b>iPosX</b> speichert die aktuelle <b>Postition der Geister auf der X-Achse</b>*/
	private int iPosX = 0;
	/**Die Variable <b>iPosY</b> speichert die aktuelle <b>Postition der Geister auf der Y-Achse</b>.*/
	private int iPosY = 0;
	/**Die Variable <b>iFarbe</b> speichert die <b>jeweilige Farbe der Geister</b>.*/
	private int iFarbe = 0;

	/**Der untenstehende Konstruktor speichert die Position der Geister auf der X-Achse,<br>
	 * die Position der Geister auf der Y-Achse und die Farbe des jeweiligen Geistes.<br>*/
	public FeldWand(int iPosX, int iPosY, int iFarbe)
	{
		/*Die Position des entsprechenden Geistes auf der X-Achse wird in iPosX gespeichert.*/
		this.iPosX = iPosX;
		/*Die Position des entsprechenden Geistes auf der Y-Achse wird in iPosY gespeichert.*/
		this.iPosY = iPosY;
		/*Die jeweilige Farbe des entsprechenden Geistes wird gespeichert.*/
		this.iFarbe = iFarbe;
	}

	/**
	 * Die Variable "iPosX" wird zurückgegeben.
	 * 
	 * @return iPosX<br>
	 * Diese Variable <b>gibt</b> die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>X-Achse zurück</b>.
	 */
	public int getFeldX()
	{
		return this.iPosX;
	}

	/**
	 * Die Variable "iPosY" wird zurückgegeben.
	 * 
	 * @return iPosY<br>
	 * Diese Variable <b>gibt</b> die <b>aktuelle Position</b> des entsprechenden Geistes auf der <b>Y-Achse zurück</b>.
	 */
	public int getFeldY()
	{
		return this.iPosY;
	}

	/**
	 * Die Variable "iFarbe" wird zurückgegeben.
	 * 
	 * @return iFarbe<br>
	 * Diese Variable <b>gibt</b> die <b>Farbe</b> des entsprechenden Geistes <b>zurück</b>.
	 */
	public int getFarbe()
	{
		return this.iFarbe;
	}
}