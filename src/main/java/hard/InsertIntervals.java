package hard;

import java.util.Arrays;
import java.util.LinkedList;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
 */
public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{21,22}};
        int[] newInterval = new int[]{15,19};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();

        if (intervals.length == 0) {
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }

        int start = intervals[0][0], end = intervals[0][1];
        int copyIndexFrom = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];

            if (end < newInterval[0]) {
                ans.add(new int[]{start, end});
                start = newInterval[0];
                end = newInterval[1];
            } else {
                if (newInterval[1] < start) {
                    start = newInterval[0];
                    end = newInterval[1];
                    copyIndexFrom = i;
                    break;
                }
                start = Math.min(start, newInterval[0]);
                end = Math.max(end, newInterval[1]);
                copyIndexFrom = i + 1;
                for (int j = i + 1; j < intervals.length; j++) {
                    if (end < intervals[j][0]) {
                        break;
                    } else {
                        end = Math.max(end, intervals[j][1]);
                        copyIndexFrom = j + 1;
                    }
                }
                break;
            }
        }
        ans.add(new int[]{start, end});

        for (int i = copyIndexFrom; i < intervals.length; i++) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
