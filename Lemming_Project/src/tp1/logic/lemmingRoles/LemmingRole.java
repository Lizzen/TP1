package tp1.logic.lemmingRoles;

import tp1.logic.GameItem;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

public interface LemmingRole {
	//public void start(Lemming lemming);
	public void play(Lemming lemming);
	public String getIcon(Lemming lemming);
	public LemmingRole parse(String input);
	public boolean receiveInteraction(GameItem other, Lemming owner);
	public boolean interactWith(Lemming receiver, Lemming owner);
	public boolean interactWith(Wall wall, Lemming owner);
	public boolean interactWith(ExitDoor door, Lemming owner);
	public boolean interactWith(MetalWall metalWall, Lemming owner);
	public String helpText();
	public boolean equals(Object obj);
	public String getName();
}
