package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer gobc;
	private int nLevel = 1;
	private int cycle = 0;
	private Lemming lemming;
	private Wall wall;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gobc = new GameObjectContainer(this);
		initGame();
	}
	
	public void initGame() {
		this.lemming = new Lemming(this, 2, 4); this.gobc.addLemming(this.lemming);
		this.lemming = new Lemming(this, 8, 9); this.gobc.addLemming(this.lemming);
		this.wall = new Wall(this, 3, 4); this.gobc.addWall(this.wall);
	}
	
	public void update() {
		this.cycle++;
		this.gobc.update();
	}
	
	public void reset() {
		this.gobc = new GameObjectContainer(this);
		initGame();
		this.cycle = 0;
	}

	public int getCycle() {
		return this.cycle;
	}

	public int numLemmingsInBoard() {
		int ret = 0;
		for (int i = 0; i < gobc.getLemmings();  ++i) {
			if (gobc.getLemming(i).isEstaVivo()) {
				ret++;
			}
		}
		return ret;
	}

	public int numLemmingsDead() {
		int ret = 0;
			ret = gobc.getLemmings() - numLemmingsInBoard(); 
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
	/*Preguntar si hace falta hacerlo con la clase Message*/
	public String positionToString(int col, int row) {		
		String ret = ""; 	
		for (int i = 0; i < this.gobc.getLemmings(); ++i) {
			Position pos = this.gobc.getLemming(i).getPos();
			if (col == pos.getCol() && row == pos.getRow()) {
				ret = this.gobc.getLemming(i).toString();
			}
		}
		
		for (int i = 0; i < this.gobc.getWalls(); ++i) {
			Position pos = this.gobc.getWall(i).getPos();
			if (col == pos.getCol() && row == pos.getRow()) {
				ret = this.gobc.getWall(i).toString();
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
		return Messages.HELP;
	}
	
	public String error() {
		return Messages.UNKNOWN_COMMAND + "\n";
	}

}
