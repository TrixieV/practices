package moderate2;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
 */
public class Combination {
    public static void main(String[] args) {
        System.out.println(combine(10, 3));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    private static void backTracking(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            backTracking(n, k - 1, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
