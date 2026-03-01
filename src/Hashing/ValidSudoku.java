package Hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return hasValidRows(board) && hasValidColumns(board) && hasValidSubBoxes(board);
    }

    private boolean hasValidRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if(curr != '.'){
                    if(rowSet.contains(curr)) return false;
                    rowSet.add(curr);
                }
            }
        }
        return true;
    }

    private boolean hasValidColumns(char[][] board) {
        for (int c = 0; c < 9; c++) {
            Set<Character> colSet = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                char curr = board[r][c];
                if(curr != '.'){
                    if(colSet.contains(curr)) return false;
                    colSet.add(curr);
                }
            }
        }
        return true;
    }

    private boolean hasValidSubBoxes(char[][] board) {
        for (int r = 0; r < 9; r+=3) {
            for (int c = 0; c < 9; c+=3) {
                Set<Character> subBox = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char curr = board[r+i][c+j];
                        if(curr != '.'){
                            if(subBox.contains(curr)) return false;
                            subBox.add(curr);
                        }
                    }
                }
            }
        }
        return true;
    }

}
