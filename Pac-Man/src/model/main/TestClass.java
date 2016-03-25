package model.main;

import model.chat.Server;
import view.frames.LogInFrame;

public class TestClass
{
	public static void main(String[] args) 
	{
		new LogInFrame();
		Server.serverStarten();
	}
}