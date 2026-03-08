package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to solve N-Queens problem: place N queens on NxN chessboard.
 *
 * <p>Given integer {@code n}, return all distinct solutions as board configurations. No two queens
 * attack each other (same row, column, or diagonal). Each solution = board strings ('Q'=queen, '.'=empty).</p>
 *
 * <p><b>Approach:</b> Backtracking (Column by Column)</p>
 * <ul>
 *   <li>Place one queen per column (0 to n-1)</li>
 *   <li>For each row in current column, check validity (no attacks)</li>
 *   <li>Valid checks: left columns same row, upper/lower diagonals</li>
 *   <li>Base case: col==n → valid solution, construct board strings</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n!), exponential backtracking.<br>
 * <b>Space Complexity:</b> O(n) recursion + O(n²) board.</p>
 *
 * @author Arpan Das
 * @since 08/03/2026
 */

public class NQueens {

    /**
     * Returns all solutions to N-Queens problem.
     *
     * <p>Backtracking places queens column-wise, checking conflicts.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 4
     * Output: [[".Q..","...Q","Q...","..q."],
     *          ["..Q.","Q...","...Q",".Q.."]]
     * 2 solutions for 4-queens ✓
     *
     * Input: n = 1
     * Output: [["Q"]]
     *
     * Input: n = 2
     * Output: [] (no solution)
     * </pre>
     *
     * @param n board size N
     * @return all valid queen placements
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(board, result, 0);
        return result;
    }

    /**
     * Backtracking: try placing queen in current column.
     *
     * <p>@param col current column to place queen</p>
     */
    private void backTrack(char[][] board, List<List<String>> result, int col) {
        // Base case: all queens placed successfully
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        // Try each row for current column
        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, col)) {
                // Place queen
                board[row][col] = 'Q';
                backTrack(board, result, col + 1);  // Recurse next column
                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    /**
     * Checks if placing queen at (row,col) is valid (no attacks).
     */
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // Check current row in previous columns
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    /**
     * Converts board to list of strings for result.
     */
    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
