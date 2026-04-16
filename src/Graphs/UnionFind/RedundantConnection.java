package Graphs.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find redundant edge creating cycle in undirected graph (NeetCode 250).
 *
 * <p>LeetCode 684: Given {@code edges} forming tree + 1 redundant edge (n vertices, n edges),
 * return edge creating cycle. Vertices numbered 1→n.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>DFS Path Check:</b> O(n²) - check cycle before adding edge</li>
 *   <li><b>Union-Find (DSU):</b> O(n α(n)) - track connected components</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n α(n)) optimal, <b>Space Complexity:</b> O(n).</p>
 *
 * @author Arpan Das
 * @since 21/03/2026
 */

public class RedundantConnection {

    /**
     * DFS version: check existing path before adding edge.
     *
     * <p>Builds graph incrementally, returns first edge creating cycle.</p>
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize adjacency lists (1-indexed)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Cycle exists → this edge is redundant
            if (hasPath(graph, u, v)) {
                return edge;
            }

            // Add edge to graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

    /**
     * DFS path existence check (with visited array).
     */
    private boolean hasPath(List<List<Integer>> graph, int src, int destination) {
        boolean[] visited = new boolean[graph.size()];
        return dfsPath(graph, visited, src, destination);
    }

    private boolean dfsPath(List<List<Integer>> graph, boolean[] visited, int curr, int destination) {
        if (curr == destination) return true;
        visited[curr] = true;

        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                if (dfsPath(graph, visited, next, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Optimal Union-Find version with path compression + union by rank.
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: edges = [[1,2],[1,3],[2,3]]
     * 1-2, 1-3 added, 2-3 creates cycle → Output: [2,3] ✓
     *
     * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
     * 1-4 creates cycle (1↔2↔3↔4) → Output: [1,4]
     * </pre>
     *
     * @param edges n edges forming tree + 1 cycle
     * @return redundant edge [u,v]
     */
    public int[] findRedundantConnectionDSU(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // Initialize DSU (1-indexed)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // Same component → cycle detected
            if (rootU == rootV) {
                return edge;
            }
            union(parent, rank, rootU, rootV);
        }
        return new int[0];
    }

    /** Path compression in find. */
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    /** Union by rank. */
    private void union(int[] parent, int[] rank, int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}

