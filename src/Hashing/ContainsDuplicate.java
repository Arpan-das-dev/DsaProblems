package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Determines whether the given integer array contains any duplicate values.
 *
 * <p>The method checks if any element appears more than once by using a
 * {@link java.util.HashSet} to track elements already encountered.
 *
 * <p><b>Approach:</b>
 * <ol>
 *   <li>Initialize an empty {@code HashSet} to store unique elements</li>
 *   <li>Iterate through each element in the array</li>
 *   <li>If the element already exists in the set, return {@code true}</li>
 *   <li>Otherwise, add the element to the set and continue</li>
 * </ol>
 *
 * <p>The algorithm exits early as soon as a duplicate is found,
 * making it efficient for large inputs.
 *
 * <p><b>Time Complexity:</b> O(n) — average case due to constant-time set operations
 * <br>
 * <b>Space Complexity:</b> O(n) — additional space used to store unique elements
 *
 * <p><b>Why HashSet?</b>
 * <ul>
 *   <li>Provides fast lookup and insertion</li>
 *   <li>Eliminates the need for nested loops</li>
 *   <li>Preferred solution in technical interviews</li>
 * </ul>
 * @since 31/12/2025
 * @author  Arpan Das
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] numbers) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int item : numbers) {
            if(!uniqueSet.contains(item)) {
                uniqueSet.add(item);
               continue;
            }
            return true;
        }
        return false;
    }
}
