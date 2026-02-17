package BitManipulation;

/**
 * Utility class to count set bits (1s) in binary representation of numbers 0 to n.
 *
 * <p>Given non-negative integer {@code n}, return array {@code answer} where
 * {@code answer[i]} = number of 1s in binary representation of {@code i}.</p>
 *
 * <p><b>Key Insight (Brian Kernighan's Algorithm):</b></p>
 * <pre>n & (n-1) turns off the rightmost set bit</pre>
 * <p>Therefore: {@code pop count(n) = pop count(n & (n-1)) + 1}</p>
 *
 * <p>Example: 5 (101) → 5 & 4 (100) → 4 & 3 (011) → 0 → [0,1,1,2,1,2]</p>
 *
 * <p><b>Time Complexity:</b> O(n), each number processes exactly #set bits operations.<br>
 * <b>Space Complexity:</b> O(n) for output array.</p>
 *
 * @author Arpan Das
 * @since 17/02/2026
 */
public class CountBits {

    /**
     * Returns array where result[i] = number of 1s in binary representation of i.
     *
     * <p>Uses dynamic programming with bitwise trick: {@code result[i] = result[i & (i-1)] + 1}</p>
     * <p>result[0] = 0 (implicit), each subsequent number builds from previous.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  n = 2
     * Output: [0,1,1]
     * 0: 00 → 0 ones
     * 1: 01 → 1 one
     * 2: 10 → 1 one
     *
     * Input:  n = 5
     * Output: [0,1,1,2,1,2]
     * 3: 011 → result[3] = result[2] + 1 = 1 + 1 = 2
     * 4: 100 → result[4] = result[0] + 1 = 0 + 1 = 1
     * 5: 101 → result[5] = result[4] + 1 = 1 + 1 = 2
     * </pre>
     *
     * @param n upper limit (inclusive)
     * @return array of set bit counts for 0 to n
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // i & (i-1) removes rightmost set bit → reuse previous count + 1
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}

