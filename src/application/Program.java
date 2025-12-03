package application;

import boardgame.Board;
import boardgame.Position;
import chess.CheesMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CheesMatch cheesMatch = new CheesMatch();

        while (true) {
            UI.printBoard(cheesMatch.getPieces());
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = cheesMatch.performChessMove(source, target);
        }
    }
}
