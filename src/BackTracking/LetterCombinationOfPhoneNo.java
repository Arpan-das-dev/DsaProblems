package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to generate all possible letter combinations for phone number digits.
 *
 * <p>Given string {@code digits} containing digits 2-9, return all possible letter combinations
 * each digit maps to (standard phone keypad mapping). Return empty list if empty input.</p>
 *
 * <p><b>Keypad Mapping:</b></p>
 * <pre>2=abc, 3=def, 4=ghi, 5=jkl, 6=mno, 7=pqrs, 8=tuv, 9=wxyz</pre>
 *
 * <p><b>Approach:</b> Backtracking DFS</p>
 * <ul>
 *   <li>For each digit position, try all corresponding letters</li>
 *   <li>Recurse to next digit, backtrack after exploring branch</li>
 *   <li>Base case: when all digits processed, add combination</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(4^N×N), N=digits.length (3^4 worst case).<br>
 * <b>Space Complexity:</b> O(N) recursion + O(4^N) result.</p>
 *
 * @author Arpan Das
 * @since 28/02/2026
 */

public class LetterCombinationOfPhoneNo {

    /** Phone keypad letter mapping for digits 0-9 */
    private static final String[] KEYS = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    /**
     * Returns all possible letter combinations for given digits.
     *
     * <p>Backtracking explores all combinations depth-first.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 2→abc, 3→def → 3×3=9 combinations ✓
     *
     * Input: digits = ""
     * Output: []
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     * Input: digits = "234"
     * Output: ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi",
     *          "bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi",
     *          "cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
     *          (3×3×4=36 combinations)
     * </pre>
     *
     * @param digits string of digits 2-9
     * @return all possible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backTrackingDfs(digits, result, 0, new StringBuilder());
        return result;
    }

    /**
     * Backtracking DFS: builds combination letter by letter.
     *
     * <p>@param index current digit position being processed</p>
     */
    private void backTrackingDfs(String digits, List<String> result,
                                 int index, StringBuilder combination) {
        // Base case: processed all digits
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // Get current digit and its letter options
        int digit = digits.charAt(index) - '0';
        String letters = KEYS[digit];

        // Try each possible letter for current digit
        for (char letter : letters.toCharArray()) {
            combination.append(letter);           // Choose
            backTrackingDfs(digits, result, index + 1, combination);  // Explore
            combination.deleteCharAt(combination.length() - 1);  // Backtrack
        }
    }
}
