package tp1.logic.gameobjects;


import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject {
	private static final String NAME = "MetalWall";
	private static final String SHORTCUT = "MW";
	
	public MetalWall(GameWorld game, int row, int col) {
		super(game, row, col);
	}
	
	public MetalWall copy() {
		return new MetalWall(game, pos.getRow(), pos.getCol());
	}
	
	public MetalWall() {
		super(NAME, SHORTCUT);
	}
	public MetalWall(GameWorld game) {
		super(game);
	}
	
	@Override
	public MetalWall parse(String line, GameWorld game) {
		String[] input = line.trim().split("\\s+");
		if (matchRolName(input[1])) {
			this.game = game;
			return new MetalWall();
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

	public String toSave() {
		String ret="";
		ret+="("+this.pos.getRow()+","+this.pos.getCol()+") "+ NAME+ "\n";
		return ret;
	}
}
