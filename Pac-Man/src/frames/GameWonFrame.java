package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**In dieser Klasse wird des Fenster, das erscheint, wenn der Benutzer <b>gewonnen</b> hat, dargestellt.<br>
 * Dieses Fenster erscheint, wenn das <b>Spiel vorbei</b> ist und <i>Pac-Man alle Münzen und alle Geister verspeist</i> hat.<br>
 * Diese Klasse erbt von der Klasse <b>JFrame</b> und implementiert den <b>ActionListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class GameWonFrame extends JFrame implements ActionListener
{
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	private Color 		backgroundColor	= new Color(38, 0, 38);
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die für das Fenster benötigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>gratulationPanel</i> wird das <b>gratTextPanel</b> mit all seinen Widgets angezeigt.*/
	private JPanel		gratulationPanel= new JPanel();
	/**Auf dem <i>gratTextPanel</i> werden die beiden Labels <i>gratulationLabel</i> und <i>gratTextLabel</i> zu einem <b>Text zusammengefügt</b>.*/
	private JPanel		gratTextPanel	= new JPanel();
	/**Auf dem <i>playagainPanel</i> werden alle <b>Komponenten</b> angezeigt, die <b>zum Wiederholen des Spiels</b> notwendig sind.*/
	private JPanel		playagainPanel	= new JPanel();
	/**Auf dem <i>buttonPanel</i> werden sämtliche <b>Buttons</b> nebeneinander <b>dargestellt</b>.*/
	private JPanel		buttonPanel		= new JPanel();
	/**Das Icon <i>gameWonIcon</i> stellt die <b>Hauptfigur Pac-Man</b>, der gerade die <i>Geister verspeist</i>, dar.*/
	private Icon		gameWonIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Game_won.PNG")));
	/**Mit dem <i>gratulationLabel</i> wird dem Benutzer <b>mit</b> seinem <b>Spielernamen gratuliert</b>.*/
	private JLabel		gratulationLabel= new JLabel();
	/**Mit dem <i>gratTextLabel</i> wird der Benutzer darauf hingewiesen, dass er <b>gewonnen</b> hat.*/
	private JLabel		gratTextLabel	= new JLabel();
	/**Mit dem <i>playagainLabel</i> wird der Benutzer gefragt, ob er <b>nochmal spielen</b> will.*/
	private JLabel		playagainLabel	= new JLabel();
	/**Auf dem Label <i>wonImage_label</i> wird das Icon <b>gameWonIcon</b> dargestellt.*/
	private JLabel		wonImage_label	= new JLabel(gameWonIcon);
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
	private int			frameHeight		= 735;
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public GameWonFrame()
	{
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		/*beim Schließen des Fensters wird das Programm beendet*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("Gewonnen");
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
		
		/*dem gratulationLabel wird der Text mit dem Spielernamen des Benutzers zugewiesen*/
		gratulationLabel.setText("GRATULATION \"" + LogInFrame.getUsername() + "\"\u0021");
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		gratulationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im gratulationLabel wird ein Schriftstil zugewiesen*/
		gratulationLabel.setFont(new Font("arial", Font.PLAIN, 40));
		/*dem Text im gratulationLabel wird eine Schriftfarbe zugewiesen*/
		gratulationLabel.setForeground(Color.CYAN);
		
		/*dem gratTextLabel wird der Hinweistext zugewiesen*/
		gratTextLabel.setText("SIE HABEN GEWONNEN\u0021 \u003A\u0029");
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		gratTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im gratTextLabel wird ein Schriftstil zugewiesen*/
		gratTextLabel.setFont(new Font("arial", Font.PLAIN, 40));
		/*dem Text im gratTextLabel wird eine Schriftfarbe zugewiesen*/
		gratTextLabel.setForeground(Color.CYAN);
		
		/*dem gratTextPanel wird ein neues BorderLayout hinzugefügt*/
		gratTextPanel.setLayout(new BorderLayout());
		/*dem gratTextPanel wird eine Hintergrundfarbe zugewiesen*/
		gratTextPanel.setBackground(backgroundColor);
		/*dem gratTextPanel wird das gratulationLabel im Norden des BorderLayouts hinzugefügt*/
		gratTextPanel.add(gratulationLabel, BorderLayout.NORTH);
		/*dem gratTextPanel wird das gratTextLabel im Süden des BorderLayouts hinzugefügt*/
		gratTextPanel.add(gratTextLabel, BorderLayout.SOUTH);
		
		/*dem Panel wird ein neues GridBagLayout hinzugefügt*/
		gratulationPanel.setLayout(new GridBagLayout());
		/*erstellt ein GridBagConstraint-Objekt mit, all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints center = new GridBagConstraints();
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		center.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Größe nicht verändert*/
		center.fill = GridBagConstraints.NONE;
		/*dem Panel wird das Textfeld im Zentrum hinzugefügt*/
		gratulationPanel.add(gratTextPanel);
		/*die Hintergrundfarbe des Panels wird festgelegt*/
		gratulationPanel.setBackground(backgroundColor);
		
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
		/*dem ja-Button wird DIESE Klasse als ActionListener zugewiesen*/
		jaButton.addActionListener(this);
		/*dem nein-Button wird ein Schriftstil zugewiesen*/
		neinButton.setFont(new Font("arial", Font.PLAIN, 38));
		/*dem nein-Button wird DIESE Klasse als ActionListener zugewiesen*/
		neinButton.addActionListener(this);
		
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
		
		/*der contentPane wird das wonImage_label im Norden des BorderLayouts hinzugefügt*/
		contentPane.add(wonImage_label, BorderLayout.NORTH);
		/*der contentPane wird das gratulationPanel im Zentrum des BorderLayouts hinzugefügt*/
		contentPane.add(gratulationPanel, BorderLayout.CENTER);
		/*der contentPane wird das playagainPanel im Süden des BorderLayouts hinzugefügt*/
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}

	/**Die <i>actionPerformed</i>-Methode fängt <b>Knopfdrücke</b> auf und verarbeitet diese.
	 * @param e Knopfdruck*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		/*wird ausgeführt, wenn der Knopf zum Wiederholen des Spiels gedrückt wurde*/
		if(e.getSource() == jaButton)
		{
			/*das aktuelle Fenster wird geschlossen*/
			this.dispose();
			
			/*========Hauptfenster öffnen========*/
			CSpielFrame oSpielFrame = new CSpielFrame(true);
		}
		/*andernsfalls wird das Programm verlassen*/
		else System.exit(0);
	}
}