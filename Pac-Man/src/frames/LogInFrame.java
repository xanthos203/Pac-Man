package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class LogInFrame extends JFrame implements KeyListener
{
	private static String username		= null;
	
	private Color 		backgroundColor	= new Color(38, 0, 38);
	private JPanel 		contentPane		= new JPanel();
	private Icon		pacmanIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man.PNG"))),
						infoIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Info_i.PNG"))),
						infoText		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Info_Text.PNG")));
	private JPanel		infoPanel		= new JPanel(),
						usernamePanel	= new JPanel();
	private JLabel		pmImage_label	= new JLabel(pacmanIcon),
						infoImage_label	= new JLabel(infoIcon),
						infoText_label	= new JLabel(infoText);
	private JTextField	usernameFeld	= new JTextField();
	private int 		screenWidth		= Toolkit.getDefaultToolkit().getScreenSize().width,  
						screenHeight	= Toolkit.getDefaultToolkit().getScreenSize().height,
						frameWidth		= 1100,
						frameHeight		= 735;
		
	public LogInFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LogIn");
		setVisible(true);
		setResizable(false);
		setSize(frameWidth, frameHeight);
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		add(contentPane);
		contentPane.setBackground(backgroundColor);
		contentPane.setLayout(new BorderLayout());
		
		infoPanel.setBackground(backgroundColor);
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(infoImage_label, BorderLayout.WEST);
		infoPanel.add(infoText_label, BorderLayout.EAST);
		
		usernameFeld.setColumns(7);
		usernameFeld.setFont(new Font("arial", Font.PLAIN, 27));
		usernameFeld.setHorizontalAlignment(SwingConstants.LEFT);
		usernameFeld.addKeyListener(this);
		
		usernamePanel.setLayout(new GridBagLayout());
		GridBagConstraints center = new GridBagConstraints();
		center.anchor = GridBagConstraints.CENTER;
		center.fill = GridBagConstraints.NONE;
		usernamePanel.add(usernameFeld, center);
		usernamePanel.setBackground(backgroundColor);
		
		contentPane.add(pmImage_label, BorderLayout.WEST);
		contentPane.add(usernamePanel, BorderLayout.CENTER);
		contentPane.add(infoPanel, BorderLayout.EAST);
	}

	public static String getUsername()
	{
		return username;
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(usernameFeld.getText().equals("") || (usernameFeld.getText().equals(" ")))
			{
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen g\u00FCltigen Spielernamen ein\u0021", "Ung\u00FCltiger Name", JOptionPane.ERROR_MESSAGE);
				usernameFeld.setText("");
				return;
			}
			if(usernameFeld.getText().length() > 12)
			{
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen k\u00FCrzeren Spielernamen ein\u0021\nDer Spielername kann nur maximal 12 Zeichen lang sein.", "Zu langer Name", JOptionPane.WARNING_MESSAGE);
				usernameFeld.setText("");
			}
			else
			{
				username = usernameFeld.getText();
				this.dispose();
				
				/*========Hauptfenster öffnen========*/
				
//				GameWonFrame  frame = new GameWonFrame();	// <= Gewonnen-Fenster; nur TEST!!!!
				GameLostFrame frame = new GameLostFrame(); 	// <= Verloren-Fenster; nur TEST!!!!
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}