package Matrix;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // right and left
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col-1);
        }

        // top and bottom
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board [i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static final int [][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'T';

        for (int[] dir : directions) {
            dfs(board,row+dir[0],col+dir[1]);
        }
    }
}
