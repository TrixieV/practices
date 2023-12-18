package moderate2;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums2 = new int[]{4,5,6,7,8};
        int[] nums1 = new int[]{0,0,0,0,0};
        merge(nums1, 0, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        int pointer1 = m - 1, pointer2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (pointer2 < 0) {
                break;
            }
            if (pointer1 < 0) {
                for (int j = i; j >= 0; j--) {
                    nums1[j] = nums2[pointer2];
                    pointer2--;
                }
                break;
            }
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[i] = nums1[pointer1];
                pointer1--;
            } else if (nums1[pointer1] == nums2[pointer2]) {
                nums1[i] = nums1[pointer1];
                nums1[i-1] = nums1[pointer1];
                i--;
                pointer1--;
                pointer2--;
            } else {
                nums1[i] = nums2[pointer2];
                pointer2--;
            }
        }
    }
}
