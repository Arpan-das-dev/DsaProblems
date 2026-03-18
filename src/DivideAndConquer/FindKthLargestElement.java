package DivideAndConquer;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Utility class to find kth  largest element in unsorted array.
 *
 * <p>Given {@code nums} and {@code k}, return kth largest element (1-indexed). Modifies input array.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>QuickSelect:</b> Average O(n), worst O(n²) - partition around pivot</li>
 *   <li><b>Min-Heap:</b> O(n log k) - maintain k largest elements</li>
 * </ul>
 *
 * <p>QuickSelect targets index {@code n-k} (kth largest position).</p>
 *
 * @author Arpan Das
 * @since 18/03/2026
 */

public class FindKthLargestElement {

    /**
     * QuickSelect: finds kth largest via randomized partitioning.
     *
     * <p>Recursively partition until pivot lands at target position n-k.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums=[3,2,1,5,6,4], k=2 → 5 (2nd largest) ✓
     * Target index: 6-2=4 → partition until pivot at index 4
     *
     * Input: nums=[3,2,3,1,2,4,5,5,6], k=4 → 4 ✓
     * </pre>
     *
     * @param nums unsorted array
     * @param k kth largest (1-indexed)
     * @return kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();

        while (true) {
            // Random pivot for average O(n)
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int finalPivotIndex = partition(nums, left, right, pivotIndex);

            // Found target position (kth largest = index n-k)
            if (finalPivotIndex == nums.length - k) {
                return nums[finalPivotIndex];
            } else if (finalPivotIndex > nums.length - k) {
                right = finalPivotIndex - 1;
            } else {
                left = finalPivotIndex + 1;
            }
        }
    }

    /**
     *  partition: arranges < pivot | pivot | >= pivot.
     */
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);  // Move pivot to end

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    /**
     * Swaps two elements in array.
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Min-heap alternative: maintains k largest elements.
     *
     * <p>Heap size ≤ k, poll smallest when exceeds.</p>
     */
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove smallest
            }
        }
        return minHeap.isEmpty() ? -1 : minHeap.peek();
    }
}
