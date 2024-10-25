package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends Command {
	
	private static final String NAME = "none";
	private static final String SHORTCUT = "n";
	private static final String DETAILS = "[n]one | \"\"";
	private static final String HELP = "user does not perform any action";
	
	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	
	@Override
	public boolean execute(Game game, GameView view) {
		view.showMessage(Messages.HELP);
		return false;
	}
}
