package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject {
	
	public MetalWall(Game game, int row, int col) {
		super(game, row, col);
	}
	
	public Position getPos() {
		return this.pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}



	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return Messages.METALWALL;
	}

	@Override
	public boolean collision(int x, int y) {
		/*if (isInPosition(x, y)) {
			return true;
		}*/
		return false;
	}

	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
