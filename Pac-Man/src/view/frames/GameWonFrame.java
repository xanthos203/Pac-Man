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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.listeners.ButtonListener;
import control.listeners.WindowClosingListener;
import model.interfaces.IWindowProperties;

/**In dieser Klasse wird des Fenster, das erscheint, wenn der Benutzer <b>gewonnen</b> hat, dargestellt.<br>
 * Dieses Fenster erscheint, wenn das <b>Spiel vorbei</b> ist und <i>Pac-Man alle M�nzen und alle Geister verspeist</i> hat.<br>
 * Diese Klasse <b>erbt von der Klasse JDialog</b> und <b>implementiert das Interface IWindowProperties</b>.
 * @author Manuel Glantschnig
 * @version 1.1 */
public final class GameWonFrame extends JDialog implements IWindowProperties
{
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die f�r das Fenster ben�tigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>gratulationPanel</i> wird das <b>gratTextPanel</b> mit all seinen Widgets angezeigt.*/
	private JPanel		gratulationPanel= new JPanel();
	/**Auf dem <i>gratTextPanel</i> werden die beiden Labels <i>gratulationLabel</i> und <i>gratTextLabel</i> zu einem <b>Text zusammengef�gt</b>.*/
	private JPanel		gratTextPanel	= new JPanel();
	/**Auf dem <i>playagainPanel</i> werden alle <b>Komponenten</b> angezeigt, die <b>zum Wiederholen des Spiels</b> notwendig sind.*/
	private JPanel		playagainPanel	= new JPanel();
	/**Auf dem <i>buttonPanel</i> werden s�mtliche <b>Buttons</b> nebeneinander <b>dargestellt</b>.*/
	private JPanel		buttonPanel		= new JPanel();
	/**Das Icon <i>gameWonIcon</i> stellt die <b>Hauptfigur Pac-Man</b>, der gerade die <i>Geister verspeist</i>, dar.*/
	private Icon		gameWonIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameWonFrame.class.getResource("/view/images/Game_won.PNG")));
	/**Mit dem <i>gratulationLabel</i> wird dem Benutzer <b>mit seinem Spielernamen gratuliert</b>.*/
	private JLabel		gratulationLabel= new JLabel();
	/**Mit dem <i>gratTextLabel</i> wird der Benutzer darauf hingewiesen, dass er <b>gewonnen</b> hat.*/
	private JLabel		gratTextLabel	= new JLabel();
	/**Mit dem <i>playagainLabel</i> wird der Benutzer gefragt, ob er <b>nochmal spielen</b> will.*/
	private JLabel		playagainLabel	= new JLabel();
	/**Auf dem Label <i>wonImage_label</i> wird das Icon <b>gameWonIcon</b> dargestellt.*/
	private JLabel		wonImage_label	= new JLabel(gameWonIcon);
	/**Mit dem <i>ja</i>-Button best�tigt der Benutzer, dass er <b>nochmal spielen</b> m�chte.*/
	private JButton		jaButton		= new JButton("     Ja     ");
	/**Mit dem <i>nein</i>-Button best�tigt der Benutzer, dass er das <b>Spiel beenden</b> m�chte.*/
	private JButton		neinButton		= new JButton("   Nein   ");
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public GameWonFrame()
	{
		/*dem Fenster wird ein neuer WindowClosingListener zugewiesen, der ausgef�hrt wird, wenn auf das Fenster geschlossen wird*/
		addWindowListener(new WindowClosingListener(this));
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWonFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("LogIn");
		/*das Fenster wird sichtbar gemacht*/
		setVisible(true);
		/*das Fenster ist in seiner Gr��e nicht ver�nderbar*/
		setResizable(false);
		/*die Gr��e des Fensters wird festgelegt*/
		setSize(frameWidth, frameHeight);
		/*die Position des Fensters am Bildschirm wird festgelegt*/
		setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
		/*dem Fenster wird die "contentPane" (ein Panel) hinzugef�gt*/
		getContentPane().add(contentPane);
		/*der contentPane wird eine Hintergrundfarbe zugewiesen*/
		contentPane.setBackground(backgroundColor);
		/*der contentPane wird ein neues BorderLayout zugewiesen*/
		contentPane.setLayout(new BorderLayout());
		
		/*dem gratulationLabel wird der Text mit dem Spielernamen des Benutzers zugewiesen*/
		gratulationLabel.setText("GRATULATION " + LogInFrame.getUsername() + "\u0021");
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
		
		/*dem gratTextPanel wird ein neues BorderLayout hinzugef�gt*/
		gratTextPanel.setLayout(new BorderLayout());
		/*dem gratTextPanel wird eine Hintergrundfarbe zugewiesen*/
		gratTextPanel.setBackground(backgroundColor);
		/*dem gratTextPanel wird das gratulationLabel im Norden des BorderLayouts hinzugef�gt*/
		gratTextPanel.add(gratulationLabel, BorderLayout.NORTH);
		/*dem gratTextPanel wird das gratTextLabel im S�den des BorderLayouts hinzugef�gt*/
		gratTextPanel.add(gratTextLabel, BorderLayout.SOUTH);
		
		/*dem Panel wird ein neues GridBagLayout hinzugef�gt*/
		gratulationPanel.setLayout(new GridBagLayout());
		/*erstellt ein GridBagConstraint-Objekt mit, all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints center = new GridBagConstraints();
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		center.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Gr��e nicht ver�ndert*/
		center.fill = GridBagConstraints.NONE;
		/*dem Panel wird das Textfeld im Zentrum hinzugef�gt*/
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
		/*dem ja-Button wird ein Hinweistext zugewiesen*/
		jaButton.setToolTipText("Nochmal spielen");
		/*dem ja-Button wird ein ActionListener zugewiesen*/
		jaButton.addActionListener(new ButtonListener(this, ButtonListener.REPEAT_GAME));
		
		/*dem nein-Button wird ein Schriftstil zugewiesen*/
		neinButton.setFont(new Font("arial", Font.PLAIN, 38));
		/*dem nein-Button wird ein Hinweistext zugewiesen*/
		neinButton.setToolTipText("Spiel beenden");
		/*dem nein-Button wird ein ActionListener zugewiesen*/
		neinButton.addActionListener(new ButtonListener(this, ButtonListener.EXIT_GAME));
		
		/*dem buttonPanel wird ein neues FlowLayout hinzugef�gt*/
		buttonPanel.setLayout(new FlowLayout());
		/*dem buttonPanel wird eine Hintergrundfarbe zugewiesen*/
		buttonPanel.setBackground(backgroundColor);
		/*dem buttonPanel wird der ja-Button zugewiesen*/
		buttonPanel.add(jaButton);
		/*dem buttonPanel wird der nein-Button zugewiesen*/
		buttonPanel.add(neinButton);
		
		/*dem playagainPanel wird ein neues BorderLayout hinzugef�gt*/
		playagainPanel.setLayout(new BorderLayout());
		/*dem playagainPanel wird eine Hintergrundfarbe zugewiesen*/
		playagainPanel.setBackground(backgroundColor);
		/*dem playagainPanel wird das playagainLabel im Norden des BorderLayouts hinzugef�gt*/
		playagainPanel.add(playagainLabel, BorderLayout.NORTH);
		/*dem playagainPanel wird das buttonPanel im S�den des BorderLayouts hinzugef�gt*/
		playagainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		/*der contentPane wird das wonImage_label im Norden des BorderLayouts hinzugef�gt*/
		contentPane.add(wonImage_label, BorderLayout.NORTH);
		/*der contentPane wird das gratulationPanel im Zentrum des BorderLayouts hinzugef�gt*/
		contentPane.add(gratulationPanel, BorderLayout.CENTER);
		/*der contentPane wird das playagainPanel im S�den des BorderLayouts hinzugef�gt*/
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}
}