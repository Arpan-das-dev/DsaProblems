package BitManipulation;

/**
 * Utility class to find the longest binary gap in positive integer's binary representation.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Binary gap = longest sequence of consecutive 0s surrounded by 1s in binary form.
 * For example, 9 (1001₂) has gap=2, 529 (1000010001₂) has gap=4, 20 (10100₂) has gap=1.
 * If no gap exists, return 0.</p>
 *
 * <p><b>Approach:</b> Bitwise Right-to-Left Traversal + Optimization</p>
 * <ul>
 *   <li>Skip trailing zeros: {@code n >>>= Integer.numberOfTrailingZeros(n)}</li>
 *   <li>Track consecutive zeros between 1s, update max gap</li>
 *   <li>Right shift {@code n>>=1} processes bits LSB→MSB</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n) bits.<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 22/02/2026
 */
public class BinaryGap {

    /**
     * Returns length of longest binary gap in n's binary representation.
     *
     * <p>Optimizes by skipping trailing zeros, finds max zeros between consecutive 1s.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 22 (10110₂)
     * Output: 2
     * Binary: 10110 → gap between 2nd-3rd 1: **10**110 → 2 zeros ✓
     *
     * Input: n = 8  (1000₂)
     * Output: 0
     * Binary: 1000 → no gap (trailing zeros ignored)
     *
     * Input: n = 5  (101₂)
     * Output: 1
     * Binary: 101 → gap: 1**0**1 → 1 zero ✓
     *
     * Input: n = 1  (1₂)
     * Output: 0
     * Single 1 → no gap
     * </pre>
     *
     * @param n positive integer (> 0)
     * @return longest binary gap length
     */
    public int binaryGap(int n) {
        // Skip trailing zeros (optimization)
        n >>>= Integer.numberOfTrailingZeros(n);
        if (n == 1) return 0;  // Single 1 has no gap

        int gap = 0;     // Current consecutive zeros
        int maxGap = 0;  // Maximum gap found

        while (n > 0) {
            if ((n & 1) == 1) {  // Current bit is 1
                maxGap = Math.max(gap, maxGap);
                gap = 0;           // Reset gap counter
            } else {
                gap++;             // Count consecutive zero
            }
            n >>= 1;               // Process next bit (right shift)
        }

        return maxGap + 1;  // +1 since gap counts spaces between 1s
    }
}

