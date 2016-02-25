package interfaces;

import java.awt.Toolkit;

/**Dieses Interface schreibt die <b>wichtigsten Fenster-Eigenschaften</b>, wie Größe und Position, vor.
 * @author Manuel Glantschnig
 * @version 1.0 */
public interface IWindowProperties
{
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	public static final int screenWidth	 = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>Höhe des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	public static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	public static final int frameWidth	 = 1100;
	/**In <i>frameHeight</i> wird die <b>Höhe des Fensters</b> gespeichert.*/
	public static final int frameHeight	 = 745;
}