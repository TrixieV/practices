package moderate1;

import java.util.HashMap;

public class MasterMind {
    public static void main(String[] args) {
        String solution = "GGBB";
        String guess = "BGBG";
        countHits(solution, guess);
    }

    private static void countHits(String solution, String guess) {
        char[] sol = solution.toCharArray();
        char[] gue = guess.toCharArray();
        char[] colors = new char[]{'R', 'G', 'B', 'W'};

        HashMap<Character, Integer> solMap = new HashMap<>();
        HashMap<Character, Integer> gueMap = new HashMap<>();
        int hits = 0, pseHits = 0;
        for (int i = 0; i < sol.length; i++) {
            if (solMap.get(sol[i]) == null) {
                solMap.put(sol[i], 1);
            } else {
                solMap.put(sol[i], solMap.get(sol[i]) + 1);
            }

            if (gueMap.get(gue[i]) == null) {
                gueMap.put(gue[i], 1);
            } else {
                gueMap.put(gue[i], gueMap.get(gue[i]) + 1);
            }

            if (sol[i] == gue[i]) {
                hits++;
            }
        }
        for (char color : colors) {
            if (solMap.get(color) != null && gueMap.get(color) != null) {
                pseHits += Math.min(solMap.get(color), gueMap.get(color));
            }
        }
        pseHits -= hits;
        System.out.println("Hits: " + hits);
        System.out.println("Pseudo hits: " + pseHits);
    }
}
