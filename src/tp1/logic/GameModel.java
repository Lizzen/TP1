package tp1.logic;

public interface GameModel { // Definir las interfaces
public boolean isFinished();
// PLAYER ACTIONS
public void update();
public void reset();
// …
public void setExit(boolean b);
}