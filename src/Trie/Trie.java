package Trie;

/**
 * Trie (Prefix Tree) implementation for efficient string insertion, search, and prefix matching.
 *
 * <p>Implements a Trie data structure where each node represents a character (a-z).
 * Supports insert, exact search, and prefix search operations. Uses array-based children
 * for O(1) character access (26 lowercase letters).</p>
 *
 * <p><b>Structure:</b></p>
 * <ul>
 *   <li>Each {@code Child} node has 26 child pointers and {@code end} flag</li>
 *   <li>Root represents empty prefix</li>
 *   <li>Path from root to {@code end=true} node = complete word</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(L) per operation (L = word length).<br>
 * <b>Space Complexity:</b> O(ALPHABET_SIZE × total characters across all words) = O(26 × N).</p>
 *
 * @author Arpan Das
 * @since 17/02/2026
 */
public class Trie {

    /** Inner node class representing a character in the Trie. */
    private static class Child {
        Child[] children = new Child[26]; // a-z mapping
        boolean end = false;              // marks end of complete word
    }

    private final Child root;

    /**
     * Initializes empty Trie with root node.
     */
    public Trie() {
        this.root = new Child();
    }

    /**
     * Inserts word into Trie by creating nodes as needed.
     *
     * <p>Traverses character-by-character, creating child nodes for missing characters.</p>
     *
     * <p><b>Example:</b> insert("cat") creates path: root → c → a → t(end=true)</p>
     *
     * @param word word to insert (lowercase a-z)
     */
    public void insert(String word) {
        Child curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';  // Map 'a'→0, 'b'→1, ..., 'z'→25

            if (curr.children[index] == null) {
                curr.children[index] = new Child();
            }
            curr = curr.children[index];
        }
        curr.end = true;  // Mark end of word
    }

    /**
     * Returns true if word exists exactly in Trie.
     *
     * <p>Follows path for all characters, returns true only if final node has {@code end=true}.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * insert("cat"); search("cat") → true
     * insert("cat"); search("ca") → false (prefix exists, not complete word)
     * </pre>
     *
     * @param word word to search for
     * @return true if exact word exists
     */
    public boolean search(String word) {
        Child node = traverse(word);
        return node != null && node.end;
    }

    /**
     * Returns true if prefix exists in Trie (complete words optional).
     *
     * <p>Follows path for all prefix characters, returns true if path exists.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * insert("cat"); startsWith("ca") → true
     * insert("dog"); startsWith("ca") → false
     * </pre>
     *
     * @param prefix prefix to check
     * @return true if prefix exists
     */
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    /**
     * Helper: traverses Trie following word/prefix characters.
     *
     * <p>Returns final node if path exists, null if any character missing.</p>
     *
     * @param word word/prefix to traverse
     * @return final node or null
     */
    private Child traverse(String word) {
        Child node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;  // Path doesn't exist
            }
            node = node.children[index];
        }
        return node;
    }
}
