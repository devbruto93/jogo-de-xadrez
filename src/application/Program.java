package application;

import boardgame.Board;
import boardgame.Position;
import chess.CheesMatch;

public class Program {
    public static void main(String[] args) {
        CheesMatch cheesMatch = new CheesMatch();
        UI.printBoard(cheesMatch.getPieces());
    }
}
