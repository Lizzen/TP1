package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public abstract class GameObject{

    private Position posicion;
	private boolean estaVivo;
	private Game game;
	private boolean isWin;
	
	public void update() {
		return ;
	}
	public boolean isInPosition(Position pos) {
		return this.posicion.equals(pos);
	}
	
	public boolean isEstaVivo() {
		return this.estaVivo;
	}
	
	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
	
	public boolean isWin() {
		return this.isWin;
	}

	
}