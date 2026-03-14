package DynamicProgramming;

public class MinCostToClimbStairs {
    // 1,100,1,1,1,100,1,1,100,1
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) return 0;
        if(cost.length == 1) return cost[0];

        int [] dp = new int[cost.length+1];

        for (int i = 2; i <= cost.length; i++) {
            int prev1 = cost[i-1]+dp[i-1];
            int prev2 = cost[i-2]+dp[i-2];
            dp[i] = Math.min(prev2,prev1);
        }
        return dp[cost.length];
    }
}
