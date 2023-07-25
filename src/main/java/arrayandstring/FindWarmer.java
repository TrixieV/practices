package arrayandstring;

import java.util.Arrays;

public class FindWarmer {
    public static void main(String[] args) {
        int[] tem = new int[]{70,77,55,48,30,77,100,31,100,69,60,47,95,68,47,33,64};
        System.out.println(Arrays.toString(findWarmerDay(tem)));
    }

    private static int[] findWarmerDay(int[] temperatures) {
        int len = temperatures.length;
        int[] daysFound = new int[len];
        daysFound[len - 1] = 0;
        int low = len - 2;
        int high = low + 1;
        while (low >= 0) {
            if (temperatures[low] < temperatures[high]) {
                daysFound[low] = high - low;
            } else {
                int nextJump = high + daysFound[high];
                if (temperatures[low] < temperatures[nextJump]) {
                    daysFound[low] = nextJump - low;
                }
                if (temperatures[low] >= temperatures[nextJump] && daysFound[nextJump] != 0) {
                    high = nextJump;
                    continue;
                }
            }
            low--;
            high = low + 1;
        }
        return daysFound;
    }
}
