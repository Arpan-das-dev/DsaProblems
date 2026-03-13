package Graphs;

import java.util.*;

/**
 * Utility class to find the shortest transformation sequence from beginWord to endWord.
 *
 * <p>Given {@code beginWord}, {@code endWord}, {@code wordList}, return minimum steps to transform
 * beginWord → endWord (one letter change/step). Each intermediate must be in wordList. Return 0 if
 * impossible.</p>
 *
 * <p><b>Approach:</b> BFS + One-Letter Mutations</p>
 * <ul>
 *   <li>BFS guarantees shortest path (unweighted graph)</li>
 *   <li>Each position: try all 26 letters → generate neighbors</li>
 *   <li>HashSet dictionary + visited prevents duplicates</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(M×N×26), M=wordList size, N=word length.<br>
 * <b>Space Complexity:</b> O(M).</p>
 *
 * @author Arpan Das
 * @since 13/03/2026
 */

public class WordLadder {

    /**
     * Returns minimum steps to transform beginWord to endWord.
     *
     * <p>BFS explores level-by-level, each level = one letter change.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: begin="hit", end="cog", wordList=["hot","dot","dog","lot","log","cog"]
     * Path: hit→hot→dot→dog→cog (4 steps) ✓
     * Output: 5 (includes beginWord)
     *
     * Input: begin="hit", end="cog", wordList=["hot","dot","dog","lot","log"]
     * No path → Output: 0
     * </pre>
     *
     * @param beginWord starting word
     * @param endWord target word
     * @param wordList dictionary of valid words
     * @return min steps or 0 if impossible
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Quick fail: endWord must exist in dictionary
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process current level
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                // Found target
                if (current.equals(endWord)) {
                    return steps;
                }

                // Generate all one-letter mutations
                for (int pos = 0; pos < current.length(); pos++) {
                    char[] chars = current.toCharArray();

                    // Try all letters at this position
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[pos] = ch;
                        String candidate = new String(chars);

                        // Valid unvisited word → enqueue
                        if (dictionary.contains(candidate) && !visited.contains(candidate)) {
                            queue.offer(candidate);
                            visited.add(candidate);
                        }
                    }
                }
            }
            steps++;
        }

        return 0; // No path found
    }
}
