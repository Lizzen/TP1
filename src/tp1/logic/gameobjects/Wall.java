package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall extends GameObject {
	
	public Wall(Game game, int row, int col) {
		super(game, row, col);
	}
	
	public Position getPos() {
		return this.pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
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
		return Messages.WALL;
	}
}
