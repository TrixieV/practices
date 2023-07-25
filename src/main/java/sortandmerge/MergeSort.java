package sortandmerge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] a = new int[]{0, 1, 3, 4, 8, 9, 12, 14, 18, 20};
        int[] b = new int[]{2, 4, 5, 7, 10, 12, 15, 20, 25, 28};
        System.out.println(Arrays.toString(mergeSort(a, b)));
    }

    private static int[] mergeSort(int[] a, int[] b) {
        int lastAIndex = a.length - 1;
        int lastBIndex = b.length - 1;
        int lastIndex = a.length + b.length - 1;
        int[] newArr = new int[lastIndex + 1];
        for (int i = 0; i < a.length; i++) {
            newArr[i] = a[i];
        }
        while (lastBIndex >= 0) {
            if (lastAIndex >= 0 && a[lastAIndex] > b[lastBIndex]) {
                newArr[lastIndex] = a[lastAIndex];
                lastAIndex--;
            }
            else {
                newArr[lastIndex] = b[lastBIndex];
                lastBIndex--;
            }
            lastIndex--;
        }
        return newArr;
    }
}
