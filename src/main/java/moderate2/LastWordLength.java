package moderate2;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
 */
public class LastWordLength {
    public static void main(String[] args) {
        String s = new String("Hello     Wor ld   ");
        System.out.println(lengthOfLastWord(s));
    }
    private static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            count++;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == ' ') {
                    break;
                }
                count++;
            }
            break;
        }
        return count;
    }
}
