package moderate1;

import java.util.Arrays;

/*
Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 */
public class PairsWithSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 3, 5, 12, 11, 6, 9, 1, 5, 14};
        findPairs(arr, 12);
    }

    private static void findPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        while (low < high){
            int sum = arr[low] + arr[high];
            if (sum == target) {
                System.out.println(arr[low] + " and " + arr[high]);
                low++;
                high--;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
    }
}
