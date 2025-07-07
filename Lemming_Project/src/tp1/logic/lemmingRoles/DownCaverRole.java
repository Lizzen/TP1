package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRol implements LemmingRole {

	private static final String NAME = Messages.DOWNCAVER_ROL_NAME;
	private static final String DETAILS = Messages.DOWNCAVER_ROL_DETAILS;
	private static final String HELP = Messages.DOWNCAVER_ROL_HELP;
	private static final String SHORTCUT = Messages.DOWNCAVER_ROL_SYMBOL;
	private static final String ICON = Messages.LEMMING_DOWN_CAVER;
	
	public DownCaverRole() {
		super(NAME, HELP, DETAILS, SHORTCUT);
	}
	
	public void play(Lemming lemming) {
		lemming.cave();
	}
	
	public String getIcon(Lemming lemming) {
		return ICON;
	}
	
	
	public String getHelp() {
		return HELP;
	}
	


	// String that represents the object status
	// for this simple class, the name is enough
	public String toString() {
		return getName();
	}

	@Override
	public boolean receiveInteraction(GameItem other, Lemming owner) {
		return other.interactWith(owner);
	}

	@Override
	public boolean interactWith(Wall wall, Lemming owner) {
		if (owner.isInPosition(wall.getPos())) {
			wall.setAlive(false);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean interactWith(MetalWall metalWall, Lemming owner) {
		if (owner.isInPosition(metalWall.getPos())) {
			owner.up();
			owner.disableRole();
			owner.walkOrFall();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean interactWith(ExitDoor door, Lemming owner) {
		if (owner.isInPosition(door.getPos())){
			owner.setExit(true);
			owner.disableRole();
			return true;
		}
		
		return false;
	}

}
