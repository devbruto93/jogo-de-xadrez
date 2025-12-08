package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook  extends ChessPiece {
    public Rook(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "R"; // ou "T" em portugues de Torre
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position auxiliar = new Position(0,0);

        // movimentar para cima
        auxiliar.setValues(position.getRow() -1, position.getColumn());
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setRow(auxiliar.getRow() -1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //movimentar para esquerda
        auxiliar.setValues(position.getRow(), position.getColumn() -1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setColumn(auxiliar.getColumn() -1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //movimentar para a direita
        auxiliar.setValues(position.getRow(), position.getColumn() +1);
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setColumn(auxiliar.getColumn() +1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }

        //movimentar para baixo
        auxiliar.setValues(position.getRow() +1, position.getColumn() );
        while (getBoard().positionExists(auxiliar) && !getBoard().thereIsAPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
            auxiliar.setRow(auxiliar.getRow() +1);
        }
        if (getBoard().positionExists(auxiliar) && isThereOpponentPiece(auxiliar)){
            matriz[auxiliar.getRow()][auxiliar.getColumn()] = true;
        }


        return matriz;
    }
}
