package tp1.control.commands;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command {
    private static final String NAME = Messages.COMMAND_LOAD_NAME;
	private static final String SHORTCUT =  Messages.COMMAND_LOAD_SHORTCUT;
	private static final String DETAILS =  Messages.COMMAND_LOAD_DETAILS;
	private static final String HELP =  Messages.COMMAND_LOAD_HELP;
    private String fileName;
    @Override
    public boolean execute(GameModel game, GameView view) throws CommandExecuteException {
        try {
            game.load(fileName);
            view.showGame();
        } catch (GameLoadException e) {
            throw new CommandExecuteException(Messages.ERROR_INVALID_FILE.formatted(fileName), e);
        }
        
        return false;
    }

    @Override
    public Command parse(String[] words) throws CommandParseException {
    	if (!matchCommandName(words[0])) {
    		return null;
    	}
        if(matchCommandName(words[0]) && words.length == 2) {
            this.fileName = words[1];
            return this;
        }
        return null;
    }
    public LoadCommand (){
        super(NAME, SHORTCUT, DETAILS, HELP);
    }
}
