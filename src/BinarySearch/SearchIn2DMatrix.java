package BinarySearch;

/**
 * Utility class to search for a target value in a sorted 2D matrix.
 *
 * <p>The matrix has the following properties:
 * <ul>
 *   <li>m rows and n columns</li>
 *   <li>Each row is sorted in non-decreasing order</li>
 *   <li>The first integer of each row is greater than the last integer of the previous row</li>
 * </ul>
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Step 1 – Find the row:</b> Use binary search on the first and last elements of each row
 *       to identify the row that could contain the target. The target must lie between
 *       matrix[mid][0] and matrix[mid][matrix[mid].length-1] to be in that row.</li>
 *   <li><b>Step 2 – Binary search in row:</b> Once the correct row is found, perform standard
 *       binary search within that row to locate the target.</li>
 * </ul>
 *
 * <p>This treats the matrix as a flattened sorted array for row selection, then searches linearly within the row.</p>
 *
 * <p><b>Time Complexity:</b> O(log m + log n), where m is rows, n is columns.<br>
 * <b>Space Complexity:</b> O(1), only a few pointers used.</p>
 *
 * @author Arpan Das
 * @since 23/01/2026
 */
public class SearchIn2DMatrix {

    /**
     * Searches for a target value in a sorted 2D matrix using two-phase binary search.
     *
     * <p>First finds the row containing the target by binary searching row boundaries,
     * then performs binary search within that row to find the exact position.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * Output: true
     * Explanation: Binary search finds row 0 (1≤3≤7), then binary search in row 0 finds 3 at index 1.
     *
     * Input:  matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * Output: false
     * Explanation: No row contains 13 within its bounds.
     *
     * Input:  matrix = [[1],[2,3,4,5],[6,7]], target = 7
     * Output: true
     * Explanation: Row 2 contains 7 (6≤7≤7), binary search finds it.
     * </pre>
     *
     * @param matrix m x n sorted matrix (each row sorted, rows in increasing order)
     * @param target value to search for
     * @return true if target exists in matrix, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge case: empty matrix
        if (matrix == null || matrix[0].length == 0) return false;

        // Step 1: Binary search to find the row containing the target
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;

            // Target is in this row if it's between first and last element
            if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target) {
                break;
            }
            // Target is in rows before mid
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            }
            // Target is in rows after mid
            else {
                top = mid + 1;
            }
        }

        // Step 2: Binary search within the identified row
        int row = (top + bottom) / 2;  // Selected row
        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}

