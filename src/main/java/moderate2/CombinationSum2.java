package moderate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        checkAndUpdateList(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private static void checkAndUpdateList(List<List<Integer>> ans, int[] candidates, int remaining, int start,
                                           List<Integer> list) {
        if (remaining < 0) {
            return;
        } else if (remaining == 0) {
            if (!ans.contains(list)) {
                ans.add(new ArrayList<>(list));
            }
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                if (candidates[i] > remaining) {
                    break;
                }
                list.add(candidates[i]);
                checkAndUpdateList(ans, candidates, remaining - candidates[i], i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
