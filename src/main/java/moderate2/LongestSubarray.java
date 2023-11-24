package moderate2;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array filled with letters and numbers,
find the longest subarray with
an equal number of letters and numbers
 */
public class LongestSubarray {
    public static void main(String[] args) {
        char[] arr = new char[]{'a','a','a','1','1','a','1',
                'a','a','a','1','1','1','1','a','a'};
        System.out.println(findSub(arr));
    }

    private static String findSub(char[] arr) {
        int letterCount = 0, numCount = 0, diff = 0;
        int low = 0, high = 0, max = 0;
        HashMap<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (numCheck(arr[i])) {
                numCount++;
            } else {
                letterCount++;
            }
            diff = letterCount - numCount;
            if (differenceMap.get(diff) == null) {
                differenceMap.put(diff, i);
            } else {
                if (i - differenceMap.get(diff) + 1 > max) {
                    low = differenceMap.get(diff);
                    high = i + 1;
                    max = high - low + 1;
                }
            }
        }

        char[] subArr = Arrays.copyOfRange(arr, low, high);
        return Arrays.toString(subArr);
    }

    private static boolean numCheck(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
