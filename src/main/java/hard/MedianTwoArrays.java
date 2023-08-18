package hard;

import java.util.Arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
public class MedianTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 4, 5};
        System.out.println(findMedian(arr1, arr2));
    }

    private static double findMedian(int[] arr1, int[] arr2) {
        int sum = arr1.length + arr2.length;
        double median = 0;
        int[] merged = new int[sum];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

        Arrays.sort(merged);
        System.out.println(Arrays.toString(merged));
        if (sum % 2 == 0) {
            int left = sum / 2 - 1;
            int right = sum / 2;
            median = (double) ((merged[left] + merged[right]) / 2.0);
        } else {
            median = merged[sum / 2];
        }

        return median;
    }
}
