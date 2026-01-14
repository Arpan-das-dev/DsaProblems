package Trees;
/**
 * Utility class for finding the diameter of a binary tree.
 *
 * <p>The diameter of a binary tree is the length of the longest path between any two nodes
 * in the tree. This path may or may not pass through the root.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a helper method that computes the maximum depth of each subtree.</li>
 *   <li>At each node, the longest path passing through that node is: leftDepth + rightDepth.</li>
 *   <li>Update a global diameter variable to keep track of the maximum such path seen so far.</li>
 *   <li>Return the depth of the current node as 1 + max(leftDepth, rightDepth).</li>
 * </ul>
 *
 * <p>This DFS-based approach computes both depth and diameter in a single traversal.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes (each node visited once).<br>
 * <b>Space Complexity:</b> O(h), where h is the height of the tree (recursion stack).</p>
 *
 * @author Arpan Das
 * @since 14/01/2026
 */
public class DiameterOfABinaryTree {

    private int diameter; // stores the maximum diameter found so far

    /**
     * Returns the diameter of the binary tree (length of the longest path between any two nodes).
     *
     * <p>The path length is measured in number of edges. For an empty tree, diameter is 0.</p>
     *
     * @param root the root node of the binary tree
     * @return the diameter of the tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return diameter;
    }

    /**
     * Helper method to compute the maximum depth of a subtree rooted at the given node.
     *
     * <p>While computing depth, it also updates the global diameter with the longest path
     * passing through the current node (leftDepth + rightDepth).</p>
     *
     * @param node the root of the current subtree
     * @return the maximum depth (number of edges from node to the deepest leaf) of the subtree
     */
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        // Update diameter with the longest path passing through this node
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return depth of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

