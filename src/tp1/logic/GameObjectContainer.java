package tp1.logic;

import java.util.ArrayList;
import java.util.Iterator;

import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.view.Messages;

public class GameObjectContainer {
	protected GameWorld game;
	private  ArrayList<GameObject> objects;
	private int deads = 0;

	public GameObjectContainer(GameWorld game) {
		this.game = game;
		this.objects = new ArrayList<GameObject>();
	}
	
	
	public void update() {
	    Iterator<GameObject> iterator = objects.iterator();
	    while (iterator.hasNext()) {
	    	GameObject GO = iterator.next();
	        if (GO.isAlive() && !GO.isWin()) {
	            GO.update();
	        }
	        if (!GO.isAlive()) {
	        	iterator.remove(); 
	            if (!GO.isSolid()) {
					this.game.addDead();
	            }
	            
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

	
	public boolean setRole(LemmingRole rol, Position posicion) throws OffBoardException, RoleParseException {
		if (posicion.getRow() >= 0 && posicion.getRow() < 10 && posicion.getCol() >= 0 && posicion.getCol() < 10) {
			for(GameObject GO: this.objects) {
				if(GO.isInPosition(posicion) && GO.setRole(rol))
					return true;
			}
			
			throw new RoleParseException("No lemming in position " + Messages.POSITION.formatted(posicion.getRow(), posicion.getCol()) + " admits role " + rol.getName());
		}
		else {
			throw new OffBoardException("Position " + Messages.POSITION.formatted(posicion.getRow(), posicion.getCol()) + " is off board");
		}
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
	public GameObjectContainer copy() {
		GameObjectContainer ret = new GameObjectContainer(this.game);
		for(GameObject GO: this.objects) {
			ret.add(GO.copy());
		}
		return ret;
	}
	
	public String toSave() {
		String ret = "";
		for(GameObject GO: this.objects) {
			if(GO.dentroRango()) {
				ret += GO.toSave();
			}
		}
		return ret;
	}
	
}
