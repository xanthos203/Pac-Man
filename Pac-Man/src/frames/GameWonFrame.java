package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class GameWonFrame extends JFrame implements ActionListener
{
	private Color 		backgroundColor	= new Color(38, 0, 38);
	private JPanel 		contentPane		= new JPanel(),
						gratulationPanel= new JPanel(),
						playagainPanel	= new JPanel(),
						buttonPanel		= new JPanel();
	private Icon		gameWonIcon		= new ImageIcon(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Game_won.PNG")));
	private JLabel		gratulationLabel= new JLabel(),
						playagainLabel	= new JLabel(),
						wonImage_label	= new JLabel(gameWonIcon);
	private JButton		jaButton		= new JButton("     Ja     "),
						neinButton		= new JButton("   Nein   ");
	private int 		screenWidth		= Toolkit.getDefaultToolkit().getScreenSize().width,  
						screenHeight	= Toolkit.getDefaultToolkit().getScreenSize().height,
						frameWidth		= 1100,
						frameHeight		= 735;
	
	public GameWonFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInFrame.class.getResource("/images/Pac-Man_icon.PNG")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gewonnen");
		setVisible(true);
		setResizable(false);
		setSize(frameWidth, frameHeight);
		setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
		add(contentPane);
		contentPane.setBackground(backgroundColor);
		contentPane.setLayout(new BorderLayout());
		
		gratulationLabel.setText("GRATULATION " + LogInFrame.getUsername() + "\u0021 SIE HABEN GEWONNEN\u0021 \u003A\u0029");
		gratulationLabel.setFont(new Font("arial", Font.PLAIN, 40));
		gratulationLabel.setForeground(Color.CYAN);
		
		gratulationPanel.setLayout(new GridBagLayout());
		GridBagConstraints center = new GridBagConstraints();
		center.anchor = GridBagConstraints.CENTER;
		center.fill = GridBagConstraints.NONE;
		gratulationPanel.add(gratulationLabel);
		gratulationPanel.setBackground(backgroundColor);
		
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
		
		contentPane.add(wonImage_label, BorderLayout.NORTH);
		contentPane.add(gratulationPanel, BorderLayout.CENTER);
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