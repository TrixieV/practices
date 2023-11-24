package moderate2;

import java.util.Arrays;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class LargestSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,-4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = 0;
        int start = 0, end = 0, sumStart = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < sum) {
                max = sum;
                end = i;
                start = sumStart;
            }
            if (sum < 0) {
                sum = 0;
                sumStart = i+1;
            }
        }

        int[] sub = Arrays.copyOfRange(nums, start, end + 1);

        System.out.println("From " + start + " to " + end);
        System.out.println("Length: " + (end - start + 1));
        System.out.println("Subarray: " + Arrays.toString(sub));

        return max;
    }
}
