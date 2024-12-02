package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT =  Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS =  Messages.COMMAND_RESET_DETAILS;
	private static final String HELP =  Messages.COMMAND_RESET_HELP;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	
	@Override
	public boolean execute(GameModel game, GameView view) throws CommandExecuteException {
		try {
			game.reset();
		} catch (GameLoadException e) {
			// TODO Auto-generated catch block
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, e);
		}
		view.showGame();
		return false;
	}
}
