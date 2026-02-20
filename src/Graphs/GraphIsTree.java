package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphIsTree {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if(m != n-1) return false;

        ArrayList<List<Integer>> adjcent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjcent.add(new ArrayList<>());
        }

         edges.forEach(item-> {
             int u = item.get(0);
             int v = item.get(1);
             adjcent.get(u).add(v);
             adjcent.get(v).add(u);
         });

        boolean [] visited = new boolean[n];
        dfs(adjcent,visited,0);

        for (boolean visit : visited){
            if(!visit) return false;
        }
        return true;
    }

    private void dfs(ArrayList<List<Integer>> adjcent, boolean[] visited, int index) {
        visited[index] = true;

        for(Integer neighbour : adjcent.get(index)){
            if(!visited[neighbour]) dfs(adjcent,visited,neighbour);
        }
    }
}
