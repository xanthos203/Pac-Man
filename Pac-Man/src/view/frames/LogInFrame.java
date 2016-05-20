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

/**In dieser Klasse namens <b>LogInFrame</b> wird des <b>Fenster zum Einloggen</b> <i>des Benutzers</i> <b>dargestellt</b>.<br>
 * Dies ist das <i>allererste Fenster</i> das der Benutzer sieht nachdem er das Spiel aufgerufen hat.<br>
 * Der <b>Spieler muss</b> hier <i>seinen gewünschten</i> <b>Spielername eingeben</b>.<br>
 * Dieser <i>Spielername</i> wird für <i>andere Speilteilnehmer</i> <b>sichtbar</b>,<br>
 * sobald der Spieler versucht an einer <b>Kommunikation via Chat teilzunehmen</b>.<br>
 * Wenn also der <i>Benutzer</i> eine <i>Message in<i> den </i>Chatverlauf stellt</i>,<br>
 * wird <i>mittels</i> seinen gewählten <i>Spielernamen angezeigt</i>,<br>
 * dass diese <i>Nachricht von ihm gesendet bzw. verfasst wurde</i>.<br>
 * <br>
 * Diese Klasse <b>erbt</b> von der Klasse <b>JFrame</b> und <b>implementiert</b> das Interface <b>IWindowProperties</b>.<br>
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
public final class LogInFrame extends JFrame implements IWindowProperties
{
	/**In der Variable <b>username</b> wird der gewählte <b>Spielername</b> des jeweiligen Benutzers <b>gespeichert</b>.*/
	private static String username;
	/**Im Textfeld <b>usernameFeld</b> kann der entsprechende <i>Benutzer</i> seinen gewünschten <b>Spielernamen eingeben</b>.*/
	private JTextField 	usernameFeld	= new JTextField();
	/**Auf der <b>contentPane</b> werden <b>alle Widgets bzw Komponenten</b>, die für das <b>LogIn-Fenster</b> bzw das <i>LogInFrame</i> <b>benötigt werden, dargestellt</b<.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem Panel <b>infoPanel</b> werden <b>alle benötigten Informationen</b>, die der Benutzer braucht,<br>
	 * um zum Beispiel zu wissen wie zum Beispiel das Spiel funktioniert, <b>bereitgestellt</b>.*/
	private JPanel		infoPanel		= new JPanel();
	/**Auf dem Panel <b>usernamePanel</b> befindet sich das Textfeld <b>usernameFeld</b>.*/
	private JPanel		usernamePanel	= new JPanel();
	/**Das <b>eingabePanel</b> beinhaltet das Label <b>hinweisLabel</b> und das Textfeld <b>usernameFeld</b>.
	 * Diese werden zu einem <b>Eingabefeld mit Hinweistext zusammengefügt</b>.*/
	private JPanel		eingabePanel	= new JPanel();
	/**Das Icon (=Bild) <b>pacmanIcon speichert</b> das <b>Bild</b> der <b>Hauptfigur</b>.*/
	private Icon		pacmanIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man.PNG")));
	/**Das Icon (=Bild) <b>infoIcon stellt</b> das <b>"Informations-i" dar</b>.*/
	private Icon		infoIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_i.PNG")));
	/**Das Icon (=Bild) <b>infoText speichert</b> eine <b>Infobox mit Hinweisen</b> <i>für</i> den <i>Spielbenutzer</i>.*/
	private Icon		infoText		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Info_Text.PNG")));
	/**Auf dem Label <b>pmImage_label</b> wird das Icon (=Bild) <b>pacmanIcon dargestellt</b>.*/
	private JLabel		pmImage_label	= new JLabel(pacmanIcon);
	/**Auf dem Label <b>infoImage_label</b> wird das Icon <b>infoIcon dargestellt</b>.*/
	private JLabel		infoImage_label	= new JLabel(infoIcon);
	/**Auf dem Label <b>infoText_label</b> wird das Icon <b>infoText dargestellt</b>.*/
	private JLabel		infoText_label	= new JLabel(infoText);
	/**Das Label namens <b>pacmanLabel</b> zeigt den <b>Namen des Spiels an</b>.
	 * Der <i>Name des Spiels lautet</i> <b>PAC-MAN</b>.*/
	private JLabel 		pacmanLabel 	= new JLabel("PAC\u00ADMAN");
	/**Das Label namens <b>hinweisLabel weißt</b> den <b>Benutzer darauf hin, wo</b> er seinen <b>Spielernamen eingeben muss bzw. soll</b>.*/
	private JLabel		hinweisLabel	= new JLabel("Spielername eingeben\u003A");
	
	/**Im Konstruktor namens <b>LogInFrame</b> werden alle <b>Eigenschaften des Fensters und der Widgets bzw. Komponenten</b> festgelegt.<br>
	 * Solche Eingenschaften wären zum Beispiel Hintergrundfarbe, Größe, Position am Bildschirm,...*/
	public LogInFrame()
	{
		/*Dem Fenster wird ein neuer WindowClosingListener zugewiesen.
		 *Dieser Listener wird ausgeführt, wenn das Fenster geschlossen wird bzw. geschlossen werden soll.*/
		addWindowListener(new WindowListener(this));
		/*Dem Fenster wird ein Icon, welches in der Taskleiste angezeigt wird, hinzugefügt.*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/view/images/Pac-Man_icon.PNG")));
		/*Das Fenster bekommt den Titel "LogIn".*/
		setTitle("LogIn");
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
		getContentPane().add(contentPane);
		/*Der contentPane wird ihre zukünftige Hintergrundfarbe mitgeteilt.*/
		contentPane.setBackground(BACKGROUND_COLOR);
		/*Der contentPane wird ein BorderLayout zugewiesen.
		 * Dieses dient zur erleichterten Position der einzelnen Komponenten am Bildschirm.*/
		contentPane.setLayout(new BorderLayout());
		
		/*Dem infoPanel wird seine zukünftige Hintergrundfarbe mitgeteilt.*/
		infoPanel.setBackground(BACKGROUND_COLOR);
		/*Dem infoPanel wird ein BorderLayout zugewiesen.*/
		infoPanel.setLayout(new BorderLayout());
		/*Dem infoPanel wird das infoImage_label zugewießen.
		 * Dieses befindet sich im Westen des BorderLayouts.
		 * Das heißt, ese befindet sich im Westen des Fensters.*/
		infoPanel.add(infoImage_label, BorderLayout.WEST);
		/*Dem infoPanel wird das infoText_label hinzugefügt.
		 * Dieses befindet sich im Osten des BorderLayouts.
		 * Das heißt es befindet sich im Osten des Fensters.*/
		infoPanel.add(infoText_label, BorderLayout.EAST);
		
		/*Die horizontale Ausrichtung des Textes wird auf das Zentrum (=Mitte des Fensters) gesetzt.*/
		hinweisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im eingabehinweisLabel wird eine Schriftart namens "Book Antiqua" mit der Schriftgröße 29 zugewiesen.*/
		hinweisLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 29));
		/*Dem Text im eingabehinweisLabel wird die Schriftfarbe "weiß" zugewiesen*/
		hinweisLabel.setForeground(Color.WHITE);
		
		/*Die horizontale Ausrichtung des Textes wird auf das Zentrum (=Mitte des Fensters) gesetzt.*/
		pacmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*Dem Text im pacmanLabel wird die Schrift "Arial" mit der Größe 62 zugewiesen.*/
		pacmanLabel.setFont(new Font("Arial", Font.BOLD, 62));
		/*Dem Text im pacmanLabel wird die Schriftfarbe "cyan" zugewiesen*/
		pacmanLabel.setForeground(Color.CYAN);
		
		/*Dem Text im usernameFeld wird die Schriftart "Arial" mit der Größe 29 zugewiesen.*/
		usernameFeld.setFont(new Font("Arial", Font.PLAIN, 29));
		/*Die horizontale Textausrichtung im usernameFeld wird auf links fixiert.*/
		usernameFeld.setHorizontalAlignment(SwingConstants.LEFT);
		/*Dem usernameFeld wird ein Hinweistext hinzugefügt.
		 * Dieser lautet "Spielername eingeben".*/
		usernameFeld.setToolTipText("Spielername eingeben");
		/*Dem usernameFeld wird ein KeyListener hinzugefügt.*/
		usernameFeld.addKeyListener(new TextfieldListener(this, usernameFeld));
		
		/*Dem eingabePanel wird ein BorderLayout hinzugefügt.
		 * Dieses dient zur erleichterten Positionierung der Komponenten innerhalb des Fensters.*/
		eingabePanel.setLayout(new BorderLayout());
		/*Dem eingabePanel wird seine zukünftige Hintergrundfarbe mitgeteilt.*/
		eingabePanel.setBackground(BACKGROUND_COLOR);
		/*Dem eingabePanel wird das eingabehinweisLabelhinzugefügt.
		 * Dieses befindet sich im Norden des BorderLayouts.
		 * Also befindet es sich im Norden des Fesnsters.*/
		eingabePanel.add(hinweisLabel, BorderLayout.NORTH);
		/*Dem eingabePanel wird das usernameFeld hinzugefügt.
		 * Dieses befindet sich im Süden des BorderLayouts.
		 * Also befindet es sich Im Süden des Fesnsters.*/
		eingabePanel.add(usernameFeld, BorderLayout.SOUTH);
		
		/*Dem usernamePanel wird ein neues GridBagLayout hinzugefügt.
		 * Dieses dient (wie das BorderLayout auch) der erleichterten Positionierung der einzelnen Komponenten bzw. Widgets innerhalb des Festers.*/
		usernamePanel.setLayout(new GridBagLayout());
		/*Dem usernamePanel wird seine zukünftige Hintergrundfarbe mitgeteilt.*/
		usernamePanel.setBackground(BACKGROUND_COLOR);
		
		/*Es wird ein GridBagConstraint-Objekt erstellt.
		 * Dieses lautet "gbc_pacmanLabel".*/
		GridBagConstraints gbc_pacmanLabel = new GridBagConstraints();
		/*Folgendes spezifiziert den Mindestabstand zwischen der jeweiligen Komponente und den Ecken der Anzeigefläche.*/
		gbc_pacmanLabel.insets = new Insets(0, 0, 5, 0);
		/*".gridx" bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der X-Achse befindet.*/
		gbc_pacmanLabel.gridx = 0;
		/*".gridy" bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der Y-Achse befindet*/
		gbc_pacmanLabel.gridy = 0;
		/*Das GridBagConstraint-Objekt wird im Zentrum (= Mitte) des GridBagLayouts platziert.*/
		gbc_pacmanLabel.anchor = GridBagConstraints.CENTER;
		/*Dem GridBagConstraint-Objekt wird mitgeteilt, dass es in seiner Größe nicht veränderbar ist.*/
		gbc_pacmanLabel.fill = GridBagConstraints.NONE;
		/*Dem usernamePanel wird das pacmanLabel auf der Position des GridBagConstraint-Objekts hinzugefügt.*/
		usernamePanel.add(pacmanLabel, gbc_pacmanLabel);
		
		/*Ein GridBagConstraint-Objekt wird erstellt.
		 * Es trägt den Namen "gbc_eingabePanel".*/
		GridBagConstraints gbc_eingabePanel = new GridBagConstraints();
		/*Der Mindestabstand zwischen den Komponenten und den Ecken der Anzeigefläche wird spezifiziert.*/
		gbc_eingabePanel.insets = new Insets(0, 0, 5, 0);
		/*".gridx" bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der X-Achse befindet.*/
		gbc_eingabePanel.gridx = 0;
		/*".gridy" bestimmt in welcher Spalte sich das GridBagConstraint-Objekt auf der Y-Achse befindet.*/
		gbc_eingabePanel.gridy = 1;
		/*Das GridBagConstraint-Objekt wird im Zentrum (= Mitte) des GridBagLayouts platziert.*/
		gbc_eingabePanel.anchor = GridBagConstraints.CENTER;
		/*Das GridBagConstraint-Objekt ist nun nicht mehr in seiner Größe veränderbar.*/
		gbc_eingabePanel.fill = GridBagConstraints.NONE;
		/*Dem usernamePanel wird das eingabePanel auf der Position des GridBagConstraint-Objekts hinzugefügt.*/
		usernamePanel.add(eingabePanel, gbc_eingabePanel);
		
		/*Der contentPane wird das pmImage_label hinzugefügt.
		 * Dieses befindet sich im Westen des BorderLayouts.
		 * Also befindet es sich im Westen des Fensters.*/
		contentPane.add(pmImage_label, BorderLayout.WEST);
		/*Der contentPane wird das usernamePanel hinzugefügt.
		 * Dieses befindet sich im Zentrum (=Mitte) des BorderLayouts.
		 * Also befindet es sich im Zentrum (= Mitte) des Fensters.*/
		contentPane.add(usernamePanel, BorderLayout.CENTER);
		/*Der contentPane wird das infoPanel hinzugefügt.
		 * Dieses befindet sich im Osten des BorderLayouts.
		 * Aslo befindet es sich im Osten des Fensters.*/
		contentPane.add(infoPanel, BorderLayout.EAST);
	}

	/**Die <i>Setter-Methode</i> für den <b>Spielername</b> setzt den <b>username</b> auf den vom Benutzer gewünschten Namen.<br>
	 * 
	 * @param name Die Variable <i>name</i> <b>beinhaltet</b> den <b>vom Benutzer festgelegten Spielernamen</b>.*/
	public static void setUsername(String name)
	{
		/*Der eingegebene Spielername des Benutzers wird in der Variable "username" gespeichert.*/
		username = name;
	}

	/**Die <i>Getter-Methode</i> für den <b>Spielername</b> gibt die Variable username zurück.<br>
	 * Sie beinhaltet den vom Benutzer gewünschten Spilernamen.<br>
	 * 
	 * @return username Die Variable <i>username</i> <b>beinhaltet</b> den <b>vom Benutzer festgelegten Spielernamen</b>.*/
	public static String getUsername()
	{
		/*Der vom Benutzer gewünschte Spielername wird zurückgegeben.*/
		return username;
	}
}