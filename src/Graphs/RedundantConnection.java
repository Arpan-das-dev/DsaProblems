package Graphs;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int edge = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= edge; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] arr : edges){
            int u = arr[0];
            int v = arr[1];

            boolean [] visited = new boolean[edge+1];
            if(hasPath(graph,visited,u,v)){
                return arr;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasPath(List<List<Integer>> graph, boolean[] visited, int src, int dist) {
        if(src == dist) return true;
        visited[src] = true;

        for (int next : graph.get(src)){
            if(!visited[next]){
                if(hasPath(graph,visited,next,dist)) return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnectionDSU(int[][] edges) {
        int n = edges.length;

        int [] parent = new int[n+1];
        int [] rank = new int[n+1];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int pu = findParent(parent,u);
            int pv = findParent(parent,v);

            if(pu == pv) return edge;
            union(parent,rank,pu,pv);
        }
        return new int[0];
    }

     private void union (int[] parent, int[] rank, int x,int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        }else {
            parent[y] = x;
            rank[x]++;
        }
    }
    private int findParent(int[] parent, int x) {
        if(parent[x] != x){
           parent[x] = findParent(parent,parent[x]);
        }
        return parent[x];
    }
}
