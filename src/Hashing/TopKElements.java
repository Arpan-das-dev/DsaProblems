package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Utility class for finding the k most frequent elements in an array.
 *
 * <p>Given an array of integers and an integer k, return the k most frequent elements.
 * The order of the returned elements does not matter.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>First, count the frequency of each element using a HashMap.</li>
 *   <li>Then, use a min-heap (priority queue) of size at most k to keep track of the k most frequent entries.</li>
 *   <li>For each frequency entry, add it to the heap; if the heap size exceeds k, remove the smallest (least frequent) element.</li>
 *   <li>Finally, extract all elements from the heap into an array and return it.</li>
 * </ul>
 *
 * <p>This approach efficiently maintains only the top k frequent elements without sorting the entire frequency map.</p>
 *
 * <p><b>Time Complexity:</b> O(n + m log k), where n is the length of nums and m is the number of unique elements.<br>
 * <b>Space Complexity:</b> O(m + k), for the frequency map and the priority queue.</p>
 *
 * @author Arpan Das
 * @since 13/01/2026
 */
public class TopKElements {

    /**
     * Returns the k most frequent elements in the given array.
     *
     * <p>Uses a frequency map to count occurrences, then a min-heap of size k
     * to keep only the top k frequent elements. The result is returned in any order.</p>
     *
     * @param nums the input array of integers
     * @param k    the number of top frequent elements to return
     * @return an array of length k containing the k most frequent elements, or empty array if invalid input
     */

    public int[] topKFrequent(int[] nums, int k) {
        // handle edge cases
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // first initialize a map which will store freq for each int value
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            // this means if that number is already present then just increment the value by 1
            // if not present then just put the default value;
           freqMap.put(num,freqMap.getOrDefault(num, 0) + 1) ;
        }
        // choose priority queue because we know it can store data into certain order (we can also customize it)
        // simply storing from min value (frequency) in bottom and max (frequency) on the top
        PriorityQueue<Map.Entry<Integer,Integer>> minToMax = new PriorityQueue<>
                ( (a,b) -> Integer.compare( a.getValue() , b.getValue()) );

        // now enter the map with Map.entry and run a loop to put the value in the queue
        for (Map.Entry<Integer,Integer> freq : freqMap.entrySet()) {
            minToMax.offer(freq); // offering the value into the queue
            if(minToMax.size() > k) {
                minToMax.poll(); // now as we need only top k elements then no need to store more items that k.
            }
        }
        int [] tops = new int[k];// simply return an array of length k
        int index = k; // length should b
        while (!minToMax.isEmpty()){
            tops[--index] = minToMax.poll().getKey(); // filling the array from the end
        }
        return tops;
    }
}
