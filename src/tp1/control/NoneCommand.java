package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class NoneCommand extends NoParamsCommand{

	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;
	
	public NoneCommand() {
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
		return str.equalsIgnoreCase(NAME)||str.equalsIgnoreCase(SHORTCUT)||str.equals("");
			
	}

}
