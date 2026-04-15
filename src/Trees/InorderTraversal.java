package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to perform inorder traversal of a binary tree.
 *
 * <p>Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * In an inorder traversal, nodes are visited in the order: left subtree, root, right subtree.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (recursive DFS):</b></p>
 * <ul>
 *   <li>Use a recursive helper method that first visits the left subtree.</li>
 *   <li>Then, add the current node's value to the result list.</li>
 *   <li>Finally, visit the right subtree.</li>
 *   <li>If the current node is null, the method returns immediately.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n is the number of nodes, since each node is visited exactly once.<br>
 * <b>Space Complexity:</b> O(h) for the recursion stack, where h is the height of the tree (O(n) in the worst case).</p>
 *
 * @author Arpan Das
 * @since 15/04/2026
 */
public class InorderTraversal {

    /**
     * Returns the inorder traversal of the binary tree rooted at root.
     *
     * <p>The traversal order is: left subtree, then root, then right subtree.
     * The result is a list of integers representing the values of the nodes in this order.</p>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     * Explanation:
     *   Inorder: left (1), root (1), right subtree (3,2).
     *   So the order is 1 (root) with left subtree, then 3, then 2.
     * </pre>
     *
     * @param root root node of the binary tree (may be null)
     * @return list of node values in inorder traversal order
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    /**
     * Recursive helper method that performs inorder traversal.
     *
     * <p>This method traverses the tree in the order: left subtree, current node, right subtree.
     * It adds the current node's value to the result list after traversing its left subtree.</p>
     *
     * @param root current node of the tree (may be null)
     * @param result list to store the inorder traversal values (passed by reference)
     */
    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}