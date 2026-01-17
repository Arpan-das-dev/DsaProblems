package Trees;

public class SubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean isSameTree(TreeNode treeNode, TreeNode sub) {
        if(treeNode == null && sub == null) return  true;
        if(treeNode == null || sub == null) return false;

        if (treeNode.val != sub.val) return false;

        return isSameTree(treeNode.left,sub.left) && isSameTree(treeNode.right,sub.right);
    }
}
