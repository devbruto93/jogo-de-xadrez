package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class CheesMatch {
    private Board board;

    public CheesMatch() {
        board = new Board(8,8);//É DEVER DESTA CLASSE SABER AS DIMENÇOES DO TABULEIRO
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++){
            for (int j=0; j<board.getColumns(); j++){
             mat[i][j] = (ChessPiece) board.piece(i,j); //DOWNCASTING PARA SABER QUE SE TRATA DE UMA PEÇA DE XADREZ
            }
        }
        return mat;
    }

    public void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
    }
}
