package tp1.exceptions;

@SuppressWarnings("serial")
public class GameLoadException extends CommandException{
	public GameLoadException (String descripcion) {
		super (descripcion);
	}
}
