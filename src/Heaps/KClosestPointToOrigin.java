package Heaps;

import java.util.PriorityQueue;

/**
 * Utility class to find the k closest points to the origin in a 2D plane.
 *
 * <p>Given an array of points on the X‑Y plane, find the k points that are closest to
 * the origin (0, 0). The distance is computed using the squared Euclidean distance to avoid
 * taking square roots. Points with equal distance can be returned in any order.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 150}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a max‑heap (max‑priority queue) that stores pairs of [index, squared distance]
 *       for points. The heap is ordered by distance in descending order.</li>
 *   <li>For each point, compute its squared distance from the origin and add it to the heap.</li>
 *   <li>If the heap size exceeds k, remove the point with the largest distance so only the k
 *       smallest distances remain.</li>
 *   <li>Once all points have been processed, extract the k elements from the heap and retrieve
 *       the corresponding points from the original array.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log k) where n = points.length; each point is pushed‑popped
 *   at most once from a heap of size k.<br>
 * <b>Space Complexity:</b> O(k) for the priority queue plus O(k) for the result array.</p>
 *
 * @author Arpan Das
 * @since 04/04/2026
 */
public class KClosestPointToOrigin {

    /**
     * Returns the k closest points to the origin (0, 0).
     *
     * <p>A point (x, y) is considered closer to the origin if its squared distance
     * \(x^2 + y^2\) is smaller. If multiple points have the same distance, any valid subset
     * of k points can be returned.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: points = [[1,3],[-2,2]], k = 1
     * Output: [[-2,2]]
     * Explanation:
     *   Distance of [1,3] from origin: 1^2 + 3^2 = 10
     *   Distance of [-2,2]: 4 + 4 = 8 (smaller), so it is the closest.
     *
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
     * Output: [[3,3],[-2,4]] (or equivalent subset)
     * Explanation:
     *   Distances: 18, 26, 20 → the two smallest are 18 and 20.
     * </pre>
     *
     * @param points an array of 2D points where points[i] = [x, y]
     * @param k number of closest points to return
     * @return a k×2 array containing the k closest points to the origin
     */
    public int[][] kClosest(int[][] points, int k) {
        // Max‑heap: keep at most k smallest distances
        PriorityQueue<int[]> distanceQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // For each point, store its index and squared distance from origin
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;

            distanceQueue.offer(new int[]{i, distance});

            // Maintain heap size at k
            if (distanceQueue.size() > k) {
                distanceQueue.poll();
            }
        }

        // Build result array from remaining k points
        int[][] result = new int[k][2];
        int index = 0;
        while (!distanceQueue.isEmpty()) {
            int[] curr = distanceQueue.poll();
            result[index++] = points[curr[0]];
        }
        return result;
    }
}
