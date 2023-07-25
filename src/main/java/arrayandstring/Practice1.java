package arrayandstring;

public class Practice1 {
    public static void main(String[] args) {
        String str1 = "ajuhfncbre";
        String str2 = "aorgnxuwjgla";

        System.out.println("Str1: " + isUniqueChars(str1));
        System.out.println("Str2: " + isUniqueChars(str2));
    }

    private static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;
        boolean[] alreadyExist = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int charAtI = str.charAt(i);
            if (alreadyExist[charAtI]) {
                return false;
            }
            alreadyExist[charAtI] = true;
        }
        return true;
    }
}
