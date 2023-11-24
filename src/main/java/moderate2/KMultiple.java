package moderate2;

/*
Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
Note that 3, 5, and 7 do not have to be factors,but it should not have any other prime factors.
For example,the first several multiples would be(in order) 1,3,5,7,9,15, 21.
 */

import java.util.LinkedList;
import java.util.Queue;

public class KMultiple {
    public static void main(String[] args) {
        System.out.println(findKth(7));
    }

    private static int findKth(int k) {
        int kthValue = 0;
        Queue<Integer> queuePow3 = new LinkedList<>();
        Queue<Integer> queuePow5 = new LinkedList<>();
        Queue<Integer> queuePow7 = new LinkedList<>();
        queuePow3.add(1);

        for (int i = 1; i <= k; i++) {
            int val3 = (queuePow3.size() > 0) ? queuePow3.peek() : Integer.MAX_VALUE;
            int val5 = (queuePow5.size() > 0) ? queuePow5.peek() : Integer.MAX_VALUE;
            int val7 = (queuePow7.size() > 0) ? queuePow7.peek() : Integer.MAX_VALUE;

            int min = Math.min(val3, Math.min(val5, val7));
            if (queuePow3.contains(min)) {
                queuePow3.remove();
                queuePow3.add(min * 3);
                queuePow5.add(min * 5);
            }
            if (queuePow5.contains(min)) {
                queuePow5.remove();
                queuePow5.add(min * 5);
            }
            if (queuePow7.contains(min)) {
                queuePow7.remove();
            }
            queuePow7.add(min * 7);

            kthValue = min;
        }

        return kthValue;
    }
}
