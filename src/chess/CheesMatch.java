package chess;

import boardgame.Board;

public class CheesMatch {
    private Board board;

    public CheesMatch() {
        board = new Board(8,8);//É DEVER DESTA CLASSE SABER AS DIMENÇOES DO TABULEIRO
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
}
