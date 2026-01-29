package Trees;


public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        // using sb for immutable object better memory usage;
        StringBuilder sb = new StringBuilder();
        // keep updating the sb with helper method
        dfs(root,sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("$,"); // if it's null then add a sign '$'/'@'/'&'/'#' etc.
            return;
        }

        sb.append(root.val).append(","); // if it's not then append value with , like 7,

        // keep recursing until reaches dead end;
        dfs(root.left,sb);
        dfs(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // simply breaking the string into array with the ',' what we used to make string
        index = 0;
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }

    // private counter for tracking the index
    private int index;
    private TreeNode buildTree(String[] nodes) {
        // handle for '$' because in our case it's represents null values;
        // due to trailing , we need to also handle the empty string
        if(nodes[index].equals("$") || nodes[index].isEmpty()) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        index++;

        // recursing and add nodes for the leaf nodes (if present)
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}
