package Sudoku;

import java.util.HashSet;

public class ValidSudoku {
    private static final int ROW_LENGTH = 9;
    private static final int COLUMN_LENGTH = 9;
    private static final int SUB_BOX_CAPACITY = 9;

    public static boolean isValidSudokuVer1(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] boxes = new short[9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') continue;

                short value = (short) (1 << (board[row][col] - '1'));
                if ((value & rows[row]) > 0) return false;
                if ((value & cols[col]) > 0) return false;
                if ((value & boxes[3 * (row / 3) + col / 3]) > 0) return false;

                rows[row] |= value;
                cols[col] |= value;
                boxes[3 * (row / 3) + col / 3] |= value;
            }
        }
        return true;
    }

    public static boolean isValidSudokuVer2(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            var rows = new HashSet<>();
            var columns = new HashSet<>();
            var box = new HashSet<>();
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.' && !rows.add(board[row][col])) {
                    return false;
                }
                if (board[col][row] != '.' && !columns.add(board[col][row])) {
                    return false;
                }
                int rowIndex = (row / 3) * 3;
                int columnIndex = (row % 3) * 3;
                if (board[rowIndex + col / 3][columnIndex + col % 3] != '.' && !box.add(board[rowIndex + col / 3][columnIndex + col % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuVer3(char[][] board) {
        if (board.length != ROW_LENGTH) return false;
        for (int row = 0; row < board.length; row++) {
            if (!isValidRow(board[row])) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if (!isValidColumn(board, col)) {
                return false;
            }
        }
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 9; i += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidRow(char[] boardRow) {
        if (boardRow.length != COLUMN_LENGTH) return false;
        var digits = new HashSet<>(COLUMN_LENGTH);
        for (int i = 0; i < boardRow.length; i++) {
            if (isFilled(boardRow[i])) {
                if (!digits.add(boardRow[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] boardRow, int columnNumber) {
        var digits = new HashSet<>(COLUMN_LENGTH);
        for (int i = 0; i < boardRow.length; i++) {
            if (isFilled(boardRow[i][columnNumber])) {
                if (!digits.add(boardRow[i][columnNumber])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSubBox(char[][] board, int startRowIndex, int startColumnIndex) {
        var digits = new HashSet<>(SUB_BOX_CAPACITY);
        for (int i = startRowIndex; i < startRowIndex + 3; i++) {
            for (int j = startColumnIndex; j < startColumnIndex + 3; j++) {
                if (isFilled(board[i][j])) {
                    if (!digits.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isFilled(char value) {
        return value != '.';
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudokuVer1(board));
        System.out.println(isValidSudokuVer2(board));
        System.out.println(isValidSudokuVer3(board));
    }
}
