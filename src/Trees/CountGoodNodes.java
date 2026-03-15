package Trees;

public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int maxSeenSoFar) {
        if(root == null) return 0;

        int count = 0;
        if(root.val >= maxSeenSoFar) {
            count = 1;
            maxSeenSoFar = root.val;
        }
        count += dfs(root.left,maxSeenSoFar);
        count += dfs(root.right,maxSeenSoFar);

        return count;
    }
}