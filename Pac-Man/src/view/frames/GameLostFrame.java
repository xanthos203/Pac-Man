package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.listeners.ButtonListener;
import control.listeners.WindowListener;
import model.interfaces.IWindowProperties;

/**In dieser Klasse namens <b>GameLodtFrame</b> wird des Fenster, das erscheint, wenn der <b>Benutzer verloren</b> hat, dargestellt.<br>
 * Dieses Fenster <b>erscheint</b>, wenn <b>Pac-Man von einen der Geister verspeist wurde</b>.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>JFrame</b> und <b>implementiert</b> das Interface <b>IWindowProperties</b>.
 * Diese <i>JFrame-Klasse</i> wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i><br>
 * Das Interface <i>IWindowProperties</i> wurde hingegen von <i>uns ersellt</i>.<br>
 * Dieses <i>Interface</i> schreibt die <i>Methoden für</i> die <i>Fenstereigenschafen vor</i>.<br>
 * <br>
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * */
@SuppressWarnings("serial")
public final class GameLostFrame extends JFrame implements IWindowProperties
{
	/**Auf der <b>contentPane</b> werden <b>alle Widgets bzw Komponenten</b>, die für das <b>GameWonFrame-Fenster benötigt werden, dargestellt</b>.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <b>gameoverPanel</b> wird das <b>gameoverLabel</b> angezeigt.*/
	private JPanel		gameoverPanel	= new JPanel();
	/**Auf dem <b>playagainPanel</b> werden alle <b>Komponenten bzw. Widgets</b> angezeigt, die <b>zum Wiederholen des Spiels</b> notwendig sind.*/
	private JPanel		playagainPanel	= new JPanel();
	/**Auf dem <b>buttonPanel</b> werden <b>Buttons</b> nebeneinander <b>dargestellt</b>.*/
	private JPanel		buttonPanel		= new JPanel();
	/**Das Icon <b>gameLostIcon</b> stellt die <b>Hauptfigur Pac-Man</b> dar.
	 * Auf dem Bild wird Pac-Man gerade <b>von Geistern verspeist </b>.*/
	private Icon		gameLostIcon	= new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameLostFrame.class.getResource("/view/images/Game_lost.PNG")));
	/**Mit dem <b>gameoverLabel</b> wird dem Benutzer mitgeteilt, dass er <b>Spiel verloren hat</b>.*/
	private JLabel		gameoverLabel	= new JLabel();
	/**Mit dem <b>playagainLabel</b> wird der Benutzer gefragt, ob er <b>nochmal spielen</b> möchte.*/
	private JLabel		playagainLabel	= new JLabel();
	/**Auf dem Label <b>lostImage_label</b> wird das Icon <b>gameLostIcon</b> dargestellt.*/
	private JLabel		lostImage_label	= new JLabel(gameLostIcon);
	/**Mit dem <b>ja-Button</b> bestätigt der Benutzer, dass er <b>nochmal spielen</b> möchte.*/
	private JButton		jaButton		= new JButton("     Ja     ");
	/**Mit dem <b>nein-Button</b> bestätigt der Benutzer, dass er das <b>Spiel beenden</b> möchte.*/
	private JButton		neinButton		= new JButton("   Nein   ");
	/**Auf der <b>contentPane</b> werden <b>alle Widgets bzw Komponenten</b>, die für das <b>GameWonFrame-Fenster benötigt werden, dargestellt</b>.*/

	/**Im Konstruktor namens <b>LogInFrame</b> werden alle <b>Eigenschaften des Fensters und der Widgets bzw. Komponenten</b> festgelegt.<br>
	 * Solche Eingenschaften wären zum Beispiel Hintergrundfarbe, Größe, Position am Bildschirm,...*/
	public GameLostFrame()
	{
		/*Dem Fenster wird ein neuer WindowClosingListener zugewiesen.
		 *Dieser Listener wird ausgeführt, wenn das Fenster geschlossen wird bzw. geschlossen werden soll.*/
		addWindowListener(new WindowListener(this));
		/*Dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameLostFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*Das Fenster bekommt den Titel "Verloren!".*/
		setTitle("Verloren\u0021");
		/*Das Fenster wird sichtbar gemacht.*/
		setVisible(true);
		/*Die Größe des Fensters ist nicht mehr veränderbar.
		 * Das heißt, dass auch der Vollbildmodus nicht möglich ist.*/
		setResizable(false);
		/*Die Größe des Fensters wird festgelegt.
		 * Diese ist 1090 breit und 739 hoch.*/
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		/*Die Position des Fensters (am Bildschirm) wird festgelegt.
		 * Das Fenster ist allerdings trotzdem am Bildschirm verschiebbar.*/
		setLocation(WINDOW_POSITION);
		/*Dem Fenster wird das Panel "contentPane" hinzugefügt.*/
		add(contentPane);
		/*Der contentPane wird ihre zukünftige Hintergrundfarbe mitgeteilt.*/
		contentPane.setBackground(BACKGROUND_COLOR);
		/*Der contentPane wird ein BorderLayout zugewiesen.
		 * Dieses dient zur erleichterten Position der einzelnen Komponenten am Bildschirm.*/
		contentPane.setLayout(new BorderLayout());
		
		/*Dem gameoverLabel wird ein Hinweistext hinzugefügt.
		 * Dieser lautet "GAME OVER!".*/
		gameoverLabel.setText("GAME OVER\u0021");
		/*Dem Text im gameoverLabel wird die Schriftart "Arial" mit der Größe 40 gegeben.*/
		gameoverLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 40));
		/*Dem Text im gameoverLabel wird die Farbe "cyan" gegeben.*/
		gameoverLabel.setForeground(Color.CYAN);
		
		/*Dem Panel wird ein GridBagLayout hinzugefügt.*/
		gameoverPanel.setLayout(new GridBagLayout());
		/*Ein GridBagConstraint-Objekt wird erstellt..*/
		GridBagConstraints center = new GridBagConstraints();
		/*Das GridBagConstraint-Objekt wird im Zentrum (= in der Mitte) des GridBagLayouts platziert.*/
		center.anchor = GridBagConstraints.CENTER;
		/*Das GridBagConstraint-Objekt ist in seiner Größe nicht mehr veränderbar.*/
		center.fill = GridBagConstraints.NONE;
		/*Dem Panel wird das Textfeld "gameoverLabel" hinzugefügt.
		 * Dieses befindet sich im Zentrum (= in der Mitte).*/
		gameoverPanel.add(gameoverLabel, center);
		/*Die zukünftige Hintergrundfarbe wird dem Panels mitgeteilt.*/
		gameoverPanel.setBackground(BACKGROUND_COLOR);
		
		/*Dem playagainLabel wird ein Fragetext zugewiesen.
		 * Dieser lautet "Nocheinmal?".*/
		playagainLabel.setText("Nocheinmal\u003F");
		/*Die horizontale Ausrichtung des Textes wird auf das Zentrum (= die Mitte) gesetzt.*/
		playagainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im playagainLabel wird der Schriftstil "Arial" mit der Größe 38 hinzugefügt.*/
		playagainLabel.setFont(new Font("arial", Font.PLAIN, 38));
		/*Dem Text im playagainLabel wird die Farbe "magenta" zugewiesen.*/
		playagainLabel.setForeground(Color.MAGENTA);

		/*Dem nein-Button wird der Schriftstil "Arial" mit der Größe 38 hinzugefügt.*/
		jaButton.setFont(new Font("Arial", Font.PLAIN, 38));
		/*Dem ja-Button wird ein Hinweistext zugewiesen.
		 * Dieser lautet "Nochmal spielen".*/
		jaButton.setToolTipText("Nochmal spielen");
		/*Dem ja-Button wird ein ActionListener zugewiesen.*/
		jaButton.addActionListener(new ButtonListener(this, ButtonListener.REPEAT_GAME));
		
		/*Dem nein-Button wird der Schriftstil "Arial" mit der Größe 38 hinzugefügt.*/
		neinButton.setFont(new Font("Arial", Font.PLAIN, 38));
		/*Dem nein-Button wird ein Hinweistext zugewiesen.
		 * Dieser lautet "Spiel beenden".*/
		neinButton.setToolTipText("Spiel beenden");
		/*Dem nein-Button wird ein ActionListener zugewiesen.*/
		neinButton.addActionListener(new ButtonListener(this, ButtonListener.EXIT_GAME));
		
		/*Dem buttonPanel wird ein FlowLayout hinzugefügt.*/
		buttonPanel.setLayout(new FlowLayout());
		/*Dem buttonPanel wird seine zukünftige Hintergrundfarbe mitgeteilt.*/
		buttonPanel.setBackground(BACKGROUND_COLOR);
		/*Dem buttonPanel wird der ja-Button zugewiesen.*/
		buttonPanel.add(jaButton);
		/*Dem buttonPanel wird der nein-Button zugewiesen.*/
		buttonPanel.add(neinButton);
		
		/*Dem playagainPanel wird ein BorderLayout hinzugefügt.*/
		playagainPanel.setLayout(new BorderLayout());
		/*Dem playagainPanel wird seine zukünftige Hintergrundfarbe mitgeteilt.*/
		playagainPanel.setBackground(BACKGROUND_COLOR);
		/*Dem playagainPanel wird das playagainLabel hinzugefügt.
		 * Dieses befindet sich im Norden des BorderLayouts.*/
		playagainPanel.add(playagainLabel, BorderLayout.NORTH);
		/*Dem playagainPanel wird das buttonPanel hinzugefügt.
		 * Dieses befindet sich im Süden des BorderLayouts.*/
		playagainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/*Der contentPane wird das lostImage_label hinzugefügt.
		 * Dieses befindet sich im Norden des BorderLayouts.*/
		contentPane.add(lostImage_label, BorderLayout.NORTH);
		/*Der contentPane wird das gameoverPanel hinzugefügt.
		 * Dieses befindet sich im Zentrum (= in der Mitte) des BorderLayouts.*/
		contentPane.add(gameoverPanel, BorderLayout.CENTER);
		/*Der contentPane wird das playagainPanel hinzugefügt.
		 * Dieses befindet sich im Süden des BorderLayouts.*/
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}
}