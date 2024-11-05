package org.example;

public class King extends ChessPiece {

    // Конструктор, принимающий цвет фигуры
    public King(String color) {
        super(color);
    }

    // Метод, возвращающий символ фигуры
    @Override
    public String getSymbol() {
        return "K";
    }

    // Метод, проверяющий, может ли король двигаться на указанную позицию
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(line, column, toLine, toColumn)) {
            return false;
        }

        int rowDiff = Math.abs(line - toLine);
        int colDiff = Math.abs(column - toColumn);

        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }

        return chessBoard.board[toLine][toColumn] == null
                || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }

    // Метод, проверяющий, находится ли указанная позиция под атакой
    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.getColor())) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        return true; // Поле под атакой
                    }
                }
            }
        }
        return false; // Поле не под атакой
    }
}
