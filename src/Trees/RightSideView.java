package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Returns right side view of binary tree - node visible when tree viewed from right.
 *
 * <p>Given the root of a binary tree, imagine viewing it from the right side. Return the right
 * side view as a list where each element is the rightmost node at each level/depth.</p>
 *
 * <p>Provides both DFS (pre-order right-first) and BFS (level-order last node) solutions.</p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Input: root = []
 * Output: []
 * </pre>
 *
 * @author Arpan Das
 * @since 17/03/2026
 */
public class RightSideView {

    /**
     * DFS solution: Pre-order traversal prioritizing right subtree first.
     *
     * <p>Uses depth tracking to add only first (rightmost) node encountered at each level.
     * Right-first traversal ensures rightmost node reaches each depth first.</p>
     *
     * @param root root of binary tree
     * @return list of right side view nodes
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    /**
     * DFS helper: adds rightmost node at each depth level.
     *
     * <p><b>Logic:</b> If <code>depth == result.size()</code>, this is first node at this depth
     * (rightmost due to right-first traversal). Recurse right → left with incremented depth.</p>
     *
     * @param root current node
     * @param result accumulates right side view
     * @param depth current depth level
     */
    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;

        // First node at this depth = rightmost node (due to right-first traversal)
        if (depth == result.size()) {
            result.add(root.val);
        }

        // Right-first ensures rightmost nodes hit new depths first
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }

    /**
     * BFS solution: Level-order traversal taking last node per level.
     *
     * <p>Uses queue for level-by-level processing. At each level, last processed node
     * (index <code>size-1</code>) is rightmost when viewed from right.</p>
     *
     * @param root root of binary tree
     * @return list of right side view nodes
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process level, rightmost node is last in level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Last node in level = rightmost from right view
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
}

