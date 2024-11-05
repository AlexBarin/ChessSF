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

        if (line == toLine || column == toColumn) {
            int rowStep = (toLine == line) ? 0 : (toLine > line ? 1 : -1);
            int colStep = (toColumn == column) ? 0 : (toColumn > column ? 1 : -1);
            int row = line + rowStep, col = column + colStep;

            while (row != toLine || col != toColumn) {
                if (chessBoard.board[row][col] != null) {
                    return false;
                }
                row += rowStep;
                col += colStep;
            }

        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }

    @Override
    String getSymbol() {
        return "R";
    }
}
