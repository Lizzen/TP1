package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public class Lemming extends GameObject {
	private boolean estaVivo;
	private boolean isWin;
	private int caida = 0;
	private boolean enAire;
	private Direction direccion;
	private WalkerRole role;
	
	public Lemming(Game game, int x, int y) {
		super(game, x, y);
		this.estaVivo = true;
		this.enAire = false;
		this.isWin = false;
		this.direccion = Direction.RIGHT;
		this.role = new WalkerRole(game);
	}
	
	
	public void update() {
		this.role.play(this);
	}
	
	public void walkOrFall() {
		// Si entra a la puerta
		if (game.doorCollision(pos.getRow(), pos.getCol()) && getCaida() < 4) {
			setWin(true);
		}
		// Si está en el aire
		else if(getEstaVivo() == true && !this.game.collision(pos.getRow() +1, pos.getCol())) {
			pos.setRow(pos.getRow() + 1);
			if (pos.getRow() == 10) {
				setEstaVivo(false);
			}
			if (isEnAire()) {
				setCaida(getCaida() + 1);
			}
			else {
				setEnAire(true);
			}
		}
		// Si muere por caida
		else if (getCaida() > 2) {
			setEstaVivo(false);
		}
		// Cambio de direccion a izquierda
		else if ((pos.getCol() + 1 == 10 || this.game.collision(pos.getRow(), pos.getCol() + 1)) && getDireccion() == Direction.RIGHT) {
			setDireccion(Direction.LEFT);
		}
		// Cambio de direccion a derecha
		else if ((pos.getCol() - 1 == -1 || this.game.collision(pos.getRow(), pos.getCol() - 1)) && getDireccion() == Direction.LEFT) {
			setDireccion(Direction.RIGHT);
		}
		// Caminar hacia la izquierda
		else if (getDireccion().equals(Direction.LEFT)) {
			pos.setCol(pos.getCol() - 1);
			setCaida(0);
		}
		// Caminar hacia la derecha
		else {
			pos.setCol(pos.getCol() + 1);
			setCaida(0);
		}
	}
	
	public String toString() {
		return this.role.getIcon(this);
	}
	
	public boolean isEstaVivo() {
		return estaVivo;
	}


	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
	
	public boolean isEnAire() {
		return enAire;
	}

	public void setEnAire(boolean enAire) {
		this.enAire = enAire;
	}

	public boolean getEstaVivo() {
		return this.estaVivo;
	}

	public int getCaida() {
		return caida;
	}


	public void setCaida(int caida) {
		this.caida = caida;
	}
	
	public boolean isInPosition(int x, int y) {
		return pos.getRow() == x && pos.getCol() == y;
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

	public WalkerRole getRole() {
		return this.role;
	}

	public void setRole(WalkerRole role) {
		this.role = role;
	}

	public boolean isWin() {
		return this.isWin;
	}

	public void setWin(boolean win) {
		this.isWin =  win;
	}
}
