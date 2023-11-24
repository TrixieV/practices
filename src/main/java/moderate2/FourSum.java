package moderate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    long sum = nums[i];
                    sum = sum + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }

        return ans;
    }
}
