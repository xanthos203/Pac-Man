package model.main;

import model.chat.Server;
import view.frames.LogInFrame;

public class TestClass
{
	public static void main(String[] args) 
	{
		LogInFrame loginframe = new LogInFrame();
		Server.serverStarten();
	}
}