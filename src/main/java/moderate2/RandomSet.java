package moderate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
Write a method to randomly generate a set of m integers from an array of size n.
Each element must have equal probability of being chosen.
 */
public class RandomSet {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,9,10,6,7,30,4,56,23,89,74,12,32,25,48};
        int[] pickRandom = pickRandomSet(arr, 6);
        System.out.println(Arrays.toString(pickRandom));
    }

    private static int[] pickRandomSet(int[] arr, int count) {
        List<Integer> indexList = new ArrayList<>();
        int[] randomSet = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int pickIndex = random.nextInt(arr.length - 1);
            if (!indexList.contains(pickIndex)) {
                indexList.add(pickIndex);
                randomSet[i] = arr[pickIndex];
            }
        }
        return randomSet;
    }
}
