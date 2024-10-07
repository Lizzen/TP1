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
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		System.out.print("Command > ");
		Scanner input = new Scanner(System.in);
		String texto = input.nextLine();
		while (!texto.equals("e") && !(this.game.playerWins() || this.game.playerLooses())) {
			switch(texto) {
			case("r"):
			case("reset"):
				this.game.reset();
				view.showGame();
				this.game.update();
				break;
			case("h"):
			case("help"):
				System.out.print(this.game.help());
				break;
			case("n"):
			case(""):
			case("none"):
				view.showGame();
				this.game.update();
				break;
			default:
				System.out.print(this.game.error());
				break;
			}
			System.out.print("Command > ");
			input = new Scanner(System.in);
			texto = input.nextLine();
		}
		view.showEndMessage();
	}
}
