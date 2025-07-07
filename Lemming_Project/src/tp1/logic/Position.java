package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Position p = (Position) obj;
		return (this.col==p.col && this.row==p.row);
	}
	private int col;
	private int row;
	
	public Position (int x, int y) {
		this.row = x;
		this.col = y;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	//TODO fill your code

}
