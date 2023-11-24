package moderate2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3}, {12, 15},{8,10},{2,9}, {4,5}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> ans = new LinkedList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (end >= intervals[i+1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
            } else {
                ans.add(new int[]{start, end});
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}
