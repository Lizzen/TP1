package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public abstract class GameObject{

    protected Position pos;
	protected GameWorld game;
	
	public GameObject(Game game, int row, int col) {
		this.game = game;
		pos = new Position();
		this.pos = new Position();
		this.pos.setRow(row);
		this.pos.setCol(col);
	}
	public void update() {
		return ;
	}
	public boolean isInPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	public abstract boolean isEstaVivo();
	public abstract boolean isWin();
	public abstract String toString();
	public abstract boolean isInPosition(int x, int y);
	public abstract boolean collision (int x, int y);
	public abstract boolean doorCollision (int x, int y);
}