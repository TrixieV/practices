package moderate2;

import java.util.ArrayList;
import java.util.List;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'9','3','.','.','2','.','4','.','.'},
                {'.','.','7','.','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','4','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','.'},
                {'.','.','.','.','.','5','2','.','.'}};

        System.out.println(checkSquare(board));
        System.out.println(checkCol(board));
        System.out.println(checkRow(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        return checkCol(board) && checkRow(board) && checkSquare(board);
    }

    private static boolean checkRow(char[][] board) {
        for (char[] chars : board) {
            List<Character> list = new ArrayList<>();
            for (int col = 0; col < board[0].length; col++) {
                if (chars[col] != '.') {
                    if (list.contains(chars[col])) {
                        return false;
                    } else list.add(chars[col]);
                }
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            List<Character> list = new ArrayList<>();
            for (char[] chars : board) {
                if (chars[col] != '.') {
                    if (list.contains(chars[col])) {
                        return false;
                    } else list.add(chars[col]);
                }
            }
        }
        return true;
    }

    private static boolean checkSquare(char[][] board) {
        int topLeftRow = 0;
        while (topLeftRow <= board.length - 3) {
            int topLeftCol = 0;
            while (topLeftCol <= board[0].length - 3) {
                List<Character> list = new ArrayList<>();
                for (int row = topLeftRow; row < topLeftRow + 3; row++) {
                    for (int col = topLeftCol; col < topLeftCol + 3; col++) {
                        if (board[row][col] != '.') {
                            if (list.contains(board[row][col])) {
                                return false;
                            } else {
                                list.add(board[row][col]);
                            }
                        }
                    }
                }
                topLeftCol += 3;
            }
            topLeftRow += 3;
        }
        return true;
    }
}
