package Greedy;

/**
 * Validates if a string containing '(', ')', and '*' is a valid parentheses string.
 *
 * <p>Given a string with open '(', close ')', and wildcard '*' characters, determine if it can be
 * valid by treating '*' as either '(', ')', or empty string. The string is valid if there's at least
 * one way to interpret '*' to make balanced parentheses.</p>
 *
 * <p><b>Key Insight:</b> Track range of possible open parentheses using min/max counters:
 * <ul>
 *   <li><code>max</code>: Maximum possible open parentheses (treating '*' as '(')</li>
 *   <li><code>min</code>: Minimum possible open parentheses (treating '*' as ')' when possible)</li>
 * </ul>
 * Valid if: never max < 0 AND final min == 0</p>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Input: s = "()"
 * Output: true
 * Explanation: Valid parentheses.
 *
 * Input: s = "(*)"
 * Output: true
 * Explanation: '*' can be treated as empty string: "()" ✓
 *
 * Input: s = "(*))"
 * Output: true
 * Explanation: '*' as '(': "(())" ✓
 *
 * Input: s = "(()"
 * Output: false
 * Explanation: Unbalanced closing parentheses.
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(n) single pass.<br>
 * <b>Space Complexity:</b> O(1) constant space.</p>
 *
 * @author Arpan Das
 * @since 15/03/2026
 */
public class ValidParenthesisString {

    /**
     * Validates parentheses string using min/max open parentheses tracking.
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Track <code>max</code> (treat '*' as '(') and <code>min</code> (treat '*' as ')')</li>
     *   <li>For each char:
     *     <ul>
     *       <li>'(': ++max, ++min</li>
     *       <li>')': --max, --min (reset min≥0)</li>
     *       <li>'*': ++max (as '('), --min (as ')')</li>
     *     </ul>
     *   </li>
     *   <li>Invalid if max < 0 anytime</li>
     *   <li>Valid if final min == 0</li>
     * </ol>
     *
     * @param s string containing '(', ')', '*'
     * @return true if valid parentheses string exists, false otherwise
     */
    public boolean checkValidString(String s) {
        int max = 0; // max possible open parentheses '('
        int min = 0; // min possible open parentheses

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Opening: must count as open parenthesis
                max++;
                min++;
            } else if (ch == ')') {
                // Closing: reduces possible opens
                max--;
                min--;
            } else {
                // '*': can be '(', ')', or empty
                max++; // as '(' increases max possible opens
                min--; // as ')' decreases min possible opens
            }

            // Invalid if more closes than opens possible
            if (max < 0) return false;

            // Can't have negative opens (reset min to 0)
            min = Math.max(min, 0);
        }

        // Must balance exactly (min == 0)
        return min == 0;
    }
}

