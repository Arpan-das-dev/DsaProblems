package Trees;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return DFS(root) != -1;

    }
    private int DFS (TreeNode root) {
        if(root == null) return 0;

        int left = DFS(root.left);
        if(left == -1) return -1;

        int right = DFS(root.right);
        if(right == -1) return -1;

       if(Math.abs(left - right) > 1) {
           return -1;
       }
        return Math.max(left,right)+1;
    }
}
