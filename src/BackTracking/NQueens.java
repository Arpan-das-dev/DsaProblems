package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                chess[r][c] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(chess,result,0);
        return result;
    }

    private void backTrack(char[][] chess, List<List<String>> result, int col) {
        if(col == chess.length) {
            result.add(construct(chess));
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            if(Valid(chess,i,col)) {
                chess[i][col] = 'Q';
                backTrack(chess, result, col+1);
                chess[i][col] = '.';
            }
        }
    }

    private boolean Valid(char[][] chess, int row, int col) {
        for (int i = 0; i < col; i++) {
            if(chess[row][i]=='Q') return false;
        }
        for (int i = row,j = col; i >= 0 && j >= 0 ; i-- ,j--) {
            if(chess[i][j] == 'Q') return false;
        }
        for (int i = row, j = col; i < chess.length && j >= 0 ; i++, j--) {
            if(chess[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> row = new ArrayList<>();
        for (char[] chars : chess) {
            String val = new String(chars);
            row.add(val);
        }
        return row;
    }
}
