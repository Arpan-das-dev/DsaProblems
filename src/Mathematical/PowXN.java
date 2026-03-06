package Mathematical;

/**
 * Utility class to compute x raised to power n efficiently.
 *
 * <p>Given base {@code x} (double) and exponent {@code n} (int), return {@code x^n}. Handles
 * negative exponents by computing {@code (1/x)^|n|}. Efficiently handles large |n| using binary
 * exponentiation.</p>
 *
 * <p><b>Approach:</b> Binary Exponentiation (Exponentiation by Squaring)</p>
 * <ul>
 *   <li>Convert {@code n} to positive {@code long pow = |n|}</li>
 *   <li>While {@code pow > 0}:
 *     <ul>
 *       <li>If LSB set ({@code pow&1}): {@code result *= x}</li>
 *       <li>Square base: {@code x *= x}</li>
 *       <li>Right shift: {@code pow >>= 1}</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log|n|).<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 06/03/2026
 */
public class PowXN {

    /**
     * Returns x raised to power n using binary exponentiation.
     *
     * <p>Iterative: processes bits of |n| from MSB→LSB.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: x = 2.0, n = 10
     *        10₂=1010 → bits 1,3 set → 2¹×2⁸=2×256=512 ✓
     * Output: 512.0
     *
     * Input: x = 2.1, n = 3
     *        3₂=11 → bits 0,1 set → 2.1¹×2.1²=2.1×4.41=9.261 ✓
     * Output: 9.261
     *
     * Input: x = 2.0, n = -2
     *        → x=0.5, n=2 → 0.5²=0.25 ✓
     * Output: 0.25
     * </pre>
     *
     * @param x base (double)
     * @param n exponent (int, can be negative)
     * @return x^n
     */
    public double myPow(double x, int n) {
        long pow = n;         // Use long to handle INT_MIN edge case
        double result = 1.0;

        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            pow = -pow;
        }

        // Binary exponentiation: process bits of pow
        while (pow > 0) {
            // If current bit is 1: multiply result by current x
            if ((pow & 1) == 1) {
                result *= x;
            }
            // Square base for next iteration
            x *= x;
            // Right shift to next bit
            pow >>= 1;
        }

        return result;
    }
}
