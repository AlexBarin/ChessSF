package org.example;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(line, column, toLine, toColumn)) {
            return false;
        }
        return line == toLine || column == toColumn;
    }

    @Override
    String getSymbol() {
        return "R";
    }
}
