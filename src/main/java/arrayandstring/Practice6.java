package arrayandstring;

public class Practice6 {
    public static void main(String[] args) {
        String str = "aabbcdeeeeeeeejjj";
        System.out.println(conpressionString(str));
    }

    private static String conpressionString(String str) {
        int count = 0;
        StringBuilder newString = new StringBuilder();
        // count each letter
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i+1 == str.length() || str.charAt(i) != str.charAt(i+1)) {
                newString.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        return (str.length() > newString.toString().length())? newString.toString() : str;
    }
}
