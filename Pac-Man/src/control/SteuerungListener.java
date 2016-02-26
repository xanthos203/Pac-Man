package control;

import java.awt.event.*;

public final class SteuerungListener implements KeyListener
{
	/**
	 * Hier wird der Spieler mit hilfe der Pfeiltasten zu Steuern.
	 * @param eTastendruck Taste gedrückt
	 */
	public void keyPressed(KeyEvent eTastendruck)
	{
	// Für Spieler welche lieber mit "WASD" spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_S))
		{
			iSpielery = pSpieler .getY();
			iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(), iSpielery);
			bSpielerAktiv = true;
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_W))
		{
			iSpielery = pSpieler.getY();
			iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(), iSpielery);
			bSpielerAktiv = true;
		}		
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_A))
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_D))
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}
		// Für Spieler welche lieber mit den Pfeiltasten spielen
		if((eTastendruck.getKeyCode() == KeyEvent.VK_DOWN))
		{
			iSpielery = pSpieler .getY();
			iSpielery = oSpieler.SpielerRaufBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(), iSpielery);
			bSpielerAktiv = true;
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_UP))
		{
			iSpielery = pSpieler.getY();
			iSpielery = oSpieler.SpielerRunterBewegen(iSpielery);
			pSpieler.setLocation(pSpieler.getX(), iSpielery);
			bSpielerAktiv = true;
		}		
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_LEFT))
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerLinksBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}
			
		if((eTastendruck.getKeyCode() == KeyEvent.VK_RIGHT))
		{
			iSpielerx = pSpieler.getX();
			iSpielerx = oSpieler.SpielerRechtsBewegen(iSpielerx);
			pSpieler.setLocation(iSpielerx, pSpieler.getY());
			bSpielerAktiv = true;
		}
		
		pSpieler.repaint();
	}

//=================================================================\\
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}