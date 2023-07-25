package moderate;

import java.util.Arrays;

public class BoardLength {
    public static void main(String[] args) {
        lengths(4, 2, 1);
    }

    private static void lengths(int k, int longer, int shorter) {
        int[] allLengths = new int[k+1];
        for (int i = 0; i <= k; i++) {
            allLengths[i] = (i * longer) + ((k - i) * shorter);
        }
        System.out.println(Arrays.toString(allLengths));
    }
}
