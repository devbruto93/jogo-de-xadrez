package application;

import boardgame.Board;
import boardgame.Position;
import chess.CheesMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CheesMatch cheesMatch = new CheesMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(cheesMatch, captured);
                System.out.println();
                System.out.println("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = cheesMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(cheesMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.println("Destino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cheesMatch.performChessMove(source, target);
                    if (capturedPiece != null){
                        captured.add(capturedPiece);
                    }
                 } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                 } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}

