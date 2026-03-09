package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int row = word2.length();
        int col = word1.length();

        int[][] dp = new int[row+1][col+1];

        for (int i = 1; i <= col ; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }

        for (int i = 1; i <= row ; i++) {
            dp[i][0] = dp[i-1][0]+1;
        }
        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
//                System.out.println("word1 -> "+word1.charAt(j-1)+" for j = "+j);
//                System.out.println("word2 -> "+word2.charAt(i-1));
                if(word1.charAt(j-1) == word2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {

                    int top = dp[i-1][j];
                    int diagonal = dp[i-1][j-1];
                    int prev = dp[i][j-1];
                    dp[i][j] = Math.min(prev,Math.min(top,diagonal))+1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[row][col];
    }
}
