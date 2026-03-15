package Trees;

/**
 * Finds Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree using recursive DFS.
 *
 * <p>Given a BST and two nodes p and q, find their lowest common ancestor - the lowest (deepest)
 * node that has both p and q as descendants (where ancestor can be a node itself).</p>
 *
 * <p><b>Key Insight:</b> Post-order DFS returns first found node from left/right subtrees:
 * <ul>
 *   <li>Base: null/equal → return current</li>
 *   <li>Both subtrees return non-null → current is LCA</li>
 *   <li>One subtree null → return other subtree result</li>
 * </ul></p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(h) where h is tree height (stops at LCA).<br>
 * <b>Space Complexity:</b> O(h) recursion stack.</p>
 *
 * @author Arpan Das
 * @since 15/03/2026
 */
public class LowestCommonAncestor {

    /**
     * Finds LCA of nodes p and q using post-order recursive search.
     *
     * <p><b>Algorithm:</b></p>
     * <pre>
     * lca(node, p, q):
     *   if node null or equals p/q: return node
     *
     *   left = lca(left, p, q)
     *   right = lca(right, p, q)
     *
     *   if left null: return right
     *   if right null: return left
     *   return node  // both paths found
     * </pre>
     *
     * @param root root of BST
     * @param p first node
     * @param q second node
     * @return lowest common ancestor node
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base cases: null or found target
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search both subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Return first non-null result (LCA or path continuation)
        if (left == null) return right;
        if (right == null) return left;

        // Both paths exist: current node is LCA
        return root;
    }
}

