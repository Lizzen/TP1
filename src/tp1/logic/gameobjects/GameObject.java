package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject implements GameItem{

    protected Position pos;
	protected GameWorld game;
	protected boolean alive;
	
	public GameObject(Game game, int row, int col) {
		this.game = game;
		this.pos = new Position(row, col);
		this.alive = true;
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
	
	@Override
	public boolean isSolid() {
		return false;
	}
	
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	@Override
	public boolean isExit() {
		return false;
	}
	
	
	
	@Override
	public boolean interactWith(Lemming lemming) { return false; }
	@Override
	public boolean interactWith(Wall wall) { return false; }
	@Override
	public boolean interactWith(ExitDoor door) { return false; }
	@Override
	public boolean interactWith(MetalWall metalWall) { return false; }
	
	public abstract boolean isWin();
	public abstract String toString();
	public abstract boolean collision (int x, int y);
}