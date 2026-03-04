package Simulation;

/**
 * Utility class to multiply two large non-negative integers represented as strings.
 *
 * <p>Given two non-negative integers {@code num1} and {@code num2} as strings, return product as
 * string. Numbers too large for int/long, so simulate grade-school multiplication algorithm.</p>
 *
 * <p><b>Approach:</b> Grade-School Multiplication + Reverse Accumulation</p>
 * <ul>
 *   <li>Process digits right→left: {@code a[i] * b[j] → position[i+j+1]}</li>
 *   <li>Handle carry propagation within nested loops</li>
 *   <li>Build result by skipping leading zeros</li>
 *   <li>Early return "0" if either input is zero</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m×n), m=|num1|, n=|num2|.<br>
 * <b>Space Complexity:</b> O(m+n).</p>
 *
 * @author Arpan Das
 * @since 04/03/2026
 */
public class MultiplyStrings {

    /**
     * Returns product of two large numbers as string.
     *
     * <p>Simulates manual multiplication with carry handling.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     *
     * Input: num1 = "123", num2 = "456"
     *        123 × 456 = 56088 ✓
     * Output: "56088"
     *
     * Input: num1 = "999", num2 = "999"
     *        999×999=998001 ✓
     * Output: "998001"
     *
     * Input: num1 = "0", num2 = "1234"
     * Output: "0"
     * </pre>
     *
     * @param num1 first number as string
     * @param num2 second number as string
     * @return product as string
     */
    public String multiply(String num1, String num2) {
        // Early termination for zero
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        // Result array: size = len1 + len2 (max digits in product)
        int[] products = new int[len1 + len2];

        // Multiply each digit pair
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                // Position: high=i+j (tens), low=i+j+1 (ones)
                int highPos = i + j;
                int lowPos = i + j + 1;

                int sum = products[lowPos] + product;
                products[lowPos] = sum % 10;      // Ones digit
                products[highPos] += sum / 10;    // Carry to tens
            }
        }

        // Build string, skip leading zeros
        StringBuilder result = new StringBuilder();
        for (int digit : products) {
            if (!(result.isEmpty() && digit == 0)) {
                result.append(digit);
            }
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}
