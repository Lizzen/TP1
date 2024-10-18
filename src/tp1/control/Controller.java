package tp1.control;

import java.util.Scanner;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}

	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		view.showWelcome();
		view.showGame();
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		String[] texto = new String[1];
		texto[0] = "";
		while (!texto[0].equalsIgnoreCase("e") && !(this.game.playerWins() || this.game.playerLooses())) {
			texto = view.getPrompt();
			if (texto.length > 1) {
				view.showError(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			}
			else {
				switch(texto[0]) {
				case("r"):
				case("reset"):
					this.game.reset();
					view.showGame();
					break;
				case("h"):
				case("help"):
					view.showMessage(Messages.HELP);
					break;
				case("n"):
				case(""):
				case("none"):
					this.game.update();
					view.showGame();
					break;
				case("e"):
				case("exit"):
					break;
				default:
					view.showError(Messages.UNKNOWN_COMMAND);
					break;
				}
			}
			
		}
		view.showEndMessage();
	}
}
