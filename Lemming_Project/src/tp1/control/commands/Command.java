package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public abstract class Command {
	private final String NAME;
	private final String SHORTCUT;
	private final String DETAILS;
	private final String HELP;
	
	public Command(String name, String shortcut, String details, String help) {
		NAME = name;
		SHORTCUT = shortcut;
		DETAILS = details;
		HELP = help;
	}
	
	public abstract boolean execute (GameModel game, GameView view) throws CommandExecuteException;

	public abstract Command parse(String[] words) throws CommandParseException;
	
	protected boolean matchCommandName(String name) {
		return getShortcut().equalsIgnoreCase(name) 
				|| getName().equalsIgnoreCase(name);

	}
	
	public String helpText() {
		return Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp())); 
	}
	
	// Getters & Setters
	protected String getDetails() {		
		return this.DETAILS;
	}
	
	protected String getHelp() {		
		return this.HELP;
	}

	protected String getName() {
		return this.NAME;
	}
	
	protected String getShortcut() {
		return this.SHORTCUT;
	}
}
