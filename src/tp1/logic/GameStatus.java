package tp1.logic;

public interface GameStatus {
public String positionToString(int x, int y);
public int getCycle();
public int numLemmingsInBoard();
public boolean playerWins();
public boolean playerLooses();
public int numLemmingsDead();
public int numLemmingsExit();
public int numLemmingsToWin();
}
