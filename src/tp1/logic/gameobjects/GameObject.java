package tp1.logic.gameobjects;

import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public abstract class GameObject implements GameItem{

    protected Position pos;
	protected GameWorld game;
	protected boolean alive;
	protected String name;
	protected String shortcut;
	
	public GameObject(String name, String shortcut) {
		this.name = name;
		this.shortcut = shortcut;
		//this.alive = true;
	}
	public void update() {
		return ;
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
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
	
	public String getName() {
		return name;
	}

	public String getShortcut() {
		return shortcut;
	}
	
	protected boolean matchRolName(String name) {
		return getName().equalsIgnoreCase(name) || getShortcut().equalsIgnoreCase(name);
	}
	
	public void setIniDirection(String input) {
		return;
	}
	
	public void setCaida(int caida) {
		return;
	}
	
	public GameObject parse(String line, GameWorld game) {
		if (matchRolName(line)) {
			this.game = game;
			return this;
		}
		
		return null;
	}
	
	/*private static Position getPositionFrom(String line) throws ObjectParseException, OffBoardException {...}
	private static String getObjectNameFrom(String line) throws ObjectParseException {...}
	private static Direction getLemmingDirectionFrom(String line) throws ObjectParseException {...}
	private static int getLemmingHeigthFrom(String line) throws ObjectParseException {...}
	private static LemmingRole getLemmingRoleFrom(String line) throws ObjectParseException {...}*/
	
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