package tp1.control.commands;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public Command parse(String[] words) {
		
		if(matchCommandName(words[0])) {
			if (words.length == 1) {			
				return this;		
			}
		} 

		return null;
	}
}
