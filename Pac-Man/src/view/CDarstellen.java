package view;

import java.awt.Color;

import javax.swing.JPanel;

import frames.CSpielFrame;

/**
 * 
 * @author Thomas
 * 
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
		oSpiel.oFrame.getContentPane().add(jPanel);
	}
}
