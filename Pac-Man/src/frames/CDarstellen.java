package frames;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * 
 * @author Thomas
 * ss
 *	Ich bin dafür zustendig die Hindernisse Darzustellen :)
 */

public class CDarstellen 
{
	JPanel jPanel;
	int zaehlerY=20;
	int zaehlerX=0;
	int laenge=20;
	int breite=5;
	
	CSpielFrame oSpiel = new CSpielFrame();
	
	public CDarstellen()
	{
		
		jPanel = new JPanel();
		jPanel.setBounds(zaehlerX,zaehlerY,laenge, breite);
		jPanel.setBackground(Color.BLUE);
		System.out.println("1");
		oSpiel.oFrame.getContentPane().add(jPanel);
	}
}
