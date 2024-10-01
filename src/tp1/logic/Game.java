package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer gob;
	private int nLevel = 1;
	private int cycle = 0;
	private Lemming lemming;
	private Wall wall;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gob = new GameObjectContainer();
		initGame();
	}
	
	public void initGame() {
		this.lemming = new Lemming(this, 2, 4); this.gob.addLemming(this.lemming);
		this.lemming = new Lemming(this, 8, 9); this.gob.addLemming(this.lemming);
		this.wall = new Wall(this, 3, 4); this.gob.addWall(this.wall);
	}

	public int getCycle() {
		return this.cycle;
	}

	public int numLemmingsInBoard() {
		int ret = 0;
		/*for (int i = 0; i < gob.getLemmings().length;  ++i) {
			if (gob.getLemming(i).isEstaVivo()) {
				ret++;
			}
		}*/
		return ret;
	}

	public int numLemmingsDead() {
		int ret = 0;
			//ret = gob.getLemmings().length - numLemmingsInBoard(); 
		return ret;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Muestra el tablero
	public String positionToString(int col, int row) {		
		String ret = ""; 	
		for (int i = 0; i < this.gob.getLemmings(); ++i) {
			Position pos = this.gob.getLemming(i).getPos();
			if (col == pos.getCol() && row == pos.getRow()) {
				ret = this.gob.getLemming(i).toString();
			}
		}
		
		for (int i = 0; i < this.gob.getWalls(); ++i) {
			Position pos = this.gob.getWall(i).getPos();
			if (col == pos.getCol() && row == pos.getRow()) {
				ret = this.gob.getWall(i).toString();
			}
		}
		return ret;
	}
	
	public boolean playerWins() {
		
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

}
