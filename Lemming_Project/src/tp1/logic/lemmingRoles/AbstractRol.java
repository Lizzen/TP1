package tp1.logic.lemmingRoles;

import tp1.logic.GameItem;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public abstract class AbstractRol implements LemmingRole{
	private final String NAME;
	private final String SHORTCUT;
	private final String HELP;
	private final String DETAILS;
	
	public AbstractRol(String name, String help, String details, String shortcut) {
		NAME = name;
		HELP = help;
		DETAILS = details;
		SHORTCUT = shortcut;	
	}
	
	protected boolean matchRolName(String name) {
		return getName().equalsIgnoreCase(name) || getShortcut().equalsIgnoreCase(name);
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getHelp() {
		return HELP;
	}
	
	public String getDetails() {
		return DETAILS;
	}
	
	public String getShortcut() {
		return SHORTCUT;
	}
	
	public String helpText() {
		return Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails() , getHelp())); 
	}

	public LemmingRole parse(String input) {
		if(matchRolName(input)) {
			return this;
		} 

		return null;
	}
	
	@Override
	public boolean receiveInteraction(GameItem other, Lemming owner) {
		return false;
	}
	
	@Override
	public boolean interactWith(Lemming receiver, Lemming owner) {
		return false;
	}
	
	@Override
	public boolean interactWith(Wall wall, Lemming owner) {
		return false;
	}
	
	@Override
	public boolean interactWith(ExitDoor door, Lemming owner) {
		if (owner.getPos().equals(door.getPos())){
			if (owner.isExit()) {
				owner.setWin(true);
			}
			else {
				owner.setExit(true);
			}
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean interactWith(MetalWall metalWall, Lemming owner) {
		return false;
	}
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		AbstractRol p = (AbstractRol) obj;
		return p.NAME == this.NAME;
	}
}
