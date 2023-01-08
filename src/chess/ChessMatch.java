package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position src = sourcePosition.toPosition();
		Position tgt = targetPosition.toPosition();
		validateSourcePosition(src);
		Piece capturedPiece = makeMove(src, tgt);
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position src, Position tgt) {
		Piece p = board.removePiece(src);
		Piece capturedPiece = board.removePiece(tgt);
		board.placePiece(p, tgt);
		return (ChessPiece) capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.containsPiece(position)) 
			throw new ChessException("There is no piece on source position");
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece,  new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
		
	}
}
