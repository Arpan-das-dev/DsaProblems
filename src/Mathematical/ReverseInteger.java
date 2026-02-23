package Mathematical;

/**
 * Utility class to reverse digits of 32-bit signed integer.
 *
 * <p>Given 32-bit signed integer {@code x}, reverse its digits. If reversing causes overflow
 * (outside [-2³¹, 2³¹-1]), return 0. Negative numbers preserve sign.</p>
 *
 * <p><b>Approach:</b> Mathematical Digit Extraction + Overflow Prevention</p>
 * <ul>
 *   <li>Extract last digit: {@code pop = x % 10}, {@code x /= 10}</li>
 *   <li>Build reversed: {@code rev = rev * 10 + pop}</li>
 *   <li>Overflow check before multiply/add:
 *     <ul>
 *       <li>{@code rev > MAX/10 || rev < MIN/10} → overflow</li>
 *       <li>Boundary: {@code rev == MAX/10 && pop > 7}, {@code rev == MIN/10 && pop < -8}</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log|x|), number of digits.<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 23/02/2026
 */
public class ReverseInteger {

    /**
     * Reverses digits of integer x, returns 0 on overflow.
     *
     * <p>Handles negative numbers correctly, checks overflow before each operation.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: x = 123
     * Output: 321
     *
     * Input: x = -123
     * Output: -321
     *
     * Input: x = 120
     * Output: 21 (trailing zeros removed)
     *
     * Input: x = 1534236469
     * Output: 0
     * Explanation: Would overflow → return 0
     *
     * Input: x = Integer.MAX_VALUE (2147483647)
     * Output: 0 (7463847412 overflows)
     * </pre>
     *
     * @param x integer to reverse
     * @return reversed integer or 0 on overflow
     */
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;     // Extract last digit
            x /= 10;              // Remove last digit

            // Overflow check before rev *= 10 + pop
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // Edge cases for exact boundary
            if (rev == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rev == Integer.MIN_VALUE / 10 && pop < -8) return 0;

            // Safe to build reversed number
            rev = rev * 10 + pop;
        }

        return rev;
    }
}

