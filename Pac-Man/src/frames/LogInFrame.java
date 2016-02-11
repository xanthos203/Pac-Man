package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**In dieser Klasse wird des Fenster zum Einloggen des Benutzers dargestellt.<br>
 * Dieses Fenster erscheint am Anfang <b>immer zuerst</b>, wenn das <i>Spiel gestartet</i> wird.<br>
 * Diese Klasse erbt von der Klasse <b>JFrame</b> und implementiert den <b>KeyListener</b>.
 * @author Manuel Glantschnig
 * @version 1.0 */
public final class LogInFrame extends JFrame implements KeyListener
{
	/**In <i>username</i> wird der <b>Spielername</b> des Benutzers gespeichert.*/
	private static String username;
	
	/**Die <i>backgroundColor</i> bestimmt die <b>Hintergrundfarbe</b> des Fensters.*/
	private Color 		backgroundColor	= new Color(38, 0, 38);
	/**Auf der <i>contentPane</i> werden <b>alle Widgets</b>, die f�r das Fenster ben�tigt werden, dargestellt.*/
	private JPanel 		contentPane		= new JPanel();
	/**Auf dem <i>infoPanel</i> werden alle ben�tigten Komponenten, die <b>Informationen f�r den Benutzer</b> bereitstellen, dargestellt.*/
	private JPanel		infoPanel		= new JPanel();
	/**Auf dem <i>usernamePanel</i> wird ein <b>Textfeld</b> dargestellt, indem der Benutzer seinen gew�nschten Spielernamen eingeben kann.*/
	private JPanel		usernamePanel	= new JPanel();
	/**Das Icon <i>pacmanIcon</i> stellt die <b>Hauptfigur Pac-Man</b> mit dem Schriftzug <i>"Spielernamen eingeben"</i> dar.*/
	private Icon		pacmanIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man.PNG")));
	/**Das Icon <i>infoIcon</i> stellt das <b>Information "i"</b> dar.*/
	private Icon		infoIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Info_i.PNG")));
	/**Das Icon <i>infoText</i> stellt eine <b>Infobox mit Hinweisen</b> f�r den Benutzer dar.*/
	private Icon		infoText		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Info_Text.PNG")));
	/**Auf dem Label <i>pmImage_label</i> wird das Icon <b>pacmanIcon</b> dargestellt.*/
	private JLabel		pmImage_label	= new JLabel(pacmanIcon);
	/**Auf dem Label <i>infoImage_label</i> wird das Icon <b>infoIcon</b> dargestellt.*/
	private JLabel		infoImage_label	= new JLabel(infoIcon);
	/**Auf dem Label <i>infoText_label</i> wird das Icon <b>infoText</b> dargestellt.*/
	private JLabel		infoText_label	= new JLabel(infoText);
	/**Im Textfeld <i>usernameFeld</i> kann der Benutzer seinen gew�nschten <b>Spielernamen</b> eingeben.*/
	private JTextField	usernameFeld	= new JTextField();
	/**In <i>screenWidth</i> wird die <b>Breite des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	private int 		screenWidth		= Toolkit.getDefaultToolkit().getScreenSize().width;
	/**In <i>screenHeight</i> wird die <b>H�he des</b> aktuell verwendeten <b>Bildschirms</b> gespeichert.*/
	private int			screenHeight	= Toolkit.getDefaultToolkit().getScreenSize().height;
	/**In <i>frameWidth</i> wird die <b>Breite des Fensters</b> gespeichert.*/
	private int			frameWidth		= 1100;
	/**In <i>frameHeight</i> wird die <b>H�he des Fensters</b> gespeichert.*/
	private int			frameHeight		= 735;
	
	/**Im Konstruktor werden die <b>Eigenschaften des Fensters und der Widgets</b> festgelegt.*/
	public LogInFrame()
	{
		/*dem Fenster wird ein Icon zugewiesen, das in der Taskleiste angezeigt wird*/
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		/*beim Schlie�en des Fensters wird das Programm beendet*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*der Titel der Fensters wird zugewiesen*/
		setTitle("LogIn");
		/*das Fenster wird sichtbar gemacht*/
		setVisible(true);
		/*das Fenster ist in seiner Gr��e nicht ver�nderbar*/
		setResizable(false);
		/*die Gr��e des Fensters wird festgelegt*/
		setSize(frameWidth, frameHeight);
		/*die Position des Fensters am Bildschirm wird festgelegt*/
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		/*dem Fenster wird die "contentPane" (ein Panel) hinzugef�gt*/
		add(contentPane);
		/*der contentPane wird eine Hintergrundfarbe zugewiesen*/
		contentPane.setBackground(backgroundColor);
		/*der contentPane wird ein neues BorderLayout zugewiesen*/
		getContentPane().setLayout(new BorderLayout());
		
		/*dem infoPanel wird die Hintergrundfarbe zugewiesen*/
		infoPanel.setBackground(backgroundColor);
		/*dem infoPanel wird ein neues BorderLayout zugewiesen*/
		infoPanel.setLayout(new BorderLayout());
		/*dem infoPanel wird das infoImage_label im Westen des BorderLayouts hinzugef�gt*/
		infoPanel.add(infoImage_label, BorderLayout.WEST);
		/*dem infoPanel wird das infoText_label im Osten des BorderLayouts hinzugef�gt*/
		infoPanel.add(infoText_label, BorderLayout.EAST);
		
		/*das usernameFeld ist sieben Spalten breit*/
		usernameFeld.setColumns(7);
		/*dem Text im usernameFeld wird ein Schriftstil zugewiesen*/
		usernameFeld.setFont(new Font("arial", Font.PLAIN, 27));
		/*die Textausrichtung im usernameFeld wird auf LINKS gesetzt*/
		usernameFeld.setHorizontalAlignment(SwingConstants.LEFT);
		/*dem usernameFeld wird DIESE Klasse als KeyListener hinzugef�gt*/
		usernameFeld.addKeyListener(this);
		
		/*dem Panel wird ein neues GridBagLayout hinzugef�gt*/
		usernamePanel.setLayout(new GridBagLayout());
		/*erstellt ein GridBagConstraint-Objekt, mit all seinen Feldern auf ihren Standardwert gesetzt*/
		GridBagConstraints center = new GridBagConstraints();
		/*das GridBagConstraint-Objekt wird im Zentrum des GridBagLayouts platziert*/
		center.anchor = GridBagConstraints.CENTER;
		/*das GridBagConstraint-Objekt wird in seiner Gr��e nicht ver�ndert*/
		center.fill = GridBagConstraints.NONE;
		/*dem Panel wird das Textfeld im Zentrum hinzugef�gt*/
		usernamePanel.add(usernameFeld, center);
		/*die Hintergrundfarbe des Panels wird festgelegt*/
		usernamePanel.setBackground(backgroundColor);
		
		/*der contentPane wird das pmImage_label im Westen des BorderLayouts hinzugef�gt*/
		contentPane.add(pmImage_label, BorderLayout.WEST);
		/*der contentPane wird das usernamePanel im Zentrum des BorderLayouts hinzugef�gt*/
		contentPane.add(usernamePanel, BorderLayout.CENTER);
		/*der contentPane wird das infoPanel im Osten des BorderLayouts hinzugef�gt*/
		contentPane.add(infoPanel, BorderLayout.EAST);
	}

	/**Die <i>Getter</i>-Methode f�r den <b>Spielername</b> retourniert den Spielername, der vom Benutzer eingeben wurde.
	 * @return den eingegebenen Spielernamen*/
	public static String getUsername()
	{
		return username;
	}

	/**Die <i>keyPressed</i>-Methode f�ngt <b>Tastendr�cke</b> auf und verarbeitet diese.
	 * @param e Tastendruck*/
	@Override
	public void keyPressed(KeyEvent e)
	{
		/*Wird nur ausgef�hrt, wenn die ENTER-Taste gedr�ckt wurde*/
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			/*wird ausgef�hrt, wenn entweder kein Text oder Leerzeichen eingegeben wurden*/
			if(usernameFeld.getText().isEmpty() || (usernameFeld.getText().equals(" ")) || (usernameFeld.getText().equals("  ")) || (usernameFeld.getText().equals("   ")) || (usernameFeld.getText().equals("    ")))
			{
				/*ein Dialogfeld mit der Meldung, dass ein ung�ltiger Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021", "Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				/*der Text im Textfeld wird zur�ckgesetzt*/
				usernameFeld.setText("");
				/*das Programm kehrt wieder zum LogIn-Fenster zur�ck*/
				return;
			}
			/*wird ausgef�hrt, wenn der eingegebene Text l�nger als 20 Zeichen ist*/
			if(usernameFeld.getText().length() > 20)
			{
				/*ein Dialogfeld mit der Meldung, dass ein zu langer Name eingegeben wurde, erscheint*/
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\nDer Spielername darf maximal 20 Zeichen lang sein.", "Zu langer Name", JOptionPane.WARNING_MESSAGE);
				/*der Text im Textfeld wird zur�ckgesetzt*/
				usernameFeld.setText("");
			}
			/*wird ausgef�hrt, wenn keine der oben stehenden Bedingungen zutrifft*/
			else
			{
				/*der eingegebene Spielername wird gespeichert*/
				username = usernameFeld.getText();
				/*das aktuelle Fenster wird geschlossen*/
				this.dispose();

				/*========Hauptfenster �ffnen========*/
				CSpielFrame oSpielFrame = new CSpielFrame(true);
			}
		}
	}
//-------------------------------------------------------------------------------------	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}