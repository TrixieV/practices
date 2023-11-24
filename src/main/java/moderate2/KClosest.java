package moderate2;

import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosest {
    private static int[][] kClosest(int[][] points, int k) {
        if (points.length == 0) {
            return null;
        }
        PriorityQueue<int[]> sortedQueue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
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
