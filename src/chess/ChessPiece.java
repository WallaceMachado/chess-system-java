package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { // por extender uma classe abstrata e n�o implemnetar todos os metodos absitrados da mesma
	
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

	// verifica se a pe�a de uma posi��o � advers�ria
	protected boolean IsThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position); // pegaa pe�a da posi��o no tabuleiro
		
		return p!= null &&p.getColor()!=color;
	}
	

}
