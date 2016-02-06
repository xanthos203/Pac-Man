package control;

import java.io.*;
import java.util.*;

public final class Tools 
{
	public static ArrayList<String> readLogCSV(String path) 
	{
		ArrayList<String> log = new ArrayList<String>();
		
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(path));
			String zeile = null;
			
			while ((zeile = in.readLine()) != null) 
			{
				log.add(zeile);
			}
			in.close();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return log;
	}
}