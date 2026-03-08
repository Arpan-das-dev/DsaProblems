package Mathematical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class to increment large integer represented as digit array by one.
 *
 * <p>Given non-negative integer {@code digits[]} (most significant digit first), return array
 * representing number + 1. Handle carry propagation and potential length increase (e.g., [9,9]→[1,0,0]).</p>
 *
 * <p><b>Approach:</b> In-place Right-to-Left Carry Propagation</p>
 * <ul>
 *   <li>Start from the least significant digit (rightmost)</li>
 *   <li>If {@code digits[i] < 9}: increment and return (no carry)</li>
 *   <li>Else: set 0, propagate carry leftward</li>
 *   <li>All 9s: create new array [1,0,0,...]</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) worst case.<br>
 * <b>Space Complexity:</b> O(1) or O(n) for new array.</p>
 *
 * @author Arpan Das
 * @since 08/03/2026
 */
public class PlusOne {

    /**
     * Increments digit array by 1 (optimal in-place).
     *
     * <p>Modifies input if possible, creates new array only for all-9s case.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: digits = [1,2,3]
     * Output: [1,2,4] ✓
     *
     * Input: digits = [4,3,2,9]
     * Output: [4,3,3,0] ✓
     *
     * Input: digits = [9,9]
     * Output: [1,0,0] ✓ (length +1)
     *
     * Input: digits = [0]
     * Output: [1]
     * </pre>
     *
     * @param digits non-negative integer digits (no leading zeros except [0])
     * @return digits + 1 as array
     */
    public int[] plusOne(int[] digits) {
        // Right-to-left carry propagation
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // Can increment without carry
                digits[i]++;
                return digits;
            }
            // Set to 0, carry over
            digits[i] = 0;
        }

        // All digits were 9: need new longer array
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * Non-optimal: List-based approach (for comparison).
     */
    public int[] plusOneNonOptimal(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        List<Integer> store = new ArrayList<>();
        int carry = 1;

        // Process right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            store.add(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) store.add(carry);

        // Reverse and convert to array
        Collections.reverse(store);
        int[] result = new int[store.size()];
        for (int i = 0; i < store.size(); i++) {
            result[i] = store.get(i);
        }
        return result;
    }
}
