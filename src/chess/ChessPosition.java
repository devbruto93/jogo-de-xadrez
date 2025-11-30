package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column> 'h' || row < 1 || row > 8){
            throw new ChessException("ERRO! Somente valores entre a1 até h8 são válidos.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
        /*o calculo é feito da seguinte maneira, a linha da matriz é = 8 - a linha do xadrez, logo 8 - 8 = 0 siginifica
        que é a linha 0 e assim por diante, a coluna o calculo é a linha do xadrez - o caractere 'a', por que? porque o
        o calculo será feito atravez dos codigos UNICODE de cada caractere, por exemplo o unicode do caractere 'a' - 'a'
        é igual a 0, 'b' - 'a' = 1 e assim por diante...loucura demais!
        * */
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    public String toSrting(){
        return "" + column + row;
    }
}
