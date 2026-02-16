package BackTracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) return false;
        int row = board.length;
        int col = board[0].length;
        boolean [][] visited = new boolean[row][col];

        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if(board[m][n] == word.charAt(0)) {
                   if(backTrackingDfs(board,visited,word,m,n,0)) return true;
                }
            }
        }
        return false;
    }

    private boolean backTrackingDfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if(index == word.length()) return true;
        if(row<0 || col <0 || row>= board.length || col>= board[0].length) return false;
        if(visited[row][col] ||word.charAt(index) != board[row][col]) return false;

        visited[row][col] = true;

        boolean found = backTrackingDfs(board,visited,word,row+1,col,index+1) || // go down
        backTrackingDfs(board,visited,word,row-1,col,index+1)|| // go up
        backTrackingDfs(board,visited,word,row,col-1,index+1) || // go left
        backTrackingDfs(board,visited,word,row,col+1,index+1); // go right

        visited[row][col] = false;
        return found;
    }

}
