package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class Wall {

	private Position pos;
	private String SYMBOL = "▓";
	private Game game;
	
	public Wall(Game game, int row, int col) {
		this.pos = new Position();
		this.pos.setCol(col);
		this.pos.setRow(row);
		this.game = game;
	}
	
	public String toString() {
		return SYMBOL;
	}
	
	public Position getPos() {
		return this.pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}

}
