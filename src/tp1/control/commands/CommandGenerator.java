package tp1.control.commands;

public class CommandGenerator {
	public CommandGenerator() {
		
	}
	
	protected static final Command[] AVAILABLE_COMMANDS = {
			new NoneCommand(),
			new EspaceCommand(),
			new ExitCommand(),
			new HelpCommand(),
			new ResetCommand(),
	};
	
	
	public static Command parse(String[] words) {
		Command ret = null;
		for (Command C: AVAILABLE_COMMANDS) {
			if(C.matchCommandName(words[0])) {
				if (words.length == 1) {			
					ret = C;
					if(ret != null) return ret;		
				}
			} 
		}

		return ret;
	}
}
