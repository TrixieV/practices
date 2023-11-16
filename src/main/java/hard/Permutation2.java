package hard;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class Permutation2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,4};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<>(), new ArrayList<>(), nums);
        return ans;
    }

    private static void backTracking(List<List<Integer>> ans, List<Integer> list, List<Integer> index, int[] nums) {
        if (list.size() == nums.length) {
            if (!ans.contains(list)) {
                ans.add(new ArrayList<>(list));
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (index.contains(i)) {
                    continue;
                }
                index.add(i);
                list.add(nums[i]);
                backTracking(ans, list, index, nums);
                list.remove(list.size() - 1);
                index.remove(index.size() - 1);
            }
        }
    }

}
