package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

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
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
