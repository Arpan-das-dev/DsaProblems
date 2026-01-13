package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

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
