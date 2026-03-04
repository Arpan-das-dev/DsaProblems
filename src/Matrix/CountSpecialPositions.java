package Matrix;

/**
 * Utility class to count special positions in binary matrix.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given m×n binary matrix (0s and 1s), return count of **special positions**: mat[i][j] == 1 AND
 * row i contains exactly one 1 AND column j contains exactly one 1. Special positions like rooks
 * that don't attack each other.</p>
 *
 * <p><b>Approach:</b> Precompute Row/Column Ones + Verification Pass</p>
 * <ul>
 *   <li>Pass 1: Count 1s per row and column (O(mn))</li>
 *   <li>Pass 2: For each 1, verify rowSum[i]==1 AND colSum[j]==1</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn).<br>
 * <b>Space Complexity:</b> O(m+n).</p>
 *
 * @author Arpan Das
 * @since 04/03/2026
 */
public class CountSpecialPositions {

    /**
     * Returns count of special positions in binary matrix.
     *
     * <p>Special = mat[i][j]==1 && exactly one 1 in row i && exactly one 1 in col j.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: mat = [[1,0,0],
     *               [0,0,1],
     *               [1,0,0]]
     * rowSums=[1,1,1], colSums=[2,0,1]
     * Special: (0,0)? row0=1✓ col0=2✗, (1,2)? row1=1✓ col2=1✓ ✓
     * Output: 1
     *
     * Input: mat = [[1,0,0],
     *               [0,1,0],
     *               [0,0,1]]
     * Special positions: (0,0),(1,1),(2,2) → Output: 3 ✓
     *
     * Input: mat = [[0,0,0],[0,0,0]]
     * Output: 0
     * </pre>
     *
     * @param mat binary matrix m×n
     * @return count of special positions
     */
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Precompute number of 1s per row and column
        int[] rowOnes = new int[rows];
        int[] colOnes = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }

        // Count special positions
        int specialCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Special: mat[i][j]==1 AND row i has one 1 AND col j has one 1
                if (rowOnes[i] == 1 && colOnes[j] == 1 && mat[i][j] == 1) {
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
}