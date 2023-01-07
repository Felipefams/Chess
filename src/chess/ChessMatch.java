package chess;

import boardgame.Board;

public class ChessMatch {
	private Board board;
	private final int dim = 8;
	
	public ChessMatch() {
		board = new Board(dim);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] m = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); ++i) {
			for(int j = 0; j < board.getColumns(); ++j) {
				m[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return m;
	}
}
