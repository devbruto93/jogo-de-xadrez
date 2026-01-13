package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position auxiliar = new Position(0,0);

        // diagonal esquerda para cima
        auxiliar.setValues(position.getRow() -1, position.getColumn() -1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setValues(auxiliar.getRow()-1, auxiliar.getColumn()-1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //diagonal direita para cima
        auxiliar.setValues(position.getRow() -1, position.getColumn() +1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setValues(auxiliar.getRow() -1, auxiliar.getColumn() +1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //diagonal direita para baixo
        auxiliar.setValues(position.getRow() +1, position.getColumn() +1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setValues(auxiliar.getRow() +1, auxiliar.getColumn() +1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //diagonal esquerda para baixo
        auxiliar.setValues(position.getRow() +1, position.getColumn() -1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setValues(auxiliar.getRow() +1, auxiliar.getColumn() -1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }
        return matriz;
    }
}
