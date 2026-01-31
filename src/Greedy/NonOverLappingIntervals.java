package Greedy;

import java.util.Arrays;

/**
 * Utility class to find the minimum number of intervals to remove to make the rest non-overlapping.
 *
 * <p>Given an array of intervals {@code intervals} where intervals[i] = [start_i, end_i],
 * return the minimum number of intervals to remove so that the remaining intervals do not overlap.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Greedy by End Time:</b> Sort intervals by ending time (earliest first).</li>
 *   <li>Iterate through sorted intervals, keeping track of the end time of the last selected interval ({@code prevEnd}).</li>
 *   <li>For each interval:
 *     <ul>
 *       <li>If it overlaps with previous ({@code start < prevEnd}): remove it (increment count), continue</li>
 *       <li>Else: select it, update {@code prevEnd} to its end time</li>
 *     </ul>
 *   </li>
 *   <li>Count of removed intervals is the minimum needed.</li>
 * </ul>
 *
 * <p>Sorting by end time is optimal because it greedily selects intervals that finish earliest,
 * maximizing room for subsequent non-overlapping intervals.</p>
 *
 * <p><b>Time Complexity:</b> O(n log n) due to sorting, O(n) for the greedy pass.<br>
 * <b>Space Complexity:</b> O(1) or O(n) depending on sorting implementation.</p>
 *
 * @author Arpan Das
 * @since 31/01/2026
 */
public class NonOverLappingIntervals {

    /**
     * Returns the minimum number of intervals to remove for non-overlapping remainder.
     *
     * <p>Sorts intervals by end time, then greedily selects non-overlapping intervals.
     * Each overlap increments the removal count.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: Remove [1,3] → remaining [1,2],[2,3],[3,4] are non-overlapping.
     *
     * Input:  intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: All overlap → keep 1, remove 2.
     *
     * Input:  intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: No overlap → remove nothing.
     * </pre>
     *
     * @param intervals array of [start,end] pairs
     * @return minimum number of intervals to remove
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Handle edge case
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by end time (earliest first) - key greedy insight
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;        // Number of intervals to remove
        int prevEnd = intervals[0][1];  // End time of last selected interval

        for (int i = 1; i < intervals.length; i++) {
            // Current interval overlaps with previous selected
            if (intervals[i][0] < prevEnd) {
                count++; // Remove current interval
            } else {
                // No overlap → select this interval
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}


