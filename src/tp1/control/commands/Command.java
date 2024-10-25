package tp1.control.commands;

import tp1.logic.Game;
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
	
	public boolean matchCommandName(String name) {
		return this.NAME.equalsIgnoreCase(name) || this.SHORTCUT.equalsIgnoreCase(name);
	}
	
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

	public abstract boolean execute (Game game, GameView view);
}
