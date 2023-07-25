package arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcdejanbcguej";
        System.out.println(findLongest(s));
    }

    private static int findLongest(String s) {
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        int longest = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < chars.length; right++) {
            if (!set.contains(chars[right])) {
                set.add(chars[right]);
                longest = Math.max(longest, right - left + 1);
            } else {
                while (set.contains(chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[right]);
            }
        }
        return longest;
    }
}
