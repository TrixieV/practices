package moderate1;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */
public class Majority {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,1,1,4,1,1,1,1};
        System.out.println(majorityElement(nums));
        System.out.println(alternativeSolution(nums));
    }

    private static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
                if (numCount.get(num) > nums.length / 2) {
                    return num;
                }
            } else {
                numCount.put(num, 1);
            }
        }
        return -1;
    }

    private static int alternativeSolution(int[] nums) {
        Arrays.sort(nums);
        int major = nums[nums.length / 2];
        return major;
    }
}
