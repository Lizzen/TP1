package tp1.logic.gameobjects;


import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall extends GameObject {
	private static final String NAME = "Wall";
	private static final String SHORTCUT = "W";
	
	public Wall(GameWorld game, int row, int col) {
		super(game, row, col);
	}
	
	public Wall() {
		super(NAME, SHORTCUT);
	}
	public Wall(GameWorld game) {
		super(game);
	}
	public Wall copy() {
		return new Wall(game, pos.getRow(), pos.getCol());
	}
	
	@Override
	public Wall parse(String line, GameWorld game) {
		if (matchRolName(line)) {
			this.game = game;
			return new Wall();
		}
		return null;
	}

	
	public void setPos(Position pos) {
		this.pos = pos;
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
	public boolean isSolid() {
		return true;
	}

	@Override
	public String toString() {
		return Messages.WALL;
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
	public String toSave() {
		String ret="";
		ret+="("+this.pos.getRow()+","+this.pos.getCol()+") "+ NAME + "\n";
		return ret;
	}
}
