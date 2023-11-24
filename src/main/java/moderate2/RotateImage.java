package moderate2;

import java.util.Arrays;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        swap(matrix, 0, 0, 0, 2);
//        System.out.println(matrix[0][0]);
//        System.out.println(matrix[0][2]);
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    private static void rotate(int[][] matrix) {
        int start = 0, end = matrix.length - 1, temp = matrix[start][end];
        for (int i = start; i <= end; i++) {
            for (int j = start; j < end - i; j++) {
                swap(matrix, i, j, j, end - i);
                swap(matrix, i, j, end - i, end - j);
                swap(matrix, i, j, end - j, i);
            }
            start++;
        }
    }

    private static void swap(int[][] matrix, int a, int b, int i, int j) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[i][j];
        matrix[i][j] = temp;
    }
}
