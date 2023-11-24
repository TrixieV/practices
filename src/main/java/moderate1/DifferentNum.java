package moderate1;

import java.util.HashMap;

public class DifferentNum {
    public static void main(String[] args) {
        String s = "a01023bE1023c34d語8ef34";
        System.out.println("Count = " + diffNumCount(s));
    }

    private static int diffNumCount(String str) {
        HashMap<String, Integer> numMap = new HashMap<>();
        int count = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (numCheck(arr[i])) {
                StringBuilder numString = new StringBuilder();
                numString.append(arr[i]);
                for (int j = i + 1; j < arr.length; j++) {
                    if (numCheck(arr[j]) || arr[j] == '0') {
                        numString.append(arr[j]);
                    } else {
                        i = j;
                        if (numMap.get(numString.toString()) == null) {
                            numMap.put(numString.toString(), 1);
                            count++;
                            System.out.println(numString.toString());
                        }
                        break;
                    }
                }
            }
        }
        return count;
    }

    private static boolean numCheck(char c) {
        if (Character.getNumericValue(c) > 0 && Character.getNumericValue(c) <= 9) {
            return true;
        } else return false;
    }
}
