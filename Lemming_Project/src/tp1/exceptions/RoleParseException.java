package tp1.exceptions;

@SuppressWarnings("serial")
public class RoleParseException extends GameParseException{
	public RoleParseException (String descripcion) {
		super (descripcion);
	}
}
