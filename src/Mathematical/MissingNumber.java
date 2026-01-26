package Mathematical;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to find the missing number in an array containing numbers from 0 to n.
 *
 * <p>Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one
 * that is missing from the array. The array contains exactly n elements (one number is missing).</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Mathematical (Optimal):</b> Use the formula for sum of first n natural numbers:
 *       sum = n(n+1)/2. Subtract the sum of array elements to find the missing number.</li>
 *   <li><b>HashSet (Non-optimal):</b> Store all elements in a set and iterate from 0 to max
 *       to find the first missing number.</li>
 * </ul>
 *
 * <p>The mathematical approach leverages the arithmetic series formula for O(n) time and O(1) space.
 * It works because the expected sum of numbers from 0 to n is known exactly.</p>
 *
 * <p><b>Time Complexity:</b> O(n) for both approaches.<br>
 * <b>Space Complexity:</b> O(1) for mathematical, O(n) for HashSet approach.</p>
 *
 * @author Arpan Das
 * @since 26/01/2026
 */
public class MissingNumber {

    /**
     * Finds the missing number using the mathematical sum formula (most optimal).
     *
     * <p>Expected sum of numbers from 0 to n is n(n+1)/2. Subtract the actual sum of
     * array elements to get the missing number. This works because exactly one number is missing.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3, expected sum = 3*4/2 = 6. Array sum = 3+0+1 = 4. Missing = 6-4 = 2.
     *
     * Input:  nums = [0,1]
     * Output: 2
     * Explanation: n = 2, expected sum = 2*3/2 = 3. Array sum = 0+1 = 1. Missing = 3-1 = 2.
     *
     * Input:  nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9, expected sum = 9*10/2 = 45. Array sum = 37. Missing = 45-37 = 8.
     * </pre>
     *
     * @param nums array containing n distinct numbers from 0 to n (exactly one missing)
     * @return the missing number in the range [0, n]
     */
    public int missingNumber(int[] nums) {
        // Formula for sum of first n natural numbers: sum = n(n+1)/2
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;

        // Subtract actual sum from expected sum to find missing number
        for (int value : nums) {
            expectedSum -= value;
        }
        return expectedSum;
    }

    /**
     * Non-optimal solution using HashSet to find the missing number.
     *
     * <p>Stores all array elements in a HashSet, finds the maximum value, then iterates
     * from 0 to max+1 to find the first missing number.</p>
     *
     * @param nums array containing n distinct numbers from 0 to n (exactly one missing)
     * @return the missing number in the range [0, n]
     */
    public int missingNumberNonPureOptimal(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        // Store all elements and track maximum
        for (int num : nums) {
            max = Math.max(max, num);
            set.add(num);
        }

        // Find first missing number from 0 to max+1
        for (int i = 0; i <= max; i++) {
            if (!set.contains(i)) return i;
        }
        return max + 1;
    }
}
