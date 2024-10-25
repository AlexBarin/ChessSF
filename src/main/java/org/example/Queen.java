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

        boolean isStraightMove = (line == toLine || column == toColumn);
        boolean isDiagonalMove = Math.abs(toLine - line) == Math.abs(toColumn - column);

        return isStraightMove || isDiagonalMove;
    }
}
