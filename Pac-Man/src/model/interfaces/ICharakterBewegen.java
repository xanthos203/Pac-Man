package model.interfaces;

/**Dieses Interface schreibt die <b>Methoden für die Bewegung</b> der Charaktere vor.<br>
 * Außerdem schreibt es noch <b>Getter-Methoden für die Position</b> der Figuren vor.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0 */
public interface ICharakterBewegen
{
	/**Methode für die <b>Aufwärtsbewegung</b> des Charakters.
	 * @param iPosY <b>aktuelle Position</b> des Charakters auf der <i>Y-Achse</i>
	 * @return <b>neue Position</b> des Charakters auf der <i>Y-Achse</i> nach Abschluss der Methode */
	int raufBewegen(int iPosY);
	
	/**Methode für die <b>Abwärtsbewegung</b> des Charakters.
	 * @param iPosY <b>aktuelle Position</b> des Charakters auf der <i>Y-Achse</i>
	 * @return <b>neue Position</b> des Charakters auf der <i>Y-Achse</i> nach Abschluss der Methode */
	int runterBewegen(int iPosY);
	
	/**Methode für die <b>Linksbewegung</b> des Charakters.
	 * @param iPosX <b>aktuelle Position</b> des Charakters auf der <i>X-Achse</i>
	 * @return <b>neue Position</b> des Charakters auf der <i>X-Achse</i> nach Abschluss der Methode */
	int linksBewegen(int iPosX);
	
	/**Methode für die <b>Rechtsbewegung</b> des Charakters.
	 * @param iPosX <b>aktuelle Position</b> des Charakters auf der <i>X-Achse</i>
	 * @return <b>neue Position</b> des Charakters auf der <i>X-Achse</i> nach Abschluss der Methode */
	int rechtsBewegen(int iPosX);
	
	/**<i>Getter-Methode</i> für die <b>aktuelle Position</b> des Charakters.
	 * @return <b>aktuelle Position</b> des Charakters auf der <i>X-Achse</i> */
	int getX();
	
	/**<i>Getter-Methode</i> für die <b>aktuelle Position</b> des Charakters.
	 * @return <b>aktuelle Position</b> des Charakters auf der <i>Y-Achse</i> */
	int getY();
}