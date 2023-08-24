package moderate;

import java.util.HashMap;

/*
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aaaaabbb";
        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> allLetters = new HashMap<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (!allLetters.containsKey(c)) {
                allLetters.put(c, 1);
            } else {
                count += 2;
                allLetters.remove(c);
            }
        }
        if (allLetters.size() > 0) {
            count++;
        }

        return count;

    }
}
