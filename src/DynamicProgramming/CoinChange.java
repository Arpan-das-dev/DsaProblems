package DynamicProgramming;

import java.util.Arrays;

/**
 * Utility class for solving the classic Coin Change problem using dynamic programming.
 *
 * <p>Given an infinite supply of coins of given denominations, find the minimum number
 * of coins needed to make up a given amount. If the amount cannot be formed, return -1.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a 1D DP array where {@code dp[i]} represents the minimum number of coins
 *       needed to make amount {@code i}.</li>
 *   <li>Initialize {@code dp[0] = 0} (zero coins needed for zero amount) and all other
 *       entries to a large value (greater than any possible answer).</li>
 *   <li>For each amount from 1 to target, try every coin denomination and update:
 *       {@code dp[i] = min(dp[i], 1 + dp[i - coin])} if the coin can be used.</li>
 *   <li>If the final value is still greater than the amount, return -1 (impossible).</li>
 * </ul>
 *
 * <p>This bottom-up DP approach avoids recomputation and efficiently computes the
 * minimum coin count in polynomial time.</p>
 *
 * <p><b>Time Complexity:</b> O(amount × number of coins).<br>
 * <b>Space Complexity:</b> O(amount), for the DP array.</p>
 *
 * @author Arpan Das
 * @since 13/01/2026
 */
public class CoinChange {

    /**
     * Returns the minimum number of coins needed to make up the given amount.
     *
     * <p>If the amount cannot be formed using the given coin denominations,
     * returns -1. Assumes an unlimited supply of each coin type.</p>
     *
     * @param coins  array of coin denominations (positive integers)
     * @param amount the target amount to make
     * @return minimum number of coins needed, or -1 if impossible
     */

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // initialize an array with the length of amount + 1
        // to hold coins needed to get that amount from zero to that amount
        Arrays.fill(dp, amount + 1); // filling the array with amount + 1 value

        dp[0] = 0; // simple to get 0 amount only 0 coins needed.

        // running loop till the amount of the amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i-coin >= 0) {// if coin value is lesser or equals
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]); // then compare
                    // which one is smaller dp[i] or the dp[i-coin] + 1; e.g i=2 and coin =2 then dp[0]+1
                }
            }
        }
        // If dp[amount] is still greater than amount, it means impossible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
