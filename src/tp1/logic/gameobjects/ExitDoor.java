package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	
	public ExitDoor(Game game, int x, int y) {
		super(game, x, y);
	}

	public Position getPos() {
		return pos;
	}
	
	public boolean isInPosition(int x, int y) {
		return pos.getRow() == x && pos.getCol() == y;
	}

	@Override
	public boolean isEstaVivo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return Messages.EXIT_DOOR;
	}

	@Override
	public boolean collision(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doorCollision(int x, int y) {
		if (isInPosition(x, y)) {
			return true;
		}
		return false;
	}
}
