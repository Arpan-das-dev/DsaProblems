package Graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic = new boolean[rows][cols];

        for (int i= 0; i< rows; i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,cols-1);
        }

        for (int i = 0; i < cols; i++) {
            dfs(heights,pacific,0,i);
            dfs(heights,atlantic,rows-1,i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) result.add(List.of(i,j));
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] seas, int rows, int cols) {
        int row = heights.length;
        int col = heights[0].length;

        if(seas[rows][cols]) return;

        seas[rows][cols] = true;

        int [][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : directions) {
            int nr = rows + dir[0];
            int nc = cols + dir[1];

            if(nc<0 || nr< 0 || nr>= row || nc>= col) continue;

            if(heights[nr][nc] >= heights[rows][cols]) dfs(heights,seas,nr,nc);
        }
    }
}
