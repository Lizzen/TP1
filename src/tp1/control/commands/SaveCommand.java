package tp1.control.commands;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class SaveCommand extends Command {
    private static final String NAME = Messages.COMMAND_SAVE_NAME;
	private static final String SHORTCUT =  Messages.COMMAND_SAVE_SHORTCUT;
	private static final String DETAILS =  Messages.COMMAND_SAVE_DETAILS;
	private static final String HELP =  Messages.COMMAND_SAVE_HELP;
    private String fileName;
    @Override
    public boolean execute(GameModel game, GameView view) throws CommandExecuteException {
        try {
            game.save(fileName);
            view.showMessage(Messages.COMMAND_SAVE_SUCCES.formatted(fileName));
        } catch (GameModelException e) {
            throw new CommandExecuteException(" Error al guardar " + fileName + "configuration", e);
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
    public SaveCommand (){
        super(NAME, SHORTCUT, DETAILS, HELP);
    }
}
