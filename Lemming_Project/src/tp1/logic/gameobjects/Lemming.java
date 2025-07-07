package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.RoleParseException;
import tp1.logic.*;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

public class Lemming extends GameObject {
	private static final String NAME = "Lemming";
	private static final String SHORTCUT = "L";
	private boolean isWin;
	private boolean exit;
	private int caida = 0;
	private boolean enAire;
	private Direction direccion;
	private LemmingRole role;
	

	@Override
	public Lemming parse(String line, GameWorld game) throws ObjectParseException {
		String[] input = line.trim().split("\\s+");
		if (matchRolName(input[1])) {
			Lemming lemming = new Lemming(game);
			try {
				lemming.setIniDirection(input[2]);
				lemming.setCaida(Integer.parseInt(input[3]));		
				lemming.setRole(LemmingRoleFactory.parse(input[4]));
			} catch (RoleParseException e) {
				throw new ObjectParseException(Messages.ERROR_LEMMING_ROL.formatted(line));
			} catch (ObjectParseException e) {
				throw new ObjectParseException(e.getMessage().formatted(line));
			}
			return lemming;
		}
		return null;
	}
	public Lemming(GameWorld game) {
		super(game);
		this.enAire = false;
		this.isWin = false;
		this.exit = false;
		this.direccion = Direction.RIGHT;
		this.role = new WalkerRole();
	}
	
	public Lemming(GameWorld game, int x, int y, LemmingRole role) {
		super(game, x, y);
		this.enAire = false;
		this.isWin = false;
		this.exit = false;
		this.direccion = Direction.RIGHT;
		if (role == null) {
			this.role = new WalkerRole();
		}
		else {
			this.role = role;
		}
	}
	
	public Lemming() {
		super(NAME, SHORTCUT);
		this.enAire = false;
		this.isWin = false;
		this.exit = false;
		this.role = new WalkerRole();
	}
	
	@Override
	public void update() {
		this.role.play(this);
	}
	
	public void walkOrFall() { 
		if (!exit) {
			if (!game.collision(pos.getRow() + 1, pos.getCol()) && pos.getRow() != 9) {
				enAire = true;
			}
			else if (pos.getRow() == 9 || this.caida >= 3 && enAire) {
				this.alive = false;					
			} 
			else {
				caida =  0;
				enAire = false;
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
		
		pos.setRow(y + 1);
		if (this.caida < 3 && game.collision(pos.getRow()+1, pos.getCol())){
			enAire = false;
			caida = 0;
		}
	}
	
	public void cave() {
		int y = pos.getRow() + 1;
		pos.setRow(y);
		if (!game.receiveInteractionsFrom(this)){
			enAire = true;
			caida++;
			disableRole();
		} else if (pos.getRow() == 10) {
			this.alive = false;		
		}
	}
	
	public void up() {
		pos.setRow(pos.getRow() - 1);
	}
	
	public void iz() {
		pos.setCol(pos.getCol() - 1);
	}
	
	public void der() {
		pos.setCol(pos.getCol() + 1);
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
	
	public boolean isInDirection(Direction dir) {
		return this.direccion.equals(dir);
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
		this.game.addExit();
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
	
	@Override
	public void setIniDirection(String input) throws ObjectParseException {
		if (input.equalsIgnoreCase("right")) {
			this.direccion = Direction.RIGHT;
		}
		else if (input.equalsIgnoreCase("left")){
			this.direccion = Direction.LEFT;
		}
		else if (input.equalsIgnoreCase("up") || input.equalsIgnoreCase("down")) {
			throw new ObjectParseException(Messages.ERROR_LEMMINGS_DIR);
		}
		else {
			throw new ObjectParseException(Messages.ERROR_OBJECTS_DIR);
		}
	}
	
	// GETTERS
	public int getCaida() {
		return caida;
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
	public Lemming copy () {
		Lemming lemming = new Lemming(this.game);
		lemming.setPos(this.pos);
		lemming.copyWin(this.isWin);
		lemming.setExit(this.exit);
		lemming.setCaida(this.caida);
		lemming.setEnAire(this.enAire);
		lemming.setDireccion(this.direccion);
		lemming.setRole(this.role);
		return lemming;
	}
	void copyWin(boolean win) {
		this.isWin = win;
	}
	@Override
	public String toSave() {
		String ret="";
		ret+="("+this.pos.getRow()+","+this.pos.getCol()+") "+ NAME + " " + this.direccion.toSave()+ " " + this.caida + " "+this.role.getName()+"\n";
		return ret;
	}
}
