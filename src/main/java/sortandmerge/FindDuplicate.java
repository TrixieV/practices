package sortandmerge;

import java.util.HashMap;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] array = new int[]{1,4,7,2,3,1,6,5,3,5,8,9,10,12,12,3,11};
        findDup(array);
    }

    private static void findDup(int[] arr) {

        // mapping number as key and count as value
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                int count = map.get(arr[i]) + 1;
                map.put(arr[i], count);
            }
        }

        map.forEach((key, value) -> {
            if (value > 1) {
                printNTimes(key, value);
            }
        });
    }

    private static void printNTimes(int number, int times) {
        for (int i = 1; i <= times; i ++) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }
}
