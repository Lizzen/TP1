package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.control.commands.Command;


public class LemmingRoleFactory {
	private static final List<LemmingRole> AVAILABLE_ROLES =
			Arrays.asList( 
					new WalkerRole(),
					new ParachuteRole()
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
}
