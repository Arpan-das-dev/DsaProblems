package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Utility class to find minimum interval length covering each query point (NeetCode 150 sheet).
 *
 * <p>LeetCode 1855: Given {@code intervals} and {@code queries}, for each query q return smallest
 * length of interval [li,ri] where li≤q≤ri (or -1 if none). Return answers in input order.</p>
 *
 * <p><b>Approach:</b> Sort + Sweep Line + Min-Heap</p>
 * <ul>
 *   <li>Sort intervals by start, queries by value</li>
 *   <li>Max-heap stores valid intervals by {length, end}</li>
 *   <li>Add intervals starting ≤ query, remove expired</li>
 * </ul>
 *
 * <p>{@code @code Time: O(n log n), Space: O(n)}<p>
 *
 * @author Arpan Das
 * @since 23/03/2026
 * <p><b>Part of {@code NeetCode 150}</b></p>
 */

public class MinIntervalToIncludeEachQuery {

    /**
     * Returns array where result[i] = min length covering queries[i].
     *
     * <p>Processes queries in sorted order, maintains valid intervals heap.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: intervals=[[2,3],[2,5],[1,8],[20,25]], queries=[2,3]
     * q=2: [2,3](len=2), [2,5](4), [1,8](8) → 2
     * q=3: [2,5](3), [1,8](8) → 3
     * Output: [2,3]
     * </pre>
     *
     * @param intervals list of [start,end]
     * @param queries query points
     * @return min lengths in query order
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Sort queries with original indices
        Integer[][] queryArray = new Integer[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queryArray[i][0] = queries[i];
            queryArray[i][1] = i;
        }
        Arrays.sort(queryArray, Comparator.comparingInt(a -> a[0]));

        // Min-heap: {length, end} for valid intervals
        PriorityQueue<int[]> validIntervals = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        int intervalIdx = 0;

        // Process queries in order
        for (Integer[] query : queryArray) {
            int qValue = query[0];
            int origIdx = query[1];

            // Add all intervals starting before/at query
            while (intervalIdx < intervals.length &&
                    intervals[intervalIdx][0] <= qValue) {
                int start = intervals[intervalIdx][0];
                int end = intervals[intervalIdx][1];
                int length = end - start + 1;
                validIntervals.offer(new int[]{length, end});
                intervalIdx++;
            }

            // Remove expired intervals (end < query)
            while (!validIntervals.isEmpty() &&
                    validIntervals.peek()[1] < qValue) {
                validIntervals.poll();
            }

            // Smallest valid length
            if (!validIntervals.isEmpty()) {
                result[origIdx] = validIntervals.peek()[0];
            }
        }

        return result;
    }
}