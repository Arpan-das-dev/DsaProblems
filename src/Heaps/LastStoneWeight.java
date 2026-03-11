package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Utility class to simulate stone smashing until one or zero remain.
 *
 * <p>Given array {@code stones} of stone weights, repeatedly smash two heaviest stones:
 * <ul>
 *   <li>Equal weights → both destroyed</li>
 *   <li>Different → remain {@code |x-y|}</li>
 * </ul>
 * Return weight of last remaining stone (0 if none).</p>
 *
 * <p><b>Approach:</b> Max Heap (PriorityQueue)</p>
 * <ul>
 *   <li>Use max-heap (reverse comparator) for heaviest-first access</li>
 *   <li>While >1 stones: pop 2 heaviest, push |diff| if unequal</li>
 *   <li>Return remaining stone or 0</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n), n operations × log n heap.<br>
 * <b>Space Complexity:</b> O(n) heap.</p>
 *
 * @author Arpan Das
 * @since 11/03/2026
 */

public class LastStoneWeight {

    /**
     * Returns weight of last remaining stone after smashing.
     *
     * <p>Max-heap simulation of heaviest-first smashing process.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: stones =[1][2][3][4][5]
     * Smashes: 8+7→1, 4+2→2, 2+1→1, 1+1→0 → Output: 1 ✓
     *
     * Input: stones =[4]
     * Output: 1
     *
     * Input: stones =[1]
     * Smash: 2+2→destroyed → Output: 0 ✓
     *
     * Input: stones = []
     * Output: 0
     * </pre>
     *
     * @param stones initial stone weights
     * @return last stone weight or 0
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        // Max-heap: heaviest first (descending order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int weight : stones) {
            maxHeap.offer(weight);
        }

        // Simulate smashing until ≤1 stone remains
        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int second = maxHeap.poll();

            // Push remaining weight if different
            if (heaviest != second) {
                maxHeap.offer(heaviest - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    /**
     * Alternative using Collections.reverseOrder() (Java 21+ streams).
     */
    public int lastStoneWeightCollectionVersion(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.stream(stones).boxed().toList());

        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int second = maxHeap.poll();

            if (heaviest != second) {
                maxHeap.offer(heaviest - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}