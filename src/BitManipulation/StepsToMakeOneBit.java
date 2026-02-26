package BitManipulation;

/**
 * Utility class to compute minimum operations to reduce binary string to "1".
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given binary string {@code s} (MSB left), return minimum steps to make it "1" using:
 * <ul>
 *   <li>Remove trailing 0 (divide by 2)</li>
 *   <li>Add 1 to number (flip trailing 1s to 0s, flip first 0→1)</li>
 * </ul></p>
 *
 * <p><b>Approach:</b> Simulate Operations on Mutable String</p>
 * <ul>
 *   <li>If ends with 0: remove last char (÷2)</li>
 *   <li>If ends with 1: flip trailing 1s→0s, flip first 0→1 (or prepend 1 for all 1s)</li>
 *   <li>Count steps until "1"</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n × log n) worst case flips.<br>
 * <b>Space Complexity:</b> O(n) for StringBuilder.</p>
 *
 * @author Arpan Das
 * @since 26/02/2026
 */
public class StepsToMakeOneBit {

    /**
     * Returns minimum steps to reduce binary string to "1".
     *
     * <p>Directly simulates both operations on mutable string representation.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "1101" (13₁₀)
     * Steps: 1101→110(÷2)→111(+1)→11(÷2)→10(÷2)→1(÷2) = 4 steps ✓
     * Output: 4
     *
     * Input: s = "10" (2₁₀)
     * Steps: 10→1(÷2) = 1-step
     * Output: 1
     *
     * Input: s = "1"
     * Output: 0 (already "1")
     *
     * Input: s = "11" (3₁₀)
     * Steps: 11→10(+1)→1(÷2) = 2 steps
     * Output: 2
     * </pre>
     *
     * @param s binary string (no leading zeros except "0")
     * @return minimum operations to reach "1"
     */
    public int numSteps(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1 && (s.equals("0") || s.equals("1"))) return 0;

        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        // Simulate until reach "1"
        while (!sb.toString().equals("1")) {
            if (sb.charAt(sb.length() - 1) == '0') {
                // Operation 1: Divide by 2 (remove trailing zero)
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Operation 2: Add 1 (flip trailing 1s → 0s, first 0 → 1)
                int len = sb.length() - 1;
                while (len >= 0 && sb.charAt(len) == '1') {
                    sb.setCharAt(len, '0');
                    len--;
                }
                if (len >= 0) {
                    // Flip first 0 to 1
                    sb.setCharAt(len, '1');
                } else {
                    // All 1s → becomes "1" + (n-1)"0"s
                    sb.insert(0, '1');
                }
            }
            steps++;
        }

        return steps;
    }
}

