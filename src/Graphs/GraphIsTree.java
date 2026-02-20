package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to validate if given graph with n nodes and m edges forms a tree.
 *
 * <p>A tree is an undirected graph that is <b>connected</b> (single component) and <b>acyclic</b>
 * (no cycles). Equivalently: exactly n-1 edges AND connected.</p>
 *
 * <p><b>Validation Approach:</b></p>
 * <ul>
 *   <li>Check |E| == |V|-1 (necessary condition)</li>
 *   <li>Build undirected adjacency list</li>
 *   <li>DFS from node 0 to mark all reachable nodes</li>
 *   <li>Verify all nodes visited (connected)</li>
 * </ul>
 * <p><b>Note:</b> No explicit cycle detection needed (edge count + connectivity guarantees acyclic).</p>
 *
 * <p><b>Time Complexity:</b> O(V+E).<br>
 * <b>Space Complexity:</b> O(V+E) for adjacency list + O(V) visited.</p>
 *
 * @author Arpan Das
 * @since 20/02/2026
 */

public class GraphIsTree {

    /**
     * Returns true if graph forms a valid tree.
     *
     * <p>Checks edge count constraint + connectivity via DFS traversal.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n=5, m=4, edges=[[0,1],[0,2],[0,3],[1,4]]
     * Output: true
     * Explanation: 5 nodes, 4 edges ✓, connected ✓ → tree (star topology)
     *
     * Input: n=5, m=5, edges=[[0,1],[1,2],[2,3],[3,4],[4,0]]
     * Output: false
     * Explanation: 5 edges > 4 ✓ → cycle exists
     *
     * Input: n=4, m=2, edges=[[0,1],[2,3]]
     * Output: false
     * Explanation: 2 edges < 3 ✓ → disconnected (2 components)
     *
     * Input: n=1, m=0, edges=[]
     * Output: true
     * Explanation: Single node is valid tree
     * </pre>
     *
     * @param n     number of nodes (0 to n-1)
     * @param m     number of edges
     * @param edges list of [u,v] undirected edges
     * @return true if forms tree
     */
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // Tree must have exactly n-1 edges
        if (m != n - 1) return false;

        // Build undirected adjacency list
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);  // Undirected
        }

        // DFS from node 0 to mark reachable nodes
        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);

        // All nodes must be reachable (connected)
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    /**
     * DFS traversal: marks current node and all reachable neighbors.
     */
    private void dfs(ArrayList<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
}

