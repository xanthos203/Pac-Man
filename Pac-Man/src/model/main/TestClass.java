package model.main;

import model.chat.Server;
import view.frames.LogInFrame;

/**
 * @author Manuel Glantschnig
 * @author Thomas Mader-Ofer
 * @author Cristina Erhart
 * @version 1.0
 */
public final class TestClass
{
	public static void main(String[] args) 
	{
		new LogInFrame();
		Server.serverStarten();
	}
}