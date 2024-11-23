package tp1.exceptions;

@SuppressWarnings("serial")
public class CommandException extends Exception{
	public CommandException (String descripcion) {
		super (descripcion);
	}
}
