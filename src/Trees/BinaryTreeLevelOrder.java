package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Breadth-First Search (BFS) solution for binary tree level order traversal.
 *
 * <p>Given the root of a binary tree, return the level order traversal of its nodes' values
 * (i.e., from left to right, level by level). Each level's nodes form one list in the result.</p>
 *
 * <p><b>Key Insight:</b> Use BFS with level-size tracking to process nodes level by level.
 * Process exactly <code>queue.size()</code> nodes per level before moving to next level.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Initialize result list and queue, add root if not null</li>
 *   <li>While queue not empty:
 *     <ul>
 *       <li>Process current level size</li>
 *       <li>Create list for current level nodes</li>
 *       <li>Add children to queue for next level</li>
 *     </ul>
 *   </li>
 * </ol>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Input: root = []
 * Output: []
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n) where n is number of nodes.<br>
 * <b>Space Complexity:</b> O(w) where w is max width of tree (queue space).</p>
 *
 * @author Arpan Das
 * @since 14/03/2026
 */
public class BinaryTreeLevelOrder {

    /**
     * Performs level order (BFS) traversal of binary tree, returning values level by level.
     *
     * <p><b>Level Processing:</b></p>
     * <pre>
     * While queue not empty:
     *   1. levelSize = queue.size()
     *   2. Create current level list
     *   3. For i=0 to levelSize-1:
     *        - Process node: add to current list
     *        - Add left/right children to queue
     *   4. Add current list to result
     * </pre>
     *
     * @param root root of binary tree
     * @return list of lists containing node values level by level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            int queueSize = nodes.size();
            List<Integer> integers = new ArrayList<>();

            // Process exactly queueSize nodes for current level
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    integers.add(node.val);
                    if (node.left != null) nodes.offer(node.left);
                    if (node.right != null) nodes.offer(node.right);
                }
            }
            lists.add(integers);
        }
        return lists;
    }
}
