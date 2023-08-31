package hard;

import java.util.Arrays;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.
 */
public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1}};

//        int[][] copyGrid = new int[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            copyGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
//        }
//        updateMinutes(copyGrid, 0, 3, 2);
//        System.out.println(Arrays.deepToString(copyGrid));

        System.out.println(orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return -1;
        }

        int[][] copyGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            copyGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
        }

        for (int i = 0; i < copyGrid.length; i++) {
            for (int j = 0; j < copyGrid[0].length; j++) {
                if (grid[i][j] == 2) {
                    updateMinutes(copyGrid, i, j, 2);
                }
            }
        }

        int max = 2;

        for (int i = 0; i < copyGrid.length; i++) {
            for (int j = 0; j < copyGrid[0].length; j++) {
                if (copyGrid[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, copyGrid[i][j]);
            }
        }

        return max - 2;
    }

    private static void updateMinutes(int[][] grid, int row, int col, int minute) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
                    grid[row][col] == 0 ||
                    (grid[row][col] > 1 && grid[row][col] < minute)) {
            return;
        }
        grid[row][col] = minute;
        updateMinutes(grid, row - 1, col, minute + 1);
        updateMinutes(grid, row + 1, col, minute + 1);
        updateMinutes(grid, row, col - 1, minute + 1);
        updateMinutes(grid, row, col + 1, minute + 1);
    }
}




















