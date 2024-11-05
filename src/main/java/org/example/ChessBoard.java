package org.example;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }
    public ChessBoard(){
        nowPlayer = "White";
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    // Метод для рокировки по 0 столбцу
    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            // Рокировка для белых (король на позиции [0,4], ладья на [0,0])
            return performCastling(0, 4, 0, 0);
        } else {
            // Рокировка для черных (король на позиции [7,4], ладья на [7,0])
            return performCastling(7, 4, 7, 0);
        }
    }

    // Метод для рокировки по 7 столбцу
    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            // Рокировка для белых (король на позиции [0,4], ладья на [0,7])
            return performCastling(0, 4, 0, 7);
        } else {
            // Рокировка для черных (король на позиции [7,4], ладья на [7,7])
            return performCastling(7, 4, 7, 7);
        }
    }

    private boolean performCastling(int kingLine, int kingColumn, int rookLine, int rookColumn) {
        ChessPiece king = board[kingLine][kingColumn];
        ChessPiece rook = board[rookLine][rookColumn];

        if (king instanceof King && rook instanceof Rook &&
                king.isCheck() && rook.isCheck()) {

            if (areSquaresEmpty(kingLine, kingColumn, rookColumn)) {
                int newKingColumn = (rookColumn == 0) ? 2 : 6;
                int newRookColumn = (rookColumn == 0) ? 3 : 5;

                board[kingLine][newKingColumn] = king;
                board[rookLine][newRookColumn] = rook;
                board[kingLine][kingColumn] = null;
                board[rookLine][rookColumn] = null;

                king.markAsMoved();
                rook.markAsMoved();

                nowPlayer = nowPlayer.equals("White") ? "Black" : "White";
                return true;
            }
        }
        return false;
    }


    private boolean areSquaresEmpty(int line, int startColumn, int endColumn) {
        int step = (endColumn > startColumn) ? 1 : -1;
        for (int col = startColumn + step; col != endColumn; col += step) {
            if (board[line][col] != null) {
                return false;
            }
        }
        return true;
    }
}
