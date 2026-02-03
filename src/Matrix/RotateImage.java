package Mathematical;

/**
 * Utility class to rotate a square matrix 90 degrees clockwise in-place.
 *
 * <p>Given an n × n matrix, rotate it 90 degrees clockwise. You must rotate the image **in-place**,
 * which means you have to modify the input 2D array directly without using an extra matrix.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> Create a new rotated matrix, copy elements using the transformation
 *       {@code rotated[c][n-1-r] = matrix[r][c]} (90° clockwise mapping).</li>
 *   <li><b>Optimal (In-place):</b> Two-step process:
 *     <ul>
 *       <li><b>Step 1:</b> Transpose matrix (swap matrix[i][j] ↔ matrix[j][i])</li>
 *       <li><b>Step 2:</b> Reverse each row (flip left-right)</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>Transpose + reverse achieves 90° clockwise rotation without extra space.</p>
 *
 * <p><b>Time Complexity:</b> O(n²) for both approaches.<br>
 * <b>Space Complexity:</b> O(n²) for brute force, O(1) for optimal.</p>
 *
 * @author Arpan Das
 * @since 31/01/2026
 */
public class RotateImage {

    /**
     * Brute force solution using extra space to create rotated matrix.
     *
     * <p>Creates a new matrix of same dimensions. For each element at {@code matrix[r][c]},
     * places it at {@code rotated[c][n-1-r]} which is the 90° clockwise position.</p>
     *
     * @param matrix n × n square matrix to rotate
     */
    public void rotateBrute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 90° clockwise: (r,c) → (c, n-1-r)
                rotated[c][rows - 1 - r] = matrix[r][c];
            }
        }
        // Note: This method doesn't copy back to original matrix
    }

    /**
     * Optimal in-place solution: Transpose + Reverse each row.
     *
     * <p><b>Step 1 - Transpose:</b> Swap elements across main diagonal (i,j ↔ j,i).
     * This converts rows to columns.<br>
     * <b>Step 2 - Reverse rows:</b> Flip each row left-to-right.
     * Combined: 90° clockwise rotation.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  matrix = [[1,2,3],[4,5,6],[7,8,9]]
     *        ↓ Transpose
     *        [[1,4,7],[2,5,8],[3,6,9]]
     *        ↓ Reverse each row
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     *
     * Input:  matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * </pre>
     *
     * @param matrix n × n square matrix to rotate in-place
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose matrix (swap across main diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // j starts from i+1 to avoid double swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row (left ↔ right)
        for (int i = 0; i < n; i++) {
            int c = 0;           // Left pointer
            int d = n - 1;       // Right pointer
            while (c < d) {
                int temp = matrix[i][c];
                matrix[i][c] = matrix[i][d];
                matrix[i][d] = temp;
                c++;
                d--;
            }
        }
    }
}
