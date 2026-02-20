package Greedy;

import java.util.Arrays;

/**
 * Utility class to determine minimum meeting rooms required for all meetings.
 *
 * <p>Given two arrays {@code start} and {@code end} representing meeting start/end times,
 * return minimum number of conference rooms required so all meetings can occur.</p>
 *
 * <p><b>Approach:</b> Two Pointers + Sorting (Optimal O(1) Space)</p>
 * <ul>
 *   <li>Sort both start and end arrays independently</li>
 *   <li>Two pointers {@code st, en} track current positions</li>
 *   <li>While processing:
 *     <ul>
 *       <li>If {@code start[st] < end[en]}: new room needed (meeting starts)</li>
 *       <li>Else: room freed ({@code rooms--}, {@code en++})</li>
 *     </ul>
 *   </li>
 *   <li>Track maximum concurrent rooms needed</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n) sorting + O(n) two pointers.<br>
 * <b>Space Complexity:</b> O(1) extra space (ignores sorting internals).</p>
 *
 * @author Arpan Das
 * @since 20/02/2026
 */

public class MeetingRooms2 {

    /**
     * Returns minimum conference rooms required for all meetings.
     *
     * <p>Sorts start/end times separately, uses two pointers to simulate room usage over time.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: start = [0,5,15], end = [30,10,20]
     * Output: 2
     * Timeline: [0-10]:1 room, [5-10]:2 rooms peak, [15-20]:1 room
     *
     * Input: start = [1,5,10,15], end = [2,3,12,20]
     * Output: 2
     * Timeline: 1-2:1, 5-3:1 (wait), 10-12:1, 15-20:1 → max 2 concurrent
     *
     * Input: start = [0], end = [30]
     * Output: 1
     *
     * Input: start = [], end = []
     * Output: 0
     * </pre>
     *
     * @param start array of meeting start times
     * @param end   array of corresponding end times
     * @return minimum rooms needed
     */
    public int minMeetingRooms(int[] start, int[] end) {
        if (start == null || start.length == 0) return 0;

        // Sort both arrays independently
        Arrays.sort(start);
        Arrays.sort(end);

        int st = 0;        // Start times pointer
        int en = 0;        // End times pointer
        int rooms = 0;     // Current rooms in use
        int maxRooms = 0;  // Peak rooms needed

        // Process all events chronologically
        while (st < start.length) {
            if (start[st] < end[en]) {
                // New meeting starts: allocate room
                rooms++;
                st++;
            } else {
                // Meeting ends: free room
                rooms--;
                en++;
            }
            // Track maximum concurrency
            maxRooms = Math.max(maxRooms, rooms);

            // Ensure end pointer doesn't exceed
            if (en == end.length) break;
        }
        return maxRooms;
    }
}

