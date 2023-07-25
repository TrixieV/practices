package arrayandstring;

import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        String str1 = "asdfghjkl";
        String str2 = "alskdjohg";
        System.out.println(isPermutation(str1, str2));
    }

    private static char[] sort(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] sorted1 = sort(str1);
        char[] sorted2 = sort(str2);
        for (int i = 0; i < str1.length(); i++) {
            if (sorted1[i] != sorted2[i]) {
                return false;
            }
        }
        return true;
    }
}
