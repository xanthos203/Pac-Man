package Figuren;
import frames.CSpielFrame;
import java.awt.Component;

/**
 * 
 * @author Thomas
 * @version 1.0
 */
public class CSpieler 
{
	private int iSpielerx=0;
	private int iSpielery=0;
	
	/**
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese gr��er und deshalb wird 
	 * @param iRaufy
	 * @return
	 */
	public int SpielerRaufBewegen(int iRaufy)
	{				
		// Hier wird �berpr�ft, ob der Spieler noch nicht den Unterenrand des Spielfeldes erreicht hat dann wird er um einen bestimmten Wert weiter geschoben
		if((iRaufy+CSpielFrame.getSpieler().getHeight()<(CSpielFrame.getFrame().getContentPane().getBounds().getHeight())-18))
		{
			iRaufy+=4;
			iSpielery = iRaufy;
		}
		return iSpielery;
	}
	
//-------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param iRuntery
	 * @return
	 * 
	 * Diese Methode bewegt den Spieler hinauf allerdings nur, wenn der Spierler den Oberenerand noch nicht erreicht hat.
	 */
	public int SpielerRunterBewegen(int iRuntery)
	{
		//  Hier wird �berpr�ft ober der Spieler noch weiter hinauf bewegt werden darf
		if(iRuntery>16)
		{
			iRuntery-=4;
			iSpielery=iRuntery;
		}
		return iSpielery;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRunterx
	 * @return
	 * 
	 * Hier wird �berpr�ft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu k�nnen
	 */
	public int SpielerRechtsBewegen(int iRunterx)
	{
		
		// Hier wird nur �berpr�ft, ob der Spieler noch weiter nach rechts fahren darf
		if((iRunterx+CSpielFrame.getSpieler().getHeight())+/*Hier wierd die Dicke des Pandels angegeben*/<CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
		{
			iRunterx+=4;
			iSpielerx = iRunterx;
		}
		
		// Hier wird �berpr�ft, ob der Spieler sich zwischen den Koordinaten f�r den Seitenwechsel befindet oder nicht
		if((iRunterx</*Hier wierd die Dicke des Pandels angegeben*/+CSpielFrame.getFrame().getContentPane().getBounds().getWidth())&&(((iSpielery>/*Hier wird eine koordinate anggegben f�r den Seiten wechsel des Spielers*/) && (iSpielery</*Hier wird eine koordinate anggegben f�r den Seiten wechsel des Spielers*/))))
		{
			iRunterx+=4;
			
			// Hier wird nur �berpr�ft, ob der Spieler den linken a��eren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
			if((iRunterx)>=CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
			{
				iRunterx = 0;
			}
			
			iSpielerx = iRunterx;
		}
		
		return iSpielerx;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @param iRunterx
	 * @return
	 * 
	 * Hier wird �berpr�ft ob der Spieler noch weiter nach Rechts bewegt werden darf oder nicht.
	 * Aber auch ob er sich zwischen den Koordinaten befindet wo er den Rand des Spielfeldes durch queren darf um auf die andere Seite gelangen zu k�nnen
	 */
	public int SpielerLinksBewegen(int iRunterx)
	{
		// Hier wird abegefragt, ob sich der Spieler am Rande des Spielfedes befindet oder nicht
		if(iRunterx>/*Hier wird abgefragt ob der Spieler den Rand des Pandels erreicht hat, in Koordinaten anggegeben*/)
		{
			iRunterx-=4;
			iSpielerx=iRunterx;
		}
		
		// Hier wird �berpr�ft ob sich der Spieler zwischen den Koordinaten befinden wo er die Wand durch fahren darf um die Seite zu wechseln
		if((iRunterx</*das selbe wie in zeile 68*/)&& ((iSpielery>/*selbe wie in Zeile 51*/) && (iSpielery/*Selbe wie in Zeile 51*/)))
		{
			iRunterx -=4;
			
			// Hier wird nur �berpr�ft, ob der Spieler den linken a��eren Fensterrand erreicht, wenn ja wird er auf die anderere Spielfeldseite gesetzt
			if(iRunterx<=0)
			{
				iRunterx = (int) CSpielFrame.getFrame().getContentPane().getBounds().getWidth();	
			}
			
			iSpielerx = iRunterx;
		}
		return iSpielerx;
	}

}

