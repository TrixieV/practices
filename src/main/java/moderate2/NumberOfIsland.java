package moderate2;

/*
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','0','0','0'},
                {'0','0','1','0','0','0'},
                {'0','1','1','0','0','0'},
                {'1','1','0','0','1','0'},
                {'0','0','1','0','0','0'},
                {'1','1','0','0','0','0'}
        };
//        boolean[][] visited = new boolean[6][6];
//        setVisited(visited);
//        System.out.println(landCheck(visited, grid, 0, 0));
//        System.out.println(Arrays.deepToString(visited));
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    landCheck(visited, grid, i, j);
                    count++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return count;
    }

    private static void landCheck(boolean[][] visited, char[][] grid, int row, int col) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length ||
                    visited[newRow][newCol]) {
                continue;
            }
            if (grid[newRow][newCol] == '0') {
                visited[newRow][newCol] = true;
            } else {
                landCheck(visited, grid, newRow, newCol);
            }
        }
    }
}
