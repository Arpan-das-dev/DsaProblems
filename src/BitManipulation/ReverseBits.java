package BitManipulation;

/**
 * Utility class to reverse the bits of a 32-bit unsigned integer.
 *
 * <p>Reverse bits of a given 32-bit unsigned integer. For example, given input 43261596
 * (represented in binary as 00000010100101000001111010011100), return 964176192
 * (represented in binary as 00111001011110000010100101000000).</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li><b>Bit-by-bit Construction:</b> Iterate from MSB (bit 31) to LSB (bit 0).</li>
 *   <li>For each position {@code shift}:
 *     <ul>
 *       <li>Extract LSB of input using {@code n & 1}</li>
 *       <li>Place it at position {@code shift} in result using left shift {@code << shift}</li>
 *       <li>Right-shift input {@code n >>> 1} to process next bit</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>Two variants shown: standard {@code >>} (arithmetic shift) and {@code >>>} (logical shift)
 * for bit-safe handling of negative numbers (treats as unsigned).</p>
 *
 * <p><b>Time Complexity:</b> O(1) = O(32) fixed iterations.<br>
 * <b>Space Complexity:</b> O(1), only a few variables.</p>
 *
 * @author Arpan Das
 * @since 16/02/2026
 */
public class ReverseBits {

    /**
     * Reverses the bits of a 32-bit integer using standard right shift.
     *
     * <p>Builds result by extracting LSB of n ({@code n & 1}), placing it at the correct
     * high-order position using left shift, then right-shifting n to process next bit.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  n = 43261596 (binary: 00000010100101000001111010011100)
     * Output: 964176192 (binary: 00111001011110000010100101000000)
     *
     * Input:  n = 4294967293 (binary: 11111111111111111111111111111101)
     * Output: 3221225471 (binary: 10111110111111000000100000111111)
     * </pre>
     *
     * @param n 32-bit unsigned integer
     * @return the integer with reversed bits
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int shift = 31; shift >= 0; shift--) {
            // Extract LSB of n and place it at position 'shift' in result
            result += (n & 1) << shift;
            // Move to next bit in n (right shift)
            n = n >> 1;
        }
        return result;
    }

    /**
     * Bit-safe version using logical right shift ({@code >>>}).
     *
     * <p>Same logic as {@code reverseBits()}, but uses unsigned right shift {@code >>> 1}
     * to handle negative numbers correctly (treats as 32-bit unsigned).
     * Uses {@code |} instead of {@code +} to avoid potential overflow (though safe for bits).</p>
     *
     * @param n 32-bit unsigned integer (handles negative correctly)
     * @return the integer with reversed bits
     */
    public int reverseBitsBitSafeApproach(int n) {
        int result = 0;
        for (int shift = 31; shift >= 0; shift--) {
            // Extract LSB and shift to position, OR into result
            result |= (n & 1) << shift;
            // Unsigned right shift (preserves bit pattern for negative numbers)
            n = n >>> 1;
        }
        return result;
    }
}

