package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { // por extender uma classe abstrata e não implemnetar todos os metodos absitrados da mesma
	
	private int moveCount;
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	

	public Color getColor() {
		return color;
	}

	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getMoveCount() {
		return moveCount;
	}
	public void increaseMoveCount() {
		moveCount++;
	}

	public void decreaseMoveCount() {
		moveCount--;
	}
	
	// verifica se a peça de uma posição é adversária
	protected boolean IsThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position); // pegaa peça da posição no tabuleiro
		
		return p!= null &&p.getColor()!=color;
	}
	

}
