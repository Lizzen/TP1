package tp1.logic.gameobjects;

import tp1.logic.*;

public class Lemming {

	public enum WalkRole {caminante};
	private Position pos;
	private boolean estaVivo;
	private int caida;
	private Direction direccion = Direction.RIGHT;
	private Game game;
	private WalkRole role = WalkRole.caminante;
	private String SYMBOLDER = "B";
	private String SYMBOLIZ = "ᗺ";
	
	public Lemming(Game game, int x, int y) {
		this.pos = new Position();
		this.pos.setRow(x);
		this.pos.setCol(y);
		this.game = game;
		this.estaVivo = true;
	}
	
	public String toString() {
		String Symbol;
		
		if(this.direccion == Direction.RIGHT) Symbol = SYMBOLDER;
		else Symbol = SYMBOLIZ;
		
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
		//TODO fill your code
	}
}
