package moderate1;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color.
You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */
public class ColorFill {
    public static void main(String[] args) {

    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int origColor = image[sr][sc];

        if (color == origColor) return image;

        dfs(image, sr, sc, origColor, color);
        return image;
    }

    private static void dfs(int[][] image, int row, int col, int origColor, int newColor) {
        if (row < 0 || col < 0 || row == image.length || col == image[0].length || image[row][col] != origColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, origColor, newColor);
        dfs(image, row + 1, col, origColor, newColor);
        dfs(image, row, col + 1, origColor, newColor);
        dfs(image, row, col - 1, origColor, newColor);
    }
}
