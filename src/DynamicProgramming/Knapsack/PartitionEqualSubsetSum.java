package DynamicProgramming;

/**
 * Utility class to determine whether an array can be partitioned into two subsets with equal sum.
 *
 * <p>Given a non‑empty array of positive integers, decide whether it is possible to partition
 * the array into two non‑empty subsets such that the sum of elements in both subsets is equal.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 150}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Compute the total sum of the array. If it is odd, equal partition is impossible.</li>
 *   <li>If the sum is even, the problem reduces to finding a subset whose sum equals sum/2.</li>
 *   <li>Use a 1D dynamic‑programming boolean array dp[0..target] where dp[i] is true if a subset
 *       with sum i can be formed.</li>
 *   <li>For each number in the array, iterate backwards from target down to the number to update
 *       dp[i] using the standard 0‑1 knapsack recurrence: dp[i] = dp[i] || dp[i − num].</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n * sum) where n = nums.length and sum is the total sum of the array.<br>
 * <b>Space Complexity:</b> O(sum) for the dp array.</p>
 *
 * @author Arpan Das
 * @since 04/04/2026
 */
public class PartitionEqualSubsetSum {

    /**
     * Returns whether the array can be partitioned into two subsets with equal sum.
     *
     * <p>The input array is treated as a set of items with weights nums[i]. The goal is to split
     * them into two subsets such that the sum of each subset is exactly half the total sum.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: subsets [1,5,5] and [11] each have sum 11.
     *
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: no subset of nums sums to 11/2 = 5.5, and total sum is odd so equal partition impossible.
     * </pre>
     *
     * @param nums array of positive integers
     * @return {@code true} if the array can be partitioned into two equal‑sum subsets; {@code false} otherwise
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }

        // If total sum is odd, equal partition is impossible
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        // dp[i] = true if sum i can be formed by some subset of nums
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 0‑1 knapsack style: iterate backwards to avoid reusing the same element
        for (int item : nums) {
            for (int i = target; i >= item; i--) {
                dp[i] = dp[i] || dp[i - item];
            }
        }

        return dp[target];
    }
}