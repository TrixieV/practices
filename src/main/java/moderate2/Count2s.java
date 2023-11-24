package moderate2;

/*
Write a method to count the number of 2s that appear
in all the numbers between O and n (inclusive).
EXAMPLE
Input: 25
Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25.
Note that 22 counts for two 2s.)
 */
public class Count2s {
    public static void main(String[] args) {
        System.out.println(countTwo(1000));
    }

    private static int countTwo(int range) {
        int count = 0;
        for (int i = 0; i <= range; i++) {
            count += count2InNum(i);
        }

        return count;
    }

    private static int count2InNum(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) {
                count++;
            }
            num /= 10;
        }

        return count;
    }

//    private static int countInPowerOf10(int range) {
//        int count = 0;
//
//        int downRange = range / 10;
//        if (downRange == 1) {
//            count = 1;
//        } else {
//            count += (countInPowerOf10(downRange) * 10 + downRange);
//        }
//
//        return count;
//    }

}
