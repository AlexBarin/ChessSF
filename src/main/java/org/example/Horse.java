package org.example;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!isValidMove(line, column, toLine, toColumn))
            return false;

        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        return (deltaLine == 2 && deltaColumn == 1) || (deltaLine == 1 && deltaColumn == 2);
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
