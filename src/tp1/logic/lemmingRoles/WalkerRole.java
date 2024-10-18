package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class WalkerRole {
	
	private Lemming lemming;
	private Game game;
	
	public WalkerRole(Game game) {
		this.game = game;
	}
	public void play(Lemming lemming) {
		this.lemming = lemming;
		lemming.walkOrFall();
	}
	
	public String getIcon(Lemming lemming) {
		String Symbol;
		
		if(lemming.getDireccion() == Direction.RIGHT) Symbol = Messages.LEMMING_RIGHT;
		else Symbol = Messages.LEMMING_LEFT;
		
		return Symbol;
	}
}
