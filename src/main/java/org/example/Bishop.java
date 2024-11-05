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

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false; // Слон ходит только по диагонали
        }

        int rowStep = (toLine > line) ? 1 : -1;
        int colStep = (toColumn > column) ? 1 : -1;
        int row = line + rowStep, col = column + colStep;

        while (row != toLine && col != toColumn) {
            if (chessBoard.board[row][col] != null) {
                return false; // Путь заблокирован
            }
            row += rowStep;
            col += colStep;
        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }
}
