package DynamicProgramming;

/**
 * Utility class to check if s3 is interleaving of s1 and s2.
 *
 * <p>Given strings {@code s1}, {@code s2}, {@code s3}, return true if {@code s3} formed by interleaving
 * {@code s1} and {@code s2} (chars taken sequentially, not reordered). |s1|+|s2|==|s3|.</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = true if s3[0..i+j-1] interleaves s2[0..i-1] and s1[0..j-1]</li>
 *   <li>Base: {@code dp[0][0]=true}, prefixes match if chars align</li>
 *   <li>Recurrence: {@code dp[i][j] = (s3[i+j-1]==s1[j-1] AND dp[i][j-1]) OR (s3[i+j-1]==s2[i-1] AND dp[i-1][j])}</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), m=|s2|, n=|s1|.<br>
 * <b>Space Complexity:</b> O(mn).</p>
 *
 * @author Arpan Das
 * @since 10/03/2026
 */
public class InterleavingString {

    /**
     * Returns true if s3 is valid interleaving of s1 and s2.
     *
     * <p>DP verifies sequential character matching paths.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s1="aabcc", s2="dbbca", s3="aadbbcbcac"
     * Path: a,a (s1) + d,b,b,c (s2) + c,c (s1) + a ✓
     * Output: true
     *
     * Input: s1="aabcc", s2="dbbca", s3="aadbbbaccc"
     * No valid interleaving → Output: false
     *
     * Input: s1="", s2="a", s3="a"
     * Output: true
     *
     * Input: s1="a", s2="b", s3="a"
     * Length mismatch → Output: false
     * </pre>
     *
     * @param s1 first string
     * @param s2 second string
     * @param s3 interleaved candidate
     * @return true if valid interleaving
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // Quick length check
        if (s1.length() + s2.length() != s3.length()) return false;

        int m = s2.length();  // rows
        int n = s1.length();  // cols

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;  // Empty prefixes match

        // Initialize first row: s1 prefix matching s3 prefix
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s1.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Initialize first column: s2 prefix matching s3 prefix
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char s3Char = s3.charAt(i + j - 1);

                // From s1: last char from s1
                dp[i][j] = dp[i][j - 1] && s1.charAt(j - 1) == s3Char;

                // OR from s2: last char from s2
                dp[i][j] = dp[i][j] || (dp[i - 1][j] && s2.charAt(i - 1) == s3Char);
            }
        }

        return dp[m][n];
    }
}
