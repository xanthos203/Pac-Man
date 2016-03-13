package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.listeners.TextfieldListener;
import control.listeners.WindowClosingListener;
import model.interfaces.IWindowProperties;

/**In dieser Klasse wird des Fenster zum Einloggen des Benutzers dargestellt.<br>
 * Dieses Fenster erscheint am Anfang <b>immer zuerst</b>, wenn das <i>Spiel gestartet</i> wird.<br>
 * Diese Klasse <b>erbt von der Klasse JDialog</b> und <b>implementiert das Interface IWindowProperties</b>.
 * @author Manuel Glantschnig
 * @version 1.2 */
public final class LogInFrame extends JDialog implements IWindowProperties
{
	/**Im Textfeld <i>usernameFeld</i> kann der Benutzer seinen gewünschten <b>Spielernamen</b> eingeben.*/
	private static	JTextField	usernameFeld	= new JTextField();
	/**In <i>username</i> wird der <b>Spielername</b> des Benutzers gespeichert.*/
	private static 	String 		username		= null;
	
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die für das Fenster benötigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>infoPanel</i> werden alle benötigten Komponenten, die <b>Informationen für den Benutzer</b> bereitstellen, dargestellt.*/
	private JPanel		infoPanel		= new JPanel();
	/**Auf dem <i>usernamePanel</i> wird ein <b>Textfeld</b> dargestellt, indem der Benutzer seinen gewünschten Spielernamen eingeben kann.*/
	private JPanel		usernamePanel	= new JPanel();
	/**Auf dem <i>eingabePanel</i> werden das Label <i>hinweisLabel</i> und das JTextField <i>usernameFeld</i> zu einem <b>Eingabefeld samt Hinweistext zusammengefügt</b>.*/
	private JPanel		eingabePanel	= new JPanel();
	/**Das Icon <i>pacmanIcon</i> stellt die <b>Hauptfigur Pac-Man</b> dar.*/
	private Icon		pacmanIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man.PNG")));
	/**Das Icon <i>infoIcon</i> stellt das <b>Information "i"</b> dar.*/
	private Icon		infoIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_i.PNG")));
	/**Das Icon <i>infoText</i> stellt eine <b>Infobox mit Hinweisen</b> für den Benutzer dar.*/
	private Icon		infoText		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_Text.PNG")));
	/**Auf dem Label <i>pmImage_label</i> wird das Icon <b>pacmanIcon</b> dargestellt.*/
	private JLabel		pmImage_label	= new JLabel(pacmanIcon);
	/**Auf dem Label <i>infoImage_label</i> wird das Icon <b>infoIcon</b> dargestellt.*/
	private JLabel		infoImage_label	= new JLabel(infoIcon);
	/**Auf dem Label <i>infoText_label</i> wird das Icon <b>infoText</b> dargestellt.*/
	private JLabel		infoText_label	= new JLabel(infoText);
	/**Mit dem <i>hinweisLabel</i> wird der Benutzer darauf <b>hingewiesen, wo er seinen Spielernamen eingeben</b> muss.*/
	private JLabel		hinweisLabel	= new JLabel();
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public LogInFrame()
	{
		/*dem Fenster wird ein neuer WindowClosingListener zugewiesen, der ausgeführt wird, wenn auf das Fenster geschlossen wird*/
		addWindowListener(new WindowClosingListener(this));
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("LogIn");
		/*das Fenster wird sichtbar gemacht*/
		setVisible(true);
		/*das Fenster ist in seiner Größe nicht veränderbar*/
		setResizable(false);
		/*die Größe des Fensters wird festgelegt*/
		setSize(frameWidth, frameHeight);
		/*die Position des Fensters am Bildschirm wird festgelegt*/
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		/*dem Fenster wird die "contentPane" (ein Panel) hinzugefügt*/
		getContentPane().add(contentPane);
		/*der contentPane wird eine Hintergrundfarbe zugewiesen*/
		contentPane.setBackground(backgroundColor);
		/*der contentPane wird ein neues BorderLayout zugewiesen*/
		contentPane.setLayout(new BorderLayout());
		
		/*dem infoPanel wird die Hintergrundfarbe zugewiesen*/
		infoPanel.setBackground(backgroundColor);
		/*dem infoPanel wird ein neues BorderLayout zugewiesen*/
		infoPanel.setLayout(new BorderLayout());
		/*dem infoPanel wird das infoImage_label im Westen des BorderLayouts hinzugefügt*/
		infoPanel.add(infoImage_label, BorderLayout.WEST);
		/*dem infoPanel wird das infoText_label im Osten des BorderLayouts hinzugefügt*/
		infoPanel.add(infoText_label, BorderLayout.EAST);
		
		/*dem eingabehinweisLabel wird der Benutzers darauf hingewiesen, seinen Spielernamen einzugeben*/
		hinweisLabel.setText("Spielername eingeben\u003A");
		/*die horizontale Ausrichtung des Textes wird auf ZENTRUM gesetzt*/
		hinweisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*dem Text im eingabehinweisLabel wird ein Schriftstil zugewiesen*/
		hinweisLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 30));
		/*dem Text im eingabehinweisLabel wird eine Schriftfarbe zugewiesen*/
		hinweisLabel.setForeground(Color.WHITE);
		
		/*dem Text im usernameFeld wird ein Schriftstil zugewiesen*/
		usernameFeld.setFont(new Font("arial", Font.PLAIN, 30));
		/*die Textausrichtung im usernameFeld wird auf LINKS gesetzt*/
		usernameFeld.setHorizontalAlignment(SwingConstants.LEFT);
		/*dem usernameFeld wird ein Hinweistext zugewiesen*/
		usernameFeld.setToolTipText("Spielername eingeben");
		/*dem usernameFeld wird ein KeyListener hinzugefügt*/
		usernameFeld.addKeyListener(new TextfieldListener(this));
		
		/*dem eingabePanel wird ein neues BorderLayout hinzugefügt*/
		eingabePanel.setLayout(new BorderLayout());
		/*dem eingabePanel wird eine Hintergrundfarbe zugewiesen*/
		eingabePanel.setBackground(backgroundColor);
		/*dem eingabePanel wird das eingabehinweisLabel im Norden des BorderLayouts hinzugefügt*/
		eingabePanel.add(hinweisLabel, BorderLayout.NORTH);
		/*dem eingabePanel wird das gratTextLabel im Süden des BorderLayouts hinzugefügt*/
		eingabePanel.add(usernameFeld, BorderLayout.SOUTH);
		
		/*dem Panel wird ein neues GridBagLayout hinzugefügt*/
		usernamePanel.setLayout(new GridBagLayout());
		/*erstellt ein GridBagConstraint-Objekt, mit all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints center = new GridBagConstraints();
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		center.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Größe nicht verändert*/
		center.fill = GridBagConstraints.NONE;
		/*dem Panel wird das eingabePanel im Zentrum hinzugefügt*/
		usernamePanel.add(eingabePanel, center);
		/*die Hintergrundfarbe des Panels wird festgelegt*/
		usernamePanel.setBackground(backgroundColor);
		
		/*der contentPane wird das pmImage_label im Westen des BorderLayouts hinzugefügt*/
		contentPane.add(pmImage_label, BorderLayout.WEST);
		/*der contentPane wird das usernamePanel im Zentrum des BorderLayouts hinzugefügt*/
		contentPane.add(usernamePanel, BorderLayout.CENTER);
		/*der contentPane wird das infoPanel im Osten des BorderLayouts hinzugefügt*/
		contentPane.add(infoPanel, BorderLayout.EAST);
	}

	/**Die <i>Getter</i>-Methode für den <b>Spielername</b> retourniert den Spielername, der vom Benutzer eingeben wurde.
	 * @return den eingegebenen Spielernamen*/
	public static String getUsername()
	{
		/*der aktuelle Spielername wird zurückgegeben*/
		return username;
	}

	/**Die <i>Setter</i>-Methode für den <b>Spielername</b> setzt den <i>username</i> auf den vom Benutzer gewünschten Text.
	 * @param name der vom Benutzer festgelegte Spielername*/
	public static void setUsername(String name)
	{
		/*der username wird auf den Wert von name gesetzt*/
		username = name;
	}
	
	/**Die <i>Getter</i>-Methode für das <b>UsernameFeld</b> retourniert das UsernameFeld, indem der Benutzer seinen Spielernamen eingeben kann.
	 * @return den eingegebenen Spielernamen*/
	public static JTextField getUsernameFeld()
	{
		/*das usernameFeld wird zurückgegeben*/
		return usernameFeld;
	}
}