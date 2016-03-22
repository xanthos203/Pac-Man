package model.interfaces;

import java.awt.Color;
import java.awt.Toolkit;

/**Dieses Interface schreibt die <b>wichtigsten Fenster-Eigenschaften</b>, wie zum Beispiel Gr��e, Position und Hintergrundfarbe, vor.
 * @author Manuel Glantschnig
 * @version 1.0 */
public interface IWindowProperties
{
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	Color backgroundColor = new Color(38, 0, 38);
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   screenWidth	  = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>H�he des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   screenHeight    = Toolkit.getDefaultToolkit().getScreenSize().height;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	int   frameWidth	  = 1091;
	/**In <i>frameHeight</i> wird die <b>H�he des Fensters</b> gespeichert.*/
	int   frameHeight	  = 739;
	/**In <i>guiRows</i> wird die <b>Anzahl der Zeilen</b>, die f�r die GUI notwendig bzw. zul�ssig ist, gespeichert.*/
	int	  guiRows		  = 28;
	/**In <i>guiColumns</i> wird die <b>Anzahl der Spalten</b>, die f�r die GUI notwendig bzw. zul�ssig ist, gespeichert.*/
	int   guiColumns	  = 33;
}