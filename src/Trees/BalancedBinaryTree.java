package Trees;

/**
 * Utility class to determine whether a binary tree is height‑balanced.
 *
 * <p>A binary tree is height‑balanced if the depth of the two subtrees of every node never differs
 * by more than 1. The tree is given as a root node, and the goal is to decide whether the entire tree
 * satisfies this property.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 150}</b>.</p>
 *
 * <p><b>Approach (DFS with early return):</b></p>
 * <ul>
 *   <li>Define a recursive helper DFS that returns:
 *     <ul>
 *       <li>the height of the subtree if it is balanced, or</li>
 *       <li>-1 if the subtree is unbalanced.</li>
 *     </ul>
 *   </li>
 *   <li>For each node, compute the left and right subtree heights.</li>
 *   <li>If either subtree returns -1 (unbalanced) or the heights differ by more than 1, return -1.</li>
 *   <li>Otherwise, return the maximum height plus 1.</li>
 *   <li>The main method checks whether the root’s DFS result is not -1.</li>
 * </ul>
 *
 * <p><b>Approach (external state variant):</b></p>
 * <ul>
 *   <li>Use instance fields flag and valid to track whether an imbalance has been found.</li>
 *   <li>Another DFS traversal returns the height but stops recursing once an imbalance is detected.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n is the number of nodes, since each node is visited once.<br>
 * <b>Space Complexity:</b> O(h) for the recursion stack, where h is the height of the tree.</p>
 *
 * @author Arpan Das
 * @since 12/04/2026
 */
public class BalancedBinaryTree {

    /**
     * Returns whether the given binary tree is height‑balanced.
     *
     * <p>A tree is height‑balanced if the depths of the left and right subtrees of every node
     * differ by at most 1. An empty tree is considered balanced.</p>
     *
     * <p>This method uses a recursive DFS that returns -1 if any subtree is unbalanced,
     * otherwise returns the height of the subtree.</p>
     *
     * @param root root node of the binary tree (may be null)
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced(TreeNode root) {
        return DFS(root) != -1;
    }

    /**
     * Helper DFS method that returns the height of the subtree rooted at root,
     * or -1 if the subtree is unbalanced.
     *
     * <p>If either left or right subtree is unbalanced (returns -1) or the heights differ
     * by more than 1, this method returns -1. Otherwise, it returns 1 + max(left height, right height).</p>
     *
     * @param root root of the current subtree (maybe null)
     * @return height if balanced, or -1 if unbalanced
     */
    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = DFS(root.left);
        if (left == -1) {
            return -1;
        }

        int right = DFS(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    private boolean flag;  // true once imbalance is detected in external‑state variant
    private boolean valid; // tracks whether the tree is still balanced

    /**
     * Returns whether the tree is balanced using an external state style (DFS with flags).
     *
     * <p>This variant uses instance fields flag and valid to stop further recursion once an
     * imbalance is found. The method initializes flags, calls a DFS helper, and returns the
     * validity of the tree.</p>
     *
     * @param root root node of the binary tree (may be null)
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalancedExternalState(TreeNode root) {
        flag = false;
        valid = true;
        dfs(root);
        return valid;
    }

    /**
     * DFS helper for the external‑state variant.
     *
     * <p>This method computes the height of the subtree rooted at root, but stops recursing
     * once an imbalance is detected (flag is set). The valid flag is set to false if the heights
     * of left and right subtrees differ by more than 1.</p>
     *
     * @param root root of the current subtree (may be null)
     * @return height of the subtree if balanced, or any value once imbalance is detected
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1) {
            valid = false;
            flag = true;
        }

        return Math.max(left, right) + 1;
    }
}