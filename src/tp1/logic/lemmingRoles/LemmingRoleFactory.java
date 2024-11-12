package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.control.commands.Command;


public class LemmingRoleFactory {
	private static final List<LemmingRole> AVAILABLE_ROLES =
			Arrays.asList( 
					new DownCaverRole(),
					new ParachuteRole(),
					new WalkerRole()
			);
	
	public static LemmingRole parse(String input) {
		LemmingRole ret = null;
		
		for (LemmingRole LR: AVAILABLE_ROLES) {
			ret = LR.parse(input);
			if (ret != null) {
				return ret;
			}
		}
		
		return null;
	}
	
	public static String commandHelp() {
		String ret = "";
		
		for (LemmingRole C: AVAILABLE_ROLES) {
			ret += C.helpText();
		}
		
		return ret;
	}
}
