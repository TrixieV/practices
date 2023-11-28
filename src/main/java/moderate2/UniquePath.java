package moderate2;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths
that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    private static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] matrixOfSteps = new int[m][n];
        for (int i = 0; i < n; i++) {
            matrixOfSteps[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            matrixOfSteps[i][0] = 1;
            for (int j = 1; j < n; j++) {
                matrixOfSteps[i][j] = matrixOfSteps[i-1][j] + matrixOfSteps[i][j-1];
            }
        }

        return matrixOfSteps[m-1][n-1];
    }
}

