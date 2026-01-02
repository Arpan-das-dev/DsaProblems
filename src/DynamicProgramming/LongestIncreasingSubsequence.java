package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLISBrute(int[] num) {
       if(num == null || num.length == 0) return 0;
       int[] dp = new int[num.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i] > num[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
