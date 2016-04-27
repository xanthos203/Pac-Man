package model.interfaces;

public interface ICharakterBewegen
{
	public int raufBewegen(int iRauf);
	public int runterBewegen(int iRunter);
	public int linksBewegen(int iLinks);
	public int rechtsBewegen(int iRechts);
	public int getX();
	public int getY();
}