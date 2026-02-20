package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to construct binary tree from preorder and inorder traversals.
 *
 * <p>Given preorder and inorder traversal arrays, return the root of the corresponding binary tree.
 * Preorder: [root,left,right], Inorder: [left,root,right]. First preorder element = root, its inorder
 * position splits left/right subtrees recursively.</p>
 *
 * <p><b>Approach:</b> Recursive Divide + HashMap Index Lookup</p>
 * <ul>
 *   <li>Build HashMap: value → inorder index (O(n))</li>
 *   <li>Preorder[preIndex] = current root</li>
 *   <li>Inorder index splits: [left,root_index-1] → left subtree, [root_index+1,right] → right</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) total (O(n) HashMap + O(n) DFS).<br>
 * <b>Space Complexity:</b> O(n) HashMap + O(h) recursion stack.</p>
 *
 * @author Arpan Das
 * @since 20/02/2026
 */

public class ConstructBinaryTree {

    private int preIndex = 0;  // Global preorder index (updated post-order)

    /**
     * Constructs binary tree from preorder and inorder traversals.
     *
     * <p>Preorder gives root order, inorder splits left/right subtrees at root position.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * Tree:     3
     *          / \
     *         9  20
     *           /  \
     *          15   7
     * Preorder: 3→9→20→15→7 ✓
     * Inorder:  9→3→15→20→7 ✓
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     * Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
     * Output: [1,2,null,null,3,null,4]
     * </pre>
     *
     * @param preorder preorder traversal array
     * @param inorder  inorder traversal array
     * @return root of constructed tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build HashMap for O(1) inorder index lookup
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTreeDFS(inOrderIndexMap, preorder, 0, inorder.length - 1);
    }

    /**
     * Recursive DFS: builds subtree for inorder range [left,right].
     *
     * <p>Root = next preorder element, inorder position splits left/right ranges recursively.</p>
     */
    private TreeNode splitTreeDFS(Map<Integer, Integer> inOrderIndexMap,
                                  int[] preorder, int left, int right) {
        // Base case: no nodes
        if (left > right) return null;

        // Current root from preorder (consume next)
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Root splits inorder into left/right subtrees
        int mid = inOrderIndexMap.get(rootVal);

        // Build left subtree: inorder[left, mid-1]
        root.left = splitTreeDFS(inOrderIndexMap, preorder, left, mid - 1);

        // Build right subtree: inorder[mid+1, right]
        root.right = splitTreeDFS(inOrderIndexMap, preorder, mid + 1, right);

        return root;
    }
}

