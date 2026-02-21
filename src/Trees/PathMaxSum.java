package Trees;

public class PathMaxSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Step 1: get max path from left & right (ignore negatives)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Step 2: path passing THROUGH this node
        int throughNode = left + right + node.val;

        // Step 3: update global max
        maxSum = Math.max(maxSum, throughNode);

        // Step 4: return max single path to parent
        return node.val + Math.max(left, right);
    }

}
