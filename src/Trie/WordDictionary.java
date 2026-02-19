package Trie;

/**
 * Utility class implementing Word Dictionary with wildcard (.) support using Trie + DFS.
 *
 * <p>Design a data structure supporting {@code addWord(word)} and {@code search(word)} where
 * {@code search} can contain {@code .} wildcards matching any lowercase letter.</p>
 *
 * <p><b>Approach:</b> Trie + Recursive DFS for Wildcard Matching</p>
 * <ul>
 *   <li><b>addWord:</b> Standard Trie insertion (O(L))</li>
 *   <li><b>search:</b> DFS traverses Trie following word characters or branches all children for {@code .}</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> addWord: O(L), search: O(26^K×L) where K = # of {@code .} wildcards.<br>
 * <b>Space Complexity:</b> O(total chars across all words).</p>
 *
 * @author Arpan Das
 * @since 19/02/2026
 */
class WordDictionary {

    /** Trie node representing a character with children array. */
    private static class Children {
        Children[] children = new Children[26];  // a-z
        boolean eow = false;                     // End of Word flag
    }

    private final Children root;

    /** Initialize empty WordDictionary with root Trie node. */
    public WordDictionary() {
        this.root = new Children();
    }

    /**
     * Adds word to dictionary.
     *
     * <p>Traverses/creates Trie path for each character, marks end node.</p>
     */
    public void addWord(String word) {
        Children curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Children();
            }
            curr = curr.children[index];
        }
        curr.eow = true;  // Mark end of word
    }

    /**
     * Returns true if word exists in dictionary (supports {@code .} wildcard).
     *
     * <p>Uses DFS: follows exact path for letters, branches all children for {@code .}.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * addWord("bad"); addWord("dad"); addWord("mad")
     * search("pad") → false     (no 'p' prefix)
     * search("bad") → true      (exact match)
     * search("b..") → true      (b + any + any → "bad")
     * search("b.d") → false     (no "bed","bid",etc.)
     * search(".ad") → true      (any + a + d → "bad","dad","mad")
     * search("b..") → true
     * </pre>
     *
     * @param word word with optional {@code .} wildcards
     * @return true if matches any word in dictionary
     */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    /**
     * DFS helper: searches from current Trie node at word position.
     *
     * <p>Base cases: end of word (check eow), null node.</p>
     * <p>Wildcard: try all 26 children. Literal: follow specific child.</p>
     */
    private boolean dfs(String word, int index, Children node) {
        // Base case: reached end of word
        if (index == word.length()) {
            return node != null && node.eow;
        }

        // Null node: no path exists
        if (node == null) return false;

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard: try all possible children
            for (Children child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Literal character: follow specific path
            int idx = ch - 'a';
            return dfs(word, index + 1, node.children[idx]);
        }
    }
}
