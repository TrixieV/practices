package hard;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
 */
public class SortColor {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,2,1,1,2,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        HashMap<Integer, Integer> countColors = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            countColors.put(i, 0);
        }
        for (int num : nums) {
            countColors.put(num, countColors.get(num) + 1);
        }
        int index = 0;
        for (int j = 0; j < 3; j ++) {
            while (countColors.get(j) > 0) {
                nums[index] = j;
                countColors.put(j, countColors.get(j) - 1);
                index++;
            }
        }

    }
}
