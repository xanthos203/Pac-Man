package model.main;

import model.chat.Server;
import view.frames.LogInFrame;

public class CMain
{
	public static void main(String[] args) 
	{
		LogInFrame loginframe = new LogInFrame();
		Server.serverStarten();
	}
}