package org.example;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!isValidMove(line, column, toLine, toColumn))
            return false;
        int rowDiff = Math.abs(line - toLine);
        int colDiff = Math.abs(column - toColumn);
        if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) {
            return false;
        }
        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
