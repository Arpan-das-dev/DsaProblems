package Trees;

/**
 * Utility class to serialize and deserialize a binary tree.
 *
 * <p>Design an algorithm to serialize a binary tree into a string and deserialize the string back
 * into the original tree structure. The encoded string should be as compact as possible.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Serialize (Preorder DFS):</b> Perform preorder traversal (root, left, right).
 *       For each node, append its value followed by ','. Use '$' as a special marker for null nodes.</li>
 *   <li><b>Deserialize:</b> Split the string by ',', then recursively build the tree using a global index.
 *       Read the next token: if '$' or empty, return null; otherwise create node and recurse for left/right children.</li>
 * </ul>
 *
 * <p>The preorder traversal with null markers uniquely represents any binary tree structure.</p>
 *
 * <p><b>Time Complexity:</b> O(n) for both serialize and deserialize, where n is number of nodes.<br>
 * <b>Space Complexity:</b> O(n) for recursion stack and output string/array.</p>
 *
 * @author Arpan Das
 * @since 29/01/2026
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * Serializes the binary tree into a compact string representation.
     *
     * <p>Uses preorder traversal: for each node, appends "{@code value,}". Null nodes are marked with "{@code $,}"
     * to preserve structure. Uses StringBuilder for efficient concatenation.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: root = [1,2,3,null,null,4,5]
     * Output: "1,2,$,$,3,4,$,$,5,$,$,$"
     * Explanation:
     * - 1,
     * - 2,$,$,
     * - 3,4,$,$,5,$,$,$,
     *
     * Input: root = []
     * Output: "$"
     *
     * Input: root = [1]
     * Output: "1,$,$"
     * </pre>
     *
     * @param root the root of the binary tree
     * @return the serialized string
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    /**
     * Preorder DFS serialization helper.
     *
     * <p>Appends "{@code root.val,}" for non-null nodes, "{@code $,}" for null nodes.
     * Recurses on left then right child to preserve preorder structure.</p>
     *
     * @param root current node
     * @param sb   StringBuilder to build the serialized string
     */
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$,"); // Null marker
            return;
        }
        sb.append(root.val).append(","); // Node value + delimiter

        // Recurse on children
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    /**
     * Deserializes the encoded string back into the original binary tree.
     *
     * <p>Splits by ',', uses a global index to read tokens in preorder. Builds tree recursively:
     * if token is '$' or empty, return null; else create node and recurse for left/right.</p>
     *
     * @param data the serialized string
     * @return the root of the reconstructed binary tree
     */
    public TreeNode deserialize(String data) {
        index = 0;
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }

    // Global index for preorder traversal during deserialization
    private int index;

    /**
     * Recursive helper to build tree from preorder token array.
     *
     * <p>Reads next token at {@code index}:
     * <ul>
     *   <li>If '$' or empty: increment index, return null</li>
     *   <li>Else: create node with parsed value, increment index, recurse for left/right children</li>
     * </ul>
     * </p>
     *
     * @param nodes array of string tokens from preorder serialization
     * @return the constructed TreeNode (null if marker)
     */
    private TreeNode buildTree(String[] nodes) {
        // Handle null marker (includes trailing empty string from final ',')
        if (nodes[index].equals("$") || nodes[index].isEmpty()) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        index++;

        // Recursively build left and right subtrees (preorder: root, left, right)
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}