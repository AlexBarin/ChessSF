package org.example;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(line, column, toLine, toColumn)) {
            return false;
        }
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        int direction = this.getColor().equals("White") ? 1 : -1;

        if (column == toColumn) {
            // Проверка на движение вперед
            if ((toLine - line == direction && targetPiece == null) || // Один шаг вперед
                    (line == (this.getColor().equals("White") ? 1 : 6) && toLine - line == 2 * direction && // Первый ход на два шага
                            chessBoard.board[line + direction][column] == null && targetPiece == null)) {
                return true;
            }
        } else if (Math.abs(column - toColumn) == 1 && toLine - line == direction && targetPiece != null) {
            // Проверка на поедание по диагонали
            return !targetPiece.getColor().equals(this.getColor());
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
