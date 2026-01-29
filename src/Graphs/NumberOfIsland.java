package Graphs;

/**
 * Utility class to count the number of islands in a 2D grid map.
 *
 * <p>Given a 2D grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically (4-directional connectivity).</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Iterate through each cell in the grid.</li>
 *   <li>When a land cell ('1') is found, increment the island count and perform DFS to
 *       mark all connected land cells as water ('0') to avoid recounting.</li>
 *   <li>DFS explores 4 directions (right, left, down, up) from the current cell,
 *       marking all reachable land cells as visited (by changing to '0').</li>
 * </ul>
 *
 * <p>This modifies the input grid in-place as a space optimization (modifying land to water).</p>
 *
 * <p><b>Time Complexity:</b> O(rows × cols), visits each cell at most once.<br>
 * <b>Space Complexity:</b> O(rows × cols) worst case for recursion stack (if whole grid is land).</p>
 *
 * @author Arpan Das
 * @since 29/01/2026
 */
public class NumberOfIsland {

    /**
     * Counts the number of islands in the given 2D grid map.
     *
     * <p>Traverses the grid cell by cell. Each unvisited land cell ('1') starts a new island,
     * which is then fully explored and marked as water ('0') via DFS to avoid recounting.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  grid = [
     *           ["1","1","0","0","0"],
     *           ["1","1","0","0","0"],
     *           ["0","0","1","0","0"],
     *           ["0","0","0","1","1"]
     *         ]
     * Output: 3
     * Explanation: 3 islands: top-left 2x2 block, single cell at (2,2), bottom-right 2 cells.
     *
     * Input:  grid = [["1","0","1","0","0","1"],["0","1","0","1","0","0"]]]
     * Output: 3
     * Explanation: Islands at positions (0,0), (0,2), (1,1).
     *
     * Input:  grid = [["1","1","1"],["0","1","0"],["1","1","1"]]
     * Output: 1
     * Explanation: All '1's are connected forming 1 island.
     * </pre>
     *
     * @param grid 2D char array where '1' = land, '0' = water
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        int island = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Scan every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // New island found
                if (grid[r][c] == '1') {
                    island++;
                    dfs(r, c, rows, cols, grid);
                }
            }
        }
        return island;
    }

    /**
     * DFS helper to mark all connected land cells of current island as visited ('0').
     *
     * <p>From current cell (r,c), recursively visits all 4-directional adjacent land cells,
     * marking them as water ('0') to indicate they've been visited and counted.</p>
     *
     * @param r    current row
     * @param c    current column
     * @param rows total number of rows
     * @param cols total number of columns
     * @param grid the grid map (modified in-place)
     */
    private void dfs(int r, int c, int rows, int cols, char[][] grid) {
        // Base cases: out of bounds or already visited water cell
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (grid[r][c] == '0') return;

        // Mark current land as visited (convert to water)
        grid[r][c] = '0';

        // Explore 4 directions: right, left, down, up
        dfs(r, c + 1, rows, cols, grid); // right
        dfs(r, c - 1, rows, cols, grid); // left
        dfs(r + 1, c, rows, cols, grid); // down
        dfs(r - 1, c, rows, cols, grid); // up
    }
}

