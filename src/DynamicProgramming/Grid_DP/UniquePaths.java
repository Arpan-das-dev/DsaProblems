package DynamicProgramming;

/**
 * Utility class to count unique paths in grid (NeetCode 150 sheet).
 *
 * <p>LeetCode 62: Robot from (0,0) → (m-1,n-1) in m×n grid. Can only move right/down. Return paths.</p>
 *
 * <p><b>Approach:</b> 2D Dynamic Programming</p>
 * <ul>
 *   <li>{@code dp[i][j]} = unique paths to (i,j)</li>
 *   <li>{@code dp[i][j] = dp[i-1][j] + dp[i][j-1]}</li>
 *   <li>Base: first row/column = 1 path each</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), <b>Space Complexity:</b> O(mn) optimizable to O(n).</p>
 *
 * @author Arpan Das
 * @since 22/03/2026
 * <p><b>Part of {@code NeetCode 150} </b></p>
 */
public class UniquePaths {

    /**
     * Returns number of unique paths from top-left to bottom-right.
     *
     * <p>DP table where each cell = sum of paths from above + left.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: m=3, n=7
     * Paths: 28 (C(9,2) combinatorial) ✓
     *
     * Input: m=3, n=2 → Output: 3
     * Paths: right-right-down, right-down-right, down-right-right
     * </pre>
     *
     * @param m grid rows
     * @param n grid columns
     * @return unique paths count
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base cases: first row and column (only 1 path each)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // take only previous value and top value
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
