package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class ExitDoor extends GameObject {
	private Position pos;
	private Game game;
	
	public ExitDoor(Game game, int x, int y) {
		this.pos = new Position();
		this.pos.setRow(x);
		this.pos.setCol(y);
		this.game = game;
	}

	public Position getPos() {
		return pos;
	}
	
	public boolean isInPosition(int x, int y) {
		return this.pos.getRow() == x && this.pos.getCol() == y;
	}
}
