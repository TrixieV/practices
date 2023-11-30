package moderate2;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPath {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},
                {1,5,2},
                {0,5,6}
        };
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] minSum = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0) {
                    if (col == 0) {
                        minSum[row][col] = grid[0][0];
                    } else {
                        minSum[row][col] = minSum[row][col-1] + grid[row][col];
                    }
                } else {
                    if (col == 0) {
                        minSum[row][col] = minSum[row - 1][col] + grid[row][col];
                    } else {
                        minSum[row][col] = Math.min(minSum[row - 1][col], minSum[row][col - 1]) + grid[row][col];
                    }
                }
            }
        }
        return minSum[grid.length - 1][grid[0].length - 1];
    }
}
