package tp1.logic;

import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.ParachuteRole;

public class Game implements GameModel, GameStatus, GameWorld{

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	private GameObjectContainer gobc;
	private int nLevel = 0;
	private int cycle = 0;
	private int lemmingsToWin;
	private int numLemmingsInBoard = 0;
	private boolean exit = false;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gobc = new GameObjectContainer(this);
		if (this.nLevel < 2) {
			initGame(this.nLevel);
		}
		else {
			initGame2();
		}
	}

	public void initGame(int nLevel){
		//Lemmings
		this.lemmingsToWin = 2;
		this.gobc.add(new Lemming(this, 3, 2, null));
		this.gobc.add(new Lemming(this, 8, 0, null));
		this.gobc.add(new Lemming(this, 0, 9, null));
		numLemmingsInBoard += 3;
		if (nLevel == 1) {
			this.gobc.add(new Lemming(this, 3, 3, null));
			numLemmingsInBoard++;
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
	
	public void initGame2(){
		//Lemmings
		this.lemmingsToWin = 2;
		this.gobc.add(new Lemming(this, 3, 2, null));
		this.gobc.add(new Lemming(this, 8, 0, null));
		this.gobc.add(new Lemming(this, 0, 9, null));
		this.gobc.add(new Lemming(this, 3, 3, null));
		this.gobc.add(new Lemming(this, 0, 6, null));
		this.gobc.add(new Lemming(this, 0, 6, new ParachuteRole()));
		numLemmingsInBoard += 6;
		
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
		this.gobc.add(new Wall(this, 5, 3));
		
		//MetalWalls
		this.gobc.add(new MetalWall(this, 6, 3));
		
		//ExitDoor
		this.gobc.add(new ExitDoor(this, 5, 4));
	}
	
	public void update() {
		this.cycle++;
		this.gobc.update();
	}
	
	public void reset() {
		this.numLemmingsInBoard = 0;
		this.gobc = new GameObjectContainer(this);
		if (this.nLevel < 2) {
			initGame(this.nLevel);
		}
		else {
			initGame2();
		}
		this.cycle = 0;
	}

	public int getCycle() {
		return this.cycle;
	}

	public int numLemmingsInBoard() {
		return numLemmingsInBoard - numLemmingsDead() - numLemmingsExit();
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
		Position p = new Position(row, col);
		return this.gobc.ObjectsInPosition(p);
	}
	
	public boolean playerWins() {
		return numLemmingsExit() >= numLemmingsToWin() && numLemmingsInBoard() == 0;
	}

	public boolean playerLooses() {
		return numLemmingsInBoard() == 0 && !playerWins();
	}
	
	@Override
	public boolean collision(int x, int y) {
		Position pos = new Position(x, y);
		return this.gobc.getCollision(pos);
	}
	
	public boolean isFinished() {
		return  (playerLooses() || isExit() || numLemmingsInBoard() == 0 && playerWins());
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	
	public boolean setRole(LemmingRole rol, Position pos) throws OffBoardException {
		try {
			boolean ret = this.gobc.setRole(rol, pos);
			return ret;
		} catch (OffBoardException e) {
			throw e;
		}
	}

	@Override
	public boolean receiveInteractionsFrom(GameItem item) {
		return this.gobc.receiveInteractionsFrom(item);
	}
}
