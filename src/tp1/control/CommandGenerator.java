package tp1.control;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {
	private static final List<Command> AVAILABLE_COMMANDS =
			Arrays.asList( new ExitCommand(), new HelpCommand(), new ResetCommand(),new NoneCommand());

	public static List<Command> getAvailableCommands() {
		return AVAILABLE_COMMANDS;
	}
	public static Command parse(String[] commandWords) {
		for (Command c: AVAILABLE_COMMANDS) {
		// TODO
			if (c.parse(commandWords)!=null) {
				return c.parse(commandWords);
			}
		}
		return null;
		}
	//public static String commandHelp() { ;}
}
