package Graphs.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find connected components in undirected graph (NeetCode 150 sheet).
 *
 * <p>Given V vertices (0→V-1) and undirected {@code edges}, return all connected components as lists
 * of vertices. Each unvisited component found via DFS.</p>
 *
 * <p><b>Approach:</b> DFS Traversal</p>
 * <ul>
 *   <li>Build adjacency list from edges</li>
 *   <li>For each unvisited node: DFS collects entire component</li>
 *   <li>Repeat until all nodes visited</li>
 * </ul>
 *
 * <p>{@code @code Time: O(V+E), Space: O(V+E)}<p>
 *
 * @author Arpan Das
 * @since 24/03/2026
 * <p><b>Part of {@code NeetCode 150}</b></p>
 */

public class ConnectedComponentsInAUnidirectedGraph {

    /**
     * Returns list of connected components.
     *
     * <p>Each component = list of vertices reachable from each other.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: v=5, edges=[[0,1],[0,2],[3,4]]
     * Components: [[0,1,2], [3,4]] ✓ (node 0 reaches 1,2)
     *
     * Input: v=3, edges=[]
     * Components: [[0], [1], [2]]
     * </pre>
     *
     * @param v vertices (0 to v-1)
     * @param edges undirected edges
     * @return list of components
     */
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        // Build adjacency list (undirected)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], vv = edge[1];
            graph.get(u).add(vv);
            graph.get(vv).add(u);
        }

        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        // Find all components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(graph, i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    /**
     * DFS collects all nodes in current component.
     */
    private void dfs(List<List<Integer>> graph, int node, boolean[] visited,
                     ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }
}
