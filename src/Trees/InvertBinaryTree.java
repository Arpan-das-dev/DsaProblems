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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null; // returning null if root is empty
        Queue<TreeNode> nodeQueue = new LinkedList<>(); // using queue for FIFO usage;
        nodeQueue.add(root); // adding the first node (root in the queue)
        while (!nodeQueue.isEmpty()) { // keep polling until queue is empty
            TreeNode node = nodeQueue.poll(); // poll a node
            // swapping values from left-> right && right -> left using temp variable
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null) nodeQueue.offer(node.right); // if right node is not null add it in queue
            if(node.left != null) nodeQueue.offer(node.left); // if left node is not null add it in queue
        }
        return root;
    }
}
