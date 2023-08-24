package moderate;

import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> allChars = new HashMap<>();

//        for (int i = 0; i < s.length(); i++) {
//            if (allChars.get(Character.getNumericValue(s.charAt(i))) == null) {
//                allChars.put(Character.getNumericValue(s.charAt(i)), 1);
//            } else {
//                allChars.put(Character.getNumericValue(s.charAt(i)),
//                        allChars.get(Character.getNumericValue(s.charAt(i))) + 1);
//            }
//
//            if (allChars.get(Character.getNumericValue(t.charAt(i))) == null) {
//                allChars.put(Character.getNumericValue(t.charAt(i)), -1);
//            } else {
//                allChars.put(Character.getNumericValue(t.charAt(i)),
//                        allChars.get(Character.getNumericValue(t.charAt(i))) - 1);
//            }
//        }
        for (char c : s.toCharArray()) {
            if (allChars.get(c) == null) {
                allChars.put(c, 1);
            } else {
                allChars.put(c, allChars.get(c) + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (allChars.get(c) == null || allChars.get(c) == 0) {
                return false;
            } else {
                allChars.put(c, allChars.get(c) - 1);
            }
        }
        return true;
    }
}
