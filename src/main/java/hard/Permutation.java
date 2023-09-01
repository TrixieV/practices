package hard;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutation {

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        checkBack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private static void checkBack(List<List<Integer>> ans, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            ans. add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                checkBack(ans, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
