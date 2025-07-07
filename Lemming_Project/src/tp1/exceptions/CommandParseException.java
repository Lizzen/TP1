package tp1.exceptions;

@SuppressWarnings("serial")
public class CommandParseException extends CommandException{
	
	public CommandParseException (String descripcion) {
		super (descripcion);
	}
	
	public CommandParseException (String descripcion, Throwable cause) {
		super (descripcion, cause);
	}
}
