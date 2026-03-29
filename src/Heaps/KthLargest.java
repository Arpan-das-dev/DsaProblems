package Heaps;

import java.util.PriorityQueue;

/**
 * Utility class to design a data structure that supports inserting numbers and finding the kth largest number.
 *
 * <p>Implement KthLargest class that supports two operations:
 * <ul>
 *   <li><code>KthLargest(int k, int[] nums)</code> - initializes the data structure with k and initial numbers nums.</li>
 *   <li><code>add(int val)</code> - adds a new number val to the stream and returns the kth largest number.</li>
 * </ul>
 * The kth largest element is found by maintaining a min-heap of size k containing the k largest elements seen so far.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a min-heap (PriorityQueue) of size k to track the k largest elements.</li>
 *   <li>When adding a new element:
 *     <ul>
 *       <li>Add the element to the heap.</li>
 *       <li>If heap size exceeds k, remove the smallest element (heap root).</li>
 *       <li>The heap root is always the kth largest element.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log k) for n insertions where k is the heap size.<br>
 * <b>Space Complexity:</b> O(k) for the priority queue.</p>
 *
 * @author Arpan Das
 * @since 29/03/2026
 * <p>part of <b>{@code NeetCode 150}</b></p>
 */
public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> stream;

    /**
     * Initializes the KthLargest data structure.
     *
     * <p>Creates a min-heap of size k and adds all initial numbers from nums.
     * The heap maintains the k largest elements seen so far.</p>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
     * // Initializes heap with [2, 4, 5] (3 largest elements: 8, 5, 4 → min-heap root is 4)
     * </pre>
     *
     * @param k the number of largest elements to track
     * @param nums initial numbers to add to the stream
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.stream = new PriorityQueue<>();
        for (int val : nums) add(val);
    }

    /**
     * Adds a new number to the stream and returns the kth largest number.
     *
     * <p>The kth largest number is the smallest element in the min-heap of size k,
     * which contains the k largest elements seen so far.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * kthLargest.add(3);  // returns 4 (heap: [2, 3, 4])
     * kthLargest.add(5);  // returns 5 (heap: [3, 4, 5])
     * kthLargest.add(10); // returns 5 (heap: [4, 5, 10])
     * kthLargest.add(9);  // returns 5 (heap: [5, 9, 10])
     * kthLargest.add(4);  // returns 5 (heap: [5, 9, 10])
     * </pre>
     *
     * @param val the number to add to the stream
     * @return the kth largest element in the stream after adding val
     */
    public int add(int val) {
        stream.offer(val);

        if (stream.size() > k) {
            stream.poll();
        }
        return stream.isEmpty() ? 0 : stream.peek();
    }
}