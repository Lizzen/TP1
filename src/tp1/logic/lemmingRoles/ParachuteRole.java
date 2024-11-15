package tp1.logic.lemmingRoles;

import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class ParachuteRole extends AbstractRol implements LemmingRole{
	
	private static final String NAME = Messages.PARACHUTE_ROL_NAME;
	private static final String DETAILS = Messages.PARACHUTE_ROL_DETAILS;
	private static final String HELP = Messages.PARACHUTE_ROL_HELP;
	private static final String SHORTCUT = Messages.PARACHUTE_ROL_SYMBOL;
	private static final String ICON = Messages.LEMMING_PARACHUTE;
	
	public ParachuteRole() {
		super(NAME, HELP, DETAILS, SHORTCUT);
	}

	@Override
	public void play(Lemming lemming) {
		lemming.setCaida(0);
		lemming.walkOrFall();
	}

	@Override
	public String getIcon(Lemming lemming) {
		return ICON;
	}

	@Override
	public boolean interactWith(Wall wall, Lemming owner) {
		if (owner.getPos().equals(wall.getPos())) {
			Position pos = owner.getPos();
			pos.setRow(pos.getRow() -1);
			owner.setPos(pos);
			owner.disableRole();
			return true;
		}
		
		return false;
	}
}
