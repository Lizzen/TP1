package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.control.commands.Command;
import tp1.exceptions.RoleParseException;
import tp1.view.Messages;


public class LemmingRoleFactory {
	private static final List<LemmingRole> AVAILABLE_ROLES =
			Arrays.asList( 
					new DownCaverRole(),
					new ParachuteRole(),
					new WalkerRole()
			);
	
	public static LemmingRole parse(String input) throws RoleParseException{
		LemmingRole ret = null;
		
		for (LemmingRole LR: AVAILABLE_ROLES) {
			ret = LR.parse(input);
			if (ret != null) {
				return ret;
			}
		}
		
		throw new RoleParseException(Messages.ERROR_LEMMING_ROL);
	}
	
	public static String commandHelp() {
		String ret = "";
		
		for (LemmingRole C: AVAILABLE_ROLES) {
			ret += C.helpText();
		}
		
		return ret;
	}
}
