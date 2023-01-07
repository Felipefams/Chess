package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch {
	private Board board;
	private final int dim = 8;
	
	public ChessMatch() {
		board = new Board(dim);
		initialSetup();
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		
	}
}
