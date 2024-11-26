package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;

public class GameObjectFactory {
	
	private static final List<GameObject> AVAILABLE_OBJ =
		Arrays.asList( 
				new Lemming(),
				new Wall(),
				new ExitDoor(),
				new MetalWall()
	);

	public static GameObject parse(String input, GameWorld game) throws ObjectParseException, OffBoardException{
		GameObject ret = null;
		String[] line = input.split(" ");
		for (GameObject GO: AVAILABLE_OBJ) {
			ret = GO.parse(line[1], game);
			if (ret != null) {
				try {
					Position pos = getPositionFrom(line[0]);
					ret.setPosition(pos);
				}
				catch(OffBoardException e) {
					throw new OffBoardException(e.toString() + input);
				}
				
				if (line.length > 2) {
					ret.setIniDirection(line[2]);
					ret.setCaida(Integer.parseInt(line[3]));
					try {
						ret.setRole(LemmingRoleFactory.parse(line[4]));
					} catch (RoleParseException e) {
						throw new ObjectParseException(e.toString() + input);
					}
				}
				return ret;
			}
		}
		
		throw new ObjectParseException("");
	}
	
	private static Position getPositionFrom(String line) throws ObjectParseException, OffBoardException {
		int x = Integer.parseInt(line, 1, 1, 0);
		int y = Integer.parseInt(line, 3, 3, 0);
		
		if (x >= 0 && x < 10 && y >= 0 && y < 10) {
			Position ret = new Position( x, y);
			return ret;
		}
		
		throw new OffBoardException("Object position is off board: ");
	}

}
