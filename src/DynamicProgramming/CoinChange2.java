package DynamicProgramming;
/**
 * Utility class to compute number of combinations to make change for amount.
 *
 * <p>Given coin denominations {@code coins} and target {@code amount}, return number of
 * combinations summing to exact amount. Order doesn't matter (unbounded knapsack combinations).</p>
 *
 * <p><b>Approach:</b> Complete DP (Coins First Iteration)</p>
 * <ul>
 *   <li>{@code dp[i]} = ways to make amount i</li>
 *   <li>{@code dp[0] = 1} (1 way to make 0: choose nothing)</li>
 *   <li>For each coin: {@code dp[i] += dp[i-coin]} for i ≥ coin</li>
 *   <li>Coins outer: combinations (order irrelevant)</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n×amount).<br>
 * <b>Space Complexity:</b> O(amount).</p>
 *
 * @author Arpan Das
 * @since 26/02/2026
 */
public class CoinChange2 {

    /**
     * Returns number of combinations to make exact amount using given coins.
     *
     * <p>Coins-first DP ensures combinations (not permutations).</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: amount = 5, coins = [1,2,5]
     * Ways: 5=5, 5=2+2+1, 5=2+1+1+1, 5=1+1+1+1+1 → 4 ways ✓
     * Output: 4
     *
     * Input: amount = 3, coins = [2]
     * Output: 0 (impossible)
     *
     * Input: amount = 0, coins = [1]
     * Output: 1 (empty selection)
     *
     * Input: amount = 1, coins = [1]
     * Output: 1
     * </pre>
     *
     * @param amount target amount
     * @param coins available denominations
     * @return number of combinations
     */
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 1;  // Base case: 1 way to make amount 0

        // Iterate coins first (ensures combinations, not permutations)
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // Ways to make i = ways without this coin + ways using this coin
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}

