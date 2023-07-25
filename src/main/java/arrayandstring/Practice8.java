package arrayandstring;

public class Practice8 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];

        int value = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = value;
                value++;
            }
        }

        setZero(matrix);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZero(int[][] matrix) {
        boolean[] checkRow = new boolean[matrix.length];
        boolean[] checkColumn = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    checkRow[i] = true;
                    checkColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < checkRow.length; i++) {
            if (checkRow[i]) {
                setZeroRow(matrix, i);
            }
        }

        for (int i = 0; i < checkColumn.length; i++) {
            if (checkColumn[i]) {
                setZeroColumn(matrix, i);
            }
        }
    }

    private static void setZeroColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    private static void setZeroRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }
}
