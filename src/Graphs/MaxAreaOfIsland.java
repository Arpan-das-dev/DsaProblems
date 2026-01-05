package Graphs;

/**
 * Utility class for finding the maximum area of an island in a 2D grid map.
 *
 * <p>Given a 2D grid where '1' represents land and '0' represents water, this
 * class identifies the largest connected group of land cells (4-directionally connected).</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Iterate through each cell in the grid using nested loops.</li>
 *   <li>For each unvisited land cell (value = 1), perform DFS to calculate its island area.</li>
 *   <li>Mark visited land cells as water (0) during DFS to avoid recounting.</li>
 *   <li>Track the maximum island area encountered across all islands.</li>
 * </ul>
 *
 * <p>The DFS explores 4-directional connectivity (up, down, left, right) recursively.</p>
 *
 * <p><b>Time Complexity:</b> O(m × n), where m and n are grid dimensions.<br>
 * <b>Space Complexity:</b> O(m × n) in worst case due to recursion stack.</p>
 *
 * @author Arpan Das
 * @since 05/01/2026
 */
public class MaxAreaOfIsland {

    /**
     * Returns the maximum area of any island in the given grid.
     *
     * <p>Each island is a group of '1's connected 4-directionally (horizontal/vertical).
     * The algorithm visits every cell exactly once, using DFS to measure island sizes.</p>
     *
     * @param grid a 2D array where grid[i][j] == 1 represents land and 0 represents water
     * @return the area of the largest island, or 0 if no land exists
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        // as it's a 2d array so we have to use double loop because it's a matrix
        // and to access each element we need the column and row value just like we do
        // in school with matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int item = grid[i][j];
                if(item == 1) { // only land (value = 1) will be counted
                    int currentArea = dfs(grid,i,j);
                    maxArea = Math.max(currentArea,maxArea);
                }
            }
        }
        return maxArea;
    }

    /**
     * Depth-First Search to calculate the area of a connected island.
     *
     * <p>Recursively explores 4 directions from current cell, marking visited land as water.
     * Returns total connected land cells forming the island.</p>
     *
     * @param grid the 2D grid map
     * @param i current row index
     * @param j current column index
     * @return total area of the connected island starting from (i,j)
     */
    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        // creating a 2d array to store value;
        grid[i][j] = 0; // making value to 0 to mark them as visited;
        int area = 1;
        // exploring in 4 direction
        area+=dfs(grid,i-1,j); // searching for up
        area+=dfs(grid,i+1,j); // searching for down
        area+=dfs(grid,i,j-1); // searching for left
        area+=dfs(grid,i,j+1); // searching for right

        return area;
    }
}
