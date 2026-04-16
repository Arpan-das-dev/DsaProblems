package Graphs.TopologicalSort;

import java.util.*;

/**
 * Utility class to determine alien language order from sorted word list.
 *
 * <p>Given array of words in alien language (sorted lexicographically), return string of unique
 * letters in order of precedence (first chars < second chars). If invalid (cycle/prefix violation),
 * return empty string.</p>
 *
 * <p><b>Approach:</b> Graph + Topological Sort (Kahn's Algorithm)</p>
 * <ul>
 *   <li>Build graph: compare adjacent words, first differing chars c1→c2 (c1 precedes c2)</li>
 *   <li>Handle prefix rule: "abc" > "ab" → invalid</li>
 *   <li>Compute indegrees, BFS from 0-indegree nodes</li>
 *   <li>If result != total unique chars → cycle exists</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(C) where C = total chars (each edge processed once).<br>
 * <b>Space Complexity:</b> O(C) for graph + indegree.</p>
 *
 * @author Arpan Das
 * @since 22/02/2026
 */

public class AlienDictionary {

    /**
     * Returns alien alphabet order or empty string if invalid.
     *
     * <p>Builds precedence graph from adjacent word pairs, performs topological sort.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: words = ["wrt","wrf","er","ett","rftt"]
     * Output: "wertf"
     * Comparisons: wrt-wrf→t→f, wrt-er→w→e, er-ett→r→t, ett-rftt→e→r
     *
     * Input: words = ["z","x"]
     * Output: "zx"
     * z > x → z→x ✓
     *
     * Input: words = ["z","x","z"]
     * Output: ""
     * Cycle detected in topological sort
     *
     * Input: words = ["ab","b"]
     * Output: "ab"
     *
     * Input: words = ["abc","ab"]
     * Output: "" (prefix violation: abc > ab invalid)
     * </pre>
     *
     * @param words sorted words in alien dictionary
     * @return valid order string or ""
     */
    public String findOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        // Build graph and indegree map
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new ArrayList<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Build edges from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // Prefix rule violation
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            // Find first differing characters
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }

        // Kahn's Algorithm: Topological sort
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Start with nodes having 0 indegree
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            result.append(ch);

            // Decrease indegree of neighbors
            for (char next : graph.getOrDefault(ch, new ArrayList<>())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle exists if not all nodes processed
        return result.length() != indegree.size() ? "" : result.toString();
    }
}
