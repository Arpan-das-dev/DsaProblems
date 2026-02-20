package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
        for (int index = 0; index < inorder.length; index++){
            inOrderIndexMap.put(inorder[index],index);
        }
        return splitTreeDFS(inOrderIndexMap,preorder,0,inorder.length-1);
    }

    private TreeNode splitTreeDFS(Map<Integer, Integer> inOrderIndexMap, int[] preorder, int left, int right) {
        if(left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderIndexMap.get(rootVal);

        // build left
        root.left = splitTreeDFS(inOrderIndexMap,preorder,left,mid-1);
        // build right
        root.right = splitTreeDFS(inOrderIndexMap,preorder,mid+1,right);

        return root;
    }
}
