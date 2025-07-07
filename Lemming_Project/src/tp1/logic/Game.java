package tp1.logic;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
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
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private boolean exit = false;
	FileGameConfiguration conf;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.gobc = new GameObjectContainer(this);
		conf = new FileGameConfiguration();
		if (this.nLevel < 2) {
			initGame(this.nLevel);
		}
		else {
			initGame2();
		}
	}
	
	public void load(String fileName) throws  GameLoadException{
		try{
		this.conf = new FileGameConfiguration(fileName, this);
		this.cycle = this.conf.getCycle();
		this.numLemmingsInBoard = this.conf.numLemmingsInBoard();
		this.lemmingsToWin = this.conf.numLemmingsToWin();
		this.numLemmingsDead = this.conf.numLemmingsDead();
		this.numLemmingsExit=this.conf.numLemmingsExit();
		this.gobc = this.conf.getGameObjects();
		}catch(GameLoadException e){
			throw e;
		}
	}
	public void initGame(int nLevel){
		//Lemmings
		this.numLemmingsExit=0;
		this.numLemmingsDead=0;
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
		for(int i = 8; i < 10; i++) {
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
		this.numLemmingsExit=0;
		this.numLemmingsDead=0;
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
	
	public void reset() throws GameLoadException {
		if(this.conf.equals(FileGameConfiguration.NONE)){//si es igual a un FileGameConfiguration vacio, reset normal
			this.numLemmingsInBoard = 0;
			this.gobc = new GameObjectContainer(this);
			if (this.nLevel < 2) {
				initGame(this.nLevel);
			}
			else {
				initGame2();
			}
			this.cycle = 0;
		}else{// si no reseteamos con el fichero
			try {
				load(this.conf.getFileName());
			} catch (GameLoadException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
	}
	
	public void reset(int nLevel) throws GameLoadException {
			this.nLevel = nLevel;
			this.numLemmingsInBoard = 0;
			this.gobc = new GameObjectContainer(this);
			this.cycle = 0;
			if (this.nLevel < 2) {
				initGame(this.nLevel);
			}
			else {
				initGame2();
			}
	}

	public int getCycle() {
		return this.cycle;
	}

	public int numLemmingsInBoard() {
		return numLemmingsInBoard - numLemmingsDead() - numLemmingsExit();
	}

	public int numLemmingsDead() {
		return numLemmingsDead;
	}

	public int numLemmingsExit() {
		return numLemmingsExit;
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
	
	public boolean setRole(LemmingRole rol, Position pos) throws OffBoardException, RoleParseException {
		try {
			boolean ret = this.gobc.setRole(rol, pos);
			return ret;
		} catch (OffBoardException e) {
			throw e;
		}
		catch (RoleParseException e) {
			throw e;
		}
	}

	@Override
	public boolean receiveInteractionsFrom(GameItem item) {
		return this.gobc.receiveInteractionsFrom(item);
	}
	
	public void addDead() {
		this.numLemmingsDead++;
	}
	
	public void addExit() {
		this.numLemmingsExit++;
	}
	
	public String toSave() {
		String ret = "";
		ret += this.cycle +" "+ this.numLemmingsInBoard() +" "+ this.numLemmingsDead +" "+ this.numLemmingsExit +" "+ this.lemmingsToWin + "\n";
		ret += this.gobc.toSave();
		return ret;
	}
	public void save(String fileName) throws GameModelException {
		
		try{
			File ficheroSalida = new File(fileName);
			FileWriter salida = new FileWriter(ficheroSalida);
			BufferedWriter writer = new BufferedWriter(salida);
			writer.write(this.toSave());
			writer.close();

		}catch(Exception e){
			throw new GameModelException("Error al guardar el fichero");
		}
		
	}
}
