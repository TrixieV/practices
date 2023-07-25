package sortandmerge;

import java.util.Arrays;

public class PeakAndValley {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,1,3,6,8,9,7,10,0};
        System.out.println(Arrays.toString(sort(arr)));

    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int length = arr.length;
        int[] newArr = new int[length];
        newArr[0] = arr[0];
        for (int i = 1; i < length; i++) {
            if (i % 2 != 0 && i + 1 < length) {
                newArr[i] = arr[i+1];
            } else if (i % 2 == 0) {
                newArr[i] = arr[i-1];
            } else {
                newArr[i] = arr[i];
            }

        }
        return newArr;
    }
}
