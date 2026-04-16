package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Utility class for course schedule topological sort (NeetCode 150 sheet).
 *
 * <p>LeetCode 210: Given {@code numCourses} and {@code prerequisites} where prerequisites[i]=[ai,bi]
 * means must take bi before ai. Return valid order or empty if cycled.</p>
 *
 * <p><b>Approach:</b> Kahn's Algorithm (BFS Topological Sort)</p>
 * <ul>
 *   <li>Build graph + indegree array</li>
 *   <li>Queue: all 0-indegree (no prereqs)</li>
 *   <li>Process → reduce neighbors' indegree → enqueue if 0</li>
 * </ul>
 *
 * <p>{@code @code Time: O(V+E), Space: O(V+E)}<p>
 *
 * @author Arpan Das
 * @since 23/03/2026
 * <p><b>Part of {@code NeetCode 150}</b></p>
 */

public class CourseSchedule2 {

    /**
     * Returns valid course completion order or empty array if impossible.
     *
     * <p>Detects cycles: if processed < numCourses → cycle exists.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: numCourses=4, prerequisites=[[1,0],[2,0],[3,1],[3,2]]
     * Indegree: [0,1,1,2] → Order: [0,1,2,3] or [0,2,1,3] ✓
     *
     * Input: numCourses=2, prerequisites=[[1,0],[0,1]]
     * Cycle → Output: []
     * </pre>
     *
     * @param numCourses total courses (0→numCourses-1)
     * @param prerequisites course dependencies
     * @return valid order array
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        // Initialize adjacency lists
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build graph + indegree
        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];    // Must complete this
            int prereqCourse = prereq[1];  // Before this

            indegree[course]++;
            adjList.get(prereqCourse).add(course);
        }

        // Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        int processed = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;
            processed++;

            // Unlock dependent courses
            for (int next : adjList.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle if not all courses processed
        return processed == numCourses ? result : new int[0];
    }
}
