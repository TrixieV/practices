package moderate;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A A ";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        String str = s.toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char l = str.charAt(left);
            char r = str.charAt(right);
            if (alphaCheck(l) && alphaCheck(r)) {
                if (l == r) {
                    left++;
                    right--;
                    continue;
                } else {
                    return false;
                }
            }
            if (!alphaCheck(l)) {
                left++;
            }
            if (!alphaCheck(r)) {
                right--;
            }
        }
        return true;
    }

    private static boolean alphaCheck(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}
