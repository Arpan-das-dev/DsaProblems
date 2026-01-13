package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfABinaryTree {
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

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
}
