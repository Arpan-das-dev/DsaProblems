package Graphs;

import java.util.*;

/**
 * Utility class for shortest time to send signal to all nodes (NeetCode 150 sheet).
 *
 * <p>LeetCode 743: Graph with n nodes (1→n), times[i]=[u,v,w] = edge u→v weight w. From node k,
 * return max shortest path time to any node (-1 if unreachable).</p>
 *
 * <p><b>Approach:</b> Dijkstra's Algorithm (Priority Queue)</p>
 * <ul>
 *   <li>Min-heap: {node, distance}</li>
 *   <li>Relax neighbors if shorter path found</li>
 *   <li>Max of min distances = answer</li>
 * </ul>
 *
 * <p>{@code @code Time: O(E log V), Space: O(V+E)}<p>
 *
 * @author Arpan Das
 * @since 24/03/2026
 * <p><b>Part of NeetCode 150 study plan</b></p>
 */

public class NetworkDelay {

    /**
     * Returns max shortest path time from k to all nodes.
     *
     * <p>Dijkstra computes min distance to each node, max unreachable = -1.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: times=[[2,1,1],[2,3,1],[3,4,1]], n=4, k=2
     * Paths: 2→1(1), 2→3(1), 3→4(2) → Max: 2 ✓
     *
     * Input: times=[[1,2,1]], n=2, k=2
     * Node 1 unreachable → Output: -1
     * </pre>
     *
     * @param times directed edges [u,v,w]
     * @param n nodes (1-indexed)
     * @param k source node
     * @return max min-distance or -1
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list: node → List<{neighbor, weight}>
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>())
                    .add(new int[]{edge[1], edge[2]});
        }

        // Min-heap Dijkstra: {node, distance}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        minHeap.offer(new int[]{k, 0});

        // Distance array (1-indexed)
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];

            // Pruning: already found shorter path
            if (dist > distances[node]) {
                continue;
            }

            // Relax neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    int newDist = dist + weight;

                    if (newDist < distances[nextNode]) {
                        distances[nextNode] = newDist;
                        minHeap.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }

        // Find max distance, check reachability
        int maxTime = Arrays.stream(distances, 1, n + 1).max().getAsInt();
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
