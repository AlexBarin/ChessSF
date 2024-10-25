package org.example;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(line, column, toLine, toColumn)) {
            return false;
        }
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        return deltaLine == deltaColumn;
    }
}
