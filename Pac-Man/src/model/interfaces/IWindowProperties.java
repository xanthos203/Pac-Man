package model.interfaces;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;

/**Dieses Interface schreibt die <b>wichtigsten Fenster-Eigenschaften</b>, wie zum Beispiel Größe, Position und Hintergrundfarbe, vor.
 * @author Manuel Glantschnig
 * @version 1.0 */
public interface IWindowProperties
{
	/**In <i>guiRows</i> wird die <b>Anzahl der Zeilen</b>, die für die GUI notwendig bzw. zulässig ist, gespeichert.*/
	int	  guiRows		  = 28;
	/**In <i>guiColumns</i> wird die <b>Anzahl der Spalten</b>, die für die GUI notwendig bzw. zulässig ist, gespeichert.*/
	int   guiColumns	  = 33;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	int   frameWidth	  = 1091;
	/**In <i>frameHeight</i> wird die <b>Höhe des Fensters</b> gespeichert.*/
	int   frameHeight	  = 739;
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   screenWidth	  = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>Höhe des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   screenHeight    = Toolkit.getDefaultToolkit().getScreenSize().height;
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	Color backgroundColor = new Color(38, 0, 38);
	/**Die <i>windowPosition</i> schreibt die <b>Position des Fensters</b> am Bildschirm vor.*/
	Point windowPosition  = new Point((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
}