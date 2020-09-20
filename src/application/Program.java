package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.ChessException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
		try{
		UI.clearScreen();
		UI.printMatch(chessMatch);
		System.out.println();
		System.out.print("Source: ");
		ChessPosition source = UI.readChessPosition(sc);
		boolean[][] possibleMoves=chessMatch.possibleMoves(source);
		UI.clearScreen();
		UI.printBoard(chessMatch.getPieces(),possibleMoves);
		System.out.println();
		System.out.print("Target: ");
		ChessPosition target = UI.readChessPosition(sc);
		System.out.println();
		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
		catch(ChessException e){
			System.out.println(e.getMessage());
			sc.nextLine();// aguardar apertar enter
		}
		catch(InputMismatchException e){
			System.out.println(e.getMessage());
			sc.nextLine();// aguardar apertar enter
		}
		}
	}

}
