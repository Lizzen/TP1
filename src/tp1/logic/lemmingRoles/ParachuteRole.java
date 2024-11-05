package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class ParachuteRole extends AbstractRol implements LemmingRole{
	
	private static final String NAME = Messages.PARACHUTE_ROL_NAME;
	private static final String HELP = Messages.PARACHUTE_ROL_HELP;
	private static final String ICON = Messages.LEMMING_PARACHUTE;
	
	public ParachuteRole() {
		super(NAME);
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
}
