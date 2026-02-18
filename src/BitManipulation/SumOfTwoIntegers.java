package BitManipulation;

/**
 * Utility class to compute sum of two integers using bitwise operations only.
 *
 * <p>Implement addition without using + operator. Uses bitwise XOR for sum without carry
 * and AND + left shift for carry propagation, iteratively until no carry remains.</p>
 *
 * <p><b>Bitwise Addition Algorithm:</b></p>
 * <ul>
 *   <li>{@code sum_without_carry = a ^ b} (XOR: 1+1=0, others normal)</li>
 *   <li>{@code carry = (a & b) << 1} (AND finds positions to carry, shift left)</li>
 *   <li>Repeat: {@code a = sum_without_carry, b = carry} until {@code carry = 0}</li>
 * </ul>
 *
 * <p>Example: 5 + 1 = 101 + 001</p>
 * <pre>1: sum=100, carry=010 → 4+2
 * 2: sum=110, carry=000 → 6 ✓</pre>
 *
 * <p><b>Time Complexity:</b> O(max word length) = O(32) or O(64).<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 18/02/2026
 */
public class SumOfTwoIntegers {

    /**
     * Returns a + b using only bitwise operations (no arithmetic operators).
     *
     * <p>Simulates binary addition: XOR for sum bits, AND+shift for carry bits.
     * Repeats until no carry remains.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: a = 1, b = 2
     * Output: 3
     * 1^2=3, (1&2)<<1=0 → done
     *
     * Input: a = 5, b = 1
     * Output: 6
     * Iteration 1: 5^1=4, (5&1)<<1=2
     * Iteration 2: 4^2=6, (4&2)<<1=0 → done
     * </pre>
     *
     * @param a first integer
     * @param b second integer
     * @return a + b
     */
    public int getSum(int a, int b) {
        while (b != 0) {  // Repeat until no carry
            int sum = a ^ b;              // Sum without carry (XOR)
            int carry = (a & b) << 1;     // Generate carry bits (AND + shift left)
            a = sum;                      // Update for next iteration
            b = carry;
        }
        return a;
    }
}

