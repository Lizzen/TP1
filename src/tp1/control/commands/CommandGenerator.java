package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {
	public CommandGenerator() {
		
	}
	
	private static final List<Command> AVAILABLE_COMMANDS =
			Arrays.asList( 
					new NoneCommand(),
					new EspaceCommand(),
					new ExitCommand(),
					new HelpCommand(),
					new ResetCommand()
			);

	
	
	public static Command parse(String[] words) {
		Command ret = null;
		
		for (Command C: AVAILABLE_COMMANDS) {
			ret = C.parse(words);
			if (ret != null) {
				return ret;
			}
		}

		return null;
	}
	
	public static String commandHelp() {
		String ret = "";
		
		for (Command C: AVAILABLE_COMMANDS) {
			ret += C.helpText();
		}
		
		return ret;
	}
}
