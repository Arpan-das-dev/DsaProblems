package Trees;

/**
 * Utility class to find Kth the smallest element in Binary Search Tree.
 *
 * <p>Given BST root and integer k, return kth smallest value (1-indexed) from in-order traversal.
 * In BST, in-order traversal gives sorted order, so kth node visited = kth smallest.</p>
 *
 * <p><b>Approach:</b> In-order DFS with Early Termination Flag</p>
 * <ul>
 *   <li>In-order: left→root→right produces sorted sequence</li>
 *   <li>Track visit count with array[0], set found flag when k reached</li>
 *   <li>Early termination: skip remaining traversal after finding kth</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(h + k) average, O(n) worst case skewed.<br>
 * <b>Space Complexity:</b> O(h) recursion stack.</p>
 *
 * @author Arpan Das
 * @since 26/02/2026
 */
public class KthSmallestElement {

    private boolean found = false;  // Early termination flag

    /**
     * Returns kth smallest element in BST (1-indexed).
     *
     * <p>In-order traversal visits nodes in sorted order, stops immediately at kth element.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: root = [3,1,4,null,2], k = 1
     *        3
     *       / \
     *      1   4
     *       \
     *        2
     * In-order: 1,2,3,4 → 1st smallest = 1 ✓
     * Output: 1
     *
     * Input: k = 2 → Output: 2 (stops after finding)
     * Input: k = 3 → Output: 3
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * In-order: 1,2,3,4,5,6 → 3rd = 3 ✓
     * Output: 3
     * </pre>
     *
     * @param root root of BST
     * @param k    kth smallest (1-indexed)
     * @return kth smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];     // Visit counter
        int[] result = new int[1];    // Result holder

        // Reset found flag for multiple calls
        found = false;
        inorder(root, k, count, result);

        return result[0];
    }

    /**
     * In-order DFS with early termination.
     *
     * <p>Stops traversing once kth element found using found flag.</p>
     */
    private void inorder(TreeNode root, int k, int[] count, int[] result) {
        // Early termination: already found kth element
        if (found) return;
        if (root == null) return;

        // Visit left subtree
        inorder(root.left, k, count, result);

        // Skip if already found
        if (found) return;

        // Visit current node
        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            found = true;  // Set termination flag
            return;
        }

        // Visit right subtree (if kth not found)
        inorder(root.right, k, count, result);
    }
}