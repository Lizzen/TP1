package tp1.exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends CommandException{
	public CommandExecuteException (String descripcion, OffBoardException obe) {
		super (descripcion + obe.toString());
	}
}
