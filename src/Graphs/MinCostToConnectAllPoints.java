package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Utility class to find minimum cost to connect all points
 *
 * <p>LeetCode 1584: Given {@code points} in 2D plane, return minimum cost (Manhattan distance) to
 * connect all points as MST. Distance = |x1-x2| + |y1-y2|.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Prim's (PriorityQueue):</b> O(n² log n) greedy MST</li>
 *   <li><b>Prim's (Dense):</b> O(n²) optimized for complete graph</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n²), <b>Space Complexity:</b> O(n).</p>
 *
 * @author Arpan Das
 * @since 20/03/2026
 */

public class MinCostToConnectAllPoints {

    /**
     * Prim's Algorithm with min-heap (optimized for sparse graphs).
     *
     * <p>Grow MST: repeatedly add the cheapest edge connecting new point.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
     * MST edges: (0,0)-(2,2)=4, (2,2)-(5,2)=3, (0,0)-(7,0)=7, (2,2)-(3,10)=9
     * Total: 20 ✓
     * </pre>
     *
     * @param points n points [x,y]
     * @return minimum connection cost
     */
    public int minCostConnectPointsPrims(int[][] points) {
        int n = points.length;
        PriorityQueue<Point> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        boolean[] visited = new boolean[n];
        minHeap.offer(new Point(0, 0));  // Start from point 0

        int totalCost = 0;
        int pointsUsed = 0;

        while (pointsUsed < n && !minHeap.isEmpty()) {
            Point curr = minHeap.poll();

            if (visited[curr.index]) continue;  // Skip duplicates

            visited[curr.index] = true;
            totalCost += curr.distance;
            pointsUsed++;

            // Connect to all unvisited points
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int manhattan = manhattanDistance(points, curr.index, i);
                    minHeap.offer(new Point(i, manhattan));
                }
            }
        }
        return totalCost;
    }

    /**
     * Prim's Algorithm (dense graph optimized, O(n²)).
     *
     * <p>Directly scan for minimum unvisited distance each iteration.</p>
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];
        minDist[0] = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            // Find unvisited node with minimum distance
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            totalCost += minDist[u];

            // Update distances to unvisited neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = manhattanDistance(points, u, v);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }
        return totalCost;
    }

    /** Manhattan distance between two points. */
    private int manhattanDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) +
                Math.abs(points[i][1] - points[j][1]);
    }

    /** Point wrapper for priority queue. */
    static class Point {
        int index;
        int distance;

        Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}

