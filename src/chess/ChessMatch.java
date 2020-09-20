package chess;

import boardgame.Board;
import boardgame.Position;
import chess.Pieces.King;
import chess.Pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i =0;i<mat.length;i++) {
			for(int j = 0;j<mat.length;j++) {
				mat[i][j]=(ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}
	
	// responsável por colocar as peças no tabuleiro no inicio da partida
	private void initialSetup() {
		board.placePiece(new King(board,Color.WHITE), new Position(2,1));
		board.placePiece(new Rook(board,Color.BLACK), new Position(2,2));
	}
}
