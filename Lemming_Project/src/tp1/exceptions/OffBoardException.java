package tp1.exceptions;

@SuppressWarnings("serial")
public class OffBoardException extends GameModelException{

	public OffBoardException(String descripcion) {
		super(descripcion);
	}

}
