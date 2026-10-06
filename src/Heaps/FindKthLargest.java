package Heaps;

import java.util.PriorityQueue;

/**
 * Utility class to find the kth largest element in an unsorted array.
 *
 * <p>Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in sorted order, not the kth distinct element.
 * The array is not modified and the solution must work for any valid k in the range [1, nums.length].</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (min-heap of size k):</b></p>
 * <ul>
 *   <li>Use a min-heap (priority queue) to maintain the k largest elements seen so far.</li>
 *   <li>Iterate through each number in the array:
 *     <ul>
 *       <li>Add the current number to the min-heap.</li>
 *       <li>If the heap size exceeds k, remove the smallest element (the root of the min-heap).</li>
 *     </ul>
 *   </li>
 *   <li>After processing all elements, the heap contains exactly the k largest elements,
 *       and the root (minimum) of the heap is the kth largest overall.</li>
 *   <li>Return the root of the heap.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log k) where n = nums.length; each insertion/removal from the heap
 *   takes O(log k) and we do this n times.<br>
 * <b>Space Complexity:</b> O(k) for storing at most k elements in the heap.</p>
 *
 * @author Arpan Das
 * @since 06/10/2026
 */
public class FindKthLargest {

    /**
     * Returns the kth largest element in the given array.
     *
     * <p>The kth largest element is defined as the element that would appear at index
     * {@code nums.length - k} if the array were sorted in ascending order.
     * This method uses a min-heap of fixed size k to efficiently track the k largest elements.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Explanation:
     *   Sorted: [1,2,3,4,5,6]; 2nd largest is 5.
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     * Explanation:
     *   Sorted: [1,2,2,3,3,4,5,5,6]; 4th largest is 4.
     * </pre>
     *
     * @param nums input array of integers; must not be null or empty
     * @param k the rank of the largest element to find (1 ≤ k ≤ nums.length)
     * @return the kth largest element in the array
     */
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // The root of the heap is the kth largest element
        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }
}
