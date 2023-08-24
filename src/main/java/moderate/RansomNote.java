package moderate;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed
by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "adbcz";
        String magazine = "abcdz";

        System.out.println(canConstruct(ransomNote, magazine));
    }
    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] letters = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                letters[ransomNote.charAt(i) - 'a'] -= 1;
            }
            letters[magazine.charAt(i) - 'a'] += 1;
        }

        for (int count : letters) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
