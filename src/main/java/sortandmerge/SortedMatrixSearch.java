package sortandmerge;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10, 20, 50, 80}, {15, 25, 55, 85}, {30, 35, 65, 95}, {40, 56, 70, 100}};
        System.out.println(search(matrix, 65));
    }

    private static boolean search(int[][] matrix, int x) {
        int row = 0;
        int col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == x) {
                return true;
            } else if (matrix[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
