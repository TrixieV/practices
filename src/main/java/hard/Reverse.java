package hard;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range, then return 0.
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(findReverse(-123));
    }

    private static int findReverse(int x) {
        long reverseNum = 0;
        for (int i = 10; x != 0; x /= 10) {
            reverseNum += (x % i);
            reverseNum *= 10;
        }

        reverseNum /= 10;
        if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
            reverseNum = 0;
        }

        return (int)reverseNum;
    }
}
