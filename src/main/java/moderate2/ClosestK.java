package moderate2;

import java.util.PriorityQueue;

public class ClosestK {
    private static int[][] kClosest(int[][] points, int k) {
        if (points.length == 0) {
            return null;
        }
        PriorityQueue<int[]> sortedQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < points.length; i++) {
            int distancePow = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            sortedQueue.add(new int[]{i, distancePow});
        }

        int[][] ans = new int[k][];

        while (k > 0) {
            ans[k-1] = points[sortedQueue.poll()[0]];
            k--;
        }

        return ans;
    }
}
