package BitManipulation;

/**
 * Utility class to compute concatenated binary representation of 1 to n.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given positive integer {@code n}, return concatenated binary numbers from 1 to n modulo 10⁹+7.
 * Concatenation = 1(1) + 10(2) + 110(3) + 1000(4) + ... Examples: n=1→1, n=3→11(3), n=4→1110(14).</p>
 *
 * <p><b>Approach:</b> Iterative Left Shift + Bit Length Calculation</p>
 * <ul>
 *   <li>For each i: {@code shift = 32 - Integer.numberOfLeadingZeros(i)} = bit length</li>
 *   <li>{@code result = ((result << shift) | i) % MOD}</li>
 *   <li>Accumulates concatenation left→right, modulo prevents overflow</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n), log n for each bit length.<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 28/02/2026
 */
public class ConcatenationOfConsecutiveBinaryNumbers {

    /**
     * Returns concatenated binary numbers 1→n modulo 10⁹+7.
     *
     * <p>Builds result by left-shifting current by bit length of i, OR with i.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 1
     * 1 (1₂) → Output: 1 ✓
     *
     * Input: n = 3
     * 1(1) + 10(2) + 11(3) = 111₂(7) → Output: 7 ✓
     *
     * Input: n = 4
     * 1+10+11+1000 = 1110₂(14) → Output: 14 ✓
     *
     * Input: n = 12
     * 1+10+11+1000+10001+... = 11011110101110₂(3614) → Output: 3614 ✓
     * </pre>
     *
     * @param n upper limit (inclusive)
     * @return concatenated binary result % 10⁹+7
     */
    public int concatenatedBinary(int n) {
        if (n <= 1) return n;

        final int MOD = 1_000_000_007;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            // A bit length of i: 32 - leading zeros in 32-bit int
            int bitLength = 32 - Integer.numberOfLeadingZeros(i);

            // Append i: shift result left by bitLength bits, OR i
            result = ((result << bitLength) | i) % MOD;
        }

        return result;
    }
}
