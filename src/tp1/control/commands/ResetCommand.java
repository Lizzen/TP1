package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends Command {
	
	private static final String NAME = "none";
	private static final String SHORTCUT = "n";
	private static final String DETAILS = "[n]one | \"\"";
	private static final String HELP = "user does not perform any action";
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	
	@Override
	public boolean execute(Game game, GameView view) {
		game.reset();
		view.showGame();
		return false;
	}

}
