package hard;

import java.util.HashMap;

/*
Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

Constraints:

1 <= num <= 3999
 */
public class RomanNumber {
    public static void main(String[] args) {
        int num = 1345;
        System.out.println(intToRoman(num));

        String s = "MCCCLXXXV";
        System.out.println(romanToInt(s));
    }

    private static String intToRoman(int num) {
        HashMap<Integer, Character> romanNumMap = new HashMap<>();
        romanNumMap.put(1000, 'M');
        romanNumMap.put(500, 'D');
        romanNumMap.put(100, 'C');
        romanNumMap.put(50, 'L');
        romanNumMap.put(10, 'X');
        romanNumMap.put(5, 'V');
        romanNumMap.put(1, 'I');
        
        StringBuilder conversion = new StringBuilder();
        
        for (int i = 1000; i >= 1; i /= 10) {
            int digit = num / i;

            if ((digit <= 3 && digit >= 1) || (digit >= 5 && digit <= 8)) {
                if (digit > 3) {
                    digit -= 5;
                    conversion.append(romanNumMap.get(i * 5));
                }
                for (int j = 0; j < digit; j++) {
                    conversion.append(romanNumMap.get(i));
                }
            } else if (digit == 4 || digit == 9) {
                conversion.append(romanNumMap.get(i));
                conversion.append(romanNumMap.get((digit + 1) * i));
            }
            num = num % i;
        }

        return conversion.toString();
    }

    private static int romanToInt(String s) {

        int result = 0, curr = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> curr = 1000;
                case 'D' -> curr = 500;
                case 'C' -> curr = 100;
                case 'L' -> curr = 50;
                case 'X' -> curr = 10;
                case 'V' -> curr = 5;
                case 'I' -> curr = 1;
            }
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }
}













