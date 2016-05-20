package view.characters;

import model.interfaces.ICharakterBewegen;
import view.frames.GameLostFrame;
import view.frames.GameMainFrame;
import view.frames.GameWonFrame;

/**
 * In dieser Klasse namens <b>Spieler</b> werden die derzeitige <b>Position</b> <i>von Pac-Man</i>,<br>
 * die <b>Anzahl der Leben</b> und der aktuelle <b>Punktestand ermittelt</b> sowie <b>gespeichert</b>.<br>
 * Dementsprechend werden die jeweiligen <b>Maßnahmen ergriffen</b> (nähere Erläuterung später).<br>
 * <br>
 * Die <i>Spieler-Klasse</i> implementiert das Inderface <b>ICharakterBewegen</b>.<br>
 * Das Interface <i>ICharakterBewegen</i> schreibt die Methoden für die Positionierung und Bewegung der Charaktere vor</b>.<br>
 * 
 * @version 1.0
 * 
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 */
public class Spieler implements ICharakterBewegen
{
	private static int iPacManPos = 610;
	/**Die Variable <b>iLeben</b> legt fest, wie viele Leben Pac-Man hat.
	 * Mit dem Wort "Leben" ist in diesem Fall gemeint, wie of der Hauptcharackter von Geistern gefressen werden darf, ohne dass Pac-Man das Spiel verliert.<br>*/
	private int iLeben = 3;
	private int iSpielerHor;
	/**In der Variable <b>dPunktestand</b> werden alle <b>erzielten Punkte zusammengezählt</b>.<br>
	 * Punkte können <i>erziehlt</i> werden, indem man <i>Münzen</i>(= gelbe Punkte) und <i>Geister frisst</i>.<br>
	 * Hat man <b>alle Münzen gefressen</b>, <i>ohne</i> dass man das <i>selbst verspeist wurde</i>, so hat man das <b>Spiel gewonnen</b><br>
	 * (unabhängig von der Punktezahl und unabhängig davon, wie viele Geister ma gegessen hat).<br>
	 * <br>
	 * Eine <b>Münze</b> entspricht <b>500 Punkte</b>.<br>
	 * Ein <b>Eating-Coin</b> (roter Punkt) ist <b>2000 Punkte</b> wert.<br>
	 * Ein <b>verspeister</b> Geist bringt <b>50000 Punkte</b>.<br>*/
	private double dPunktestand = 0;
	
//-------------------------------------------------------------------------------------------------------------------------
	/**Je nach dem wie viele Leben Pac.Man noch hat müssen entsprechend verschiedene Maßnahmen ergriffen werden.<br>
	 * Dies geschieht in der untenstehenden Methode "setLeben".<br>
	 * Dort werden zum Beispiel die entsprechenden Fenster bzw. Klassen geöffnet.
	 * 
	 * @param iLeben
	 * In der Variable <i>iLeben</i> wirden die <b>noch verfügbaren Leben</b> von Pac-Mn <b>gespeichert</b>.*/
	public void setLeben(int iLeben)
	{
		if (iLeben <= 0)
		{
			/*Der Klasse "GameMainFrame" wird mitgeteilt, dass der Hauptcharakter "gestorben" (=keine Leben mehr hat) ist.*/
			GameMainFrame.setSpielerLebt(false);
			/*Das Hauptfenster wird unsichtbar gemacht.*/
			GameMainFrame.getGameMainFrame().setVisible(false);
			new GameLostFrame();
			GameMainFrame.getGameMainFrame().dispose();
		}
		if (iLeben >= 3)
		{
			this.iLeben = 3;
			/*Der Klasse "GameMainFrame" wird der aktuelle Spielerstand (=Anzahl der Leben) mitgeteilt.*/
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			this.iLeben = iLeben;
			/*Der Klasse "GameMainFrame" wird der aktuelle Spielerstand (=Anzahl der Leben) mitgeteilt.*/
			GameMainFrame.updateSpielstandlabelText();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**In der folgenden Methode namens <b>setPunktestand</b> werden die jeweiligen Maßnahmen bezüglich des jeweiligen Punktestandes ergriffen.<br>
	 * Wenn der Spieler zum Beispiel alle Punkte erreicht hat, wird das Fenster "GameWonFrame" geöffnet.<br>
	 * Bis zu diesem Zeitpunkt wird immer der aktuelle Punktestand gespeichert.<br>
	 * 
	 * @param dPunktestand<br>
	 * In der Variable <i>dPunktestand</i> wird der <b>aktuelle Punktestand gespeichert</b>.*/
	public void setPunktestand(double dPunktestand)
	{
		/*Wenn der Spieler gewonnen hat, wird nachfolgendes ausgeführt.*/
		if ((dPunktestand >= 999999999999999L) && (iLeben > 0))
		{
			/*Das Huptfenster wird unsichtbar gemacht.*/
			GameMainFrame.getGameMainFrame().setVisible(false);
			/*Das Fenster "GameWonFrame" wird geöffnet*/
			new GameWonFrame();
			GameMainFrame.getGameMainFrame().dispose();
		}
		/*Wenn der Punktestand 0 beträgt, wird folgendes ausgeführt.*/
		if (dPunktestand <= 0)
		{
			/*Der Punktestand 0 wird gespeichert.
			 *Der Benutzer hat also im Moment noch keine Punkte.*/
			this.dPunktestand = 0;
			/*Der Klasse "GameMainFrame" wird der aktuelle Spielerstand (=Anzahl der Punkte) mitgeteilt.*/
			GameMainFrame.updateSpielstandlabelText();
		}
		else
		{
			/*Der aktuelle Punktestand wird gespeichert.*/
			this.dPunktestand = dPunktestand;
			/*Der Klasse "GameMainFrame" wird der aktuelle Spielerstand (=Anzahl der Punkte) mitgeteilt.*/
			GameMainFrame.updateSpielstandlabelText();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier in der Methode raufBewegen wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int raufBewegen(int iPosX, int iPosY)
	{
		iPacManPos -= 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			/*Wenn die Position (von Pac-Man) bzgl. der Y-Koordinate größer als null ist wird diese Position um eins verringert.*/
			if (iPosY > 0)
			{
				/*Die Position von Pac-Man auf der Y-Koordinate wird um eins verringert.*/
				iPosY--;
			}
		}
		/*Ist dies nicht der Fall, so wird folgendes ausgeführt.*/
		else
		{
			iPacManPos += 33;
		}
		/*Die aktuelle Position von Pac-Man auf der Y-Koordinate wird zurückgegeben.*/
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int runterBewegen(int iPosX, int iPosY)
	{	
		iPacManPos += 33;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			if (iPosY < (GameMainFrame.GUI_ROWS - 1))
			{
				/*Die Position von Pac-Man auf der Y-Koordinate wird um eins erhöht.*/
				iPosY++;
			}
		}
		/*Ist dies nicht der Fall, so wird folgendes ausgeführt.*/
		else
		{
			iPacManPos -= 33;
		}
		/*Die aktuelle Position von Pac-Man auf der Y-Koordinate wird zurückgegeben.*/
		return iPosY;
	}
//-------------------------------------------------------------------------------------------------------------------------	
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int linksBewegen(int iPosX, int iPosY)
	{
		iPacManPos--;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor > -1) 
			{
				iSpielerHor--;
			} 
			else
			{
				iSpielerHor = iPosX;
			}
		}
		/*Ist dies nicht der Fall, so wird folgendes ausgeführt.*/
		else
		{
			iPacManPos++;
		}
		if (iSpielerHor == 0)
		{
			iSpielerHor = (GameMainFrame.GUI_COLUMNS - 2);
		}	
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Hier in dieser Methode wird als erstes die Position vom Pac-Man geändert und danach wird abgefragt,
	 * ob das Feld welches er betreten will eine Wand oder ein Gang ist.
	 */
	@Override
	public int rechtsBewegen(int iPosX, int iPosY)
	{
		iPacManPos++;
		if (Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.GANG_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.PAC_MAN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.EATING_COIN_INDEX ||
			Integer.parseInt(GameMainFrame.getSpielfeldAL().get(iPacManPos)) == GameMainFrame.TELEPORTER_INDEX)
		{
			iSpielerHor = iPosX;
			if (iSpielerHor < (GameMainFrame.GUI_COLUMNS - 1)) 
			{
				iSpielerHor++;
			}
			/*Ist dies nicht der Fall, so wird folgendes ausgeführt.*/
			else 
			{
				iSpielerHor = iPosX;
			}
		}
		/*Ist dies nicht der Fall, so wird folgendes ausgeführt.*/
		else
		{
			iPacManPos--;
		}
		if (iSpielerHor == (GameMainFrame.GUI_COLUMNS - 1))
		{
			iSpielerHor = 1;
		}
		/*Die Variable "iSpielerHor" wird zurückgegeben.*/
		return iSpielerHor;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**In der Methode <b>getLeben</b> wird die aktuelle <b>Anzahl</b> der <b>noch verfügbaren Leben zurückgegeben</b>.<br>
	 * 
	 * @return iLeben
	 * Die Variable <i>"iLeben"</i> gibt die <b>Anzahl der verfügbaren Leben zurück</b>.*/
	public int getLeben()
	{
		/*Die Variable "iLeben" wird zurückgegeben.*/
		return iLeben;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/**In der Methode <b>getPunktestand</b> wird der <b>aktuelle Punktestand zurückgegeben</b>.<br>
	 * 
	 * @return dPunktestand
	 * Die Variable <i>"dPunktestand"</i> gibt den <b>derzeitigen Punktestand zurück</b>.*/
	public double getPunktestand()
	{
		/*Die Variable "dPunktestand" wird zurückgegeben.*/
		return dPunktestand;
	}
}