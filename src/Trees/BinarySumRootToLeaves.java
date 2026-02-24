package Trees;

/**
 * Utility class to compute sum of binary numbers formed by root-to-leaf paths.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given binary tree where each node has value 0 or 1, return sum of all unique binary numbers
 * formed by root-to-leaf paths. Each path read as binary number (MSB→LSB from root→leaf).</p>
 *
 * <p><b>Approach:</b> DFS Path Building + Binary Accumulation</p>
 * <ul>
 *   <li>Pass current path value: {@code curr = curr*2 + node.val}</li>
 *   <li>At leaf: return path value, else sum left+right subtrees</li>
 *   <li>Modulo 10⁹+7 not needed (32-bit int safe for binary tree)</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), visit each node once.<br>
 * <b>Space Complexity:</b> O(h) recursion stack.</p>
 *
 * @author Arpan Das
 * @since 24/02/2026
 */
public class BinarySumRootToLeaves {

    /**
     * Returns sum of all root-to-leaf binary numbers.
     *
     * <p>DFS builds path value, sums contributions at leaves only.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: root = [1,0,1,0,1,0,1]
     *        1     → binary 1
     *       / \
     *      0   1  → paths: 10(2), 11(3)
     *     / \ / \
     *    0  1 0  1
     * Output: 22 (1+2+3+16+17+18+19)
     *
     * Input: root = [0]
     * Output: 0
     *
     * Input: root = [1,1]
     *        1
     *       /
     *      1  → path 11₂ = 3
     * Output: 3
     *
     * Input: root = [1,0]
     *        1
     *         \
     *          0 → path 10₂ = 2
     * Output: 2
     * </pre>
     *
     * @param root binary tree root (nodes contain 0 or 1)
     * @return sum of all root-to-leaf binary numbers
     */
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    /**
     * DFS: builds current path value, returns contribution at leaf.
     *
     * <p>@param curr current binary number from root to current node</p>
     */
    private int dfs(TreeNode root, int curr) {
        if (root == null) return 0;

        // Update current path value: shift left + add current bit
        curr = (curr * 2) + root.val;

        // Leaf node: return path value
        if (root.left == null && root.right == null) {
            return curr;
        }

        // Non-leaf: sum left + right subtree contributions
        int leftSum = dfs(root.left, curr);
        int rightSum = dfs(root.right, curr);
        return leftSum + rightSum;
    }
}



