package main;

import chat.Server;
import frames.*;

public class CMain
{
	public static void main(String[] args) 
	{
		LogInFrame loginframe = new LogInFrame();
		Server.serverStarten();
	}
}