package boardgame;

public abstract class Piece {
	
	protected Position position;
	
	private Board board;

	public Piece() {};
	
	
	
	public Piece(Board board) {
		
		position= null;
		this.board = board;
	}

	

	public Board getBoard() {
		return board;
	}



	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
	boolean[][] mat = possibleMoves(); // recebe a matriz de retorno do metodo de pissiblemoves
	for (int i=0; i<mat.length; i++) {
		for (int j=0; j<mat.length; j++) {
			if (mat[i][j]) { // verificar se nessa posição é true
				return true;// então existe pelo meno uma possibilidade
							}
		}
	}
	return false;
	}
}
