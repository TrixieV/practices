package hard;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(8338));
    }

    private static boolean checkPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int afterReverse = 0;

        while (x > afterReverse) {
            afterReverse = afterReverse * 10 + (x % 10);
            x /= 10;
        }

        System.out.println(afterReverse);

        if (afterReverse == x || x == afterReverse / 10) {
            return true;
        }

        return false;
    }
}
