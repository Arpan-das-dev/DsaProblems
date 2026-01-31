package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Utility class to determine if all courses can be completed given their prerequisites.
 *
 * <p>Given numCourses and a list of prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first to take course ai, return true if it's possible to finish
 * all courses, false if there exists a cycle preventing completion.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Topological Sort using Kahn's Algorithm (BFS):</b></li>
 *   <li>Build adjacency list (graph) where graph[i] contains courses that depend on i.</li>
 *   <li>Compute inDegree array: number of prerequisites each course has.</li>
 *   <li>Add all courses with 0 prerequisites to a queue (can be taken immediately).</li>
 *   <li>Process queue: for each course, reduce inDegree of dependent courses; add to queue when inDegree becomes 0.</li>
 *   <li>If all courses are processed (count == numCourses), no cycle exists; otherwise, cycle detected.</li>
 * </ul>
 *
 * <p>A cycle means some courses have circular dependencies, making completion impossible.</p>
 *
 * <p><b>Time Complexity:</b> O(V + E), where V = numCourses, E = prerequisites.length.<br>
 * <b>Space Complexity:</b> O(V + E) for graph and queue.</p>
 *
 * @author Arpan Das
 * @since 31/01/2026
 */
public class CourseSchedule {

    /**
     * Determines if all courses can be completed without encountering a cycle.
     *
     * <p>Uses topological sort via Kahn's algorithm. If all courses can be processed through
     * the queue (count == numCourses), there is no cycle and all courses can be finished.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: Must take course 0 first, then course 1. No cycle.
     *
     * Input:  numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: Course 0 requires 1, course 1 requires 0 → cycle detected.
     *
     * Input:  numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: true
     * Explanation: Valid order: 0→1→3, 0→2→3. All courses can be completed.
     * </pre>
     *
     * @param numCourses     total number of courses (0 to numCourses-1)
     * @param prerequisites  array where [ai,bi] means must take bi before ai
     * @return true if all courses can be completed (no cycle), false otherwise
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list (graph)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // Each course starts with empty dependency list
        }

        // Step 2: Compute inDegree (number of prerequisites per course)
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // pre[1] → pre[0]: course pre[0] depends on course pre[1]
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++; // Increment prerequisite count for course pre[0]
        }

        // Step 3: Initialize queue with courses having 0 prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // These courses can be taken immediately
            }
        }

        // Step 4: Process topological sort
        int count = 0; // Number of courses that can be completed
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // Take a course with 0 prerequisites
            count++; // Successfully completed this course

            // Reduce prerequisite count for all dependent courses
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next); // This course now has 0 prerequisites
                }
            }
        }

        // If count == numCourses, all courses completed → no cycle
        return count == numCourses;
    }
}

