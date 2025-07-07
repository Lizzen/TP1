package tp1.exceptions;

@SuppressWarnings("serial")
public class GameParseException extends GameModelException{
	public GameParseException (String descripcion) {
		super (descripcion);
	}
}
