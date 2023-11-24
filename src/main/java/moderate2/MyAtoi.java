package moderate2;

/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
(similar to C/C++'s atoi function).
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("0000000000075808 string"));
//        System.out.println(Integer.MIN_VALUE);
    }

    private static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        boolean negative = false;
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+') {
                if (c == '-') {
                    negative = true;
                }
                if (s.charAt(i+1) < '0' || s.charAt(i+1) > '9') {
                    break;
                }
                continue;
            }
            if (c >= '0' && c <= '9') {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        result *= 10;
                        result += (s.charAt(j) - '0');
                        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                            break;
                        }
                    } else break;
                }
            }
            break;
        }

        if (negative) {
            result *= (-1);
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int)result;
    }
}















