package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to insert new interval into sorted non-overlapping intervals list.
 *
 * <p>Given sorted non-overlapping {@code intervals} and {@code newInterval}, insert newInterval
 * into list, merging overlapping intervals. Output sorted non-overlapping intervals.</p>
 *
 * <p><b>Approach:</b> Three Phase Linear Scan (O(n))</p>
 * <ul>
 *   <li><b>Phase 1:</b> Add all intervals completely before newInterval</li>
 *   <li><b>Phase 2:</b> Merge all overlapping intervals into newInterval</li>
 *   <li><b>Phase 3:</b> Add all remaining intervals after merged newInterval</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) single pass.<br>
 * <b>Space Complexity:</b> O(n) for output.</p>
 *
 * @author Arpan Das
 * @since 21/02/2026
 */

public class InsertIntervals {

    /**
     * Inserts newInterval into sorted intervals, merging overlaps.
     *
     * <p>Assumes input intervals sorted and non-overlapping. Mutates newInterval during merge.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Phase1: add [1,3] (3<2? no → 3>=2 ✓), Phase2: merge [1,3]+[2,5]=[1,5]
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Phase2 merges [3,5],[6,7],[8,10] → [3,10]
     *
     * Input: intervals = [], newInterval = [5,7]
     * Output: [[5,7]]
     *
     * Input: intervals = [[1,5]], newInterval = [2,3]
     * Output: [[1,5]] (completely contained)
     * </pre>
     *
     * @param intervals sorted non-overlapping intervals
     * @param newInterval interval to insert
     * @return merged sorted non-overlapping intervals
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add intervals completely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge all overlapping/contained intervals into newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Extend newInterval to cover current
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        result.add(newInterval);

        // Phase 3: Add remaining intervals (all after merged newInterval)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
