package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameLostFrame extends JFrame implements ActionListener
{
	private Color 		backgroundColor	= new Color(38, 0, 38);
	private JPanel 		contentPane		= new JPanel(),
						gameoverPanel	= new JPanel(),
						playagainPanel	= new JPanel(),
						buttonPanel		= new JPanel();
	private Icon		gameLostIcon	= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Game_lost.PNG")));
	private JLabel		gameoverLabel	= new JLabel(),
						playagainLabel	= new JLabel(),
						lostImage_label	= new JLabel(gameLostIcon);
	private JButton		jaButton		= new JButton("     Ja     "),
						neinButton		= new JButton("   Nein   ");
	private int 		screenWidth		= Toolkit.getDefaultToolkit().getScreenSize().width,  
						screenHeight	= Toolkit.getDefaultToolkit().getScreenSize().height,
						frameWidth		= 1100,
						frameHeight		= 735;
	
	public GameLostFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Verloren");
		setVisible(true);
		setResizable(false);
		setSize(frameWidth, frameHeight);
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		add(contentPane);
		contentPane.setBackground(backgroundColor);
		contentPane.setLayout(new BorderLayout());
		
		gameoverLabel.setText("GAME OVER\u0021");
		gameoverLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 40));
		gameoverLabel.setForeground(Color.CYAN);
		
		gameoverPanel.setLayout(new GridBagLayout());
		GridBagConstraints center = new GridBagConstraints();
		center.anchor = GridBagConstraints.CENTER;
		center.fill = GridBagConstraints.NONE;
		gameoverPanel.add(gameoverLabel, center);
		gameoverPanel.setBackground(backgroundColor);
		
		playagainLabel.setText("Nochmal\u003F");
		playagainLabel.setFont(new Font("arial", Font.PLAIN, 38));
		playagainLabel.setForeground(Color.MAGENTA);
		playagainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		jaButton.setFont(new Font("arial", Font.PLAIN, 38));
		jaButton.addActionListener(this);
		neinButton.setFont(new Font("arial", Font.PLAIN, 38));
		neinButton.addActionListener(this);
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(backgroundColor);
		buttonPanel.add(jaButton);
		buttonPanel.add(neinButton);
		
		playagainPanel.setLayout(new BorderLayout());
		playagainPanel.setBackground(backgroundColor);
		playagainPanel.add(playagainLabel, BorderLayout.NORTH);
		playagainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		contentPane.add(lostImage_label, BorderLayout.NORTH);
		contentPane.add(gameoverPanel, BorderLayout.CENTER);
		contentPane.add(playagainPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == jaButton)
		{
			this.dispose();
			
			/*========Hauptfenster öffnen========*/
		}
		
		else System.exit(0);
	}
}