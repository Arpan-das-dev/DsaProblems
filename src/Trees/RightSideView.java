package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result,0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result,int depth) {
        if(root == null) return;
        // it ensures at same level only right node is taken and
        // in the next step same recursive call with increased depth
        if(depth == result.size()) result.add(root.val);

        // right dfs first because view is from right side
        dfs(root.right,result,depth+1);
        dfs(root.left,result,depth+1);
    }
}
