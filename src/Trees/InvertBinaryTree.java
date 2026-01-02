package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Utility class for inverting a binary tree.
 *
 * <p>A binary tree is considered inverted when, for every node,
 * its left and right children are swapped.</p>
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>Use <b>Breadth-First Search (BFS)</b> to traverse the tree level by level</li>
 *   <li>A {@link Queue} is used to process nodes in FIFO order</li>
 *   <li>At each node, swap the left and right child references</li>
 *   <li>Continue until all nodes are processed</li>
 * </ul>
 *
 * <p>This approach avoids recursion and ensures all nodes
 * are inverted in-place.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of nodes<br>
 * <b>Space Complexity:</b> O(n), due to the queue used for traversal</p>
 *
 * @author Arpan Das
 * @since 03/01/2025
 */
public class InvertBinaryTree {
    /**
     * Inverts the given binary tree by swapping left and right
     * children of every node.
     *
     * <p>The tree is modified in-place and the same root reference
     * is returned after inversion.</p>
     *
     * @param root the root node of the binary tree
     * @return the root of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {

        // Base case: if the tree is empty, nothing to invert
        if (root == null) {
            return null;
        }

        // Queue for level-order (BFS) traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        // Start traversal from the root node
        nodeQueue.add(root);

        // Process nodes until the queue becomes empty
        while (!nodeQueue.isEmpty()) {

            // Retrieve and remove the current node from the queue
            TreeNode node = nodeQueue.poll();

            // Swap left and right child references
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add non-null children to the queue for further processing
            if (node.left != null) {
                nodeQueue.offer(node.left);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
        }

        // Return the root of the inverted tree
        return root;
    }
}
