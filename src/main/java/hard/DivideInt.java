package hard;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part.
For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
[−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1,
then return 231 - 1, and if the quotient is strictly less than -231, then return -231.


 */
public class DivideInt {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    private static int divide(int dividend, int divisor) {
        int divideAns = 0;
        long remain = Math.abs((long) dividend);
        long divideNum = Math.abs((long) divisor);

        if (divideNum > remain) {
            return 0;
        }
        long sum = Math.abs((long) divisor);
        int count = 0;

        while (true) {
            if (sum + sum > remain) {
                remain -= sum;
                break;
            }
            sum += sum;
            count++;
        }

        while (remain >= divideNum) {
            remain -= divideNum;
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
                divideAns--;
                if (divideAns == Integer.MIN_VALUE) {
                    break;
                }
            } else {
                divideAns++;
                if (divideAns == Integer.MAX_VALUE) {
                    break;
                }
            }
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            divideAns -= Math.pow(2, count);
        } else {
            divideAns += Math.pow(2, count);
        }

        return divideAns;
    }
}
