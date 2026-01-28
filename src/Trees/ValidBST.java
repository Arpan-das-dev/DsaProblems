package Trees;

/**
 * Utility class to validate if a binary tree is a valid Binary Search Tree (BST).
 *
 * <p>A valid BST is defined as:
 * <ul>
 *   <li>The left subtree of a node contains only nodes with keys less than the node's key</li>
 *   <li>The right subtree contains only nodes with keys greater than the node's key</li>
 *   <li>Both left and right subtrees must also be valid BSTs</li>
 * </ul>
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use recursive DFS with range validation: each node must lie strictly within
 *       a valid range (min, max) passed from its parent.</li>
 *   <li>For left child: valid range becomes (min, parent's value)</li>
 *   <li>For right child: valid range becomes (parent's value, max)</li>
 *   <li>Base cases: null node is valid; node outside its range makes the tree invalid</li>
 * </ul>
 *
 * <p>Using Long.MIN_VALUE and Long.MAX_VALUE as initial bounds handles edge cases
 * where node values could be Integer.MIN_VALUE or Integer.MAX_VALUE.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes (visits each once).<br>
 * <b>Space Complexity:</b> O(h), where h is the height (recursion stack).</p>
 *
 * @author Arpan Das
 * @since 28/01/2026
 */
public class ValidBST {

    /**
     * Validates if the binary tree is a valid Binary Search Tree.
     *
     * <p>Recursively checks that every node lies within its valid range inherited from ancestors.
     * Uses Long bounds to handle edge cases with Integer extremes.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: root = [2,1,3]
     * Output: true
     * Explanation: Valid BST: 1 < 2 < 3.
     *
     * Input: root = [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: Node 1 has right child 3 which violates BST property (3 > 1 but should be < 5).
     *
     * Input: root = [2147483647]
     * Output: true
     * Explanation: Single node is always valid BST.
     *
     * Input: root = [Integer.MAX_VALUE, Integer.MAX_VALUE]
     * Output: false
     * Explanation: Right child doesn't have value > parent.
     * </pre>
     *
     * @param root the root node of the binary tree
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * DFS helper to validate BST property within given range bounds.
     *
     * <p>Checks if current node is valid within (min, max), then recursively validates
     * left subtree in range (min, root.val) and right subtree in range (root.val, max).</p>
     *
     * @param root current node being validated
     * @param min  minimum allowed value (exclusive)
     * @param max  maximum allowed value (exclusive)
     * @return true if subtree rooted at current node is valid BST within bounds
     */
    private boolean dfs(TreeNode root, long min, long max) {
        // Base case: empty subtree is valid
        if (root == null) return true;

        // Current node must be strictly within bounds
        if (root.val <= min || root.val >= max) return false;

        // Recursively validate left and right subtrees with tightened bounds
        return dfs(root.left, min, root.val) &&    // left: (min, root.val)
                dfs(root.right, root.val, max);    // right: (root.val, max)
    }
}
