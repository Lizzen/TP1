package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.view.Messages;

public class Lemming {

	public enum WalkRole {caminante};
	private Position pos;
	private boolean estaVivo;
	private boolean isWin;
	private int caida;
	private Direction direccion = Direction.RIGHT;
	private Game game;
	private WalkRole role = WalkRole.caminante;
	
	public Lemming(Game game, int x, int y) {
		this.game = game;
		this.pos = new Position();
		this.pos.setRow(x);
		this.pos.setCol(y);
		this.game = game;
		this.estaVivo = true;
		this.isWin = false;
	}
	
	public String toString() {
		String Symbol;
		
		if(this.direccion == Direction.RIGHT) Symbol = Messages.LEMMING_RIGHT;
		else Symbol = Messages.LEMMING_LEFT;
		
		return Symbol;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}


	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}


	public int getCaida() {
		return caida;
	}


	public void setCaida(int caida) {
		this.caida = caida;
	}
	
	public boolean isInPosition(int x, int y) {
		return this.pos.getRow() == x && this.pos.getCol() == y;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Direction getDireccion() {
		return direccion;
	}

	public void setDireccion(Direction direccion) {
		this.direccion = direccion;
	}

	public WalkRole getRole() {
		return role;
	}


	public void setRole(WalkRole role) {
		this.role = role;
	}
	
	public void update() {
		if (this.game.doorCollision(this.pos.getRow(), this.pos.getCol()) && caida < 4) {
			this.isWin =  true;
		}
		else if(this.estaVivo == true && !this.game.collision(this.pos.getRow() +1, this.pos.getCol())) {
			this.pos.setRow(this.pos.getRow() + 1);
			if (this.pos.getRow() == 10) {
				this.estaVivo = false;
			}
			this.caida++;
		}
		else if (this.caida > 3) {
			this.estaVivo = false;
		}
		else if ((this.pos.getCol() + 1 == 10 || this.game.collision(this.pos.getRow(), this.pos.getCol() + 1)) && this.direccion == Direction.RIGHT) {
			this.direccion = Direction.LEFT;
		}
		else if ((this.pos.getCol() - 1 == -1 || this.game.collision(this.pos.getRow(), this.pos.getCol() - 1)) && this.direccion == Direction.LEFT) {
			this.direccion = Direction.RIGHT;
		}
		else if (this.direccion.equals(Direction.LEFT)) {
			this.pos.setCol(this.pos.getCol() - 1);
			this.caida = 0;
		}
		else {
			this.pos.setCol(this.pos.getCol() + 1);
			this.caida = 0;
		}
		
		
	}

	public boolean isWin() {
		return isWin;
	}
}
