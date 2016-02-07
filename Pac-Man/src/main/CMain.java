package main;

import control.CLogDB;
import frames.GameWonFrame;
import frames.LogInFrame;

public class CMain
{
	public static void main(String[] args) 
	{
		LogInFrame loginframe = new LogInFrame();
		CLogDB logdb = new CLogDB(System.getProperty("user.dir") + "\\src\\view\\GUI.csv");
	}
}