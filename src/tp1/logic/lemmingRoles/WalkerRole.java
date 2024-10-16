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
		update();
	}
	
	public String getIcon(Lemming lemming) {
		String Symbol;
		
		if(lemming.getDireccion() == Direction.RIGHT) Symbol = Messages.LEMMING_RIGHT;
		else Symbol = Messages.LEMMING_LEFT;
		
		return Symbol;
	}

	public void update() {
		// Si entra a la puerta
		if (this.game.doorCollision(lemming.getPos().getRow(), lemming.getPos().getCol()) && lemming.getCaida() < 4) {
			lemming.setWin(true);
		}
		// Si está en el aire
		else if(lemming.getEstaVivo() == true && !this.game.collision(lemming.getPos().getRow() +1, lemming.getPos().getCol())) {
			lemming.getPos().setRow(lemming.getPos().getRow() + 1);
			if (lemming.getPos().getRow() == 10) {
				lemming.setEstaVivo(false);
			}
			if (lemming.isEnAire()) {
				lemming.setCaida(lemming.getCaida() + 1);
			}
			else {
				lemming.setEnAire(true);
			}
		}
		// Si muere por caida
		else if (lemming.getCaida() > 2) {
			lemming.setEstaVivo(false);
		}
		// Cambio de direccion a izquierda
		else if ((lemming.getPos().getCol() + 1 == 10 || this.game.collision(lemming.getPos().getRow(), lemming.getPos().getCol() + 1)) && lemming.getDireccion() == Direction.RIGHT) {
			lemming.setDireccion(Direction.LEFT);
		}
		// Cambio de direccion a derecha
		else if ((lemming.getPos().getCol() - 1 == -1 || this.game.collision(lemming.getPos().getRow(), lemming.getPos().getCol() - 1)) && lemming.getDireccion() == Direction.LEFT) {
			lemming.setDireccion(Direction.RIGHT);
		}
		// Caminar hacia la izquierda
		else if (lemming.getDireccion().equals(Direction.LEFT)) {
			lemming.getPos().setCol(lemming.getPos().getCol() - 1);
			lemming.setCaida(0);
		}
		// Caminar hacia la derecha
		else {
			lemming.getPos().setCol(lemming.getPos().getCol() + 1);
			lemming.setCaida(0);
		}
	}

}
