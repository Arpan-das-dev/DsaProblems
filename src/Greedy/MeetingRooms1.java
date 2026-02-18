package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Utility class to determine if a single meeting room can accommodate all meetings.
 *
 * <p>Given an array of meeting time intervals {@code intervals[i] = [start_i, end_i]},
 * return {@code true} if one can attend all meetings without conflict (no overlaps).</p>
 *
 * <p><b>Approach:</b> Sort by Start Time + Greedy Check</p>
 * <ul>
 *   <li>Sort meetings by start time</li>
 *   <li>Track earliest end time of previous meeting</li>
 *   <li>For each subsequent meeting: if {@code prevEnd > currStart}, conflict exists</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n) sorting + O(n) scan = O(n log n).<br>
 * <b>Space Complexity:</b> O(1) extra space (ignoring sorting's internal space).</p>
 *
 * @author Arpan Das
 * @since 18/02/2026
 */
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms1 {

    /**
     * Returns true if all meetings can be attended in a single room (no overlaps).
     *
     * <p>Sorts meetings by start time, then checks if each meeting starts after previous ends.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  arr = [[0,30],[5,10],[15,20]]
     * Output: false
     * Explanation: [0,30] overlaps with [5,10]
     *
     * Input:  arr = [[7,10],[2,4]]
     * Output: true
     * Explanation: After sorting: [2,4],[7,10] → 4 ≤ 7 ✓
     * </pre>
     *
     * @param arr array of [start,end] meeting intervals
     * @return true if no overlaps (single room sufficient)
     */
    public boolean canAttend(int[][] arr) {
        // Handle edge cases
        if (arr == null || arr.length <= 1) return true;

        // Sort by start time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int prevEnd = arr[0][1];  // End time of first meeting

        // Check each subsequent meeting for overlap
        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];

            // Conflict: previous meeting hasn't ended when current starts
            if (prevEnd > curr[0]) {
                return false;
            }

            // Update end time of last meeting
            prevEnd = curr[1];
        }

        return true;  // No conflicts found
    }
}

