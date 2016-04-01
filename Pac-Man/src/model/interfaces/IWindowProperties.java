package model.interfaces;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;

/**Dieses Interface schreibt die <b>wichtigsten Fenster-Eigenschaften</b>, wie zum Beispiel Gr��e, Position und Hintergrundfarbe, vor.
 * @author Manuel Glantschnig
 * @version 1.0 */
public interface IWindowProperties
{
	/**In <i>guiRows</i> wird die <b>Anzahl der Zeilen</b>, die f�r die GUI notwendig bzw. zul�ssig ist, gespeichert.*/
	int	  GUI_ROWS		   = 28;
	/**In <i>guiColumns</i> wird die <b>Anzahl der Spalten</b>, die f�r die GUI notwendig bzw. zul�ssig ist, gespeichert.*/
	int   GUI_COLUMNS	   = 33;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	int   FRAME_WIDTH	   = 1091;
	/**In <i>frameHeight</i> wird die <b>H�he des Fensters</b> gespeichert.*/
	int   FRAME_HEIGHT	   = 739;
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   SCREEN_WIDTH	   = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>H�he des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	int   SCREEN_HEIGHT    = Toolkit.getDefaultToolkit().getScreenSize().height;
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	Color BACKGROUND_COLOR = new Color(38, 0, 38);
	/**Die <i>windowPosition</i> schreibt die <b>Position des Fensters</b> am Bildschirm vor.*/
	Point WINDOW_POSITION  = new Point((SCREEN_WIDTH - FRAME_WIDTH) / 2, (SCREEN_HEIGHT - FRAME_HEIGHT) / 2);
}