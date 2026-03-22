package Matrix;

import java.util.Arrays;
/**
 * Utility class to set entire rows/columns to zero where zero exists (NeetCode 150 sheet).
 *
 * <p>LeetCode 73: Given m×n {@code matrix}, set row i and column j to zeros if matrix[i][j]==0.
 * Do in-place (modify input).</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute:</b> Track rows/cols with zeros → fill O(mn) space</li>
 *   <li><b>O(1) Space:</b> Use first row/col as markers, multi-pass</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), <b>Space Complexity:</b> O(1) optimal.</p>
 *
 * @author Arpan Das
 * @since 22/03/2026
 * <p><b>Part of NeetCode 150 study plan</b></p>
 */

public class SetZeros {

    /**
     * Brute force: track zero rows/columns explicitly.
     *
     * <p>Two passes: mark + fill. Simple but O(m+n) space.</p>
     */
    public void setZeroesBrute(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];

        // Step 1: Identify zero positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Step 2: Zero entire rows/columns
        for (int i = 0; i < m; i++) {
            if (zeroRows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < n; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Optimal O(1) space: use first row/column as markers.
     *
     * <p>5-step process preserves original first row/col info.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]] ✓
     *
     * Input: [[0,1],[2,3]]
     * Output: [[0,0],[0,3]]
     * </pre>
     *
     * @param matrix m×n integer matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check first column
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Mark zeros using first row/col (skip borders)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;     // Mark row
                    matrix[0][j] = 0;     // Mark column
                }
            }
        }

        // Step 4: Zero inner matrix using markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle borders
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}