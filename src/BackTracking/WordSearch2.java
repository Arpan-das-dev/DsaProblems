package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find all words from dictionary present in character board.
 *
 * <p>Given an m×n {@code board} of characters and array of {@code words}, return all words
 * present in board. Words constructed from sequentially adjacent cells (up/down/left/right).
 * Each cell used once per word. Optimized solution uses Trie + DFS.</p>
 *
 * <p><b>Two Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> DFS for each word from each starting cell O(m×n×W×4^L)</li>
 *   <li><b>Trie + DFS:</b> Build Trie once, DFS once per cell following Trie paths O(m×n×4^min(L))</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n×4^min(L)) for Trie approach.<br>
 * <b>Space Complexity:</b> O(total chars in words) for Trie + O(m×n) visited.</p>
 *
 * @author Arpan Das
 * @since 19/02/2026
 */

public class WordSearch2 {

    /**
     * Brute force: tries every word from every starting position.
     * Inefficient for many words.
     */
    public List<String> findWordsBrute(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Try every cell as start for every word
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (String word : words) {
                    if (board[r][c] == word.charAt(0)) {
                        dfs(board, word, result, visited, r, c, 0);
                    }
                }
            }
        }
        return result.stream().distinct().toList();
    }

    /** Brute force DFS helper. */
    private void dfs(char[][] board, String word, List<String> result,
                     boolean[][] visited, int row, int col, int index) {
        // Found complete word
        if (index == word.length()) {
            result.add(word);
            return;
        }

        // Bounds check or mismatch
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || board[row][col] != word.charAt(index)) {
            return;
        }

        visited[row][col] = true;

        // Explore 4 directions
        dfs(board, word, result, visited, row + 1, col, index + 1); // down
        dfs(board, word, result, visited, row - 1, col, index + 1); // up
        dfs(board, word, result, visited, row, col + 1, index + 1); // right
        dfs(board, word, result, visited, row, col - 1, index + 1); // left

        visited[row][col] = false; // backtrack
    }

    // ========== OPTIMIZED TRIE SOLUTION ==========

    /** Trie node for efficient word prefix matching. */
    private static class Trie {
        Trie[] children = new Trie[26];
        String word;  // Complete word stored at leaf
    }

    /** 4-directional movement: right, left, down, up */
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Returns all words from dictionary present in board.
     *
     * <p>Builds Trie once, then DFS from each board cell following Trie paths.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
     *        words = ["oath","pea","eat","rain"]
     * Output: ["eat","oath"]
     * Path for "oath": o(0,0)→a(0,1)→t(1,1)→h(2,1)
     * Path for "eat":  e(1,0)→a(1,2)→t(1,1)
     *
     * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
     * Output: []
     * Explanation: Cannot reuse cell 'b' after a→b→c
     *
     * Input: board = [["a","b","c","d"],["s","a","a","t"],["a","c","k","e"],["a","c","d","n"]]
     *        words = ["bat","cat","back","backend","stack"]
     * Output: ["cat","back","backend"]
     * </pre>
     *
     * @param board m×n character grid
     * @param words dictionary of words to find
     * @return list of found words (no duplicates)
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Trie root = buildTrie(words);  // O(total chars in words)

        // Start DFS from each cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, root, visited, result, r, c);
            }
        }
        return result;
    }

    /**
     * DFS: Explore from current cell following Trie node children.
     *
     * <p>Prunes paths without Trie continuation. Marks/unmarks visited cells.</p>
     */
    private void dfs(char[][] board, Trie node, boolean[][] visited,
                     List<String> result, int r, int c) {
        // Bounds check or already visited
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) {
            return;
        }

        // Get next Trie node for current character
        char ch = board[r][c];
        Trie next = node.children[ch - 'a'];
        if (next == null) return;  // Pruning: no word continues with this char

        // Found complete word
        if (next.word != null) {
            result.add(next.word);
            next.word = null;  // Prevent duplicates
        }

        // Mark visited and explore neighbors
        visited[r][c] = true;
        for (int[] dir : directions) {
            dfs(board, next, visited, result, r + dir[0], c + dir[1]);
        }
        visited[r][c] = false;  // Backtrack
    }

    /**
     * Builds Trie from all input words.
     *
     * <p>Stores complete word at leaf node for easy detection.</p>
     */
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Trie();
                }
                curr = curr.children[idx];
            }
            curr.word = word;  // Store at end
        }
        return root;
    }
}
