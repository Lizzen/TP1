package tp1.logic;

import java.util.ArrayList;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;


public class GameObjectContainer {
	protected Game game;
	protected int x, y;
	private  ArrayList<Lemming> lemmings;
	private  ArrayList<Wall> walls;
	private  ExitDoor exitDoor;
	
	public GameObjectContainer(Game game) {
		this.game = game;
		this.lemmings = new ArrayList<Lemming>();
		this.walls = new ArrayList<Wall>();
		this.exitDoor = null;
	}
	
	public void update() {
		for(Lemming GO: this.lemmings) {
			if (GO.isEstaVivo() || !GO.isWin()) {
				GO.update();
			}
			else if (!GO.isEstaVivo()) {
				removeDead(GO);
			}
		}
	}
	
	public void removeDead(Lemming lemming) {
		lemmings.remove(lemming);
	}
	
	public String ObjectsInPosition(int x, int y) {
		String ret = ""; 
		boolean esLemming = false;
		for(Lemming GO: this.lemmings) {
			if(!GO.isWin() && GO.isEstaVivo() && GO.isInPosition(x, y)) {
				ret += GO.toString();
				esLemming = true;
			}
		}
		
		if (!esLemming) {
			for(Wall GO: this.walls) {
				if(GO.isInPosition(x, y)) ret = Messages.WALL;			
			}
		}
		
		if (exitDoor.isInPosition(x, y)) ret += Messages.EXIT_DOOR;

		return ret;
	}
	
	public int numLemmingsInBoard() {
		int ret = 0;
		
		for(Lemming GO: this.lemmings) {
			if(GO.isEstaVivo() && !GO.isWin()) {
				ret++;
			}
		}
		return ret;
	}
	
	public int numLemmingsExit() {
		int ret = 0;
		for(Lemming GO: this.lemmings) {
			if(GO.isWin()) {
				ret++;
			}
		}
		return ret;
	}
	
    public void addLemming(Lemming lemming) {
    	this.lemmings.add(lemming);
    }
    
    public void addWall(Wall wall) {
    	this.walls.add(wall);
    }
    
    public boolean getCollision(int x, int y) {
    	boolean ret = false;
		for(Wall GO: this.walls) {
			if(GO.isInPosition(x, y)) ret = true;			
		}
		
		return ret;
    }
    
    public boolean doorCollision(int x, int y) {
		
		return this.exitDoor.isInPosition(x, y);
    }

	public int getWalls() {
    	return this.walls.size();
    }
    
    public Wall getWall(int i) {
    	return this.walls.get(i);
    }
    
    public int getLemmings() {
    	return this.lemmings.size();
    }
    
    public Lemming getLemming(int i) {
    	return this.lemmings.get(i);
    }

	public void addExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
		
	}
}
