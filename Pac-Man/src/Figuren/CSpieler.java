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
	 * Diese methode heist zwar Spieler rauf bewegen, allerdings wird hier der Spieler runterbeweget, da aber die Koordinaten steigen werder  diese größer und deshalb wird 
	 * @param iRaufy
	 * @return
	 */
	public int SpielerRaufBewegen(int iRaufy)
	{				
		if((iRaufy+CSpielFrame.getSpieler().getHeight()<(CSpielFrame.getFrame().getContentPane().getBounds().getHeight())-18))
		{
			iRaufy+=4;
			iSpielery = iRaufy;
		}
		return iSpielery;
	}
	
//-------------------------------------------------------------------------------------------------------------------------
	
	public int SpielerRunterBewegen(int iRuntery)
	{
		if(iRuntery>16)
		{
			iRuntery-=4;
			iSpielery=iRuntery;
		}
		return iSpielery;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public int SpielerRechtsBewegen(int iRunterx)
	{
		if((iRunterx+CSpielFrame.getSpieler().getHeight())+/*Hier wierd die Dicke des Pandels angegeben*/<CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
		{
			iRunterx+=4;
			iSpielerx = iRunterx;
		}
		
		if((iRunterx<16+CSpielFrame.getFrame().getContentPane().getBounds().getWidth())&&(((iSpielery>/*Hier wird eine koordinate anggegben für den Seiten wechsel des Spielers*/) && (iSpielery</*Hier wird eine koordinate anggegben für den Seiten wechsel des Spielers*/))))
		{
			iRunterx+=4;
			
			if((iRunterx)>=CSpielFrame.getFrame().getContentPane().getBounds().getWidth())
			{
				iRunterx = 0;
			}
			
			iSpielerx = iRunterx;
		}
		return iSpielerx;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public int SpielerLinksBewegen(int iRunterx)
	{
		
		if(iRunterx>/*Hier wird abgefragt ob der Spieler den Rand des Pandels erreciht hat, in Koordinaten anggegeben*/)
		{
			iRunterx-=4;
			iSpielerx=iRunterx;
		}
		
		if((iRunterx</*das selbe wie in zeile 68*/)&& ((iSpielery>/*selbe wie in Zeile 51*/) && (iSpielery/*Selbe wie in Zeile 51*/)))
		{
			iRunterx -=4;
			
			if(iRunterx<=0)
			{
				iRunterx = (int) CSpielFrame.getFrame().getContentPane().getBounds().getWidth();	
			}
			
			iSpielerx = iRunterx;
		}
		return iSpielerx;
	}

}

