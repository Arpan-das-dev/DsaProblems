package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to check whether there are duplicate elements within a certain distance in an array.
 *
 * <p>Given an integer array nums and an integer k, determine if there exist two distinct indices i and j
 * such that nums[i] == nums[j] and |i − j| ≤ k. In other words, some duplicate must appear within
 * at most k positions of each other.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach (sliding window with HashSet):</b></p>
 * <ul>
 *   <li>Maintain a HashSet of elements currently within the sliding window of size at most k.</li>
 *   <li>For each element in the array:
 *     <ul>
 *       <li>If the element is already in the set, return true (duplicate found within k indices).</li>
 *       <li>Otherwise, add the element to the set.</li>
 *       <li>If the set size exceeds k, remove the element that is too far back (left pointer).</li>
 *     </ul>
 *   </li>
 *   <li>If the loop completes without finding such a duplicate, return false.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = nums.length; each element is added and removed at most once.<br>
 * <b>Space Complexity:</b> O(k) for the HashSet which stores at most k elements at a time.</p>
 *
 * @author Arpan Das
 * @since 13/04/2026
 */
public class ContainsDuplicate2 {

    /**
     * Returns whether there exists a duplicate pair within distance k.
     *
     * <p>The method checks if any element appears again within at most k indices of its previous occurrence.
     * If so, it returns true. If the array is processed entirely without finding such a pair, it returns false.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Explanation:
     *   nums[0] = 1, nums[3] = 1; |3 - 0| = 3 ≤ k → true.
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Explanation:
     *   nums[2] = 1, nums[3] = 1; |3 - 2| = 1 ≤ k → true.
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     * Explanation:
     *   Nearest duplicates (1,2,3) are at distance 3, which is > k → false.
     * </pre>
     *
     * @param nums non‑null array of integers; may be empty
     * @param k maximum allowed distance between duplicate indices (k ≥ 0)
     * @return true if there is a duplicate within at most k indices, false otherwise
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        int left = 0;

        for (int curr : nums) {
            if (unique.contains(curr)) {
                return true;
            } else if (unique.size() > k) {
                unique.remove(nums[left]);
                left++;
            } else {
                unique.add(curr);
            }
        }
        return false;
    }
}