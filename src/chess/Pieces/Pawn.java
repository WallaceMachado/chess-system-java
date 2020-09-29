package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		if(getColor()==Color.WHITE) {
			// uma linha acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//duas linhas acima
		p.setValues(position.getRow() - 2, position.getColumn());
		Position p2 = new Position(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p) && getMoveCount()==0 && getBoard().positionExists(p2) && !getBoard().thereIsAPieceInPosition(p2)) {
			mat[p.getRow()][p.getColumn()] = true;
		}	
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// caso haja um opoente na diagonal superior esquerda
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		}
		else {
			
				// uma linha acima
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//duas linhas acima
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p) && getMoveCount()==0 && getBoard().positionExists(p2) && !getBoard().thereIsAPieceInPosition(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}	
			// caso haja um opoente na diagonal superior esquerda
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// caso haja um opoente na diagonal superior esquerda
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		
		 return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
