package moderate1;
/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.
 */
public class FirstOccurrence {
    public static void main(String[] args) {
        String haystack = "cccc";
        String needle = "c";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if ((j + i) >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    } else {
                        if (j == needle.length() - 1) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
