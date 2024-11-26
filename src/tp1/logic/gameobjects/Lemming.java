package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming extends GameObject {
	private static final String NAME = "Lemming";
	private static final String SHORTCUT = "L";
	private boolean isWin;
	private boolean exit;
	private int caida = 0;
	private boolean enAire;
	private Direction direccion;
	private LemmingRole role;
	
	public Lemming() {
		super(NAME, SHORTCUT);
		this.enAire = false;
		this.isWin = false;
		this.exit = false;
		this.direccion = Direction.RIGHT;
		this.role = new WalkerRole();
	}
	
	@Override
	public void update() {
		this.role.play(this);
	}
	
	public void walkOrFall() { 
		if (!exit) {
			if (!game.collision(pos.getRow() + 1, pos.getCol())) {
				enAire = true;
			}
			
			if (isEnAire()) {
				caida++;
				fall();
			}
			else {
				disableRole();
				walk();
			}
		}

		game.receiveInteractionsFrom(this);
	}
	
	public void walk() {
		int x = pos.getCol();
		
		if (this.direccion.equals(Direction.RIGHT)) {
			if (x == 9) {
				this.direccion = Direction.LEFT;
			}
			else {
				pos.setCol(x + 1);
			}
		}
		else {
			if (x == 0) {
				this.direccion = Direction.RIGHT;
			}
			else {
				pos.setCol(x - 1);
			}
		}
	}
	
	public void fall() {
		int y = pos.getRow();
		
		if (y == 9 || this.caida >= 3 && game.collision(pos.getRow()+1, pos.getCol())) {
			this.alive = false;
		}
		else {
			pos.setRow(y + 1);
			if (this.caida < 3 && game.collision(pos.getRow()+1, pos.getCol())){
				enAire = false;
				caida = 0;
			}
		}
	}
	
	public void cave() {
		int y = pos.getRow() + 1;
		pos.setRow(y);
		if (!game.receiveInteractionsFrom(this)){
			enAire = true;
			caida++;
			disableRole();
		}
	}
	
	public String toString() {
		return this.role.getIcon(this);
	}
	
	@Override
	public boolean collision(int x, int y) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	public void disableRole() {
		this.role = new WalkerRole();
	}

	// SETTERS	
	public boolean isEnAire() {
		return enAire;
	}

	public void setEnAire(boolean enAire) {
		this.enAire = enAire;
	}
	
	public void setCaida(int caida) {
		this.caida = caida;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void setDireccion(Direction direccion) {
		this.direccion = direccion;
	}
	
	public void setWin(boolean win) {
		this.isWin =  win;
	}
	
	public boolean setRole(LemmingRole role) {
		if (!this.role.equals(role)) {
			this.role = role;
			return true;
		}

		return false;
	}
	
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	
	public void setIniDirection(String input) {
		if (input.equalsIgnoreCase("right")) {
			this.direccion = Direction.RIGHT;
		}
		else {
			this.direccion = Direction.LEFT;
		}
	}
	
	// GETTERS
	public int getCaida() {
		return caida;
	}

	public Position getPos() {
		return pos;
	}

	public Direction getDireccion() {
		return direccion;
	}
	
	public LemmingRole getRole() {
		return role;
	}

	//BOOLEANS
	public boolean isWin() {
		return this.isWin;
	}
	
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}

	@Override
	public boolean interactWith(Wall wall) {
		return role.interactWith(wall, this);
	}

	@Override
	public boolean interactWith(ExitDoor door) {
		return role.interactWith(door, this);
	}
	
	@Override
	public boolean interactWith(MetalWall metalWall) {
		return role.interactWith(metalWall, this);
	}

	@Override
	public boolean isExit() {
		return exit;
	}
}
