package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to find all elements that appear more than n/3 times in an array.
 *
 * <p>Given an integer array nums, return a list of all elements that appear more than n/3 times
 * when n is the length of the array. There can be at most two such elements by the pigeon‑hole principle.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (brute‑force with hash map):</b></p>
 * <ul>
 *   <li>Count the frequency of each element using a HashMap.</li>
 *   <li>Iterate through the map and collect all elements whose frequency is greater than n/3.</li>
 * </ul>
 *
 * <p><b>Approach (Boyer‑Moore majority‑element variant):</b></p>
 * <ul>
 *   <li>Use two candidate variables and their counts to track the most frequent elements in a single pass.</li>
 *   <li>If the current element matches either candidate, increment that candidate’s count.</li>
 *   <li>If one candidate count becomes zero, replace that candidate with the current element.</li>
 *   <li>If neither candidate matches and both counts are positive, decrement both counts.</li>
 *   <li>After the first pass, second pass verifies whether the candidates actually occur more than n/3 times.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b>
 *   <ul>
 *     <li>Brute‑force: O(n) for counting plus O(n) for filtering → O(n).</li>
 *     <li>Boyer‑Moore variant: O(n) for two passes over the array.</li>
 *   </ul>
 * <b>Space Complexity:</b>
 *   <ul>
 *     <li>Brute‑force: O(n) for the HashMap.</li>
 *     <li>Boyer‑Moore variant: O(1) extra space plus O(1) for the result list (at most 2 elements).</li>
 *   </ul>
 * </p>
 *
 * @author Arpan Das
 * @since 13/04/2026
 */
public class MajorityElement2 {

    /**
     * Returns all elements that appear more than n/3 times using a brute‑force HashMap approach.
     *
     * <p>Each element is counted once, and then elements with frequency strictly greater than n/3
     * are collected into the result list. The array is treated as read‑only.</p>
     *
     * @param nums non‑null array of integers; may be empty
     * @return list of elements that appear more than n/3 times (at most 2 elements)
     */
    public List<Integer> majorityElementBrute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int key : freq.keySet()) {
            if (freq.get(key) > nums.length / 3) {
                result.add(key);
            }
        }
        return result;
    }

    /**
     * Returns all elements that appear more than n/3 times using a Boyer‑Moore‑style voting algorithm.
     *
     * <p>By the pigeon‑hole principle, at most two elements can appear more than n/3 times. The algorithm:
     * <ul>
     *   <li>Finds two candidate elements in a single pass using two counters.</li>
     *   <li>Verifies both candidates in a second pass by counting their occurrences.</li>
     *   <li>Adds candidates to the result list only if their count is greater than n/3.</li>
     * </ul>
     * This method is more space‑efficient than the brute‑force HashMap solution.</p>
     *
     * @param nums non‑null array of integers; may be empty
     * @return list of elements that appear more than n/3 times (at most 2 elements)
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int firstCandidate = 0, secondCandidate = 0;
        int count1 = 0, count2 = 0;

        // First pass: find two candidate majority elements.
        for (int num : nums) {
            if (num == firstCandidate) {
                count1++;
            } else if (num == secondCandidate) {
                count2++;
            } else if (count1 == 0) {
                firstCandidate = num;
                count1 = 1;
            } else if (count2 == 0) {
                secondCandidate = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify candidates.
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == firstCandidate) {
                count1++;
            } else if (num == secondCandidate) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(firstCandidate);
        }
        if (count2 > nums.length / 3) {
            result.add(secondCandidate);
        }

        return result;
    }
}
