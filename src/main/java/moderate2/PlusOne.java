package moderate2;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is
the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    private static int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] newDigits = new int[len + 2];
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}
