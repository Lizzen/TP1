package tp1.logic.gameobjects;

import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	private static final String NAME = "ExitDoor";
	private static final String SHORTCUT = "ED";
	
	public ExitDoor() {
		super(NAME, SHORTCUT);
	}

	public Position getPos() {
		return pos;
	}
	
	public String getNAME() {
		return NAME;
	}

	public String getSHORTCUT() {
		return SHORTCUT;
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
}
