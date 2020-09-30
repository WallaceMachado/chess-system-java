package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		// mover pra cima e esquerda
		p.setValues(position.getRow() - 1, position.getColumn()-2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getColumn()-1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// mover pra cima e direita
		p.setValues(position.getRow() - 1, position.getColumn()+2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getColumn()+1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// mover para baixo e esquerda
		p.setValues(position.getRow() + 1, position.getColumn()-2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getColumn()-1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover para baixo e direta
		p.setValues(position.getRow() + 1, position.getColumn()+2);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getColumn()+1);
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}

	@Override
	public String toString() {
		return "N";
	}

}
