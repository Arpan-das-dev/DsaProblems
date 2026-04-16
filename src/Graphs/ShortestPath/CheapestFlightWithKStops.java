package Graphs.ShortestPath;

import java.util.*;

public class CheapestFlightWithKStops {
    // [from,to,price]
    // Dijkstra
    private static class State {
        private int node;
        private int cost;
        private int stops;

        public State(int n, int c, int s){
            this.node = n;
            this.cost = c;
            this.stops = s;
        }
    }

    public int findCheapestPriceDijkstra(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for (int [] f : flights) {
            adj.computeIfAbsent(f[0],x-> new ArrayList<>())
                    .add(new int[] {f[1],f[2]});
        }

        PriorityQueue<State> states = new PriorityQueue<>(Comparator.comparingInt(i->i.cost));
        states.offer(new State(src,0,0));

        int [] bestStops = new int[n];
        Arrays.fill(bestStops,Integer.MAX_VALUE);

        while (!states.isEmpty()){
            State curr = states.poll();
            if(curr.node == dst) return curr.cost;

            if(curr.stops >k || curr.stops > bestStops[curr.node] || !adj.containsKey(curr.node)) continue;
            bestStops[curr.node] = curr.stops;

            for (int[] next : adj.get(curr.node)){
                states.offer(new State(next[0], curr.cost+ next[2],curr.stops+1));
            }
        }
        return -1;
    }

    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;

        // k stops = k+1 edges
        for (int i = 0; i <= k ; i++) {
            int[] next = dist.clone();

            for (int [] f: flights) {
                int u = f[0]; int v = f[1]; int c = f[2];
                if(dist[u] == Integer.MAX_VALUE) continue;
                next[v] = Math.min(next[v],dist[u]+c);
            }
            dist = next;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
