package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.listeners.TextfieldListener;
import control.listeners.WindowListener;
import model.interfaces.IWindowProperties;

/**In dieser Klasse wird des Fenster zum Einloggen des Benutzers dargestellt.<br>
 * Dieses Fenster erscheint am Anfang <b>immer zuerst</b>, wenn das <i>Spiel gestartet</i> wird.<br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>JDialog</b> und <b>implementiert</b> das Interface <b>IWindowProperties</b>.
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.2 */
@SuppressWarnings("serial")
public final class LogInFrame extends JFrame implements IWindowProperties
{
	/**In <i>username</i> wird der <b>Spielername</b> des Benutzers gespeichert.*/
	private static String username;
	
	/**Im Textfeld <i>usernameFeld</i> kann der Benutzer seinen gew�nschten <b>Spielernamen</b> eingeben.*/
	private JTextField  usernameFeld	= new JTextField();
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die f�r das Fenster ben�tigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>infoPanel</i> werden alle ben�tigten Komponenten, die <b>Informationen f�r den Benutzer</b> bereitstellen, dargestellt.*/
	private JPanel		infoPanel		= new JPanel();
	/**Auf dem <i>usernamePanel</i> wird ein <b>Textfeld</b> dargestellt, indem der Benutzer seinen gew�nschten Spielernamen eingeben kann.*/
	private JPanel		usernamePanel	= new JPanel();
	/**Auf dem <i>eingabePanel</i> werden das Label <i>hinweisLabel</i> und das JTextField <i>usernameFeld</i> zu einem <b>Eingabefeld samt Hinweistext zusammengef�gt</b>.*/
	private JPanel		eingabePanel	= new JPanel();
	/**Das Icon <i>pacmanIcon</i> stellt die <b>Hauptfigur Pac-Man</b> dar.*/
	private Icon		pacmanIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man.PNG")));
	/**Das Icon <i>infoIcon</i> stellt das <b>Information "i"</b> dar.*/
	private Icon		infoIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_i.PNG")));
	/**Das Icon <i>infoText</i> stellt eine <b>Infobox mit Hinweisen</b> f�r den Benutzer dar.*/
	private Icon		infoText		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_Text.PNG")));
	/**Auf dem Label <i>pmImage_label</i> wird das Icon <b>pacmanIcon</b> dargestellt.*/
	private JLabel		pmImage_label	= new JLabel(pacmanIcon);
	/**Auf dem Label <i>infoImage_label</i> wird das Icon <b>infoIcon</b> dargestellt.*/
	private JLabel		infoImage_label	= new JLabel(infoIcon);
	/**Auf dem Label <i>infoText_label</i> wird das Icon <b>infoText</b> dargestellt.*/
	private JLabel		infoText_label	= new JLabel(infoText);
	/**Das <i>pacmanLabel</i> zeigt lediglich den <b>Namen des Spiels</b> an.*/
	private JLabel 		pacmanLabel 	= new JLabel("PAC\u00ADMAN");
	/**Mit dem <i>hinweisLabel</i> wird der Benutzer darauf <b>hingewiesen, wo er seinen Spielernamen eingeben</b> muss.*/
	private JLabel		hinweisLabel	= new JLabel("Spielername eingeben\u003A");
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public LogInFrame()
	{
		/*dem Fenster wird ein neuer WindowClosingListener zugewiesen, der ausgef�hrt wird, wenn auf das Fenster geschlossen wird*/
		addWindowListener(new WindowListener(this));
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("LogIn");
		/*das Fenster wird sichtbar gemacht*/
		setVisible(true);
		/*das Fenster ist in seiner Gr��e nicht ver�nderbar*/
		setResizable(false);
		/*die Gr��e des Fensters wird festgelegt*/
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		/*die Position des Fensters am Bildschirm wird festgelegt*/
		setLocation(WINDOW_POSITION);
		/*dem Fenster wird die "contentPane" (ein Panel) hinzugef�gt*/
		getContentPane().add(contentPane);
		/*der contentPane wird eine Hintergrundfarbe zugewiesen*/
		contentPane.setBackground(BACKGROUND_COLOR);
		/*der contentPane wird ein neues BorderLayout zugewiesen*/
		contentPane.setLayout(new BorderLayout());
		
		/*dem infoPanel wird die Hintergrundfarbe zugewiesen*/
		infoPanel.setBackground(BACKGROUND_COLOR);
		/*dem infoPanel wird ein neues BorderLayout zugewiesen*/
		infoPanel.setLayout(new BorderLayout());
		/*dem infoPanel wird das infoImage_label im Westen des BorderLayouts hinzugef�gt*/
		infoPanel.add(infoImage_label, BorderLayout.WEST);
		/*dem infoPanel wird das infoText_label im Osten des BorderLayouts hinzugef�gt*/
		infoPanel.add(infoText_label, BorderLayout.EAST);
		
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		hinweisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im eingabehinweisLabel wird ein Schriftstil zugewiesen*/
		hinweisLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 29));
		/*dem Text im eingabehinweisLabel wird eine Schriftfarbe zugewiesen*/
		hinweisLabel.setForeground(Color.WHITE);
		
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		pacmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im pacmanLabel wird ein Schriftstil zugewiesen*/
		pacmanLabel.setFont(new Font("Arial", Font.BOLD, 62));
		/*dem Text im pacmanLabel wird eine Schriftfarbe zugewiesen*/
		pacmanLabel.setForeground(Color.CYAN);
		
		/*dem Text im usernameFeld wird ein Schriftstil zugewiesen*/
		usernameFeld.setFont(new Font("arial", Font.PLAIN, 29));
		/*die Textausrichtung im usernameFeld wird auf LINKS gesetzt*/
		usernameFeld.setHorizontalAlignment(SwingConstants.LEFT);
		/*dem usernameFeld wird ein Hinweistext zugewiesen*/
		usernameFeld.setToolTipText("Spielername eingeben");
		/*dem usernameFeld wird ein KeyListener hinzugef�gt*/
		usernameFeld.addKeyListener(new TextfieldListener(this, usernameFeld));
		
		/*dem eingabePanel wird ein neues BorderLayout hinzugef�gt*/
		eingabePanel.setLayout(new BorderLayout());
		/*dem eingabePanel wird eine Hintergrundfarbe zugewiesen*/
		eingabePanel.setBackground(BACKGROUND_COLOR);
		/*dem eingabePanel wird das eingabehinweisLabel im Norden des BorderLayouts hinzugef�gt*/
		eingabePanel.add(hinweisLabel, BorderLayout.NORTH);
		/*dem eingabePanel wird das gratTextLabel im S�den des BorderLayouts hinzugef�gt*/
		eingabePanel.add(usernameFeld, BorderLayout.SOUTH);
		
		/*dem Panel wird ein neues GridBagLayout hinzugef�gt*/
		usernamePanel.setLayout(new GridBagLayout());
		/*die Hintergrundfarbe des Panels wird festgelegt*/
		usernamePanel.setBackground(BACKGROUND_COLOR);
		
		/*erstellt ein GridBagConstraint-Objekt, mit all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints gbc_pacmanLabel = new GridBagConstraints();
		/*spezifiziert den Mindestabstand zwischen der Komponente und den Ecken der Anzeigefl�che*/
		gbc_pacmanLabel.insets = new Insets(0, 0, 5, 0);
		/*bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der X-Achse befindet*/
		gbc_pacmanLabel.gridx = 0;
		/*bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der Y-Achse befindet*/
		gbc_pacmanLabel.gridy = 0;
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		gbc_pacmanLabel.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Gr��e nicht ver�ndert*/
		gbc_pacmanLabel.fill = GridBagConstraints.NONE;
		/*dem usernamePanel wird das pacmanLabel auf der Position des GridBagConstraint-Objekts hinzugef�gt*/
		usernamePanel.add(pacmanLabel, gbc_pacmanLabel);
		
		/*erstellt ein GridBagConstraint-Objekt, mit all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints gbc_eingabePanel = new GridBagConstraints();
		/*spezifiziert den Mindestabstand zwischen der Komponente und den Ecken der Anzeigefl�che*/
		gbc_eingabePanel.insets = new Insets(0, 0, 5, 0);
		/*bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der X-Achse befindet*/
		gbc_eingabePanel.gridx = 0;
		/*bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der Y-Achse befindet*/
		gbc_eingabePanel.gridy = 1;
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		gbc_eingabePanel.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Gr��e nicht ver�ndert*/
		gbc_eingabePanel.fill = GridBagConstraints.NONE;
		/*dem usernamePanel wird das eingabePanel auf der Position des GridBagConstraint-Objekts hinzugef�gt*/
		usernamePanel.add(eingabePanel, gbc_eingabePanel);
		
		/*der contentPane wird das pmImage_label im Westen des BorderLayouts hinzugef�gt*/
		contentPane.add(pmImage_label, BorderLayout.WEST);
		/*der contentPane wird das usernamePanel im Zentrum des BorderLayouts hinzugef�gt*/
		contentPane.add(usernamePanel, BorderLayout.CENTER);
		/*der contentPane wird das infoPanel im Osten des BorderLayouts hinzugef�gt*/
		contentPane.add(infoPanel, BorderLayout.EAST);
	}

	/**Die <i>Setter</i>-Methode f�r den <b>Spielername</b> setzt den <i>username</i> auf den vom Benutzer gew�nschten Text.
	 * @param name der vom Benutzer festgelegte Spielername*/
	public static void setUsername(String name)
	{
		/*der username wird auf den Wert von name gesetzt*/
		username = name;
	}

	/**Die <i>Getter</i>-Methode f�r den <b>Spielername</b> retourniert den Spielername, der vom Benutzer eingeben wurde.
	 * @return den eingegebenen Spielernamen*/
	public static String getUsername()
	{
		/*der aktuelle Spielername wird zur�ckgegeben*/
		return username;
	}
}