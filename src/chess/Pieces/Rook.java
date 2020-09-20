package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "R";
	}

	public boolean[][] possibleMoves() {
		
		// valor default é falso
		boolean [][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position (0,0);
		//mover pra cima
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

}
