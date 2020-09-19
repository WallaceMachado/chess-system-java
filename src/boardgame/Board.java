package boardgame;

import java.util.ArrayList;

public class Board {
	private int rows;
	private int columns;
	
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		//if (rows < 1 || columns < 1) {
		//	throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
	//	}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Piece piece(int row, int column) {
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//metodo coloca uma peça em um posição no tabuleiro
	public void placePiece(Piece piece, Position position) {
		
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position = position;// deixa de ser nula e passa a ter a posição informada
		
	}

}
