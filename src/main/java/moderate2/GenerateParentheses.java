package moderate2;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backCheck(ans,"", n, n);
        return ans;
    }

    private static void backCheck(List<String> ans, String str, int open, int close) {
        if (open == close && open == 0) {
            ans.add(str);
            return;
        }
        if (open > 0) {
            backCheck(ans, str + "(", open - 1, close);
        }
        if (close > open) {
            backCheck(ans, str + ")", open, close - 1);
        }
    }
}
