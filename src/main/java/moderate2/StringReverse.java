package moderate2;

import java.util.Stack;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class StringReverse {
    public static void main(String[] args) {
        String s = "  Hello   my  name  is    Thao   ";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords2(String s) {
        StringBuilder ans = new StringBuilder();
        int start = s.length() - 1, end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                if (i == 0) {
                    ans.append(s, start, end);
                    break;
                }
            } else {
                if (!s.substring(start, end).equals(" ")) {
                    ans.append(s, start, end);
                    ans.append(" ");
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) != ' ') {
                        i = j + 1;
                        break;
                    }
                    i = j;
                }
                end = i;
            }
        }
        if (ans.substring(ans.length() - 1).equals(" ")) {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.toString();
    }

    private static String reverseWords(String s) {
        Stack<String> words = new Stack<>();
        String[] allWords = s.split(" ");
        for (String word : allWords) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!words.isEmpty()) {
            ans.append(words.pop());
            if (words.isEmpty()) {
                continue;
            }
            ans.append(" ");
        }

        return ans.toString();
    }
}
