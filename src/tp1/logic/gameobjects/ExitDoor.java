package tp1.logic.gameobjects;
import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	private static final String NAME = "ExitDoor";
	private static final String SHORTCUT = "ED";
	
	public ExitDoor(GameWorld game, int x, int y) {
		super(game, x, y);
	}
	
	public ExitDoor() {
		super(NAME, SHORTCUT);
	}
	public ExitDoor(GameWorld game) {
		super(game);
	}

	@Override
	public ExitDoor parse(String line, GameWorld game) {
		if (matchRolName(line)) {
			this.game = game;
			return new ExitDoor();
		}
		return null;
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
	public ExitDoor copy(){
		ExitDoor ret = new ExitDoor(this.game, this.pos.getRow(), this.pos.getCol());
		return ret;

	}

	public String toSave() {
		String ret="";
		ret+="("+this.pos.getRow()+","+this.pos.getCol()+") "+ NAME + "\n";
		return ret;
	}

}
