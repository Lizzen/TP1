package tp1.logic;

import java.util.ArrayList;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;


public class GameObjectContainer {
	protected Game game;
	protected int x, y;
	private  ArrayList<Lemming> lemmings;
	private  ArrayList<Wall> walls;
	
	public GameObjectContainer() {
		this.lemmings = new ArrayList<Lemming>();
		this.walls = new ArrayList<Wall>();
	}
    public void addLemming(Lemming lemming) {
    	this.lemmings.add(lemming);
    }
    
    public void addWall(Wall wall) {
    	this.walls.add(wall);
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
}
