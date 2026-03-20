package Simulation;

/**
 * Utility class to concatenate array with itself (NeetCode 250 #1).
 *
 * <p>LeetCode 1929: Given {@code nums} of length n, return array of length 2n where first n elements
 * = nums, next n elements = nums again. O(1) extra space excluding output.</p>
 *
 * <p><b>Approach:</b> Single Pass Array Copy</p>
 * <ul>
 *   <li>Create result array of size 2n</li>
 *   <li>Copy nums[i] → result[i] and result[i+n] simultaneously</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n), <b>Space Complexity:</b> O(1) extra (excluding output).</p>
 *
 * @author Arpan Das
 * @since 20/03/2026
 * <p><b>Part of {@code NeetCode 250} sheet</b></p>
 */
public class ConcatenationOfArray {

    /**
     * Returns nums concatenated with itself.
     *
     * <p>Optimized single loop: fills both copies simultaneously.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,3,2,1] → Output: [1,3,2,1,1,3,2,1] ✓
     *
     * Input: nums = [1,2,2,2,2,2,2] → Output: [1,2,2,2,2,2,2,1,2,2,2,2,2,2]
     * </pre>
     *
     * @param nums input array
     * @return concatenated array (length 2n)
     */
    public int[] getConcatenation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[2 * n];
        // Single pass: copy to both positions simultaneously
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];           // First copy
            result[i + n] = nums[i];       // Second copy
        }
        return result;
    }
}

