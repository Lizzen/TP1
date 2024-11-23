package tp1.exceptions;

@SuppressWarnings("serial")
public class OffBoardException extends CommandException{

	public OffBoardException(String descripcion) {
		super(descripcion);
	}

}
