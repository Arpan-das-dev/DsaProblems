package Trees;
/**
 * Utility class to check if a given binary tree is a subtree of another binary tree.
 *
 * <p>Given the roots of two binary trees {@code root} and {@code subRoot}, determine whether
 * {@code subRoot} is a subtree of {@code root}. A subtree of {@code root} is a tree
 * consisting of a node in {@code root} and all its descendants. The subtree must
 * match exactly in structure and node values.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a helper method {@code isSameTree} to check if two trees are identical in structure and values.</li>
 *   <li>At each node in the main tree:
 *     <ul>
 *       <li>If the current node is {@code null}, it cannot contain {@code subRoot}.</li>
 *       <li>If the tree rooted at the current node is identical to {@code subRoot}, return {@code true}.</li>
 *       <li>Otherwise, recursively check the left and right subtrees of the main tree.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This recursive solution traverses the main tree and, for each node, checks subtree identity,
 * ensuring the correct subtree relationship is detected.</p>
 *
 * <p><b>Time Complexity:</b> O(m × n), where m is the number of nodes in the main tree and n in the subtree.<br>
 * <b>Space Complexity:</b> O(h) for the recursion stack, where h is the height of the main tree.</p>
 *
 * @author Arpan Das
 * @since 17/01/2026
 */
public class SubTree {

    /**
     * Determines whether {@code subRoot} is a subtree of {@code root}.
     *
     * <p>Traverses the main tree using DFS. If the current node is null, returns false.
     * If the tree rooted at the current node is identical to {@code subRoot}, returns true.
     * Otherwise, checks if {@code subRoot} is a subtree in the left or right subtree.</p>
     *
     * @param root    the root of the main binary tree
     * @param subRoot the root of the subtree to be checked
     * @return {@code true} if {@code subRoot} is a subtree of {@code root}, otherwise {@code false}
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; // Empty tree cannot have a subtree

        // If the current node’s tree matches the subtree, we found it
        if (isSameTree(root, subRoot)) return true;

        // Otherwise, check in left and right subtrees
        return isSubtree(root.left,  subRoot) ||
                isSubtree(root.right, subRoot);
    }

    /**
     * Helper method to check if two binary trees are identical in structure and node values.
     *
     * <p>Two trees are same if:
     * <ul>
     *   <li>both are null (true), or</li>
     *   <li>only one is null (false), or</li>
     *   <li>both are non-null, their values are equal, and both left and right subtrees are same.</li>
     * </ul>
     * </p>
     *
     * @param treeNode first binary tree node
     * @param sub      second binary tree node
     * @return {@code true} if both trees are identical, otherwise {@code false}
     */
    private boolean isSameTree(TreeNode treeNode, TreeNode sub) {
        if (treeNode == null && sub == null) return true;
        if (treeNode == null || sub == null) return false;

        if (treeNode.val != sub.val) return false;

        return isSameTree(treeNode.left,  sub.left)  &&
                isSameTree(treeNode.right, sub.right);
    }
}
