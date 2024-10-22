package tp1.logic;

import java.util.ArrayList;
import java.util.Iterator;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class GameObjectContainer {
	protected Game game;
	private int x, y;
	private  ArrayList<GameObject> objetos;
	private  ArrayList<Wall> walls;
	private  ExitDoor exitDoor;
	private int deads = 0;
	private int nlemmings=0;
	
	public GameObjectContainer(Game game) {
		this.game = game;
		this.objetos = new ArrayList<GameObject>();
		this.walls = new ArrayList<Wall>();
		this.exitDoor = null;
	}
	
	public void update() {
	    Iterator<GameObject> iterator = lemmings.iterator();
	    while (iterator.hasNext()) {
	    	GameObject GO = iterator.next();
	        if (GO.isEstaVivo() && !GO.isWin()) {
	            GO.update();
	        }
	        if (!GO.isEstaVivo()) {
	            iterator.remove(); 
	            deads++;
	        }
	    }
	}
	public void add(GameObject obj) {
		objetos.add(obj);
	}
	
	public int getDeads() {
		return deads;
	}
	
	public String ObjectsInPosition(Position posicion) {
		String ret = ""; 
		/*boolean esLemming = false;
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
		
		if (exitDoor.isInPosition(x, y)) ret += Messages.EXIT_DOOR;*/
		for(GameObject Go: this.objetos) {
			if(Go.isInPosition(posicion))
				ret+=Go.toString();
		}

		return ret;
	}
	
	public int numLemmingsInBoard() {
		/*int ret = 0;
		
		for(Lemming GO: this.lemmings) {
			if(GO.isEstaVivo() && !GO.isWin()) {
				ret++;
			}
		}
		return ret;*/
		return this.nlemmings;
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
	
    public void addLemming() {
    	this.nlemmings++;
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
    
    public int getLemmings() {
    	return this.lemmings.size();
    }

	public void addExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
		
	}
}
