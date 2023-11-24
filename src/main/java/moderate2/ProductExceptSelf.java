package moderate2;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of
all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    // approach 1: O(n) time
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] ans = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int prev = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = left[i] * prev;
            prev *= nums[i];
        }

        return ans;
    }

    // approach 2: optimizing space complexity
    private static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int prev = 1;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * prev;
            prev *= nums[i - 1];
        }

        prev = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] *= prev;
            prev *= nums[i];
        }

        return ans;
    }
}
