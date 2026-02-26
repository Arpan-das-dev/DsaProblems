package Matrix;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Utility class to compute minimum time for rotting oranges to infect all fresh oranges.
 *
 * <p>Given m×n grid where 0=empty, 1=fresh orange, 2=rotten orange. Each minute, every rotten
 * orange infects adjacent (4-dir) fresh oranges simultaneously. Return minimum minutes until all
 * fresh oranges rot, -1 if impossible.</p>
 *
 * <p><b>Approach:</b> Multi-source BFS (Level Order)</p>
 * <ul>
 *   <li>Enqueue all initial rotten oranges (minute 0)</li>
 *   <li>Count fresh oranges initially</li>
 *   <li>Process level-by-level: each level = 1 minute</li>
 *   <li>Track fresh count, return level when 0 or -1 if remaining</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n), visit each cell once.<br>
 * <b>Space Complexity:</b> O(m×n) worst case queue.</p>
 *
 * @author Arpan Das
 * @since 26/02/2026
 */

public class RottingOranges {

    /** 4-directional movement: right, down, left, up */
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Returns minutes until all oranges rot, -1 if impossible.
     *
     * <p>Multi-source BFS from all initial rotten oranges, level = time elapsed.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     *        2 1 1    → t=0: rotten(2) infects adjacents
     *        1 1 0    → t=1: 2 2 2
     *        0 1 1         1 2 2
     * Output: 4
     *        → t=2: 2 2 2
     *             1 2 2 → t=3: 2 2 2 → t=4: all rotten ✓
     *
     * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1 (disconnected fresh orange)
     *
     * Input: grid = [[0,2]]
     * Output: 0 (no fresh oranges)
     * </pre>
     *
     * @param grid m×n grid (0=empty, 1=fresh, 2=rotten)
     * @return minutes or -1
     */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> rotten = new LinkedList<>();
        int freshCount = 0;

        // Initialize queue with all rotten oranges, count fresh
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    rotten.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;

        // BFS level-by-level (each level = 1 minute)
        while (!rotten.isEmpty() && freshCount > 0) {
            int levelSize = rotten.size();

            for (int i = 0; i < levelSize; i++) {
                int[] curr = rotten.poll();
                int r = curr[0], c = curr[1];

                // Infect 4 adjacent fresh oranges
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Bounds check + fresh orange
                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
                            grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;     // Rot
                        rotten.offer(new int[]{nr, nc});
                        freshCount--;         // Decrement fresh count
                    }
                }
            }
            minutes++;  // Next minute
        }

        // Return minutes or -1 if fresh oranges remain
        return freshCount == 0 ? minutes : -1;
    }
}
