package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class WalkerRole implements LemmingRole {
	
	private static final String NAME = Messages.WALKER_ROL_NAME;
	private static final String HELP = Messages.WALKER_ROL_HELP;
	private static final String ICON_RIGHT = Messages.LEMMING_RIGHT;
	private static final String ICON_LEFT = Messages.LEMMING_LEFT;
	
	public void play(Lemming lemming) {
		lemming.walkOrFall();
	}
	
	public String getIcon(Lemming lemming) {
		String Symbol;
		
		if(lemming.getDireccion() == Direction.RIGHT) Symbol = ICON_RIGHT;
		else Symbol = ICON_LEFT;
		
		return Symbol;
	}
	
	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getHelp() {
		return HELP;
	}
	
	// String that represents the object status
	// for this simple class, the name is enough
	@Override
	public String toString() {
		return getName();
	}
}
