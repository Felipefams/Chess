package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) 
			throw new BoardException("Error creating board: board size must be at least 1x1");
		
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

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) 
			throw new BoardException("Position not on the board");
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if(!positionExists(position)) 
			throw new BoardException("Position not on the board");
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(containsPiece(position))
			throw new BoardException("Theres already a piece in position " + position);
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
		if(piece(position) == null) return null;
		Piece tmp = piece(position);
		tmp.position = null; //removes the piece from the board
		pieces[position.getRow()][position.getColumn()] = null;
		return tmp;
	}
	
	public boolean positionExists(int row, int col) {
		return row >= 0 && row < rows && col >= 0 && col < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean containsPiece(int row, int col) {
		if(!positionExists(row, col)) 
			throw new BoardException("Position not on the board");
		return piece(row, col) != null;
	}
	
	public boolean containsPiece(Position pos) {
		if(!positionExists(pos)) 
			throw new BoardException("Position not on the board");
		return piece(pos) != null;
	}
	
}
