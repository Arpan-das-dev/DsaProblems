package BitManipulation;

/**
 * Utility class to compute the number of 1 bit (Hamming weight) in a 32-bit unsigned integer.
 *
 * <p>Write a function that takes an unsigned integer and returns the number of '1' bits it has
 * (also known as the Hamming weight).</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> Right-shift the number 32 times, check the least significant bit (LSB)
 *       each time using {@code n & 1}, and count 1s.</li>
 *   <li><b>Optimal (Brian Kernighan):</b> Use the property that {@code n & (n-1)} clears the
 *       least significant set bit (rightmost 1). Repeat until n becomes 0, counting iterations.</li>
 * </ul>
 *
 * <p>The optimal approach is faster because it only loops the number of set bits times, not 32.</p>
 *
 * <p><b>Time Complexity:</b> O(32) = O(1) for brute force, O(pop count(n)) = O(1) worst case for optimal.<br>
 * <b>Space Complexity:</b> O(1) for both.</p>
 *
 * @author Arpan Das
 * @since 03/02/2026
 */
public class Number1Bits {

    /**
     * Brute force solution: count 1 bit by checking LSB 32 times.
     *
     * <p>Right-shift n 32 times, each time checking if LSB is 1 using {@code n & 1}.
     * Works for 32-bit unsigned integers (treats n as unsigned by shifting).</p>
     *
     * @param n 32-bit unsigned integer
     * @return the number of 1 bit (Hamming weight)
     */
    public int hammingWeightBrute(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++; // Check LSB
            n = n >> 1;                 // Right shift (unsigned behavior for negative)
        }
        return count;
    }

    /**
     * Optimal Brian Kernighan algorithm: clear rightmost 1 bit repeatedly.
     *
     * <p>The trick: {@code n & (n-1)} clears the least significant set bit.
     * <pre>n = 11011011 (219)
     * n & (n-1) = 11011010 (218)  → cleared rightmost 1
     * Repeat until n = 0, count iterations = number of 1s</pre></p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  n = 00000000000000000000000000001011
     * Output: 3
     * Explanation: Input has 3 ones.
     *
     * Input:  n = 00000000000000000000000010000000
     * Output: 1
     * Explanation: Input has 1 one.
     *
     * Input:  n = 11111111111111111111111111111101
     * Output: 31
     * Explanation: Input has 31 ones.
     * </pre>
     *
     * @param n 32-bit unsigned integer
     * @return the number of 1 bit (Hamming weight)
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1); // Clear the rightmost set bit
            result++;        // Count the cleared bit
        }
        return result;
    }
}
