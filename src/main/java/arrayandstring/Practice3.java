package arrayandstring;

public class Practice3 {
    public static void main(String[] args) {
        String str = "Hello my new friend       ";
        System.out.println(replaced(str));
    }

    private static String replaced(String str) {
        // find real length of string
        int realLength = 0;
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            realLength = i + 1;
            break;
        }

        // make a new array with real length
        // use StringBuilder to append new string
        char[] toArray = new char[realLength];
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < realLength; i++) {
            toArray[i] = str.charAt(i);
            if (toArray[i] != ' ') {
                newString.append(toArray[i]);
            } else {
                newString.append("%20");
            }
        }

        return newString.toString();
    }
}
