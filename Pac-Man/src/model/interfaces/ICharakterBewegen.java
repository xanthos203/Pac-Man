package model.interfaces;

/**Dieses Interface schreibt die <b>Methoden f�r die Bewegung</b> der Charaktere vor.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public interface ICharakterBewegen
{
	/**Methode f�r die <b>Aufw�rtsbewegung</b> des Charakters.
	 * @param iPosY <b>aktuelle Position</b> des Charakters auf der <i>Y-Achse</i>
	 * @param sName <b>Name</b> des Charakters
	 * @return <b>neue Position</b> des Charakters auf der <i>Y-Achse</i> nach Abschluss der Methode */
	int raufBewegen(int iPosY, String sName);
	/**Methode f�r die <b>Abw�rtsbewegung</b> des Charakters.
	 * @param iPosY <b>aktuelle Position</b> des Charakters auf der <i>Y-Achse</i>
	 * @param sName <b>Name</b> des Charakters
	 * @return <b>neue Position</b> des Charakters auf der <i>Y-Achse</i> nach Abschluss der Methode */
	int runterBewegen(int iPosY, String sName);
	/**Methode f�r die <b>Linksbewegung</b> des Charakters.
	 * @param iPosX <b>aktuelle Position</b> des Charakters auf der <i>X-Achse</i>
	 * @param sName <b>Name</b> des Charakters
	 * @return <b>neue Position</b> des Charakters auf der <i>X-Achse</i> nach Abschluss der Methode */
	int linksBewegen(int iPosX, String sName);
	/**Methode f�r die <b>Rechtsbewegung</b> des Charakters.
	 * @param iPosX <b>aktuelle Position</b> des Charakters auf der <i>X-Achse</i>
	 * @param sName <b>Name</b> des Charakters
	 * @return <b>neue Position</b> des Charakters auf der <i>X-Achse</i> nach Abschluss der Methode */
	int rechtsBewegen(int iPosX, String sName);
}