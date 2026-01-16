package Trees;
/**
 * Utility class for checking whether two binary trees are structurally identical
 * and have the same node values at each position.
 *
 * <p>Two trees are considered the same if they are structurally identical and
 * the nodes at each position have the same value.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use recursive DFS to compare both trees node by node.</li>
 *   <li>Base cases:
 *     <ul>
 *       <li>If both nodes are null, they are same (true).</li>
 *       <li>If only one is null, they are different (false).</li>
 *     </ul>
 *   </li>
 *   <li>Compare current node values; if they differ, return false.</li>
 *   <li>Recursively check left subtrees and right subtrees.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes in the smaller tree.<br>
 * <b>Space Complexity:</b> O(h), where h is the height of the tree (recursion stack).</p>
 *
 * @author Arpan Das
 * @since 16/01/2026
 */
public class SameTree {

    /**
     * Checks if two binary trees are the same (structurally identical with same node values).
     *
     * <p>Uses recursive DFS to compare both trees node by node from the root.</p>
     *
     * @param p root of the first binary tree
     * @param q root of the second binary tree
     * @return true if both trees are the same, false otherwise
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are same
        if (p == null && q == null) return true;
        // If only one is null, they are different
        if (p == null || q == null) return false;

        // If current node values are different, trees are not same
        if (p.val != q.val) return false;

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
