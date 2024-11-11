package tp1.logic.lemmingRoles;

import tp1.logic.GameItem;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public abstract class AbstractRol implements LemmingRole{
	private final String NAME;
	
	public AbstractRol(String name) {
		NAME = name;
	}
	
	protected boolean matchRolName(String name) {
		return getName().equalsIgnoreCase(name);
	}
	
	public String getName() {
		return NAME;
	}

	public LemmingRole parse(String input) {
		if(matchRolName(input)) {
			return this;
		} 

		return null;
	}
	
	public boolean receiveInteraction(GameItem other, Lemming owner) {
		return false;
	}
	public boolean interactWith(Lemming receiver, Lemming owner) {
		return false;
	}
	public boolean interactWith(Wall wall, Lemming owner) {
		return false;
	}
	public boolean interactWith(ExitDoor door, Lemming owner) {
		if (owner.getPos().equals(door.getPos())){
			owner.setWin(true);
			return true;
		}
		
		return false;
	}
}
