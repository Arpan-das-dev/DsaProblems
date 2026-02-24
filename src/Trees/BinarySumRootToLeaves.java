package Trees;

public class BinarySumRootToLeaves {
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int curr) {
        if(root == null) return 0;

        curr = curr*2 + root.val;

        int left = dfs(root.left,curr);
        int right = dfs(root.right,curr);

        if(root.left == null && root.right == null) return curr;

        return left+right;
    }
}

