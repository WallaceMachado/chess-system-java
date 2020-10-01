package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		//movimentos do bispo
		// mover diagonal superior esquerda
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover diagonal superior direita
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// mover diagonal inferior esquerda
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// mover diagonal inferior direita
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// movimentos da torre
		p.setValues(position.getRow()-1, position.getColumn());
		while(getBoard().positionExists(p)&& !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p)&& IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//mover para baixo
		p.setValues(position.getRow()+1, position.getColumn());
		while(getBoard().positionExists(p)&& !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p)&& IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		// mover para  esquerda
		p.setValues(position.getRow(), position.getColumn()-1);
		while(getBoard().positionExists(p)&& !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p)&& IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		// mover para a direita
		p.setValues(position.getRow(), position.getColumn()+1);
		while(getBoard().positionExists(p)&& !getBoard().thereIsAPieceInPosition(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p)&& IsThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "Q";
	}
	

}
