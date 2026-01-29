package Heaps;

import java.util.PriorityQueue;

/**
 * Utility class to design a data structure that supports adding numbers and finding median in O(log n) time.
 *
 * <p>Implement the MedianFinder class with two operations:
 * <ul>
 *   <li>{@code addNum(num)}: adds the integer num to the data structure</li>
 *   <li>{@code findMedian()}: returns the median of all elements so far</li>
 * </ul>
 * </p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use two heaps to maintain the median efficiently:
 *     <ul>
 *       <li>{@code maxHeap}: stores the smaller half (largest element at top)</li>
 *       <li>{@code minHeap}: stores the larger half (smallest element at top)</li>
 *     </ul>
 *   </li>
 *   <li>Maintain heap sizes such that {@code maxHeap.size() ≤ minHeap.size() + 1}</li>
 *   <li>Add numbers by placing them in the appropriate heap, then rebalance if needed</li>
 *   <li>Median is either {@code maxHeap.peek()} (odd count) or average of both heap tops (even count)</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n) for addNum, O(1) for findMedian.<br>
 * <b>Space Complexity:</b> O(n) for storing all numbers.</p>
 *
 * @author Arpan Das
 * @since 29/01/2026
 */
public class MedianFinder {

    private final PriorityQueue<Integer> maxHeap;  // Smaller half (max heap - largest on top)
    private final PriorityQueue<Integer> minHeap;  // Larger half (min heap - smallest on top)

    /**
     * Initializes the MedianFinder with two heaps:
     * maxHeap for smaller half (descending order), minHeap for larger half (ascending order).
     */
    public MedianFinder() {
        // maxHeap: largest element at top (reverse natural order)
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // minHeap: smallest element at top (natural order)
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    /**
     * Adds a number to the data structure while maintaining heap balance.
     *
     * <p><b>Algorithm:</b></p>
     * <ul>
     *   <li>If maxHeap is empty or num ≤ maxHeap.top(): add to maxHeap</li>
     *   <li>Else: add to minHeap</li>
     *   <li>Rebalance: maxHeap.size() ≤ minHeap.size() + 1</li>
     * </ul></p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * addNum(1): maxHeap=[1]
     * addNum(2): maxHeap=[2], minHeap=[1]
     * addNum(3): maxHeap=[3], minHeap=[1,2]
     * </pre>
     *
     * @param num the number to add
     */
    public void addNum(int num) {
        // Add to appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Rebalance heaps: maxHeap should not be more than 1 larger than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * Returns the median of all elements in the data structure.
     *
     * <p>Median rules:
     * <ul>
     *   <li>Odd count: return maxHeap.peek() (middle element)</li>
     *   <li>Even count: return average of maxHeap.peek() and minHeap.peek()</li>
     * </ul>
     * </p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * After addNum(1,2,3): maxHeap=[3], minHeap=[1,2]
     * findMedian() → 2.0 (average of 3 and 1)
     *
     * After addNum(4): maxHeap=[4], minHeap=[1,2,3]
     * findMedian() → 2.5 (average of 4 and 1)
     * </pre>
     *
     * @return the median (double) of all elements
     */
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements: average of both heap tops
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        // Odd number of elements: top of maxHeap (middle element)
        return maxHeap.peek();
    }
}
