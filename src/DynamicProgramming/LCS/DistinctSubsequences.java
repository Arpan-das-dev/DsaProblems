package DynamicProgramming;

/**
 * Utility class to count distinct subsequences of s matching target t.
 *
 * <p>Given strings {@code s} and {@code t}, return number of distinct subsequences of {@code s} that
 * equal {@code t}. Subsequence = chars in order (not necessarily contiguous).</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = #ways s[0..j-1] forms t[0..i-1]}</li>
 *   <li>Base: {@code dp[0][j]=1} (empty t formed by any s prefix)</li>
 *   <li>Recurrence:
 *     <ul>
 *       <li>Match {@code s[j-1]==t[i-1]}: {@code dp[i][j] = dp[i][j-1] + dp[i-1][j-1]}</li>
 *       <li>No match: {@code dp[i][j] = dp[i][j-1]} (skip s[j-1])</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), m=|t|, n=|s|.<br>
 * <b>Space Complexity:</b> O(mn).</p>
 *
 * @author Arpan Das
 * @since 11/03/2026
 */
public class DistinctSubsequences {

    /**
     * Returns number of distinct subsequences of s matching t.
     *
     * <p>Counts always to pick subsequence chars matching t order.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s="rabbbit", t="rabbit"
     * Ways: r a b b b i t → pick 1st/2nd/3rd b → 3 ways ✓
     * Output: 3
     *
     * Input: s="babgbag", t="bag"
     * Multiple b,a,g combinations → Output: 5
     *
     * Input: s="b", t="abc"
     * Impossible (|s|<|t|) → Output: 0
     * </pre>
     *
     * @param s source string
     * @param t target subsequence
     * @return number of matching subsequences
     */
    public int numDistinct(String s, String t) {
        int m = t.length();   // rows (target)
        int n = s.length();   // cols (source)

        if (m > n) return 0;  // Impossible

        int[][] dp = new int[m + 1][n + 1];

        // Base case: empty target formed 1 way by any prefix
        dp[0][0] = 1;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(j - 1);
                char tChar = t.charAt(i - 1);

                if (sChar == tChar) {
                    // Use this match: add ways from previous target prefix
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    // Skip this s char: same as previous column
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
