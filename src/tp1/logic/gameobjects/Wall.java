package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class Wall extends GameObject {

	private Position pos;
	private Game game;
	
	public Wall(Game game, int row, int col) {
		this.pos = new Position();
		this.pos.setCol(col);
		this.pos.setRow(row);
		this.game = game;
	}
	
	public Position getPos() {
		return this.pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public boolean isInPosition(int x, int y) {
		return this.pos.getRow() == x && this.pos.getCol() == y;
	}
}
