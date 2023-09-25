package hard;

/*
Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = "1";
        String ans = "";
        for (int i = 2; i <= n; i++) {
            ans = convert(prev);
            prev = convert(prev);
        }
        return ans;
    }

    private static String convert(String s) {
        StringBuilder str = new StringBuilder();
        if (s.length() < 2) {
            return "11"; // 21
        }
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                str.append(count);
                str.append(s.charAt(i - 1));
                count = 1;
            }

            if (i == s.length() - 1) {
                str.append(count);
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
