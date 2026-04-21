package DynamicProgramming.Knapsack;

/**
 * Utility class to count the number of ordered combinations that sum to a target.
 *
 * <p>Given an array of distinct positive integers nums and an integer target, return the number of
 * possible combinations that add up to target. Numbers can be used multiple times, and different
 * sequences are counted as different combinations (order matters).</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (1D dynamic programming):</b></p>
 * <ul>
 *   <li>Use a 1D DP array dp[0..target] where dp[i] represents the number of ways to form sum i.</li>
 *   <li>Initialize dp[0] = 1, since there is exactly one way to form sum 0 (using no numbers).</li>
 *   <li>For each current sum i from 1 to target, iterate through all numbers in nums.</li>
 *   <li>If the current number num ≤ i, we can append it to every combination that forms sum i − num;
 *       so dp[i] += dp[i − num].</li>
 *   <li>The final answer is dp[target].</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(target × nums.length) because for each of the target values,
 *   all numbers are considered once.<br>
 * <b>Space Complexity:</b> O(target) for the dp array.</p>
 *
 * @author Arpan Das
 * @since 21/04/2026
 */
public class CombinationSum4 {

    /**
     * Returns the number of ordered combinations of nums elements that sum to target.
     *
     * <p>Each element in nums may be used multiple times, and different orders of the same elements
     * are counted as different combinations. For example, for nums = [1,2,3] and target = 4,
     * combinations (1,1,2) and (2,1,1) are considered distinct.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [3,1,2], target = 4
     * Output: 7
     * Explanation:
     *   7 possible ordered combinations add up to 4:
     *   (1,1,1,1), (1,1,2), (1,2,1), (1,3), (2,1,1), (2,2), (3,1)
     *
     * Input: nums = [1,2], target = 3
     * Output: 3
     * Explanation:
     *   (1,1,1), (1,2), (2,1)
     * </pre>
     *
     * @param nums array of distinct positive integers; may not be null or empty
     * @param target the target sum (≥ 0)
     * @return the number of possible combinations that sum to target
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // 0 sum can be formed in 1 way: use no numbers

        // For each current sum from 1 to target
        for (int i = 1; i <= target; i++) {
            // For each number in nums
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}