package tp1.logic;

import tp1.logic.gameobjects.Lemming;


public class GameObjectContainer {
	protected Game game;
	protected int x, y;
	private Lemming[] lemmings;
	
	public GameObjectContainer(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
    public void add(Lemming lemming) {
    	lemming = new Lemming(game, x, y);
    	this.lemmings[lemmings.length] = lemming;
    }
    
    //public void add(Wall wall) {...}

}
