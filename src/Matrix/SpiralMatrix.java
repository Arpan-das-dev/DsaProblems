package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to traverse a 2D matrix in spiral order (clockwise).
 *
 * <p>Given an m x n matrix, return all elements in spiral order: start from top-left,
 * move right → down → left → up, repeat inward until all elements visited.</p>
 *
 * <p><b>Approach:</b> Boundary Tracking with 4 Directions</p>
 * <ul>
 *   <li>Track 4 boundaries: {@code left, right, top, bottom}</li>
 *   <li>While boundaries valid ({@code left ≤ right && top ≤ bottom}):
 *     <ol>
 *       <li>Right: {@code top} row, {@code left→right}, then {@code top++}</li>
 *       <li>Down:  {@code right} column, {@code top→bottom}, then {@code right--}</li>
 *       <li>Left:  {@code bottom} row, {@code right→left} (if {@code top ≤ bottom}), then {@code bottom--}</li>
 *       <li>Up:    {@code left} column, {@code bottom→top} (if {@code left ≤ right}), then {@code left++}</li>
 *     </ol>
 *   </li>
 * </ul>
 *
 * <p>Conditional checks prevent duplicate processing of corners in inner layers.</p>
 *
 * <p><b>Time Complexity:</b> O(m×n), visit each element exactly once.<br>
 * <b>Space Complexity:</b> O(m×n) for output list (O(1) extra space ignoring output).</p>
 *
 * @author Arpan Das
 * @since 16/02/2026
 */

public class SpiralMatrix {

    /**
     * Returns all elements of matrix in clockwise spiral order.
     *
     * <p>Uses boundary tracking: traverse right→down→left→up layers inward.
     * Conditional checks ensure corners aren't processed twice.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * Input: matrix = [[1]]
     * Output: [1]
     *
     * Input: matrix = []
     * Output: []
     * </pre>
     *
     * @param matrix m×n 2D integer matrix
     * @return list of elements in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // Traverse right: top row, left → right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // Shrink top boundary

            // Traverse down: right column, top → bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // Shrink right boundary

            // Traverse left: bottom row, right → left (if row remains)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // Shrink bottom boundary
            }

            // Traverse up: left column, bottom → top (if column remains)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // Shrink left boundary
            }
        }
        return result;
    }
}
