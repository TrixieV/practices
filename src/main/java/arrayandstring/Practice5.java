package arrayandstring;

public class Practice5 {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "pae";
        System.out.println(checkTwoStrings(str1, str2));
    }

    private static boolean checkTwoStrings(String str1, String str2) {
        String s1 = (str1.length() <= str2.length())? str1 : str2;
        String s2 = (str2.length() >= str1.length())? str2 : str1;
        int differentOfLength = Math.abs(s1.length() - s2.length());
        if (differentOfLength > 1) return false;
        int index1 = 0, index2 = 0;
        boolean foundDifference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (differentOfLength == 1) {
                    index2++;
                }
                else if (differentOfLength == 0) {
                    index1++;
                    index2++;
                }
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
