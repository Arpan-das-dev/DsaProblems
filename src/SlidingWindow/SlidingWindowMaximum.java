package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Utility class to find maximum in each k-sized sliding window {@code NeetCode 150}.
 *
 * <p>LeetCode 239: Given {@code nums} and window size {@code k}, return max for each contiguous
 * subarray of size k. Output length = n-k+1.</p>
 *
 * <p><b>Approach:</b> Deque (Monotonic Decreasing Queue)</p>
 * <ul>
 *   <li>Deque stores <b>indices</b> in decreasing nums[] order</li>
 *   <li>Front = window maximum (always valid index)</li>
 *   <li>Remove: out-of-window indices + smaller values</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), each element added/removed once.<br>
 * <b>Space Complexity:</b> O(k).</p>
 *
 * @author Arpan Das
 * @since 22/03/2026
 */

public class SlidingWindowMaximum {

    /**
     * Returns maximum for each k-sized sliding window.
     *
     * <p>Deque maintains indices: front=largest valid, decreasing order.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums=[1,3,-1,-3,5,3,6,7], k=3
     * Windows: [1,3,-1]→3, [3,-1,-3]→3, [-1,-3,5]→5, [-3,5,3]→5, [5,3,6]→6, [3,6,7]→7
     * Output: [3,3,5,5,6,7] ✓
     * </pre>
     *
     * @param nums input array
     * @param k window size
     * @return max array for each window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(nums.length - k + 1);
        Deque<Integer> deque = new ArrayDeque<>();  // Indices in decreasing order

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices with smaller values (monotonic deque)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // First valid window: add max to result
            if (i >= k - 1) {
                result.add(nums[deque.getFirst()]);
            }
        }

        // Convert to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
