package Matrix;

/**
 * Utility class to capture surrounded regions in 2D board (X's and O's).
 *
 * <p>Given {@code board} where 'X' = land, 'O' = water, capture surrounded 'O' regions (not
 * connected to border) by changing to 'X'. Border-connected 'O's stay 'O'.</p>
 *
 * <p><b>Approach:</b> DFS Flood Fill from Borders + Reverse Marking</p>
 * <ul>
 *   <li>DFS border 'O's → mark 'T' (temporarily safe)</li>
 *   <li>Second pass: 'O'→'X' (surrounded), 'T'→'O' (border-safe)</li>
 *   <li>4-directional connectivity</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(mn), visit each cell once.<br>
 * <b>Space Complexity:</b> O(mn) recursion stack worst case.</p>
 *
 * @author Arpan Das
 * @since 11/03/2026
 */
public class SurroundedRegions {

    /** 4-directional moves: right, left, down, up */
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Modifies board in-place: captures surrounded 'O' regions.
     *
     * <p>Border DFS marks safe regions, reverse pass flips surrounded ones.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * Border O's safe, inner O's surrounded → Output:
     * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * </pre>
     *
     * @param board m×n char matrix ('X','O')
     */
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: DFS all border 'O's (mark as safe 'T')
        // Left and right borders
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);   // Left column
            dfs(board, i, n - 1); // Right column
        }
        // Top and bottom borders
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);     // Top row
            dfs(board, m - 1, j); // Bottom row
        }

        // Step 2: Flip remaining regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Surrounded → capture
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Border-connected → restore
                }
            }
        }
    }

    /**
     * DFS flood fill: marks connected 'O's as 'T' (temporarily safe).
     */
    private void dfs(char[][] board, int row, int col) {
        // Bounds check + not water
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] != 'O') {
            return;
        }

        // Mark as temporarily safe
        board[row][col] = 'T';

        // Recurse 4 directions
        for (int[] dir : directions) {
            dfs(board, row + dir[0], col + dir[1]);
        }
    }
}

