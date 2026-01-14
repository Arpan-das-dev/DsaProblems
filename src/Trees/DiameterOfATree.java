package Trees;

public class DiameterOfATree {

    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        diameter = Math.max(diameter,rightDepth+leftDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
