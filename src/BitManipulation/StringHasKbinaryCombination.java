package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to check if binary string contains all combinations of length K.
 *
 * <p><b>this is not from {@code neetcode 150} sheet</b></p>
 *
 * <p>Given binary string {@code s} and integer {@code k}, return true if {@code s} contains all
 * {@code 2^k} binary combinations of length {@code k} as substrings (e.g., k=2 → "00","01","10","11").</p>
 *
 * <p><b>Approach:</b> Sliding Window + Early Termination</p>
 * <ul>
 *   <li>Generate all k-length substrings using sliding window</li>
 *   <li>Track unique combinations in HashSet</li>
 *   <li>Early exit when {@code 2^k} unique found (all combinations present)</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(|s|×k) substring operations.<br>
 * <b>Space Complexity:</b> O(2^k × k) worst case for HashSet.</p>
 *
 * @author Arpan Das
 * @since 23/02/2026
 */
import java.util.HashSet;
import java.util.Set;

public class StringHasKbinaryCombination {

    /**
     * Returns true if s contains all 2^k binary combinations of length k.
     *
     * <p>Uses sliding window to check all k-length substrings against required set.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "00110110", k = 2
     * Output: true
     * Contains: "00","01","11","10" ✓ (all 4 combinations)
     *
     * Input: s = "0110", k = 1
     * Output: true
     * Contains: "0","1" ✓ (both combinations)
     *
     * Input: s = "0110", k = 2
     * Output: false
     * Contains: "01","11","10" → missing "00"
     *
     * Input: s = "1001010", k = 4
     * Output: false
     * Only 4 chars, needs 16 combinations ✓
     * </pre>
     *
     * @param s binary string
     * @param k combination length
     * @return true if all combinations present
     */
    public boolean hasAllCodes(String s, int k) {
        // Early termination: impossible if string too short
        if (s.length() < k) return false;

        Set<String> binary = new HashSet<>();
        int totalCombinations = 1 << k;  // 2^k

        // Sliding window: check all k-length substrings
        for (int i = 0; i <= s.length() - k; i++) {
            String combo = s.substring(i, i + k);
            binary.add(combo);

            // Early exit: found all required combinations
            if (binary.size() == totalCombinations) {
                return true;
            }
        }

        return false;
    }
}

