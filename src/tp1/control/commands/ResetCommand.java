package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
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
	private int level = 10;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	
	@Override
	public boolean execute(GameModel game, GameView view) throws CommandExecuteException {
		try {
			if (level != 10) {
				game.reset(level);
				level = 10;
			}
			else {
				game.reset();
			}
			
		} catch (GameLoadException e) {
			// TODO Auto-generated catch block
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, e);
		}
		view.showGame();
		return false;
	}
	
    @Override
    public Command parse(String[] words) throws CommandParseException {
    	if (!matchCommandName(words[0])) {
    		return null;
    	}
    	
        if(matchCommandName(words[0])) {
        	try {
        		if (words.length > 1) {
                	this.level = Integer.parseInt(words[1]);
                	if (level < 0 || level > 2) {
                		throw new CommandParseException(Messages.INVALID_LEVEL_NUMBER);
                	}
                }
                return this;
        	} catch (NumberFormatException e){
        		throw new CommandParseException(Messages.LEVEL_NOT_A_NUMBER);
        	}    
        }
        return null;
    }
}
