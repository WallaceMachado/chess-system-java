package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.Pieces.King;
import chess.Pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}

		return mat;
	}

	// retirar a peça de uma posição e colocar em outra
	// recebe uma posição de origem()source) e envia para uma posição de
	// destino(target)
	// posição no formatdo do usuário (a1) precisa ser convertida para uma posição
	// do sistema
	// precisa validar se tem uma peça na posição de origem

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validadeSourcePosition(source);
		validadeTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}

	public void validadeSourcePosition(Position source) {
		if (!board.thereIsAPieceInPosition(source)) {

			throw new ChessException("There is not piece on souce position");
		}

		if (!board.piece(source).isThereAnyPossibleMove()) {

			throw new ChessException("There is no possible moves");
		}

	}
	
	public void validadeTargetPosition(Position source,Position target) {
		if (!board.piece(source).possibleMove(target)) {

			throw new ChessException("The chosen piece can't move to target position");
		}

	}

	public Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);// cptura a peça do local de destino se houver
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// responsável por colocar as peças no tabuleiro no inicio da partida
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
