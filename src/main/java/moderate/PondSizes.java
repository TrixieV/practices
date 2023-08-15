package moderate;

/*
You have an integer matrix representing a plot of land, where the value at that location represents the height above sea level.
A value of zero indicates water. A pond is a region of water connected vertically, horizontally, or diagonally.
The size of the pond is the total number of connected water cells. Write a method to compute the sizes of all ponds in the matrix.
 */

public class PondSizes {
    public static void main(String[] args) {
        int[][] land = new int[][]{
                {0, 1, 3, 0},
                {1, 0, 1, 1},
                {2, 0, 1, 0},
                {0, 1, 1, 0}
        };
        boolean[][] visited = new boolean[4][4];
        setVisited(visited);
        findAllPondSizes(land);
    }

    private static void setVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void findAllPondSizes(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        setVisited(visited);

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (visited[i][j] || land[i][j] != 0) {
                    continue;
                }
                System.out.println(countSize(visited, land, i, j));
            }
        }
    }

    private static int countSize(boolean[][] visited, int[][] land, int row, int column) {
        int size = 1;
        visited[row][column] = true;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0 ||
                        visited[i][j] || (i == row && j == column)) {
                    continue;
                }

                visited[i][j] = true;
                size += countSize(visited, land, i, j);

            }
        }
        return size;
    }
}



















