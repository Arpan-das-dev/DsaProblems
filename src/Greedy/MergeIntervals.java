package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Utility class to merge overlapping intervals into non-overlapping ranges.
 *
 * <p>Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping
 * intervals and return an array of non-overlapping intervals sorted by start time.</p>
 *
 * <p><b>Approach:</b> Sort + Greedy Merge</p>
 * <ul>
 *   <li>Sort intervals by start time</li>
 *   <li>Initialize {@code previousEnd} with first interval</li>
 *   <li>For each subsequent interval:
 *     <ul>
 *       <li>If {@code previousEnd ≥ current.start}: merge by extending end</li>
 *       <li>Else: add previous to result, set current as new previous</li>
 *     </ul>
 *   </li>
 *   <li>Add final previous interval to result</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n) sorting + O(n) merge = O(n log n).<br>
 * <b>Space Complexity:</b> O(n) for output (O(1) extra ignoring output).</p>
 *
 * @author Arpan Das
 * @since 17/02/2026
 */
import java.util.*;

public class MergeIntervals {

    /**
     * Merges all overlapping intervals into non-overlapping ranges.
     *
     * <p>Sorts by start time, then greedily merges consecutive overlapping intervals.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: [1,3] and [2,6] overlap → [1,6]
     *
     * Input:  intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Touching intervals merge (4==4)
     *
     * Input:  intervals = [[1,4],[0,4]]
     * Output: [[0,4]]
     * Explanation: After sorting [0,4],[1,4] → merge to [0,4]
     * </pre>
     *
     * @param intervals array of [start,end] pairs
     * @return merged non-overlapping intervals
     */
    public int[][] merge(int[][] intervals) {
        // Handle edge cases
        if (intervals == null || intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] previousEnd = intervals[0];  // First interval as initial merged

        // Merge overlapping intervals
        for (int index = 1; index < intervals.length; index++) {
            int[] curr = intervals[index];

            // Overlap: extend previous end to maximum of both ends
            if (previousEnd[1] >= curr[0]) {
                previousEnd[1] = Math.max(previousEnd[1], curr[1]);
            } else {
                // No overlap: save previous, start new merge
                merged.add(previousEnd);
                previousEnd = curr;
            }
        }

        // Add final merged interval
        merged.add(previousEnd);

        return merged.toArray(new int[merged.size()][]);
    }
}

