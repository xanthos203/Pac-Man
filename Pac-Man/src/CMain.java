import control.CLogDB;

public class CMain
{
	public static void main(String[] args) 
	{
		CLogDB logdb = new CLogDB(System.getProperty("user.dir") + "\\src\\view\\GUI.csv");
	}
}