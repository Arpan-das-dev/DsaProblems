package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    public List<String> findWordsBrute(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (String word : words) {
                    if (board[r][c] == word.charAt(0)) dfs(board, word, result, visited, r, c, 0);
                }
            }
        }
        return result.stream().distinct().toList();
    }

    private void dfs(char[][] board, String word, List<String> result, boolean[][] visited,
                     int row, int col, int index) {
        if (index == word.length()) {
            result.add(word);
            return;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
        if (visited[row][col] || board[row][col] != word.charAt(index)) return;

        visited[row][col] = true;

        dfs(board, word, result, visited, row + 1, col, index + 1);
        dfs(board, word, result, visited, row - 1, col, index + 1);
        dfs(board, word, result, visited, row, col + 1, index + 1);
        dfs(board, word, result, visited, row, col - 1, index + 1);

        visited[row][col] = false;
    }

    private static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    private static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];
        List<String> result = new ArrayList<>();
        Trie node = buildTrie(words);

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(board, node, visited, result, r, c);
            }
        }
        return result;
    }

    private void dfs(char[][] board, Trie node, boolean[][] visited, List<String> result, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if (visited[r][c]) return;

        char ch = board[r][c];
        Trie trie = node.children[ch - 'a'];

        if (trie == null) return;
        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(board, trie, visited, result, nr, nc);
        }
        visited[r][c] = false;
    }

    private Trie buildTrie(String[] words) {
        Trie node = new Trie();

        for (String word : words) {
            Trie curr = node;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return node;
    }
}
