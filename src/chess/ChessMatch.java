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

	// retirar a pe�a de uma posi��o e colocar em outra
	// recebe uma posi��o de origem()source) e envia para uma posi��o de
	// destino(target)
	// posi��o no formatdo do usu�rio (a1) precisa ser convertida para uma posi��o
	// do sistema
	// precisa validar se tem uma pe�a na posi��o de origem

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
		Piece capturedPiece = board.removePiece(target);// cptura a pe�a do local de destino se houver
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// respons�vel por colocar as pe�as no tabuleiro no inicio da partida
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
