package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K"; // ou R de Rei
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piece = new Position(0,0);

        //acima
        piece.setValues(position.getRow() -1, position.getColumn());
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //abaixo
        piece.setValues(position.getRow() +1, position.getColumn());
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //esquerda
        piece.setValues(position.getRow(), position.getColumn() -1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //direita
        piece.setValues(position.getRow(), position.getColumn() +1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //diagonal esquerda+cima
        piece.setValues(position.getRow() -1, position.getColumn() -1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //diagonal esquerda+baixo
        piece.setValues(position.getRow() +1, position.getColumn() -1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //diagona direita+cima
        piece.setValues(position.getRow() -1, position.getColumn() +1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        //diagonal direita+baixo
        piece.setValues(position.getRow() +1, position.getColumn() +1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        return matriz;
    }
}
