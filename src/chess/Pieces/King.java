package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);// pega a peça na posição
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
		// se p não for nulo, se tiver uma torre na posição p, se a cor de p for igual a
		// cor do rei, se a quantidade de movimento for zero
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
		
		// #specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
					// #specialmove castling kingside rook
				Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
				if (testRookCastling(posT1)) {
					Position p1 = new Position(position.getRow(), position.getColumn() + 1);
					Position p2 = new Position(position.getRow(), position.getColumn() + 2);
						if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
							mat[position.getRow()][position.getColumn() + 2] = true;
						}
					}
					// #specialmove castling queenside rook
				Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
				if (testRookCastling(posT2)) {
					Position p1 = new Position(position.getRow(), position.getColumn() - 1);
					Position p2 = new Position(position.getRow(), position.getColumn() - 2);
					Position p3 = new Position(position.getRow(), position.getColumn() - 3);
						if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
							mat[position.getRow()][position.getColumn() - 2] = true;
						}
					}
		}
		return mat;
	}

	}

