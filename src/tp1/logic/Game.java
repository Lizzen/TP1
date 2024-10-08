package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
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
	private ExitDoor exitDoor;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gobc = new GameObjectContainer(this);
		initGame(this.nLevel);
	}
	
	public void initGame(int nLevel){
		this.lemming = new Lemming(this, 3, 2); this.gobc.addLemming(this.lemming);
		this.lemming = new Lemming(this, 8, 0); this.gobc.addLemming(this.lemming);
		this.lemming = new Lemming(this, 0, 9); this.gobc.addLemming(this.lemming);

		for(int i = 2; i < 5; i++) {
			this.wall = new Wall(this, 4, i); this.gobc.addWall(this.wall);
		}
		int j = 0;
		for(int i = 8; i < 11; i++) {
			this.wall = new Wall(this, 1, i); this.gobc.addWall(this.wall);
			this.wall = new Wall(this, 9, i); this.gobc.addWall(this.wall);
			this.wall = new Wall(this, 9, j); this.gobc.addWall(this.wall);
			++j;
		}
		for(int i = 4; i < 8; i++) {
			this.wall = new Wall(this, 6, i); this.gobc.addWall(this.wall);
		}
		this.wall = new Wall(this, 5, 7); this.gobc.addWall(this.wall);
		this.wall = new Wall(this, 8, 8); this.gobc.addWall(this.wall);
		this.exitDoor = new ExitDoor(this, 5, 4); this.gobc.addExitDoor(this.exitDoor);
		
		if (nLevel == 1) {
			this.lemming = new Lemming(this, 3, 3); this.gobc.addLemming(this.lemming);
		}
	}
	
	public void update() {
		this.cycle++;
		this.gobc.update();
	}
	
	public void reset() {
		this.gobc = new GameObjectContainer(this);
		initGame(this.nLevel);
		this.cycle = 0;
	}

	public int getCycle() {
		return this.cycle;
	}

	public int numLemmingsInBoard() {
		int ret = 0;
		for (int i = 0; i < this.gobc.getLemmings(); i++) {
			if (this.gobc.getLemming(i).isEstaVivo() && !this.gobc.getLemming(i).isWin()) {
				ret++;
			}
		}
		return ret;
	}

	public int numLemmingsDead() {
		int ret = 0;
			ret = this.gobc.getLemmings() - numLemmingsInBoard(); 
		return ret;
	}

	public int numLemmingsExit() {
		int ret = 0;
		for (int i = 0; i < this.gobc.getLemmings(); i++) {
			if (this.gobc.getLemming(i).isWin()) {
				ret++;
			}
		}
		return ret;
	}

	public int numLemmingsToWin() {
		return 2;
	}
	
	// Muestra el tablero
	/*Preguntar si hace falta hacerlo con la clase Message*/
	public String positionToString(int col, int row) {		
		return this.gobc.ObjectsInPosition(row, col);
	}
	
	public boolean playerWins() {
		return numLemmingsExit() >= numLemmingsToWin();
	}

	public boolean playerLooses() {
		return numLemmingsInBoard() == 0 && !playerWins();
	}
	
	public boolean collision(int x, int y) {
		return this.gobc.getCollision(x, y);
	}

	public boolean doorCollision(int x, int y) {
		return this.gobc.doorCollision(x, y);
	}
	
	public String help() {
		return Messages.HELP;
	}
	
	public String error() {
		return Messages.UNKNOWN_COMMAND + "\n";
	}

}
