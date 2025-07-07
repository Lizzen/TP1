package tp1.exceptions;

@SuppressWarnings("serial")
public class GameModelException extends Exception{

	public GameModelException (String descripcion) {
		super (descripcion);
	}
	
	public GameModelException (String descripcion, Throwable cause) {
		super (descripcion, cause);
	}
}
