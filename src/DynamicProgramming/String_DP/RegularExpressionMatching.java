package DynamicProgramming.Grid_DP;

/**
 * Utility class to implement regular expression matching with '.' and '*'.
 *
 * <p>Given string {@code s} and pattern {@code p} supporting {@code '.'} (any char) and {@code '*'}
 * (zero or more preceding), return true if {@code p} matches entire {@code s} exactly.</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = true if s[0..i-1] matches p[0..j-1]</li>
 *   <li>Base: {@code dp[0][0]=true}, empty pattern matches empty string</li>
 *   <li>Empty string + {@code a*b*}: {@code dp[0][j] = dp[0][j-2]} if p[j-1]='*'</li>
 *   <li>Match cases:
 *     <ul>
 *       <li>Literal/{@code .}: {@code dp[i][j] = dp[i-1][j-1]}</li>
 *       <li>{@code x*}: 0 occurrences ({@code dp[i][j-2]}) OR 1+ ({@code dp[i-1][j]})</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n), m=|s|, n=|p|.<br>
 * <b>Space Complexity:</b> O(m×n).</p>
 *
 * @author Arpan Das
 * @since 28/02/2026
 */
public class RegularExpressionMatching {

    /**
     * Returns true if pattern p matches entire string s.
     *
     * <p>Fills DP table handling {@code .} and {@code *} special cases.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "aa", p = "a"
     * Output: false (doesn't match entire s)
     *
     * Input: s = "aa", p = "a*"
     * Output: true (* matches 0+ 'a')
     *
     * Input: s = "ab", p = ".*"
     * Output: true (.* matches any string)
     *
     * Input: s = "aab", p = "c*a*b"
     * Output: true (c*→0 c's, a*→2 a's, b→b)
     *
     * Input: s = "mississippi", p = "mis*is*p*."
     * Output: false
     * </pre>
     *
     * @param s input string
     * @param p pattern with . and *
     * @return true if matches entirely
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;  // Empty string matches empty pattern

        // Handle empty string + x* patterns
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char patternChar = p.charAt(j - 1);

                if (patternChar == '*' || patternChar == '.') {
                    // Match literal or .  consume both characters
                    if (patternChar == s.charAt(i - 1) || patternChar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

                if (patternChar == '*') {
                    char prevChar = p.charAt(j - 2);
                    // 0 occurrences: ignore x*
                    dp[i][j] = dp[i][j - 2];

                    // 1+ occurrences: if matched, use previous row (match again)
                    if (prevChar == '.' || prevChar == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}

