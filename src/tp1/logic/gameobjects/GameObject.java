package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject{

    protected Position pos;
	protected GameWorld game;
	
	public GameObject(Game game, int row, int col) {
		this.game = game;
		this.pos = new Position(row, col);
	}
	public void update() {
		return ;
	}
	
	public boolean isInPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	public boolean setRole(LemmingRole role) {
		return false;
	}
	
	public abstract boolean isEstaVivo();
	public abstract boolean isWin();
	public abstract String toString();
	public abstract boolean isInPosition(int x, int y);
	public abstract boolean collision (int x, int y);
	public abstract boolean doorCollision (int x, int y);
}