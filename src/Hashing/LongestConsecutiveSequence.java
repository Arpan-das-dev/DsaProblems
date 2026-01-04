package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for finding the length of the longest consecutive sequence
 * within an unsorted array of integers.
 *
 * <p>A consecutive sequence is a set of elements that can be ordered to form a
 * continuous range, such as [100, 101, 102, 103].</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Inserts all numbers into a {@link java.util.HashSet} for constant-time lookup.</li>
 *   <li>For each unique number, check if it is the start of a new sequence
 *       (i.e., its predecessor number is not present in the set).</li>
 *   <li>Then, iteratively count all consecutive numbers following it while tracking the longest streak.</li>
 * </ul>
 *
 * <p>This hash-based approach avoids sorting and efficiently solves the problem
 * in linear time.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the length of the input array.<br>
 * <b>Space Complexity:</b> O(n), due to the additional HashSet.</p>
 *
 * @author Arpan Das
 * @since 04/01/2026
 */
public class LongestConsecutiveSequence {

    /**
     * Determines the length of the longest consecutive elements sequence in the array.
     *
     * <p>Each number is used as a potential starting point if its immediate
     * predecessor does not exist in the set. The algorithm then expands
     * forward while counting all successive numbers to form a streak.</p>
     *
     * @param numbers an array of integers (unsorted, may contain duplicates)
     * @return the length of the longest consecutive sequence found
     */
    public int longestConsecutive(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int item : numbers) set.add(item);

        int maxStreak = 0; // default max streak
        for(int integer : set) { // loop run
            if(!set.contains(integer-1)) { // if 100 -9 is present means
                                           // it may be the start of the sequence
                int value = integer;
                int currentStreak = 1;  // default streak as 1;
                while (set.contains(value+1)) { // if 100 + 1 = 101 contains then run the loop
                    value ++; // increment to update values like 101>102>103
                    currentStreak ++; // and also increment current streak
                }
                maxStreak = Math.max(maxStreak,currentStreak); // putting only max value of the streak.
            }
        }
        return maxStreak;
    }
}
