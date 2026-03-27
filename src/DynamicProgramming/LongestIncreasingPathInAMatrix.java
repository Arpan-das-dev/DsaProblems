package DynamicProgramming;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int max = Integer.MIN_VALUE;
        int [][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(matrix,dp,i,j);
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    private static final int [][] direction = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0}};

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(i < 0 || j < 0 || i>= matrix.length || j>= matrix[0].length) return 0;
        if(dp[i][j] != 0) return dp[i][j];

        int max = 1;
        for (int [] dir : direction){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length) {
                if(matrix[nr][nc] > matrix[i][j]){
                   max = Math.max(max,1+ dfs(matrix,dp,nr,nc));
                }
            }
        }
        dp[i][j] = max;
        return max;
    }
}
