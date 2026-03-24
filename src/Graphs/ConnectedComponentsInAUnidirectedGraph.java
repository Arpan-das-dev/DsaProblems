package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsInAUnidirectedGraph {
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean [] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> connected = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if(!visited[i]){
               ArrayList<Integer> component = new ArrayList<>();
               dfs(graph,component,i,visited);
               connected.add(component);
            }
        }
        return connected;
    }

    private void dfs(List<List<Integer>> graph, ArrayList<Integer> component, int node, boolean[] visited)
    {
        visited[node] = true;
        component.add(node);

        for (int neighbour : graph.get(node)) {
            if(!visited[neighbour]) dfs(graph,component,neighbour,visited);
        }
    }
}
