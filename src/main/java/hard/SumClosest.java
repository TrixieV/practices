package hard;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.


 */
public class SumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSumClosest(nums, 2));
    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0, closestSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < closest) {
                    closest = diff;
                    closestSum = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
