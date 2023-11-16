package hard;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutation {

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, nums, new ArrayList<>());
        return ans;
    }

    private static void backTracking(List<List<Integer>> ans, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                backTracking(ans, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
