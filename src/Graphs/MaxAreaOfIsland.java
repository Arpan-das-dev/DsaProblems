package Graphs;

public class MaxAreaOfIsland {

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
