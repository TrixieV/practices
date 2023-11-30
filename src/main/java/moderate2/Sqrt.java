package moderate2;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.
*/
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    private static int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (((long) mid * mid) > (long)x) {
                right = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
