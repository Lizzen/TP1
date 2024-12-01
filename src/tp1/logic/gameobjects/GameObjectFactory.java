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
import tp1.view.Messages;

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
		String[] line = input.trim().split("\\s+");
		for (GameObject GO: AVAILABLE_OBJ) {
			ret = GO.parse(line[1], game);
			if (ret != null) {
				try {
					Position pos = getPositionFrom(line[0]);
					ret.setPosition(pos);
					ret.setAlive(true);
				}
				catch(OffBoardException e) {
					throw e;
				}
				catch(ObjectParseException e) {
					throw e;
				}
				
				if (line.length > 2) {
					try {
						ret.setIniDirection(line[2]);
						ret.setCaida(Integer.parseInt(line[3]));		
						ret.setRole(LemmingRoleFactory.parse(line[4]));
					} catch (RoleParseException e) {
						throw new ObjectParseException(Messages.ERROR_LEMMING_ROL.formatted(input));
					} catch (ObjectParseException e) {
						throw new ObjectParseException(e.getMessage().formatted(input));
					}
				}
				return ret;
			}
		}
		
		throw new ObjectParseException(Messages.UNKNOWN_GAME_OBJECT);
	}
	
	private static Position getPositionFrom(String line) throws ObjectParseException, OffBoardException {
		try {
			// Eliminar los paréntesis
			line = line.replace("(", "").replace(")", "");
			// Dividir la cadena por la coma
			String[] parts = line.trim().split(",");
			// Parsear las coordenadas
			int x = Integer.parseInt(parts[0]);
			int y = Integer.parseInt(parts[1]);
	
			if (x >= 0 && x < 10 && y >= 0 && y < 10) {
				return new Position(x, y);
			} else {
				throw new OffBoardException(Messages.ERROR_OBJECTS_OFFBOARD);
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new ObjectParseException(Messages.ERROR_OBJECTS_POS);
		}
	}

}
