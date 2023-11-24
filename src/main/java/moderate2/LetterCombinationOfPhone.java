package moderate2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
 */
public class LetterCombinationOfPhone {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        String[] phoneLettersMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new LinkedList<>();
        backTrack("", phoneLettersMap, digits, output);

        return output;
    }

    private static void backTrack(String combination, String[] phoneLettersMap, String nextDigit, List<String> output) {
        if (nextDigit.isEmpty()) {
            output.add(combination);
        } else {
            String letters = phoneLettersMap[nextDigit.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                String combined = combination + letter;
                backTrack(combined, phoneLettersMap, nextDigit.substring(1), output);
            }
        }
    }
}




















