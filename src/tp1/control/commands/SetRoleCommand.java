package tp1.control.commands;

import tp1.logic.GameModel;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT1 = Messages.COMMAND_SETROLE_SHORTCUT1;
	private static final String SHORTCUT2 = Messages.COMMAND_SETROLE_SHORTCUT2;
	private static final String DETAILS =  Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP =  Messages.COMMAND_SETROLE_HELP;

	public SetRoleCommand() {
		super(NAME, SHORTCUT1, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(GameModel game, GameView view) {
		
		return false;
	}

	@Override
	public Command parse(String[] words) {
		LemmingRole role;
		if(matchCommandName(words[0])) {
			role = LemmingRoleFactory.parse(words[1]);
			if (role != null) {
				return this;
			}
		} 
		return null;
	}

}
