package Graphs;

public class SwimInRisingWater {
    private  int row;
    private  int col;
    private static final int[][] direction = new int[][] { {0,1},{0,-1},{1,0},{-1,0}};

    private boolean canReach(int i, int j, int[][]grid, boolean[][]visited,int time){
        // edge case for array out of bound index
        if(i < 0 || j <0 || i >= row || j >= col) return false;
        if(visited[i][j] || grid[i][j] >time) return false;

        visited[i][j] = true;
        if(i == row-1 && j == col-1) return true;

        for (int [] dir : direction){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(canReach(nr,nc,grid,visited,time)) return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        // lets do binary search
        int left = grid[0][0];
        int right = row*row -1; //from the question constraint

        int reach = 0;
        while (left <= right){
            int mid = left + (right-left)/2;

            boolean[][] visited = new boolean[row][col];
            if(canReach(0,0,grid,visited,mid)){
                reach = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return reach;
    }
}
