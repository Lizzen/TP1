package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand{

	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;
	
	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);	}

	@Override
	public Command parse(String [] str) {
		// TODO Auto-generated method stub
		if (str.length > 0 && matchCommand(str[0])) {
	        return new ExitCommand();
	    }
		return null;
	}

	@Override
	public void execute(Game g, GameView view) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected boolean matchCommand(String str) {
		// TODO Auto-generated method stub
		return str.equalsIgnoreCase(NAME)||str.equalsIgnoreCase(SHORTCUT);
			
	}

}
