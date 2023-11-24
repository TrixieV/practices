package moderate2;

/*
Given a string s, return the longest palindromic substring in s.
 */
public class PalindromicSubstring {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(checkPalindrome(s));
        System.out.println(longestPalindromicSub(s));
    }

    private static String longestPalindromicSub(String s) {
        int max = 0;
        String palindromeFound = new String();

        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sub = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sub.append(s.charAt(j));
                if (checkPalindrome(sub.toString())) {
                    if (max < sub.length()) {
                        max = sub.length();
                        palindromeFound = sub.toString();
                    }
                }
            }
        }
        return palindromeFound;
    }

    private static boolean checkPalindrome(String s) {
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
