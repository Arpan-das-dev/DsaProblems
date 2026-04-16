package Graphs.ShortestPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * this class represents the Dijkstra algorithm
 * <p> {@code  Objective:} To find min Distance from A node to B node</p>
 * <p> This is a generic algorithm not a part of {@code NeetCode 150/250 Sheet}</p>
 */
public class Dijkstra {
    private static class Pair{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] dijkstra(int V, List<List<Pair>> adj, int src) {
        int [] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pairPriorityQueue.offer(new Pair(src,0));

        while (!pairPriorityQueue.isEmpty()) {
            Pair curr = pairPriorityQueue.poll();
            int u = curr.node;

            for (Pair neigh : adj.get(u)){
                int v = neigh.node;
                int weight = neigh.distance;

                if(dist[u]+weight < dist[v]){
                    dist[v] = dist[u]+ weight;
                    pairPriorityQueue.offer(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
}
