package org.example;

public class Queen extends ChessPiece {

    // Конструктор, принимающий цвет фигуры
    public Queen(String color) {
        super(color);
    }

    // Метод, возвращающий символ фигуры
    @Override
    public String getSymbol() {
        return "Q";
    }

    // Метод, проверяющий, может ли ферзь двигаться на указанную позицию
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(line, column, toLine, toColumn)) {
            return false;
        }

        if (line == toLine || column == toColumn) {
            // Прямой ход
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

        } else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            // Диагональный ход
            int rowStep = (toLine > line) ? 1 : -1;
            int colStep = (toColumn > column) ? 1 : -1;
            int row = line + rowStep, col = column + colStep;

            while (row != toLine && col != toColumn) {
                if (chessBoard.board[row][col] != null) {
                    return false;
                }
                row += rowStep;
                col += colStep;
            }
        } else {
            return false;
        }

        return chessBoard.board[toLine][toColumn] == null
                || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }
}
