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

/**In dieser Klasse namens <b>GameWonFrame</b> wird des Fenster, das erscheint, wenn der <b>Benutzer gewonnen</b> hat, dargestellt.<br>
 * Dieses Fenster <b>erscheint</b>, wenn <b>Pac-Man alle M�nzen und alle Geister verspeist</b> hat.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>JFrame</b> und <b>implementiert</b> das Interface <b>IWindowProperties</b>.
 * Diese <i>JFrame-Klasse</i> wird sozusagen von <i>"JAVA"</i> vorgeschrieben, um den Benutzer ein wenig <i>"unter die Arme zu greifen".</i><br>
 * Das Interface <i>IWindowProperties</i> wurde hingegen von <i>uns ersellt</i>.<br>
 * Dieses <i>Interface</i> schreibt die <i>Methoden f�r</i> die <i>Fenstereigenschafen vor</i>.<br>
 * <br>
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * */
@SuppressWarnings("serial")
public final class GameWonFrame extends JFrame implements IWindowProperties
{
	/**Auf der <b>contentPane</b> werden <b>alle Widgets bzw Komponenten</b>, die f�r das <b>GameWonFrame-Fenster ben�tigt werden, dargestellt</b>.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <b>gratulationPanel</b> wird das <b>gratTextPanel</b> mit seinen Widgets bzw. Komponenten <b>angezeigt</b>.*/
	private JPanel		gratulationPanel= new JPanel();
	/**Auf dem <b>gratTextPanel</b> werden die beiden Labels <b>gratulationLabel</b> und <b>gratTextLabel</b> <i>zu einem Text zusammengef�gt</i>.*/
	private JPanel		gratTextPanel	= new JPanel();
	/**Auf dem <b>playagainPanel</b> werden alle <b>Komponenten angezeigt</b>, die <b>zum Wiederholen des Spiels</b> notwendig sind.*/
	private JPanel		playagainPanel	= new JPanel();
	/**Auf dem <b>buttonPanel</b> werden s�mtliche <b>Buttons</b> <i>nebeneinander</i> <b>dargestellt</b>.*/
	private JPanel		buttonPanel		= new JPanel();
	/**Das Icon <b>gameWonIcon</b> stellt die <b>Hauptfigur Pac-Man</b> dar.<br>
	 * Auf diesem Bild genie�t er gerade seine athletischen K�nste, indem er ein spezielles Festmahl in allen Z�gen genie�t.<br>
	 * Diese vorz�gliche Mahlzeit besteht aus seinen ehemaligen Mitgenossen - den Geistern.<br>
	 * Er verspei�t also sozusagen die Geister.<br>*/
	private Icon		gameWonIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameWonFrame.class.getResource("/view/images/Game_won.PNG")));
	/**Im <b>gratulationLabel</b> wird dem Benutzer <b>mit seinem Spielernamen f�r seine K�nste gratuliert</b>.*/
	private JLabel		gratulationLabel= new JLabel();
	/**Mit dem <b>gratTextLabel</b> wird der Benutzer darauf aufmerksam gemacht, dass er <b>gewonnen</b> hat.*/
	private JLabel		gratTextLabel	= new JLabel();
	/**Mit dem <b>playagainLabel</b> wird der Benutzer gefragt, ob er <b>nocheinmal spielen</b> will.*/
	private JLabel		playagainLabel	= new JLabel();
	/**Auf dem Label <b>wonImage_label</b> wird das Icon <b>gameWonIcon</b> dargestellt.*/
	private JLabel		wonImage_label	= new JLabel(gameWonIcon);
	/**Sobald der Benutzer den <b>ja-Button</b> bet�tigt, sagt er, dass er gerne <b>nocheinmal spielen m�chte</b>.*/
	private JButton		jaButton		= new JButton("     Ja     ");
	/**Mit dem <b>nein-Button</b> hingegen sagt der Spieler, dass er <i>nicht mehr spielen m�chte</i>.<br>
	 * Nach Bet�tigung des Buttons wird das <b>Programm geschossen</b>.<br>
	 * Somit wird auch das <b>Spiel beendet</b>.<br>*/
	private JButton		neinButton		= new JButton("   Nein   ");

	/**Im Konstruktor namens <b>LogInFrame</b> werden alle <b>Eigenschaften des Fensters und der Widgets bzw. Komponenten</b> festgelegt.<br>
	 * Solche Eingenschaften w�ren zum Beispiel Hintergrundfarbe, Gr��e, Position am Bildschirm,...*/
	public GameWonFrame()
	{
		/*Dem Fenster wird ein neuer WindowClosingListener zugewiesen.
		 *Dieser Listener wird ausgef�hrt, wenn das Fenster geschlossen wird bzw. geschlossen werden soll.*/
		addWindowListener(new WindowListener(this));
		/*Dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWonFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*Das Fenster bekommt den Titel "Gewonnen!".*/
		setTitle("Gewonnen\u0021");
		/*Das Fenster wird sichtbar gemacht.*/
		setVisible(true);
		/*Die Gr��e des Fensters ist nicht mehr ver�nderbar.
		 * Das hei�t, dass auch der Vollbildmodus nicht m�glich ist.*/
		setResizable(false);
		/*Die Gr��e des Fensters wird festgelegt.
		 * Diese ist 1090 breit und 739 hoch.*/
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		/*Die Position des Fensters (am Bildschirm) wird festgelegt.
		 * Das Fenster ist allerdings trotzdem am Bildschirm verschiebbar.*/
		setLocation(WINDOW_POSITION);
		/*Dem Fenster wird das Panel "contentPane" hinzugef�gt.*/
		getContentPane().add(contentPane);
		/*Der contentPane wird ihre zuk�nftige Hintergrundfarbe mitgeteilt.*/
		contentPane.setBackground(BACKGROUND_COLOR);
		/*Der contentPane wird ein BorderLayout zugewiesen.
		 * Dieses dient zur erleichterten Position der einzelnen Komponenten am Bildschirm.*/
		contentPane.setLayout(new BorderLayout());
		
		/*Dem gratulationLabel wird der Text "GRATULATION jeweiliger Spielername !" hinzugef�gt.
		 * Wenn der Spielername also zum Beispiel "Das Dynamische Trio" ist, so lautet dieser Text "GRATULATION Das Dynamische Trio!".*/
		gratulationLabel.setText("GRATULATION " + LogInFrame.getUsername() + "\u0021");
		/*Die horizontale Ausrichtung des "gratulationLabels" wird auf das Zentrum (=Mitte des Fensters) gesetzt.*/
		gratulationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im gratulationLabel wird die Schriftart "Arial" mit der Gr��e 40 zugewiesen:*/
		gratulationLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		/*Dem Text im gratulationLabel wird die Farbe "wei�" gegeben.*/
		gratulationLabel.setForeground(Color.CYAN);
		
		/*Dem gratTextLabel wird ein Hinweistext zugewiesen.
		 * Dieser Hinwei�text lautet "SIE HABEN GEWONNEN!!!"*/
		gratTextLabel.setText("SIE HABEN GEWONNEN\u0021 \u003A\u0029");
		/*Die horizontale Ausrichtung des "gratulationLabels" wird auf das Zentrum (=Mitte des Fensters) gesetzt.*/
		gratTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im gratTextLabel wird die Schriftart "Arial" mit der Schriftgr��e 40 zugewiesen.*/
		gratTextLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		/*Dem Text im gratTextLabel wird die Farbe "cyan" gegeben.*/
		gratTextLabel.setForeground(Color.CYAN);
		
		/*Dem gratTextPanel wird ein BorderLayout hinzugef�gt.*/
		gratTextPanel.setLayout(new BorderLayout());
		/*Dem gratTextPanel wird seine zuk�nftige Hintergrundfarbe zugewiesen.*/
		gratTextPanel.setBackground(BACKGROUND_COLOR);
		/*Dem gratTextPanel wird das gratulationLabel hinzugef�gt.
		 * Dieses befindet sich im Norden des BorderLayouts. */
		gratTextPanel.add(gratulationLabel, BorderLayout.NORTH);
		/*Dem gratTextPanel wird das gratTextLabel hinzugef�gt.
		 * Dieses befindet sich im S�den des BorderLayouts.*/
		gratTextPanel.add(gratTextLabel, BorderLayout.SOUTH);
		
		/*Dem Panel wird ein GridBagLayout hinzugef�gt.*/
		gratulationPanel.setLayout(new GridBagLayout());
		/*Es wird ein GridBagConstraint-Objekt erstellt.*/
		GridBagConstraints center = new GridBagConstraints();
		/*Das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert.*/
		center.anchor = GridBagConstraints.CENTER;
		/*Das GridBagConstraint-Objekt ist in seiner Gr��e nun nicht ver�nderbar.*/
		center.fill = GridBagConstraints.NONE;
		/*Dem gratulationPanel wird das Textfeld "gratTextPanel" im Zentrum hinzugef�gt.*/
		gratulationPanel.add(gratTextPanel);
		/*Die zuk�nftige Hintergrundfarbe wird dem Panels mitgeteilt.*/
		gratulationPanel.setBackground(BACKGROUND_COLOR);
		
		/*Dem playagainLabel wird der Fragetext zugewiesen.
		 * Deiser lautet "Nocheinmal?".*/
		playagainLabel.setText("Nocheinmal\u003F");
		/*Die horizontale Ausrichtung des Textes wird auf das Zentrum (= Mitte) gesetzt.*/
		playagainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im playagainLabel wird die Schriftart "Arial" mit dr Gr��e 38 gegeben.*/
		playagainLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		/*Dem Text im playagainLabel wird die Schriftfarbe "magenta" gegeben.*/
		playagainLabel.setForeground(Color.MAGENTA);
		
		/*Dem ja-Button wird die Schriftart "Arial" mit dr Gr��e 38 gegeben.*/
		jaButton.setFont(new Font("Arial", Font.PLAIN, 38));
		/*Dem ja-Button wird ein Hinweistext zugewiesen.
		 * Dieser lautet "Nocheinmal spielen?".*/
		jaButton.setToolTipText("Nocheinhmal spielen");
		/*Dem ja-Button wird ein ActionListener zugewiesen.*/
		jaButton.addActionListener(new ButtonListener(this, ButtonListener.REPEAT_GAME));
		
		/*Dem nein-Button wird die Schriftart "Arial" mit dr Gr��e 38 gegeben.*/
		neinButton.setFont(new Font("Arial", Font.PLAIN, 38));
		/*Dem ja-Button wird ein Hinweistext zugewiesen.
		 * Dieser lautet "Nocheinmal spielen?".*/
		neinButton.setToolTipText("Spiel beenden");
		/*dem nein-Button wird ein ActionListener zugewiesen.*/
		neinButton.addActionListener(new ButtonListener(this, ButtonListener.EXIT_GAME));
		
		/*Dem buttonPanel wird ein FlowLayout hinzugef�gt.*/
		buttonPanel.setLayout(new FlowLayout());
		/*Dem buttonPanel wird seine zuk�nftige Hintergrundfarbe mitgeteilt.*/
		buttonPanel.setBackground(BACKGROUND_COLOR);
		/*Dem buttonPanel wird der ja-Button hizugef�gt.*/
		buttonPanel.add(jaButton);
		/*Dem buttonPanel wird der nein-Button zugewiesen.S*/
		buttonPanel.add(neinButton);
		
		/*Dem playagainPanel wird ein BorderLayout hinzugef�gt.*/
		playagainPanel.setLayout(new BorderLayout());
		/*Dem playagainPanel wird seine zuk�nftige Hintergrundfarbe mitgeteilt.*/
		playagainPanel.setBackground(BACKGROUND_COLOR);
		/*Dem playagainPanel wird das playagainLabel hinzugef�gt.
		 * Dieses befindet sich im Norden des BorderLayouts.*/
		playagainPanel.add(playagainLabel, BorderLayout.NORTH);
		/*Dem playagainPanel wird das buttonPanel hinzugef�gt.
		 * Dieses befindet sich im S�den des BorderLayouts.*/
		playagainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/*Der contentPane wird das wonImage_label hinzugef�gt.
		 * Dieses befindet sich im Norden des BorderLayouts.*/
		contentPane.add(wonImage_label, BorderLayout.NORTH);
		/*Der contentPane wird das gratulationPanel hinzugef�gt.
		 * Dieses befindet sich im Zentrum (=in der Mitte) des BorderLayouts.*/
		contentPane.add(gratulationPanel, BorderLayout.CENTER);
		/*Der contentPane wird das playagainPanel hinzugef�gt.
		 * Dieses befindet sich im S�den des BorderLayouts.*/
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}
}