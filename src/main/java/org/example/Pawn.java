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
        if (column != toColumn) {
            return false;
        }

        int direction = "White".equals(getColor()) ? 1 : -1;
        int startLine = "White".equals(getColor()) ? 1 : 6;

        if ("White".equals(getColor())) {
            if (toLine == line + direction) {
                return true;
            }
            if (line == startLine && toLine == line + 2 * direction) {
                return true;
            }
        }

        if ("Black".equals(getColor())) {
            if (toLine == line + direction) {
                return true;
            }
            if (line == startLine && toLine == line + 2 * direction) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
