package control;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeMap;

public class CLogDB 
{
	public ArrayList<CLogzeile> log = new ArrayList<CLogzeile>();
	private CLogzeile logzeile = new CLogzeile();
	
	public CLogDB(String path) 
	{
		//ArrayList der Logzeilen als Strings besorgen
		ArrayList<String> logString = Tools.readLogCSV(path);
		
		//Zeilenobjekte aus Stringzeilen erzeugen und der ArrayList hinzufügen
		for (String zeile : logString) 
		{
			String[] teile = zeile.split(";");
			
			//Manchmal fehlt die letzte Spalte (Information)
			logzeile = null;
			
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
//--------------------------------------------------------
	public CLogDB() 
	{
		// TODO Auto-generated constructor stub
	}
}
