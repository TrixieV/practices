package moderate2;

import java.util.ArrayList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtracking(int start, int k, int remain, List<Integer> list, List<List<Integer>> ans) {
        if (remain < 0 || list.size() > k || remain == 0 && list.size() < k) {
            return;
        } else if (remain == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9 && i <= remain; i++) {
            list.add(i);
            backtracking(i + 1, k, remain - i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
