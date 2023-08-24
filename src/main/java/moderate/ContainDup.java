package moderate;

import java.util.HashMap;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */
public class ContainDup {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,6,2,4,8,10,9,3,0};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
