package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find all cells in a height map from which water can flow to both
 * the Pacific and Atlantic oceans.
 *
 * <p>Given a height map {@code heights} where heights[i][j] represents the height of
 * cell (i,j), return the coordinates of all cells where water can flow to both oceans.
 * Water can flow from a cell to an adjacent cell (up, down, left, right) if the adjacent
 * cell's height is greater than or equal to the current cell's height.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Instead of searching from every cell outward (O(mn × mn)), perform DFS from the ocean borders inward.</li>
 *   <li>Create two visited matrices: one for Pacific ocean reachability, one for Atlantic.</li>
 *   <li>Run DFS from all Pacific border cells (left column + top row) to mark all reachable cells.</li>
 *   <li>Run DFS from all Atlantic border cells (right column + bottom row) to mark all reachable cells.</li>
 *   <li>The result cells are those marked reachable from both oceans.</li>
 * </ul>
 *
 * <p>This reverse-flow approach is more efficient as it explores only valid paths from the borders.</p>
 *
 * <p><b>Time Complexity:</b> O(m × n), where m = rows, n = columns (each cell visited at most twice).<br>
 * <b>Space Complexity:</b> O(m × n) for the visited matrices + O(m + n) for recursion stack.</p>
 *
 * @author Arpan Das
 * @since 28/01/2026
 */
public class PacificAtlanticWaterFlow {

    /**
     * Returns all coordinates of cells from which water can flow to both Pacific and Atlantic oceans.
     *
     * <p>Uses reverse DFS from ocean borders: marks all cells reachable from Pacific
     * and Atlantic borders, then finds the intersection of both reachable sets.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
     * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
     * Explanation: Water flows to both oceans from these 7 cells.
     *
     * Input:  heights = [[2,1],[1,2]]
     * Output: [[0,0],[0,1],[1,0],[1,1]]
     * Explanation: Every cell can reach both oceans.
     *
     * Input:  heights = [[1,2,3],[3,4,5]]
     * Output: [[1,1]]
     * Explanation: Only cell (1,1) can reach both oceans.
     * </pre>
     *
     * @param heights m x n matrix representing height map
     * @return list of [row,col] coordinates reachable from both oceans
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Track reachability from each ocean
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific borders (left column + top row)
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);     // Left column
            dfs(heights, atlantic, i, cols - 1); // Right column
        }
        // DFS from top/bottom rows
        for (int i = 0; i < cols; i++) {
            dfs(heights, pacific, 0, i);     // Top row
            dfs(heights, atlantic, rows - 1, i); // Bottom row
        }

        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    /**
     * DFS helper to mark all cells reachable from the starting ocean border cell.
     *
     * <p>From current cell (rows, cols), recursively visits all 4-directional neighbors (up, down, left, right)
     * if they are within bounds and have height ≥ current height (water can flow uphill).</p>
     *
     * @param heights height map
     * @param seas    visited matrix for the current ocean (pacific or atlantic)
     * @param rows    current row
     * @param cols    current column
     */
    private void dfs(int[][] heights, boolean[][] seas, int rows, int cols) {
        int row = heights.length;
        int col = heights[0].length;

        // Skip if already visited (avoid revisiting)
        if (seas[rows][cols]) return;
        seas[rows][cols] = true;

        // 4-directional exploration: right, left, down, up
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int nr = rows + dir[0];
            int nc = cols + dir[1];

            // Skip out-of-bounds cells
            if (nc < 0 || nr < 0 || nr >= row || nc >= col) continue;

            // Water flows if neighbor height ≥ current height
            if (heights[nr][nc] >= heights[rows][cols]) {
                dfs(heights, seas, nr, nc);
            }
        }
    }
}
