package Graphs;

public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int island = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == '1') {
                    island++;
                    dfs(r,c,rows,cols,grid);
                }
            }
        }
        return island;
    }

    private void dfs(int r, int c, int rows, int cols, char[][] grid) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(r, c + 1, rows, cols, grid);
        dfs(r, c - 1, rows, cols, grid);
        dfs(r + 1, c, rows, cols, grid);
        dfs(r - 1, c, rows, cols, grid);
    }
}
