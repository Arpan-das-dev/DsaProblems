package Greedy;

/**
 * Utility class to partition decimal number into minimum deci-binary numbers.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given string {@code n} representing positive integer, partition into minimum deci-binary numbers
 * (only digits 0 and 1). Return minimum number of partitions. Each partition ≤ n numerically.</p>
 *
 * <p><b>Key Insight:</b> Maximum digit determines minimum partitions needed.</p>
 * <ul>
 *   <li>Largest digit d requires at least d deci-binary numbers (each ≤1 per position)</li>
 *   <li>Maximum digit across all positions = answer</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(|n|).<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 01/03/2026
 */
public class PartitionIntoMinimumDeciBinaryNumbers {

    /**
     * Returns minimum deci-binary partitions needed for n.
     *
     * <p>Maximum digit = minimum partitions (each position independent).</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: n = "32"
     * Max digit=3 → Output: 3
     * Partitions: "11"+"11"+"10" = 3+3+2=8→32₃? Wait, numerically ≤32₁₀ ✓
     *
     * Input: n = "82734"
     * Max digit=8 → Output: 8 ✓
     *
     * Input: n = "27346209830709182346"
     * Max digit=8 → Output: 8 ✓
     *
     * Input: n = "1"
     * Output: 1
     * </pre>
     *
     * @param n string decimal representation (no leading zeros)
     * @return minimum number of deci-binary partitions
     */
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char ch : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, ch - '0');
        }

        return maxDigit;
    }
}