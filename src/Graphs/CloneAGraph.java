package Graphs;

import java.util.HashMap;
import java.util.Map;
/**
 * Utility class for cloning an undirected graph represented as an adjacency list.
 *
 * <p>Given a reference of a node in a connected undirected graph, return a deep copy
 * (clone) of the graph. Each node in the graph contains a value and a list of its neighbors.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use DFS (depth-first search) with a visited map to avoid cycles and redundant cloning.</li>
 *   <li>For each node:
 *     <ul>
 *       <li>If it’s null, return null.</li>
 *       <li>If already cloned, return the existing clone from the map.</li>
 *       <li>Otherwise, create a new node with the same value and store it in the map.</li>
 *       <li>Recursively clone all neighbors and add them to the clone’s neighbor list.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This ensures that each node is cloned exactly once and the entire graph structure
 * (including cycles) is preserved in the clone.</p>
 *
 * <p><b>Time Complexity:</b> O(N + M), where N is the number of nodes and M is the number of edges.<br>
 * <b>Space Complexity:</b> O(N) for the visited map and recursion stack.</p>
 *
 * @author Arpan Das
 * @since 16/01/2026
 */
public class CloneAGraph {

    private final Map<Node, Node> visited = new HashMap<>();

    /**
     * Returns a deep copy (clone) of the given undirected graph.
     *
     * <p>Uses DFS and a visited map to ensure each node is cloned only once and
     * the entire graph structure (including cycles) is correctly replicated.</p>
     *
     * @param node a reference to a node in the original graph (maybe null)
     * @return a deep copy of the graph; returns null if the input node is null
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If this node is already cloned, return the existing clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node with the same value
        Node clone = new Node(node.val);
        // Record that this original node maps to this clone
        visited.put(node, clone);

        // Recursively clone all neighbors and add them to the clone's neighbor list
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}

