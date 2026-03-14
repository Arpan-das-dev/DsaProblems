package Trees;


import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()){
            int queueSize = nodes.size();
            List<Integer> integers = new ArrayList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = nodes.poll();
                if(node != null){
                    integers.add(node.val);
                    if(node.left != null) nodes.offer(node.left);
                    if(node.right != null) nodes.offer(node.right);
                }
            }
            lists.add(integers);
        }
        return lists;
    }

}
