package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import control.ButtonListener;

/**In dieser Klasse wird des Fenster, das erscheint, wenn der Benutzer <b>verloren</b> hat, dargestellt.<br>
 * Dieses Fenster erscheint, wenn das <b>Spiel vorbei</b> ist und <i>Pac-Man alle seine Leben verloren</i> hat.<br>
 * Diese Klasse <b>erbt von der Klasse JDialog</b>.
 * @author Manuel Glantschnig
 * @version 1.1 */
public final class GameLostFrame extends JDialog
{
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	private Color 		backgroundColor	= new Color(38, 0, 38);
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die für das Fenster benötigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>gameoverPanel</i> wird das <b>gameoverLabel</b> angezeigt.*/
	private JPanel		gameoverPanel	= new JPanel();
	/**Auf dem <i>playagainPanel</i> werden alle <b>Komponenten</b> angezeigt, die <b>zum Wiederholen des Spiels</b> notwendig sind.*/
	private JPanel		playagainPanel	= new JPanel();
	/**Auf dem <i>buttonPanel</i> werden sämtliche <b>Buttons</b> nebeneinander <b>dargestellt</b>.*/
	private JPanel		buttonPanel		= new JPanel();
	/**Das Icon <i>gameLostIcon</i> stellt die <b>Hauptfigur Pac-Man</b>, der gerade <i>von Geistern verspeist wird</i>, dar.*/
	private Icon		gameLostIcon	= new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameLostFrame.class.getResource("/images/Game_lost.PNG")));
	/**Mit dem <i>gameoverLabel</i> wird dem Benutzer mitgeteilt, dass das <b>Spiel vorbei</b> ist.*/
	private JLabel		gameoverLabel	= new JLabel();
	/**Mit dem <i>playagainLabel</i> wird der Benutzer gefragt, ob er <b>nochmal spielen</b> will.*/
	private JLabel		playagainLabel	= new JLabel();
	/**Auf dem Label <i>lostImage_label</i> wird das Icon <b>gameLostIcon</b> dargestellt.*/
	private JLabel		lostImage_label	= new JLabel(gameLostIcon);
	/**Mit dem <i>ja</i>-Button bestätigt der Benutzer, dass er <b>nochmal spielen</b> möchte.*/
	private JButton		jaButton		= new JButton("     Ja     ");
	/**Mit dem <i>nein</i>-Button bestätigt der Benutzer, dass er das <b>Spiel beenden</b> möchte.*/
	private JButton		neinButton		= new JButton("   Nein   ");
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	private int 		screenWidth		= Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>Höhe des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	private int			screenHeight	= Toolkit.getDefaultToolkit().getScreenSize().height;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	private int			frameWidth		= 1100;
	/**In <i>frameHeight</i> wird die <b>Höhe des Fensters</b> gespeichert.*/
	private int			frameHeight		= 745;
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public GameLostFrame()
	{
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameLostFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		/*beim Schließen des Fensters wird das Programm beendet*/
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("Verloren");
		/*das Fenster wird sichtbar gemacht*/
		setVisible(true);
		/*das Fenster ist in seiner Größe nicht veränderbar*/
		setResizable(false);
		/*die Größe des Fensters wird festgelegt*/
		setSize(frameWidth, frameHeight);
		/*die Position des Fensters am Bildschirm wird festgelegt*/
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		/*dem Fenster wird die "contentPane" (ein Panel) hinzugefügt*/
		add(contentPane);
		/*der contentPane wird eine Hintergrundfarbe zugewiesen*/
		contentPane.setBackground(backgroundColor);
		/*der contentPane wird ein neues BorderLayout zugewiesen*/
		contentPane.setLayout(new BorderLayout());
		
		/*dem gameoverLabel wird der Hinweistext, dass das Spiel vorbei ist, zugewiesen*/
		gameoverLabel.setText("GAME OVER\u0021");
		/*dem Text im gameoverLabel wird ein Schriftstil zugewiesen*/
		gameoverLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 40));
		/*dem Text im gameoverLabel wird eine Schriftfarbe zugewiesen*/
		gameoverLabel.setForeground(Color.CYAN);
		
		/*dem Panel wird ein neues GridBagLayout hinzugefügt*/
		gameoverPanel.setLayout(new GridBagLayout());
		/*erstellt ein GridBagConstraint-Objekt, mit all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints center = new GridBagConstraints();
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		center.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Größe nicht verändert*/
		center.fill = GridBagConstraints.NONE;
		/*dem Panel wird das Textfeld im Zentrum hinzugefügt*/
		gameoverPanel.add(gameoverLabel, center);
		/*die Hintergrundfarbe des Panels wird festgelegt*/
		gameoverPanel.setBackground(backgroundColor);
		
		/*dem playagainLabel wird der Fragetext zugewiesen*/
		playagainLabel.setText("Nochmal\u003F");
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		playagainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im playagainLabel wird ein Schriftstil zugewiesen*/
		playagainLabel.setFont(new Font("arial", Font.PLAIN, 38));
		/*dem Text im playagainLabel wird eine Schriftfarbe zugewiesen*/
		playagainLabel.setForeground(Color.MAGENTA);
		
		/*dem ja-Button wird ein Schriftstil zugewiesen*/
		jaButton.setFont(new Font("arial", Font.PLAIN, 38));
		/*dem ja-Button wird ein Hinweistext zugewiesen*/
		jaButton.setToolTipText("Nochmal spielen");
		/*dem ja-Button wird ein ActionListener zugewiesen*/
		jaButton.addActionListener(new ButtonListener(this, jaButton));
		/*dem nein-Button wird ein Schriftstil zugewiesen*/
		neinButton.setFont(new Font("arial", Font.PLAIN, 38));
		/*dem nein-Button wird ein Hinweistext zugewiesen*/
		neinButton.setToolTipText("Spiel beenden");
		/*dem nein-Button wird ein ActionListener zugewiesen*/
		neinButton.addActionListener(new ButtonListener(this, jaButton));
		
		/*dem buttonPanel wird ein neues FlowLayout hinzugefügt*/
		buttonPanel.setLayout(new FlowLayout());
		/*dem buttonPanel wird eine Hintergrundfarbe zugewiesen*/
		buttonPanel.setBackground(backgroundColor);
		/*dem buttonPanel wird der ja-Button zugewiesen*/
		buttonPanel.add(jaButton);
		/*dem buttonPanel wird der nein-Button zugewiesen*/
		buttonPanel.add(neinButton);
		
		/*dem playagainPanel wird ein neues BorderLayout hinzugefügt*/
		playagainPanel.setLayout(new BorderLayout());
		/*dem playagainPanel wird eine Hintergrundfarbe zugewiesen*/
		playagainPanel.setBackground(backgroundColor);
		/*dem playagainPanel wird das playagainLabel im Norden des BorderLayouts hinzugefügt*/
		playagainPanel.add(playagainLabel, BorderLayout.NORTH);
		/*dem playagainPanel wird das buttonPanel im Süden des BorderLayouts hinzugefügt*/
		playagainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/*der contentPane wird das lostImage_label im Norden des BorderLayouts hinzugefügt*/
		contentPane.add(lostImage_label, BorderLayout.NORTH);
		/*der contentPane wird das gameoverPanel im Zentrum des BorderLayouts hinzugefügt*/
		contentPane.add(gameoverPanel, BorderLayout.CENTER);
		/*der contentPane wird das playagainPanel im Süden des BorderLayouts hinzugefügt*/
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}
}