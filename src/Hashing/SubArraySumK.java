package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to count subarrays with given sum k.
 * {@code NeetCode 250 sheet}
 * <p>LeetCode 560: Given {@code nums} and {@code k}, return count of contiguous subarrays summing to k.</p>
 *
 * <p><b>Approach:</b> Prefix Sum + HashMap (Subarray Sum = prefix[j] - prefix[i])</p>
 * <ul>
 *   <li>Track prefix[i] → frequency map</li>
 *   <li>For prefix[j], count = freq[prefix[j] - k]</li>
 *   <li>Empty prefix (0) starts with freq=1</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), <b>Space Complexity:</b> O(n).</p>
 *
 * @author Arpan Das
 * @since 21/03/2026
 */

public class SubArraySumK {

    /**
     * Returns count of subarrays summing to k using prefix sums.
     *
     * <p>Key insight: {@code sum[i+1..j] = prefix[j+1] - prefix[i]} = k</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,1,1], k = 2
     * Prefix: [0,1,2,3]
     * Subarrays: [1,1] (prefix2-prefix0=2), [1,1] (prefix3-prefix1=2) → Output: 2 ✓
     *
     * Input: nums = [1,2,3], k = 3
     * Subarrays: [3], [1,2] → Output: 2
     * </pre>
     *
     * @param nums input array
     * @param k target sum
     * @return count of matching subarrays
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0, 1);  // Empty prefix

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            // Update current prefix
            prefixSum += num;

            // Check for subarray ending here: prefixSum - k
            if (prefixFreq.containsKey(prefixSum - k)) {
                count += prefixFreq.get(prefixSum - k);
            }

            // Record current prefix frequency
            prefixFreq.put(prefixSum, prefixFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

