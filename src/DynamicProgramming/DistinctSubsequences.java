package DynamicProgramming;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int row = t.length();
        int col = s.length();

        if(row > col) return 0;

        int [][] dp = new int[row+1][col+1];
        dp[0][0] = 1; // empty to make empty is one

        for (int i = 1; i < col; i++) {
            dp[0][i]  = 1; // to make "" we need prev operation which is one for empty vs empty
        }

        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col ; c++) {
                char sChar = s.charAt(c-1);
                char tChar = t.charAt(r-1);

                if(sChar == tChar) {
                    dp[r][c] = dp[r][c-1] + dp[r-1][c-1];
                }else {
                    dp[r][c] = dp[r][c-1];
                }
            }
        }
        return dp[row][col];
    }
}
