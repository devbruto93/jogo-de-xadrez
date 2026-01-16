package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "C"; // ou K de King
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piece = new Position(0,0);


        piece.setValues(position.getRow() -1, position.getColumn() -2);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }


        piece.setValues(position.getRow() -2, position.getColumn() -1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() -2, position.getColumn() +1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() -1, position.getColumn() +2);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() +1, position.getColumn() +2);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() +2, position.getColumn() +1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() +2, position.getColumn() -1);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        piece.setValues(position.getRow() +1, position.getColumn() -2);
        if (getBoard().positionExists(piece) && canMove(piece)){
            matriz[piece.getRow()][piece.getColumn()] = true;
        }

        return matriz;
    }
}
