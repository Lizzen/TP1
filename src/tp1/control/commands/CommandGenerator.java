package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

public class CommandGenerator {
	
	private static final List<Command> AVAILABLE_COMMANDS =
			Arrays.asList( 
					new SetRoleCommand(),
					new NoneCommand(),
					new ResetCommand(),
					new LoadCommand(),
					new SaveCommand(),
					new HelpCommand(),
					new ExitCommand()
			);

	
	
	public static Command parse(String[] words) throws CommandParseException{
		Command ret = null;
		
		if (words[0].equalsIgnoreCase("")) {
			return AVAILABLE_COMMANDS.get(1);
		}
		for (Command C: AVAILABLE_COMMANDS) {
			try {
				ret = C.parse(words);
				if (ret != null) {
					return ret;
				}
			} catch (CommandParseException e) {
				throw e;
			}
		}

		 throw new CommandParseException(Messages.UNKNOWN_COMMAND.formatted(words[0]));
	}
	
	public static String commandHelp() {
		String ret = "";
		
		for (Command C: AVAILABLE_COMMANDS) {
			ret += C.helpText();
		}
		
		return ret;
	}
}
