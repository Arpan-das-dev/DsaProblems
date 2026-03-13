package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to find single occurrence number in array with paired duplicates.
 *
 * <p>Given {@code nums} where every element appears twice except one, return the unique number.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>HashMap:</b> O(n) time/space, count frequencies</li>
 *   <li><b>Bitwise XOR:</b> O(n) time, O(1) space (a⊕a=0, 0⊕b=b)</li>
 * </ul>
 *
 * <p><b>XOR Properties:</b> Commutative, associative, self-inverse, identity=0.</p>
 *
 * @author Arpan Das
 * @since 13/03/2026
 */

public class SingleNumber {

    /**
     * HashMap version: counts frequencies, returns single occurrence.
     *
     * <p>Linear pass to build map, linear scan for value=1.</p>
     *
     * @param nums array with 1 unique + rest duplicates
     * @return single number
     */
    public int singleNumberMapVersion(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        // Count occurrences
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Find single occurrence
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // Should not reach (guaranteed 1 single)
    }

    /**
     * Optimal XOR version: all pairs cancel, single remains.
     *
     * <p>Leverages XOR properties: {@code a⊕a=0}, {@code 0⊕b=b}, order-independent.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [2,2,1] → 2⊕2⊕1 = 0⊕1 = 1 ✓
     * Input: nums = [4,1,2,1,2] → 4⊕1⊕2⊕1⊕2 = 4 ✓
     * Input: nums = [1] → 1 ✓
     * </pre>
     *
     * <p><b>Time:</b> O(n), <b>Space:</b> O(1)</p>
     *
     * @param nums array with exactly one single occurrence
     * @return the unique number
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

