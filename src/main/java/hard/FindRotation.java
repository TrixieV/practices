package hard;

/*
Given two n x n binary matrices mat and target,
return true if it is possible to make mat equal to target by rotating mat in 90-degree increments,
or false otherwise.
 */
public class FindRotation {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] target = new int[][]{{1,0}, {0,1}};

        System.out.println(findRotation(mat, target));
    }

    private static boolean findRotation(int[][] mat, int[][] target) {
        boolean check2Matrix = true;
        int numOfRotation = 4, len = mat.length - 1;
        int[][] result = new int[mat.length][mat.length];
        while (numOfRotation != 0) {
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= len; j++) {
                    result[j][len - i] = mat[i][j];
                    if (result[j][len - i] != target[j][len - i]) {
                        check2Matrix = false;
                    }
                }
            }
            if (check2Matrix) {
                break;
            }
            numOfRotation--;
        }
        return check2Matrix;
    }

//    private static void rotateAndCheck(int[][] matrix, int[][] result, int[][] target, boolean check2Matrix) {
//        int len = matrix.length - 1;
//        for (int i = 0; i <= len; i++) {
//            for (int j = 0; j <= len; j++) {
//                result[j][len - i] = matrix[i][j];
//                if (result[j][len - i] != target[j][len - i]) {
//                    check2Matrix = false;
//                }
//            }
//        }
//    }

}
