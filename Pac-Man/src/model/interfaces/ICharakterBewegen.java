package model.interfaces;

/**
 * Dieses <i>Interface</i> namens <b>"ICharakterBewegen"</b> schreibt <b>Methoden bzgl. der Bewegungen</b> der Charaktere (Geister und Pac-Man) vor.<br>
 * <br>
 * Mittels dieser Methoden wird ermittelt, <i>wo sich der entsprechende Charakter dezeit befindet</i> (Getter-Methoden).<br>
 * Der jeweiligen Spielfigur wird anschlie�end mitgetteilt,<i>wo sich seine n�chste "erw�nschte" Position im Spielfeld befindet</i>.<br>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart 
 * 
 * */
public interface ICharakterBewegen
{
	/**
	 * Die folgende Methode schreibt die <b>Aufw�rtsbewegung</b> des jeweiligen Charakters vor.<br>
	 * @param iPosY <br>
	 * Die Variable <i>iPosY</i> speichert die <b>aktuelle Position</b> des entsprechenden Charakters auf der <i>Y-Achse</i>.<br>
	 * @return Nach Abschluss der Methode wird die <b>neu erw�nschte Position</b> einer Spielfigur auf der <i>Y-Achse</i> dem jeweiligen Spielcharakter mitgeteilt.<br>
	 */
	int raufBewegen(int iPosY, String sName);
	
	/**
	 * Diese Methode hingegen schreibt die <b>Abw�rtsbewegung</b> der entsprechenden Spielfigur vor.<br>
	 * @param iPosY <br>
	 * Hier wird ebenfalls die <b>aktuelle Position</b> des jeweiligen Charakters auf der <i>Y-Achse</i> gespeichert.
	 * @return Nach Abschluss dieser Methode wird die <b>neu erw�nschte Position</b> einer Spielfigur auf der <i>Y-Achse</i> dem jeweiligen Spielcharakter mitgeteilt.<br>
	 */
	int runterBewegen(int iPosY, String sName);
	
	/**
	 * Die n�chste Methode ist f�r die <b>Linksbewegung</b> des Charakters verantwortlich.<br>
	 * @param iPosX <br>
	 * Die Variable <i>iPosX</i> speichert die <b>aktuelle Position</b> des entsprechenden Charakters auf der <i>X-Achse</i>.<br>
	 * @return Nach Abschluss dieser Methode wird die <b>neu erw�nschte Position</b> einer Spielfigur auf der <i>X-Achse</i> dem jeweiligen Spielcharakter mitgeteilt.<br>
	 */
	int linksBewegen(int iPosX, String sName);
	
	/**
	 * Diese Methode hingegen schreibt die <b>Rechtsbewegung</b> der entsprechenden Spielfigur vor.<br>
	 * @param iPosX <br>
	 * Hier wird ebenfalls die <b>aktuelle Position</b> des jeweiligen Charakters auf der <i>X-Achse</i> gespeichert.
	 * @return Nach Abschluss dieser Methode wird die <b>neu erw�nschte Position</b> einer Spielfigur auf der <i>X-Achse</i> dem jeweiligen Spielcharakter mitgeteilt.<br>
	 */
	int rechtsBewegen(int iPosX, String sName);
}