package arrayandstring;

import java.util.HashMap;

public class TwoSum {
    private static int[] find2Sum(int[] arr, int target) {
        if (arr.length == 2) return new int[]{0,1};
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            int remaining = target - arr[i];
            if (remaining >= 0 && map.get(remaining) != null) {
                return new int[]{map.get(remaining), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }
}
