package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {

		// valor default é falso
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		// mover pra cima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover para baixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover para esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover para a direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// diagnal superior esquerda
		p.setValues(position.getRow()-1, position.getColumn() -1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// diagonal superior direita
		
		p.setValues(position.getRow()-1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//diagonal inferior esquerda
		
		p.setValues(position.getRow()+1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//diagonal inferior direita
		
		p.setValues(position.getRow()+1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}

}
