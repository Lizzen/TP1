package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;

public abstract class Command {
	
	private GameView view;
	private String name;
	private String shortcut;
	private String details;
	private String help;
	protected boolean matchCommand(String str) {
		return false;
	}
	public abstract Command parse(String[] commandWords);
	public abstract void execute(Game g,GameView view);
	public Command(String nombre,String shortcut,String details,String help) {
		this.name=nombre;
		this.shortcut=shortcut;
		this.details=details;
		this.help=help;
	}
	public String getName() {
		return name;
	}
	public String getShortcut() {
		return shortcut;
	}
	
	public String getDetails() {
		return details;
	}
	
	public String getHelp() {
		return help;
	}
}
