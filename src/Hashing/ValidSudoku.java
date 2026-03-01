package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to validate Sudoku board configuration.
 *
 * <p>Given 9×9 Sudoku board ('.' = empty, '1'-'9' = filled), return true if valid per Sudoku rules:
 * each row, column, 3×3 sub-box contains unique digits 1-9 (ignore empty cells).</p>
 *
 * <p><b>Approach:</b> Triple Validation with HashSet</p>
 * <ul>
 *   <li>Validate all 9 rows independently</li>
 *   <li>Validate all 9 columns independently</li>
 *   <li>Validate all 9 3×3 sub-boxes independently</li>
 *   <li>Ignore '.' cells, check for duplicates 1-9 in each unit</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(1) = O(81) cells × 3 passes.<br>
 * <b>Space Complexity:</b> O(1) = O(9×9) worst case HashSets.</p>
 *
 * @author Arpan Das
 * @since 01/03/2026
 */

public class ValidSudoku {

    /**
     * Returns true if Sudoku board is valid (rows, columns, sub-boxes).
     *
     * <p>Checks three independent constraints using HashSet for uniqueness.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: board = [["5","3",".",".","7",".",".",".","."],
     *                 ["6",".",".","1","9","5",".",".","."],
     *                 [".","9","8",".",".",".",".","6","."], ... (valid)]
     * Output: true
     *
     * Input: Duplicate in row 8: change board[7][4]='3' (duplicate)
     * Output: false
     *
     * Input: All '.' empty board
     * Output: true (no violations)
     * </pre>
     *
     * @param board 9×9 Sudoku grid ('.' empty)
     * @return true if valid Sudoku configuration
     */
    public boolean isValidSudoku(char[][] board) {
        return hasValidRows(board) &&
                hasValidColumns(board) &&
                hasValidSubBoxes(board);
    }

    /**
     * Validates all 9 rows have unique digits 1-9.
     */
    private boolean hasValidRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];
                if (cell != '.') {
                    if (!seen.add(cell)) {  // add() returns false if duplicate
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Validates all 9 columns have unique digits 1-9.
     */
    private boolean hasValidColumns(char[][] board) {
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char cell = board[row][col];
                if (cell != '.') {
                    if (!seen.add(cell)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Validates all 9 3×3 sub-boxes have unique digits 1-9.
     */
    private boolean hasValidSubBoxes(char[][] board) {
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> seen = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char cell = board[boxRow + i][boxCol + j];
                        if (cell != '.') {
                            if (!seen.add(cell)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
