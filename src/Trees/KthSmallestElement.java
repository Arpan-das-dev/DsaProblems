package Trees;

public class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        int [] count = new int[1];
        int [] result = new int[1];
        inorder(root,k,count,result);
        return result[0];
    }

    private void inorder(TreeNode root, int k, int[] count, int[] result) {
        if(root == null) return;

        inorder(root.left,k,count,result);
        count[0] ++;
        if(count[0] == k){
            result[0] = root.val;
            return;
        }

        inorder(root.right,k,count,result);
    }
}
