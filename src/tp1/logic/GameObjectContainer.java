package tp1.logic;

import java.util.ArrayList;
import java.util.Iterator;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.view.Messages;

public class GameObjectContainer {
	protected Game game;
	private  ArrayList<GameObject> objects;
	private int deads = 0;

	public GameObjectContainer(Game game) {
		this.game = game;
		this.objects = new ArrayList<GameObject>();
	}
	
	public void update() {
	    Iterator<GameObject> iterator = objects.iterator();
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
		this.objects.add(obj);
	}
	
	public int getDeads() {
		return deads;
	}
	
	public String ObjectsInPosition(Position posicion) {
		String ret = ""; 

		for(GameObject GO: this.objects) {
			if(GO.isInPosition(posicion) && !GO.isWin())
				ret+=GO.toString();
		}

		return ret;
	}
	
	public boolean setRole(LemmingRole rol, Position posicion) {
		for(GameObject GO: this.objects) {
			if(GO.isInPosition(posicion) && GO.setRole(rol))
				return true;
		}

		return false;
	}
	
	public int numLemmingsExit() {
		int ret = 0;
		for(GameObject GO: this.objects) {
			if(GO.isWin()) {
				ret++;
			}
		}
		return ret;
	}
    
    public boolean getCollision(Position pos) {
		for(GameObject GO: this.objects) {
			if(GO.isInPosition(pos) && GO.isSolid()) return true;			
		}
		
		return false;
    }
    
    public int getobjectsSize() {
    	return this.objects.size();
    }

	public boolean receiveInteractionsFrom(GameItem item) {
		for(GameObject GO: this.objects) {
			if (GO.receiveInteraction(item)) {
				return true;
			}	
		}
		return false;
	}
}
