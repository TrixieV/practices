package moderate;

import java.util.ArrayList;
import java.util.List;

/*
Given two arrays of integers, find a pair of values (one value from each array) that you
 can swap to give the two arrays the same sum.
 */
public class SumSwap {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] arr2 = new int[]{3, 6, 3, 3};
        swap(arr1, arr2);
    }

    private static void swap(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0;
        for (int a : arr1) {
            sum1 += a;
        }
        for (int b : arr2) {
            sum2 += b;
        }

        List<Integer> listArray2 = new ArrayList<>();

        for (int num : arr2) {
            listArray2.add(num);
        }

        if ((sum1 + sum2) % 2 != 0) {
            System.out.println("No swap");
        } else {
            int diff = (sum1 - sum2) / 2;
            for (int i = 0; i < arr1.length; i++) {
                int swapNum = arr1[i] - diff;
                if (listArray2.contains(swapNum)) {
                    System.out.println("Swap numbers: {" + arr1[i] + ", " + swapNum + "}");
                    break;
                }
            }
        }
    }
}
