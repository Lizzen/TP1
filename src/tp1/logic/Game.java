package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer gobc;
	private int nLevel = 0;
	private int cycle = 0;
	private int lemmingsToWin;
	private boolean exit = false;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gobc = new GameObjectContainer(this);
		initGame(this.nLevel);
	}

	public void initGame(int nLevel){
		//Lemmings
		this.lemmingsToWin = 2;
		this.gobc.add(new Lemming(this, 3, 2));
		this.gobc.add(new Lemming(this, 8, 0));
		this.gobc.add(new Lemming(this, 0, 9));
		if (nLevel == 1) {
			this.gobc.add(new Lemming(this, 3, 3));
		}
		
		//Walls
		for(int i = 2; i < 5; i++) {
			this.gobc.add(new Wall(this, 4, i));
		}
		for(int i = 8; i < 11; i++) {
			this.gobc.add(new Wall(this, 1, i));
			this.gobc.add(new Wall(this, 9, i));
		}
		for(int i = 4; i < 8; i++) {
			this.gobc.add(new Wall(this, 6, i));
		}
		this.gobc.add(new Wall(this, 5, 7));
		this.gobc.add(new Wall(this, 8, 8));
		this.gobc.add(new Wall(this, 9, 0));
		this.gobc.add(new Wall(this, 9, 1));
		
		//ExitDoor
		this.gobc.add(new ExitDoor(this, 5, 4));
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
		return this.gobc.numLemmingsInBoard();
	}

	public int numLemmingsDead() {
		return this.gobc.getDeads();
	}

	public int numLemmingsExit() {
		return this.gobc.numLemmingsExit();
	}

	public int numLemmingsToWin() {
		return lemmingsToWin;
	}
	
	// Muestra el tablero
	public String positionToString(int col, int row) {
		Position p = new Position();
		p.setCol(col);
		p.setRow(row);
		return this.gobc.ObjectsInPosition(p);
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
	public boolean isFinished() {
		return  (playerWins() || playerLooses() || isExit());
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
