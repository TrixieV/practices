package moderate2;

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid.
A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePath2 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] newGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    newGrid[i][j] = Math.abs(obstacleGrid[0][0] - 1);
                    continue;
                }
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        newGrid[i][j] = 0;
                    } else {
                        newGrid[i][j] = newGrid[i][j-1];
                    }
                    continue;
                }
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        newGrid[i][j] = 0;
                    } else {
                        newGrid[i][j] = newGrid[i-1][j];
                    }
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    newGrid[i][j] = 0;
                } else {
                    newGrid[i][j] = newGrid[i-1][j] + newGrid[i][j-1];
                }
            }
        }
        return newGrid[rows-1][cols-1];
    }
}
