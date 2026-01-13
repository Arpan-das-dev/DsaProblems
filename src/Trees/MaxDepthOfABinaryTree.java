package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Utility class for finding the maximum depth of a binary tree.
 *
 * <p>The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Recursive DFS:</b> Recursively compute the depth of left and right subtrees,
 *       then return 1 + max(leftDepth, rightDepth).</li>
 *   <li><b>Iterative BFS (Level Order):</b> Use a queue to process nodes level by level,
 *       incrementing depth for each level until the queue is empty.</li>
 * </ul>
 *
 * <p>Both methods correctly compute the maximum depth, with DFS being more concise
 * and BFS being useful when level-by-level processing is needed.</p>
 *
 * <p><b>Time Complexity:</b> O(n) for both, where n is the number of nodes.<br>
 * <b>Space Complexity:</b> O(h) for DFS (recursion stack), O(w) for BFS (queue), where h is height and w is max width.</p>
 *
 * @author Arpan Das
 * @since 13/01/2026
 */
public class MaxDepthOfABinaryTree {

    /**
     * Computes the maximum depth of a binary tree using BFS (level-order traversal).
     *
     * <p>Processes nodes level by level using a queue. For each level, the depth is incremented
     * and all children of current level nodes are enqueued for the next level.</p>
     *
     * @param root the root node of the binary tree
     * @return the maximum depth (number of levels) of the tree; 0 if root is null
     */
    public int maxDepthBFS(TreeNode root) {
        if(root == null) return 0; // if the root is null then return zero

        Queue<TreeNode> nodes = new LinkedList<>(); // initialize a queue because it's follow FIFO order
        nodes.offer(root); // just add the root
        int depth = 0; // default value = 0 because may be next layer is null.

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size(); // number of nodes present
            depth++; // increasing the depth

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.poll(); // pick the node

                // offer the left and right node if they and their parent is not null
                if (node != null && node.left != null) nodes.offer(node.left);
                if (node != null && node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }

    /**
     * Computes the maximum depth of a binary tree using recursive DFS.
     *
     * <p>Recursively computes the depth of left and right subtrees, then returns
     * 1 plus the maximum of the two depths.</p>
     *
     * @param root the root node of the binary tree
     * @return the maximum depth (number of nodes from root to the deepest leaf); 0 if root is null
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
}
