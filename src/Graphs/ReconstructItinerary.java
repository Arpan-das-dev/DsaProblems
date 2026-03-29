package Graphs;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();

        tickets.forEach(item -> graph
                .computeIfAbsent(item.getFirst(), k -> new PriorityQueue<>())
                .offer(item.get(1)));

        List<String> result = new ArrayList<>();
        dfs("JFK",graph,result);
        return result;
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> qu = graph.get(src);

        while (qu != null && !qu.isEmpty()){
            String next = qu.poll();
            dfs(next,graph,result);
        }
        result.addFirst(src);
    }
}
