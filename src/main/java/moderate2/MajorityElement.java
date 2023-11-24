package moderate2;

/*
Majority Element: A majority element is an element that makes up more than half of the items in an array.
Given a positive integers array, find the majority element. If there is no majority element, return -1.
Do this in O(N) time and 0(1) space.
EXAMPLE
Input: 125959555
Output: 5
 */

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(findMajority("166666663208675"));
    }

    private static int findMajority(String arr) {
        int max = 1;
        int majorNum = -1;
        int sumNumber = 0;
        if (arr.length() <= 1) {
            return -1;
        }
        HashMap<Character, Integer> countingInt = new HashMap<>();
        for (int i = 0; i < arr.length(); i++) {
            sumNumber++;
            char num = arr.charAt(i);
            if (numCheck(num)) {
                if (countingInt.get(num) == null) {
                    countingInt.put(num, 1);
                } else {
                    int updatingCount = countingInt.get(num) + 1;
                    countingInt.put(num, updatingCount);
                    if (max < updatingCount) {
                        max = updatingCount;
                        majorNum = Integer.parseInt(String.valueOf(num));
                    }

                }
            }
        }

        if (max >= (sumNumber / 2)) {
            return majorNum;
        }
        return -1;
    }

    private static boolean numCheck(char c) {
        return c >= '0' && c <= '9';
    }
}



















