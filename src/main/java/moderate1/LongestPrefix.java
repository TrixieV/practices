package moderate1;

import java.util.Arrays;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder prefix = new StringBuilder();
        int l1 = strs[0].length();
        int l2 = strs[strs.length - 1].length();

        for (int i = 0; i < l1; i++) {
            if (i >= l2) {
                break;
            }
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                prefix.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return prefix.toString();
    }
}
