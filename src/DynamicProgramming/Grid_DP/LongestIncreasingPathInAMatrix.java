package DynamicProgramming.Grid_DP;

/**
 * Utility class to find the longest increasing path in matrix (NeetCode 150 sheet).
 *
 * <p>LeetCode 329: Given m×n {@code matrix} of distinct integers, return length of longest strictly
 * increasing path (4-directional moves). Same start point memoized.</p>
 *
 * <p><b>Approach:</b> DFS + Memoization (DP on DAG)</p>
 * <ul>
 *   <li>{@code dp[i][j]} = longest increasing path from (i,j)</li>
 *   <li>Recur 4 directions where next > current</li>
 *   <li>Memo prevents recomputation</li>
 * </ul>
 *
 * <p>{@code @code Time: O(mn), Space: O(mn)}<p>
 *
 * @author Arpan Das
 * @since 27/03/2026
 * <p><b>Part of NeetCode 150 study plan</b></p>
 */
public class LongestIncreasingPathInAMatrix {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Returns length of longest strictly increasing path.
     *
     * <p>Memoized DFS from every cell finds global maximum.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: [[9,9,4],[6,6,8],[2,1,1]]
     * Paths: 9→down→6→right→8 (len=4) ✓
     * Output: 4
     *
     * Input: [[3,4,5],[3,2,6],[2,7,4]]
     * Path: 1→2→3→4→5→6→7 (len=7)
     * Output: 7
     * </pre>
     *
     * @param matrix m×n integer grid
     * @return longest increasing path length
     */
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int maxLength = 0;

        // Try every starting cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, memo, i, j));
            }
        }
        return maxLength;
    }

    /**
     * Memoized DFS: longest increasing path from current cell.
     *
     * <p>{@code @code if(dp[i][j]≠0) return dp[i][j]; // memo hit}</p>
     */
    private int dfs(int[][] matrix, int[][] memo, int row, int col) {
        // Bounds check
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }

        // Memoized result
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxPath = 1;  // Current cell

        // Check 4 directions
        for (int[] dir : DIRECTIONS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            // Valid bounds + strictly increasing
            if (nextRow >= 0 && nextRow < matrix.length &&
                    nextCol >= 0 && nextCol < matrix[0].length &&
                    matrix[nextRow][nextCol] > matrix[row][col]) {

                maxPath = Math.max(maxPath, 1 + dfs(matrix, memo, nextRow, nextCol));
            }
        }

        memo[row][col] = maxPath;
        return maxPath;
    }
}
