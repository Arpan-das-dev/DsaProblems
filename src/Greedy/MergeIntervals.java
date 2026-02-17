package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merge = new ArrayList<>();
        int [] previousEnd = intervals[0];

        for (int index = 1; index < intervals.length; index++) {
            int[] curr = intervals[index];
            if(previousEnd[1] >= curr[0]) {
                previousEnd[1] = Math.max(previousEnd[1], curr[1]);
            } else {
                merge.add(previousEnd);
                previousEnd = curr;
            }
        }
        merge.add(previousEnd);
        return merge.toArray(new int[merge.size()][]);
    }
}
