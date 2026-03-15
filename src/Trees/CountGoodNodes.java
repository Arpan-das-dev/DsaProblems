package Trees;

/**
 * Counts "good nodes" in a binary tree where path maximum is tracked during DFS.
 *
 * <p>Given the root of a binary tree, determine the number of "good nodes" in the tree.
 * A node is good if no node on the path from root to that node has a value strictly greater
 * than this node's value (i.e., node.val ≥ maxSeenSoFar).</p>
 *
 * <p><b>Key Insight:</b> DFS traversal maintaining path maximum. Each node is good if
 * its value ≥ current path maximum, then update maximum for subtree traversal.</p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes 3,4,1,5 are good (4 nodes ≥ path max)
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Nodes 3,3,4 are good
 *
 * Input: root = [1]
 * Output: 1
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n) visits each node once.<br>
 * <b>Space Complexity:</b> O(h) recursion stack where h is tree height.</p>
 *
 * @author Arpan Das
 * @since 15/03/2026
 */
public class CountGoodNodes {

    /**
     * Counts good nodes in binary tree using DFS with path maximum tracking.
     *
     * <p><b>Recursive Logic:</b></p>
     * <pre>
     * dfs(node, pathMax):
     *   if node == null: return 0
     *
     *   count = 0
     *   if node.val ≥ pathMax:
     *     count = 1
     *     pathMax = node.val  // update for subtree
     *
     *   count += dfs(left, pathMax)
     *   count += dfs(right, pathMax)
     *   return count
     * </pre>
     *
     * @param root root of binary tree
     * @return total count of good nodes
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    /**
     * DFS helper: counts good nodes in subtree maintaining path maximum.
     *
     * @param root current node
     * @param maxSeenSoFar maximum value seen on path from root to current
     * @return number of good nodes in subtree
     */
    private int dfs(TreeNode root, int maxSeenSoFar) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= maxSeenSoFar) {
            count = 1;
            maxSeenSoFar = root.val;  // Update max for subtree traversal
        }

        count += dfs(root.left, maxSeenSoFar);
        count += dfs(root.right, maxSeenSoFar);

        return count;
    }
}
