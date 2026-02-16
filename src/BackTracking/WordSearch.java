package BackTracking;

/**
 * Utility class to search for a word in a 2D character grid using backtracking.
 *
 * <p>Given an m x n {@code board} of characters and a {@code word}, return {@code true} if
 * {@code word} exists in the grid. Word can be constructed from letters in sequentially adjacent
 * cells (horizontally/vertically adjacent). Each cell used at most once per word attempt.</p>
 *
 * <p><b>Approach:</b> Backtracking DFS from Every Starting Position</p>
 * <ul>
 *   <li>Try every cell as starting position if it matches {@code word[0]}</li>
 *   <li>From each valid start, perform DFS in 4 directions (up, down, left, right)</li>
 *   <li>Mark cells as visited during exploration, backtrack (unmark) after</li>
 *   <li>Base cases: word found (index == length), out of bounds, mismatch, already visited</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n×4^L), m×n starting positions, 4^L paths for word length L.<br>
 * <b>Space Complexity:</b> O(m×n) for visited matrix + O(L) recursion stack.</p>
 *
 * @author Arpan Das
 * @since 16/02/2026
 */
public class WordSearch {

    /**
     * Returns true if the word exists in the board, false otherwise.
     *
     * <p>Tries every cell as potential starting point. Uses DFS backtracking to explore
     * all possible paths matching subsequent characters.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     * Path: A(0,0)→B(0,1)→C(0,2)→C(1,2)→E(1,3)→D(2,1)
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * Output: true
     * Path: S(1,3)→E(1,3)→E(2,3)
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * Output: false
     * </pre>
     *
     * @param board m×n character grid
     * @param word  target word to find
     * @return true if word exists, false otherwise
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) return false;

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Try every cell as starting position
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backTrackingDfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * DFS backtracking helper: explores from current position for next character.
     *
     * <p>Marks current cell visited, recursively tries 4 directions, backtracks by unmarking.
     * Returns true if complete word found via any path.</p>
     *
     * @param board   character grid
     * @param visited visited tracking matrix
     * @param word    target word
     * @param row     current row position
     * @param col     current column position
     * @param index   current character index in word
     * @return true if word found from this position
     */
    private boolean backTrackingDfs(char[][] board, boolean[][] visited,
                                    String word, int row, int col, int index) {

        // Base case: found complete word
        if (index == word.length()) return true;

        // Base case: out of bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        // Base case: cell visited or character mismatch
        if (visited[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Explore 4 directions: down, up, left, right
        boolean found = backTrackingDfs(board, visited, word, row + 1, col, index + 1) || // down
                backTrackingDfs(board, visited, word, row - 1, col, index + 1) || // up
                backTrackingDfs(board, visited, word, row, col - 1, index + 1) || // left
                backTrackingDfs(board, visited, word, row, col + 1, index + 1);    // right

        // Backtrack: unmark cell for other paths
        visited[row][col] = false;
        return found;
    }
}
