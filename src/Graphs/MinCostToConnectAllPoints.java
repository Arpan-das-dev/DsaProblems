package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public int minCostConnectPointsPrims(int[][] points) {
        int n = points.length;
        PriorityQueue<point> pointPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        boolean[] primMST = new boolean[n]; // check whether the index is visited or not
        pointPriorityQueue.offer(new point(0, 0));

        int minCost = 0;
        int pointsConnected = 0; // validation of MST edges < vertices

        while (pointsConnected < n && !pointPriorityQueue.isEmpty()) {
            point curr = pointPriorityQueue.poll();
            if (primMST[curr.index]) continue; // skip visited points

            primMST[curr.index] = true;
            minCost += curr.distance;
            pointsConnected++;

            for (int i = 0; i < n; i++) {
                if (!primMST[i]) {
                    int x = Math.abs(points[curr.index][0] - points[i][0]);
                    int y = Math.abs(points[curr.index][1] - points[i][1]);

                    pointPriorityQueue.offer(new point(i, x + y));
                }
            }
        }
        return minCost;
    }

    static class point {
        int index;
        int distance;

        point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];

        minDist[0] = 0;
        int cost = 0;

        for (int i = 0; i < n; i++) {

            int u = -1;

            // pick minimum unvisited node
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            cost += minDist[u];

            // update distances
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                            Math.abs(points[u][1] - points[v][1]);

                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }

        return cost;
    }
}
