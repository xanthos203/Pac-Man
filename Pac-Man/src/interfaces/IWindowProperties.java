package interfaces;

import java.awt.Color;
import java.awt.Toolkit;

/**Dieses Interface schreibt die <b>wichtigsten Fenster-Eigenschaften</b>, wie Größe, Position und Hintergrundfarbe, vor.
 * @author Manuel Glantschnig
 * @version 1.0 */
public interface IWindowProperties
{
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	public static final Color backgroundColor = new Color(38, 0, 38);
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	public static final int   screenWidth	  = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>Höhe des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	public static final int   screenHeight    = Toolkit.getDefaultToolkit().getScreenSize().height;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	public static final int   frameWidth	  = 1091;
	/**In <i>frameHeight</i> wird die <b>Höhe des Fensters</b> gespeichert.*/
	public static final int   frameHeight	  = 739;
}