package DynamicProgramming.LCS;

/**
 * Utility class to compute minimum edit distance (Levenshtein distance) between two strings.
 *
 * <p>Given strings {@code word1} and {@code word2}, return minimum operations (insert, delete,
 * replace) to convert word1 to word2. Each operation costs 1.</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = min operations for word2[0..i-1] and word1[0..j-1]</li>
 *   <li>Base: {@code dp[i][0]=i} (delete i chars), {@code dp[0][j]=j} (insert j chars)</li>
 *   <li>Recurrence:
 *     <ul>
 *       <li>Match: {@code dp[i][j] = dp[i-1][j-1]}</li>
 *       <li>Mismatch: {@code min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1}</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), m=|word2|, n=|word1|.<br>
 * <b>Space Complexity:</b> O(mn).</p>
 *
 * @author Arpan Das
 * @since 09/03/2026
 */
public class EditDistance {

    /**
     * Returns minimum operations to convert word1 to word2.
     *
     * <p>Standard Levenshtein distance DP table filling.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: word1 = "horse", word2 = "ros"
     * Operations: horse→hor se→hor s e→hors→ros = 3 ✓
     * Output: 3
     *
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     *
     * Input: word1 = "cat", word2 = "cut"
     * Match c,t → replace a→u = 1 ✓
     * Output: 1
     *
     * Input: word1 = "", word2 = "a"
     * Insert 1 char → Output: 1
     * </pre>
     *
     * @param word1 source string
     * @param word2 target string
     * @return minimum edit distance
     */
    public int minDistance(String word1, String word2) {
        int m = word2.length();  // rows
        int n = word1.length();  // cols

        int[][] dp = new int[m + 1][n + 1];

        // Base cases: deletions from empty string
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // Base cases: insertions into empty string
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Characters match: no operation needed
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min of: delete (top), insert (left), replace (diagonal)
                    int deleteOp = dp[i - 1][j];
                    int insertOp = dp[i][j - 1];
                    int replaceOp = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
