package moderate1;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> openParentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParentheses.push(')');
            }else if (s.charAt(i) == '[') {
                openParentheses.push(']');
            } else if (s.charAt(i) == '{') {
                openParentheses.push('}');
            } else {
                if (openParentheses.empty()) {
                    return false;
                }
                if (openParentheses.pop() == s.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (!openParentheses.empty()) {
            return false;
        }
        return true;
    }
}
