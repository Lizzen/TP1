package tp1.exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends CommandException{
	public CommandExecuteException (String descripcion) {
		super (descripcion);
	}
}
