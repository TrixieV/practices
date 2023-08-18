package hard;

/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
 */
public class MatchingWords {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "aa*";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;

        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (state[0][j - 2])) {
                    state[0][j] = true;
                }
            }
        }
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
}

//        int sPointer = 0;
//        int pPointer = 0;
//
//        while (pPointer < p.length()) {
//            if (sPointer < s.length() && s.charAt(sPointer) == p.charAt(pPointer)) {
//                sPointer++;
//                pPointer++;
//                continue;
//            }
//            if (p.charAt(pPointer) == '.') {
//                if (pPointer < p.length() - 1 && p.charAt(pPointer + 1) == '*') {
//                    if (pPointer + 2 == p.length()) {
//                        return true;
//                    } else {
//                        if (sPointer < s.length() && s.charAt(sPointer) != p.charAt(pPointer + 2)) {
//                            sPointer++;
//                            continue;
//                        } else if (sPointer >= s.length()) {
//                            return false;
//                        }
//                        pPointer += 3;
//                    }
//                }
//            }
//            if (s.charAt(sPointer) != p.charAt(pPointer) &&
//                    (p.charAt(pPointer) != '.' && p.charAt(pPointer) != '*')) {
//                return false;
//            }
//            if (p.charAt(pPointer) == '*') {
//                if (p.charAt(pPointer - 1) == '.') {
//                    sPointer++;
//                } else {
//
//                }
//            }
//        }

