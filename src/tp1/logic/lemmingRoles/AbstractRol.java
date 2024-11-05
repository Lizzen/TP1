package tp1.logic.lemmingRoles;

public abstract class AbstractRol implements LemmingRole{
	private final String NAME;
	
	public AbstractRol(String name) {
		NAME = name;
	}
	
	protected boolean matchRolName(String name) {
		return getName().equalsIgnoreCase(name);
	}
	
	public String getName() {
		return NAME;
	}

	public LemmingRole parse(String input) {
		if(matchRolName(input)) {
			return this;
		} 

		return null;
	}
}
