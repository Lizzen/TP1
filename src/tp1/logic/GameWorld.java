package tp1.logic;

import tp1.logic.gameobjects.GameObject;

public interface GameWorld {

	boolean collision(int x, int y);
	public boolean receiveInteractionsFrom(GameItem item);
}
