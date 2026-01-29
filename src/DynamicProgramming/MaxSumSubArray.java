package DynamicProgramming;

/**
 * Utility class to find the contiguous subarray within an array that has the largest sum.
 *
 * <p>Given an integer array {@code nums}, return the maximum sum of any non-empty subarray.
 * A subarray is a contiguous sequence of elements within the array.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Kadane's Algorithm (dynamic programming with O(1) space).</li>
 *   <li>Maintain two variables:
 *     <ul>
 *       <li>{@code subSumEnds}: maximum sum of subarray ending at current index</li>
 *       <li>{@code maxSumSeen}: maximum subarray sum found so far</li>
 *     </ul>
 *   </li>
 *   <li>For each element, decide whether to:
 *     <ul>
 *       <li>Start a new subarray from current element, or</li>
 *       <li>Extend the previous subarray by adding current element</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>The key insight: at each position, the optimal subarray either starts fresh or extends the previous optimal ending there.</p>
 *
 * <p><b>Time Complexity:</b> O(n), single pass through the array.<br>
 * <b>Space Complexity:</b> O(1), only two variables used.</p>
 *
 * @author Arpan Das
 * @since 29/01/2026
 */
public class MaxSumSubArray {

    /**
     * Returns the maximum sum of any contiguous subarray using Kadane's Algorithm.
     *
     * <p>For each index i, {@code subSumEnds} represents the maximum sum ending at i:
     * <pre>subSumEnds[i] = max(nums[i], subSumEnds[i-1] + nums[i])</pre>
     * Track the global maximum across all such endings.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: Subarray [4,-1,2,1] has maximum sum 6.
     *
     * Input:  nums = [1]
     * Output: 1
     *
     * Input:  nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: Entire array sums to 23.
     *
     * Input:  nums = [-1]
     * Output: -1
     * Explanation: Single element is the maximum.
     * </pre>
     *
     * @param nums array of integers (non-empty after edge case handling)
     * @return the maximum sum of any contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        // Handle edge cases
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Initialize with first element
        int subSumEnds = nums[0];   // Max sum ending at current index
        int maxSumSeen = nums[0];   // Global maximum subarray sum

        // Iterate through remaining elements
        for (int index = 1; index < nums.length; index++) {
            // Either start new subarray OR extend previous subarray
            subSumEnds = Math.max(nums[index], subSumEnds + nums[index]);
            // Update global maximum
            maxSumSeen = Math.max(subSumEnds, maxSumSeen);
        }

        return maxSumSeen;
    }
}
