package control;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeMap;

public class CLogDB 
{
	private ArrayList<CLogzeile> log = new ArrayList<CLogzeile>();
	
	public CLogDB(String path) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> logString = Tools.readLogCSV(path);
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzufügen
		for (String zeile : logString) 
		{
			String[] teile = zeile.split(";");
			//Manchmal fehlt die letzte Spalte (Information)
			CLogzeile logzeile = null;
			if (teile.length >= 6) 
			{
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], teile[5]); 
			} 
			else 
			{
				logzeile = new CLogzeile(teile[0], teile[1], teile[2], teile[3], teile[4], " ");
			}
			log.add(logzeile);
		}
	}
	
//-----------------------------------------------------------------------------------------------------	
	public void listTagesaktivitaeten() 
	{
		TreeMap<String, Integer> anzTag = new TreeMap<String, Integer>();
		ListIterator<CLogzeile> lit = log.listIterator(log.size()-1);  //auf letzte Zeile positionieren
		while (lit.hasPrevious()) 
		{
		CLogzeile zeile = lit.previous();
			
		}
	}
}
