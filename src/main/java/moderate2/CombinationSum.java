package moderate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations
that sum up to target is less than 150 combinations for the given input.


 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{4,5,6,7,8,9};
        System.out.println(combinationSum(candidates, 20));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<>(), candidates, 0, target);
        return ans;
    }

    private static void backTracking(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int remaining) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > remaining) {
                    break;
                }
                list.add(candidates[i]);
                backTracking(ans, list, candidates, i, remaining - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}