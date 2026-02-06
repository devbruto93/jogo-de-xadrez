package application;

import chess.ChessMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.println("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.println("Destino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                    if (capturedPiece != null){
                        captured.add(capturedPiece);
                    }
                    if (chessMatch.getPromoted() != null){
                        System.out.print("Para qual peça deseja promover? (B/C/T/Q)");
                        String type = sc.nextLine().toUpperCase();
                        while (!type.equals("B") && !type.equals("C") && !type.equals("T") && type.equals("Q")){
                            System.out.print("Valor inválido! Entre com (B/C/T/Q)");
                            type = sc.nextLine().toUpperCase();

                        }
                        chessMatch.replacePromotedPiece(type);
                    }

                 }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                 } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}

