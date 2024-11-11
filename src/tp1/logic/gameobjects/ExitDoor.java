package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	
	public ExitDoor(Game game, int x, int y) {
		super(game, x, y);
	}

	public Position getPos() {
		return pos;
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
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}

	@Override
	public boolean interactWith(Lemming lemming) {
		return false;
	}

	@Override
	public boolean interactWith(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean interactWith(ExitDoor door) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExit() {
		// TODO Auto-generated method stub
		return false;
	}
}
