package org.example;

public abstract class ChessPiece {
    private String color;
    private boolean check;
    ChessPiece(String color){
        this.color = color;
        this.check = true;
    }

    public String getColor(){
        return color;
    }

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    abstract String getSymbol();
    private boolean isOnBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }

    protected boolean isValidMove(int line, int column, int toLine, int toColumn) {
        return isOnBoard(line, column) && isOnBoard(toLine, toColumn) && !(line == toLine && column == toColumn);
    }

    public void markAsMoved() {
        this.check = false;
    }
}
