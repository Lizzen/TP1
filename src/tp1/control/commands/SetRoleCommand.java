package tp1.control.commands;

import tp1.logic.GameModel;
import tp1.logic.Position;
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
	private Position pos;
	private LemmingRole role;

	public SetRoleCommand() {
		super(NAME, SHORTCUT1, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(GameModel game, GameView view) {
		game.setRole(role, pos);
		game.update();
		view.showGame();
		return false;
	}
	
	protected boolean dentroRango(int x, int y) {
		return x < 10 && x >=0 && y < 10 && y >= 0;
	}

	@Override
	public Command parse(String[] words) {
		if(matchCommandName(words[0])) {
			int x =  words[2].charAt(0) - 'A';
			int y = Integer.parseInt(words[3]) - 1;
			role = LemmingRoleFactory.parse(words[1]);
			if (role != null && dentroRango(x, y)) {
				this.pos = new Position(x, y);
				return this;
			}
		} 
		return null;
	}

}
