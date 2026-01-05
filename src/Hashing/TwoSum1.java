package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for finding two indices in an array whose values add up
 * to a given target.
 *
 * <p>The method returns the indices of the two numbers such that their sum
 * is equal to the specified target value.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Traverse the array once while maintaining a map of number → index.</li>
 *   <li>For each element, compute the complement as {@code target - currentValue}.</li>
 *   <li>If the complement is already in the map, a valid pair is found and indices are returned.</li>
 * </ul>
 *
 * <p>This hash-based approach avoids the need for nested loops and achieves
 * optimal linear-time performance.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the number of elements in the array.<br>
 * <b>Space Complexity:</b> O(n), due to the extra map for storing visited elements.</p>
 *
 * @author Arpan Das
 * @since 05/01/2026
 */
public class TwoSum1 {

    /**
     * Returns the indices of the two numbers such that they add up to the target.
     *
     * <p>If no such pair exists, an empty array is returned.</p>
     *
     * @param numbers the input array of integers
     * @param target the target sum to be achieved by adding two elements
     * @return an array of size 2 containing the indices of the two numbers,
     *         or an empty array if no valid pair is found
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> keyTargetMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if(keyTargetMap.containsKey(key)) {
                return new int[] {keyTargetMap.get(key),i};
            }
            keyTargetMap.put(numbers[i],i);
        }
        return new int[] {};
    }
}
