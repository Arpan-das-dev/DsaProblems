package SlidingWindow;

/**
 * Utility class to find minimum swaps to group all 1's together (single contiguous segment).
 *
 * <p>LeetCode 1151: Given binary {@code nums}, return minimum swaps to make all 1's contiguous.
 * Return -1 if impossible (ones > array length).</p>
 *
 * <p><b>Approach:</b> Sliding Window (Min Zeros in Window of Size = Total Ones)</p>
 * <ul>
 *   <li>Count total ones (target window size)</li>
 *   <li>Slide window of size totalOnes, track zeros</li>
 *   <li>Min zeros = min swaps needed</li>
 * </ul>
 *
 * <p>{@code @code Time: O(n), Space: O(1)}<p>
 *
 * @author Arpan Das
 * @since 28/03/2026
 */
public class MinSwapsToGroupAllOnes {

    /**
     * Returns minimum swaps to make all 1's contiguous.
     *
     * <p>Swaps = zeros in optimal window covering all ones.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,0,1,0,1]
     * Total ones=3, window [0,1,0,1,0]→2 zeros → Output: 2 ✓
     * Swap to [1,1,1,0,0]
     *
     * Input: nums = [1,0,1,0,0]
     * Total ones=2, min zeros=1 → Output: 1
     *
     * Input: nums = [0,0,0,1]
     * Window size=1, zeros=0 → Output: 0
     * </pre>
     *
     * @param nums binary array (0s and 1s)
     * @return min swaps or -1 if impossible
     */
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        // Impossible if more ones than array length
        if (totalOnes == 0 || totalOnes > nums.length) {
            return 0;
        }

        int left = 0;
        int zerosInWindow = 0;
        int minSwaps = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            // Expand window
            if (nums[right] == 0) {
                zerosInWindow++;
            }

            int windowSize = right - left + 1;

            // Shrink when window reaches target size
            if (windowSize == totalOnes) {
                minSwaps = Math.min(minSwaps, zerosInWindow);

                // Slide window
                if (nums[left] == 0) {
                    zerosInWindow--;
                }
                left++;
            }
        }

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
}
