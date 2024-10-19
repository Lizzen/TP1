package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public class Lemming {

	private Position pos;
	private boolean estaVivo;
	private boolean isWin;
	private int caida;
	private boolean enAire;
	private Direction direccion;
	private Game game;
	private WalkerRole role;
	
	public Lemming(Game game, int x, int y) {
		this.game = game;
		this.pos = new Position();
		this.pos.setRow(x);
		this.pos.setCol(y);
		this.game = game;
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
		if (this.game.doorCollision(getPos().getRow(), getPos().getCol()) && getCaida() < 4) {
			setWin(true);
		}
		// Si está en el aire
		else if(getEstaVivo() == true && !this.game.collision(getPos().getRow() +1, getPos().getCol())) {
			getPos().setRow(getPos().getRow() + 1);
			if (getPos().getRow() == 10) {
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
		else if ((getPos().getCol() + 1 == 10 || this.game.collision(getPos().getRow(), getPos().getCol() + 1)) && getDireccion() == Direction.RIGHT) {
			setDireccion(Direction.LEFT);
		}
		// Cambio de direccion a derecha
		else if ((getPos().getCol() - 1 == -1 || this.game.collision(getPos().getRow(), getPos().getCol() - 1)) && getDireccion() == Direction.LEFT) {
			setDireccion(Direction.RIGHT);
		}
		// Caminar hacia la izquierda
		else if (getDireccion().equals(Direction.LEFT)) {
			getPos().setCol(getPos().getCol() - 1);
			setCaida(0);
		}
		// Caminar hacia la derecha
		else {
			getPos().setCol(getPos().getCol() + 1);
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
		return this.pos.getRow() == x && this.pos.getCol() == y;
	}

	public Position getPos() {
		return this.pos;
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
