package Graphs.ShortestPath;

/**
 * Utility class to find minimum time to swim from (0,0) to (n-1,n-1) (NeetCode 150 sheet).
 *
 * <p>LeetCode 778: n×n {@code grid} where grid[i][j] = min time to reach cell. Can swim to 4-adjacent
 * cells if time ≥ max(grid values on path). Return min time to reach bottom-right.</p>
 *
 * <p><b>Approach:</b> Binary Search + DFS Reachability</p>
 * <ul>
 *   <li>Binary search on time t ∈ [0, n²-1]</li>
 *   <li>Check: DFS can reach (n-1,n-1) visiting ≤ t cells?</li>
 * </ul>
 *
 * <p>{@code @code Time: O(n² log(n²)), Space: O(n²)}<p>
 *
 * @author Arpan Das
 * @since 23/03/2026
 * <p><b>Part of <b> {@code NeetCode 150}</b></p>
 */
public class SwimInRisingWater {

    private int rows, cols;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Returns minimum time needed to reach bottom-right.
     *
     * <p>Binary searches earliest time where DFS path exists.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: grid = [[0,2],[1,3]]
     * t=3: path 0→1→3 ✓ → Output: 3
     *
     * Input: grid = [[0,1,2],[5,6,3],[9,9,9]]
     * t=9: only path possible → Output: 9
     * </pre>
     *
     * @param grid n×n elevation grid
     * @return minimum required time
     */
    public int swimInWater(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int left = grid[0][0];
        int right = rows * cols - 1;
        int minTime = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean[][] visited = new boolean[rows][cols];
            if (canReach(grid, visited, 0, 0, mid)) {
                minTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minTime;
    }

    /**
     * DFS: can reach target with max time constraint?
     *
     * <p>{@code @code if(i<0||j<0||i≥rows||j≥cols) return false;}</p>
     */
    private boolean canReach(int[][] grid, boolean[][] visited, int i, int j, int maxTime) {
        // Bounds + visited + too slow
        if (i < 0 || j < 0 || i >= rows || j >= cols) return false;
        if (visited[i][j] || grid[i][j] > maxTime) return false;

        visited[i][j] = true;
        if (i == rows - 1 && j == cols - 1) return true;

        // Try 4 directions
        for (int[] dir : DIRECTIONS) {
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];
            if (canReach(grid, visited, nextRow, nextCol, maxTime)) {
                return true;
            }
        }
        return false;
    }
}