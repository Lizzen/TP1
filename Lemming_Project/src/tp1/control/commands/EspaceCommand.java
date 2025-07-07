package tp1.control.commands;

import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GameView;

public class EspaceCommand extends NoParamsCommand {
	
	private static final String NAME = "\"";
	private static final String SHORTCUT = "";
	private static final String DETAILS = "";
	private static final String HELP = "";
	
	public EspaceCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	
	@Override
	public boolean execute(GameModel game, GameView view) {
		game.update();
		view.showGame();
		return false;
	}
}
