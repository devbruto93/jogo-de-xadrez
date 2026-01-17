package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.CheesMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private CheesMatch cheesMatch;

    public King(Board board, Color color, CheesMatch cheesMatch) {
        super(board, color);
        this.cheesMatch = cheesMatch;
    }

    @Override
    public String toString(){
        return "K"; // ou K de King
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
        //roque pequeno
        if (getMoveCount() == 0 && !cheesMatch.getCheck()){
            Position posT1 = new Position(position.getRow(), position.getColumn() +3);
            if (testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() +1);
                Position p2 = new Position(position.getRow(), position.getColumn() +2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    matriz[position.getRow()][position.getColumn() +2] = true;
                }
            }
            // roque grande
            Position posT2 = new Position(position.getRow(), position.getColumn() -4);
            if (testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getColumn() -1);
                Position p2 = new Position(position.getRow(), position.getColumn() -2);
                Position p3 = new Position(position.getRow(), position.getColumn() -3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    matriz[position.getRow()][position.getColumn() -2] = true;
                }
            }
        }
        return matriz;
    }
}
