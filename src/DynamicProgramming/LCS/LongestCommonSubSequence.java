package DynamicProgramming;

/**
 * Utility class to find length of longest common subsequence between two strings.
 *
 * <p>Given two strings {@code text1} and {@code text2}, return length of their longest common
 * subsequence (LCS). LCS is longest sequence present in both strings (not necessarily contiguous).</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = LCS length for {@code text1[0..i-1]} and {@code text2[0..j-1]}</li>
 *   <li>If {@code text1[i-1] == text2[j-1]}: {@code dp[i][j] = dp[i-1][j-1] + 1}</li>
 *   <li>Else: {@code dp[i][j] = max(dp[i-1][j], dp[i][j-1])}</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n), fill complete DP table.<br>
 * <b>Space Complexity:</b> O(m×n) for DP table.</p>
 *
 * @author Arpan Das
 * @since 19/02/2026
 */
public class LongestCommonSubSequence {

    /**
     * Returns length of longest common subsequence between two strings.
     *
     * <p>Fills DP table bottom-up: match extends diagonal by 1, mismatch takes max from left/top.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3
     * Explanation: LCS = "ace"
     *
     * Input: text1 = "abc", text2 = "abc"
     * Output: 3
     * Explanation: LCS = "abc" (identical strings)
     *
     * Input: text1 = "abc", text2 = "def"
     * Output: 0
     * Explanation: No common characters
     *
     * Input: text1 = "bl", text2 = "yby"
     * Output: 1
     * Explanation: LCS = "b" (either first or last b in text2)
     * </pre>
     *
     * @param text1 first string
     * @param text2 second string
     * @return length of longest common subsequence
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // Quick check for identical strings
        if (text1.equals(text2)) return text1.length();

        int rows = text1.length();
        int cols = text2.length();
        int[][] dp = new int[rows + 1][cols + 1];

        // Fill DP table (1-based indexing for strings)
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match: extend LCS from diagonal
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Mismatch: take maximum from top (skip text1[i]) or left (skip text2[j])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[rows][cols];  // Bottom-right cell has final answer
    }
}
