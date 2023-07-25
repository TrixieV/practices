package arrayandstring;

public class Practice4 {
    public static void main(String[] args) {
        String str = "aaiikkffnnbbeerrhDDEEYuY";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        int[] arraysOfLetters = new int[26];
        // count for each letter
        for (int i = 0; i < str.length(); i++) {
            int numericOfChar = Character.toLowerCase(str.charAt(i)) - 'a';
            if (numericOfChar > -1 && numericOfChar < 26) {
                arraysOfLetters[numericOfChar] += 1;
            }
        }

        // check if the count is odd or even
        int numberOfOdd = 0;
        for (int i = 0; i < 26; i++) {
            if (arraysOfLetters[i] != 0 && (arraysOfLetters[i] % 2) != 0) {
                numberOfOdd++;
            }
        }
        if (numberOfOdd > 1) {
            return false;
        }
        return true;
    }
}
