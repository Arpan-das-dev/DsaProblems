package DynamicProgramming.LinearDP;

/**
 * Dynamic Programming solution for minimum cost to reach top of stairs.
 *
 * <p>Given an array where cost[i] represents the cost of sitting/starting from the i-th step,
 * find the minimum cost to reach the top (index N). You are allowed to climb either 1 or 2 steps
 * at a time from any step.</p>
 *
 * <p><b>Key Insight:</b> At each step i, the minimum cost to reach i is cost[i] plus the minimum of:
 * <ul>
 *   <li>dp[i-1] (coming from 1 step below)</li>
 *   <li>dp[i-2] (coming from 2 steps below)</li>
 * </ul></p>
 *
 * <p><b>DP Definition:</b> dp[i] = minimum cost to reach step i (0-indexed)</p>
 * <pre>dp[0] = cost[0], dp[1] = cost[1]
 * dp[i] = cost[i] + min(dp[i-1], dp[i-2]) for i ≥ 2</pre>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Starting at index 0 → 2 → 4 → 6 → 9 gives minimum cost = 1+1+1+1+1+1 = 6
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start at index 1, pay cost[1] = 15
 *
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n) - single pass through array.<br>
 * <b>Space Complexity:</b> O(n) for DP array (can be optimized to O(1) using variables).</p>
 *
 * @author Arpan Das
 * @since 14/03/2026
 */
public class MinCostToClimbStairs {

    /**
     * Calculates minimum cost to reach top of stairs with 1 or 2-step climbs.
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Handle edge cases: empty/null array → 0, single step → cost[0]</li>
     *   <li>Create DP array of size n+1 where dp[i] = min cost to reach step i</li>
     *   <li>For i from 2 to n: dp[i] = cost[i-1] + min(dp[i-1], dp[i-2])</li>
     *   <li>Return dp[n] (minimum cost to reach top)</li>
     * </ol>
     *
     * <p>Note: dp[0] and dp[1] are implicitly handled by the loop logic since we start from i=2.</p>
     *
     * @param cost array where cost[i] = cost to start/sit at step i
     * @return minimum cost to reach top of stairs (beyond last step)
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];

        int[] dp = new int[cost.length + 1];

        // Fill DP table: dp[i] = min cost to reach step i
        for (int i = 2; i <= cost.length; i++) {
            int prev1 = cost[i - 1] + dp[i - 1];  // From 1 step below
            int prev2 = cost[i - 2] + dp[i - 2];  // From 2 steps below
            dp[i] = Math.min(prev2, prev1);
        }

        return dp[cost.length];  // Min cost to reach top
    }
}
