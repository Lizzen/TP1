package tp1.logic;



public interface GameWorld {
	
	boolean collision(int x, int y);
	public boolean receiveInteractionsFrom(GameItem item);
	void addDead();
	void addExit();

}
