package Greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i  =0;
        int limit = intervals.length;

        // add exactly those intervals which are before new interval
        // we decide it by checking if current interval's end time is before new interval's start time
        while (i < limit && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // now check for next intervals and update the new intervals
        // while start will be the lower limit and end will be the max limit
        while (i < limit && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        // add the updated result;
        result.add(newInterval);

        // add remaining element left in the intervals
        while (i<limit) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
