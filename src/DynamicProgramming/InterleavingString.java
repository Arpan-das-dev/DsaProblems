package DynamicProgramming;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if(s1.length()+s2.length() != s3.length()) return false;

        int row = s2.length();
        int col = s1.length();

        boolean [][] dp = new boolean[row+1][col+1];
        dp[0][0] = true;

        for (int i = 1; i <= col; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i <= row ; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= col ; j++) {
                if(s1.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j-1];
                }
                if(s2.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
            }
        }
        return dp[row][col];
    }
}
