package Trees;

/**
 * Utility class to find maximum path sum in a binary tree (any path, any nodes).
 *
 * <p>Given non-empty binary tree root, return maximum path sum of any path. Path = sequence of
 * adjacent nodes connected by edges. Path sum = sum of node values. Path can start/end anywhere.</p>
 *
 * <p><b>Approach:</b> Post-order DFS + Global Maximum Tracking</p>
 * <ul>
 *   <li><b>dfs(node):</b> Returns max gain from node downward (single path to leaf)</li>
 *   <li>At each node: compute left_gain = max(0, dfs(left)), right_gain = max(0, dfs(right))</li>
 *   <li>Update global max: node.val + left_gain + right_gain (path through node)</li>
 *   <li>Return to parent: node.val + max(left_gain, right_gain) (single arm only)</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), visit each node once.<br>
 * <b>Space Complexity:</b> O(h) recursion stack (h = tree height).</p>
 *
 * @author Arpan Das
 * @since 21/02/2026
 */

public class PathMaxSum {
    private int maxSum = Integer.MIN_VALUE;  // Global maximum path sum

    /**
     * Returns maximum path sum of any path in binary tree.
     *
     * <p>Initiates DFS, returns tracked global maximum.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: root = [1,2,3]
     *        1
     *       / \
     *      2   3
     * Output: 6 (2→1→3)
     *
     * Input: root = [-10,9,20,null,null,15,7]
     *         -10
     *         / \
     *        9  20
     *          /  \
     *         15   7
     * Output: 42 (15→20→7)
     *
     * Input: root = [2,-1,-2,-3,null,null,4]
     *        2
     *       / \
     *     -1  -2
     *      |    \
     *     -3     4
     * Output: 7 (single node 4, ignores negatives)
     *
     * Input: root = [-3]
     * Output: -3 (single negative node)
     * </pre>
     *
     * @param root root of binary tree (non-empty)
     * @return maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * Post-order DFS: computes max downward path and updates global max.
     *
     * <p>@return max gain from this node downward (used by parent)</p>
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Get max path gains from children (ignore negatives: max(0, ...))
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path THROUGH current node (left + node + right)
        int throughNode = node.val + left + right;

        // Update global maximum (any path ending anywhere)
        maxSum = Math.max(maxSum, throughNode);

        // Return max single path UPWARD to parent (node + max one child)
        return node.val + Math.max(left, right);
    }
}


