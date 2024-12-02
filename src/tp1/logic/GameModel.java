package tp1.logic;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel { // Definir las interfaces
public boolean isFinished();
// PLAYER ACTIONS
public void update();
public void reset() throws GameLoadException;
public void reset(int nLevel) throws GameLoadException;
// …
public void load(String fileName) throws GameLoadException;
public void setExit(boolean b);
public boolean setRole(LemmingRole role, Position pos) throws OffBoardException, RoleParseException;
public void save(String fileName) throws GameModelException;
}