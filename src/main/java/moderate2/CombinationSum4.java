package moderate2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
Given an array of distinct integers nums and a target integer target,
return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(combinationSum4(nums, 4));
    }

    private static int combinationSum4(int[] nums, int target) {
//        AtomicInteger count = new AtomicInteger(0);
//        Arrays.sort(nums);
//        backtracking(nums, target, count, new ArrayList<>());
//        return count.get();
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(i - j >= 0) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }

    private static void backtracking(int[] nums, int remain, AtomicInteger count, List<Integer> list) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            count.set(count.intValue()+1);
            return;
        }
        for (int i = 0; i < nums.length && nums[i] <= remain; i++) {
            list.add(nums[i]);
            backtracking(nums, remain - nums[i], count, list);
            list.remove(list.size() - 1);
        }
    }
}





















