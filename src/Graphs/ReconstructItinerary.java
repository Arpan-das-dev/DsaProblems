package Graphs;

import java.util.*;

/**
 * Utility class to reconstruct the itinerary for an itinerary given a list of airline tickets.
 *
 * <p>Given an array of tickets where each ticket is a pair [from, to], reconstruct the itinerary
 * that starts from "JFK" and uses all tickets exactly once. The itinerary is the lexicographically
 * smallest valid route when multiple itineraries are possible.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 150}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Model the tickets as a directed graph where each node is an airport and edges are flights.
 *       Use a map from airport to a min‑heap (PriorityQueue) of destinations to ensure lexicographic order.</li>
 *   <li>For each ticket [from, to], add to from → to in the graph’s adjacency list.</li>
 *   <li>Perform a depth‑first traversal starting from "JFK".
 *       Instead of immediately prepending each node to the result, process all outgoing edges, then
 *       add the node at the end and reverse the order with a linked list that supports insertion at front.</li>
 *   <li>The final result is a list representing the reconstructed itinerary.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(E log E) where E is the number of tickets (edges). Each edge is inserted
 *   into a priority queue, and each edge is popped once during DFS.<br>
 * <b>Space Complexity:</b> O(E + V) for the graph and the recursion stack.</p>
 *
 * @author Arpan Das
 * @since 29/03/2026
 */
public class ReconstructItinerary {

    /**
     * Reconstructs the lexicographically smallest valid itinerary starting from "JFK".
     *
     * <p>The itinerary must use all given tickets exactly once, and it must start from "JFK".
     * If multiple valid itineraries exist, this method returns the one that is lexicographically smallest.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * Output: ["JFK","MUC","LHR","SFO","SJC"]
     *
     * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * Explanation: Another valid itinerary exists ["JFK","SFO","ATL","JFK","ATL","SFO"], but the returned
     *              one is lexicographically smaller at the first diverging position.
     * </pre>
     *
     * @param tickets list of tickets where each ticket is [from, to]
     * @return the reconstructed itinerary as a list of airport names
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        tickets.forEach(item -> graph
                .computeIfAbsent(item.getFirst(), k -> new PriorityQueue<>())
                .offer(item.get(1)));

        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        return result;
    }

    /**
     * Recursive helper that traverses the graph in lexicographic order.
     *
     * <p>Starting from src, exhaust all outgoing edges from the priority queue,
     * then add src to the front of the result list.
     * This ensures the deepest nodes are appended last, producing a correct Eulerian‑like path.</p>
     *
     * @param src current airport node
     * @param graph adjacency map from airport to priority queue of destinations
     * @param result list that will hold the reconstructed itinerary
     */
    private void dfs(String src, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> qu = graph.get(src);

        while (qu != null && !qu.isEmpty()) {
            String next = qu.poll();
            dfs(next, graph, result);
        }
        result.addFirst(src);
    }
}
