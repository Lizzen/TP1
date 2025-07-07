package tp1;

import java.util.Locale;

import tp1.control.Controller;
import tp1.logic.Game;
import tp1.view.ConsoleView;
import tp1.view.GameView;
import tp1.view.Messages;

public class Main {

	/**
	 * Lemmings entry point
	 * 
	 * @param args Arguments for the game.
	 */
	public static void main(String[] args) {
		// Required to avoid issues with tests
		// Locale.of("es", "ES");
		// You can replace the following line by the previous line if using Java21
		Locale.setDefault(new Locale("es", "ES"));
		try {
			
			int nLevel = 1;
			if (args.length != 0) nLevel = Integer.parseInt(args[0]);

			Game game = new Game(nLevel);
			GameView view = new ConsoleView(game);
			Controller controller = new Controller(game, view);
					
			controller.run();
		} catch (NumberFormatException e) {
			System.out.println(String.format(Messages.LEVEL_NOT_A_NUMBER_ERROR, args[0]));
		}
	}
}

/*
 * 0 4 0 0 4 
(3,2) Lemming  RIGHT 0 Walker
(1,0) Wall 
(1,4) MetalWall 
(7,4) ExitDoor 

setRole Parachuter A 10
setRole Walker B 8
setRole DownCaver D 5
load conf_0
setRole W C 7
save patata

String.join(" ", Arrays.copyOfRange(words, 1, words.length));
public LemmingRole parse(String input) throws RoleParseException {
	if(input.startsWith("IW")) {
		try {
			String cargaS = input.replaceFirst("IW:", "");
			this.cargaVirica = Integer.parseInt(cargaS);
			return this;
		}
		catch (NumberFormatException e){
			throw new RoleParseException(Messages.UNKNOWN_ROLE_ARGS.formatted(input));
		}
	} 

	return null;
}

public void play(Lemming lemming) {
	if (!lemming.getCarga()) {
		lemming.setCarga(true);
	}
	lemming.walkOrFall();
	cargaVirica++;
	if (cargaVirica == 5) {
		lemming.setAlive(false);
	}
}
*/
