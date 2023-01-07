package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}
	public Board(int n) {
		this.rows = n;
		this.columns = n;
		this.pieces = new Piece[n][n];
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
}
