package moderate;

import java.util.Arrays;

public class MinDifference {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,89,56,21,8,10};
        int[] arr2 = new int[]{91,26,44,12,19,5};
        System.out.println(findMinDiff(arr1, arr2));
    }

    private static int findMinDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int min = Integer.MAX_VALUE, a = 0, b = 0;
        while (a < arr1.length && b < arr2.length) {
            if (Math.abs(arr1[a] - arr2[b]) < min) {
                min = Math.abs(arr1[a] - arr2[b]);
                if (min == 0) {
                    break;
                }
            }
            if (arr1[a] < arr2[b]) {
                a++;
            } else if (arr1[a] > arr2[b]) {
                b++;
            }
        }
        return min;
    }
}
