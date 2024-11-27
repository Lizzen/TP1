package tp1.logic;

import tp1.exceptions.OffBoardException;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel { // Definir las interfaces
public boolean isFinished();
// PLAYER ACTIONS
public void update();
public void reset();
// …
public void setExit(boolean b);
public boolean setRole(LemmingRole role, Position pos) throws OffBoardException;
}