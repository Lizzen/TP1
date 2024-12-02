package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SETROLE_SHORTCUT;
	private static final String DETAILS =  Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP =  Messages.COMMAND_SETROLE_HELP;
	private Position pos;
	private LemmingRole role;

	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(GameModel game, GameView view) throws CommandExecuteException {
		try {
			if (game.setRole(role, pos)) {
				game.update();
				view.showGame();
			}
			else {
				view.showError("SetRoleCommand error (Incorrect position or no object in that position admits that role)");
			}
		} catch (OffBoardException obe) {
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, obe);
		}
		catch (RoleParseException e) {
			throw new CommandExecuteException(e.getMessage());
		}

		return false;
	}
	
	@Override
	public Command parse(String[] words) throws CommandParseException {
		if (words.length < 1 || !matchCommandName(words[0]))
	 		return null;
		
		if(matchCommandName(words[0]) && words.length < 5) {
			try {
				int x = (words[2].charAt(0)) - 'A';
				int y = Integer.parseInt(words[3]) - 1;
				
				
				try {
					role = LemmingRoleFactory.parse(words[1]);
				} catch (RoleParseException e) {
					throw new CommandParseException(Messages.INVALID_COMMAND_PARAMS, e);
				}
				
				if (role != null) {
					this.pos = new Position(x, y);
					return this;
				}
				
			} catch (NumberFormatException e) {
			 	throw new CommandParseException(Messages.INVALID_POSITION.formatted
			 	 		(Messages.POSITION.formatted(words[2], words[3])));
			}
		} 

		throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
	}
	
	@Override
	public String helpText() {
		String ret = Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp()));
		ret += LemmingRoleFactory.commandHelp();
		return ret; 
	}

}
