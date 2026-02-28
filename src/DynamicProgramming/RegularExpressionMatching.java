package DynamicProgramming;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int row = s.length()+1;
        int col = p.length()+1;

        boolean[][] dp = new boolean[row][col];

        dp[0][0] = true;

        for (int i = 2; i < col; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                char pattern = p.charAt(c-1);
                char curr = s.charAt(r-1);

                if(pattern == curr || pattern == '.') {
                    dp[r][c] = dp[r-1][c-1]; // if pattern matches or . then look diagonaly to check
                                // if apart from curr matching is rest of the exp is matched
                } else if (pattern == '*') {
                    // then calculate 0 occurrence
                    dp[r][c] = dp[r][c-2];
                    char prev = p.charAt(c-2);
                    if(prev == '.' || prev == curr) {
                        // if the 2 col back value is . or same match with exp then look at the top value
                        dp[r][c] = dp[r][c] ||dp[r-1][c];
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }
}
