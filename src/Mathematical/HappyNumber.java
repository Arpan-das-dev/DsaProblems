package Mathematical;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to detect if number is "happy" (reaches 1 via digit square sums).
 *
 * <p>Happy number: repeatedly replace with sum of squares of digits → reaches 1. Unhappy → cycles
 * (detected via seen set). Known cycle: 4→16→37→58→89→145→42→20→4.</p>
 *
 * <p><b>Approach:</b> Floyd's Cycle Detection Alternative (HashSet)</p>
 * <ul>
 *   <li>Track seen sums → cycle if repeat</li>
 *   <li>Transform: {@code n → Σ(digit_i²)}</li>
 *   <li>1 = happy, cycle = unhappy</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n × digits), worst case cycle length.<br>
 * <b>Space Complexity:</b> O(log n) seen set.</p>
 *
 * @author Arpan Das
 * @since 18/03/2026
 */

public class HappyNumber {

    /**
     * Returns true if n is happy number.
     *
     * <p>Detects cycles via seen sums. 1→happy, cycle→unhappy.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = 19
     * 19→82→68→100→1 → Output: true ✓
     *
     * Input: n = 2
     * 2→4→16→37→58→89→145→42→20→4 (cycle) → Output: false
     *
     * Input: n = 1
     * Output: true
     * </pre>
     *
     * @param n positive integer
     * @return true if happy number
     */
    public boolean isHappy(int n) {
        if (n == 1) return true;

        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // Cycle detected
            }
            seen.add(n);
            n = getNext(n);
        }
        return true;
    }

    /**
     * Computes next number: sum of squares of digits.
     *
     * <p>Example: 19 → 1²+9² = 1+81 = 82</p>
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
