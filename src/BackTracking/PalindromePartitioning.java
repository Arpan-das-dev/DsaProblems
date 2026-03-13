package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find all palindrome partitionings of input string.
 *
 * <p>Given string {@code s}, return all ways to split into palindrome substrings. Order matters.</p>
 *
 * <p><b>Approach:</b> Backtracking + Palindrome Validation</p>
 * <ul>
 *   <li>Try all substring lengths from current position</li>
 *   <li>If palindrome → recurse, backtrack after</li>
 *   <li>Base: full string partitioned → add copy to result</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n×2^n), n substrings × exponential partitions.<br>
 * <b>Space Complexity:</b> O(n) recursion + result storage.</p>
 *
 * @author Arpan Das
 * @since 13/03/2026
 */

public class PalindromePartitioning {

    /**
     * Returns all possible palindrome partitionings of s.
     *
     * <p>Backtracking generates all valid splits where each part is palindrome.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "aab"
     * Output: [["a","a","b"], ["aa","b"]] ✓
     *
     * Input: s = "a"
     * Output: [["a"]]
     *
     * Input: s = ""
     * Output: [[]]
     * </pre>
     *
     * @param s input string
     * @return list of all palindrome partitions
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) return result;

        backtrack(s, result, 0, new ArrayList<>());
        return result;
    }

    /**
     * Backtracking helper: builds partitions from index i.
     *
     * @param s input string
     * @param result all valid partitions
     * @param start current start index
     * @param current current partition
     */
    private void backtrack(String s, List<List<String>> result, int start, List<String> current) {
        // Base case: full partition found
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible substring endings
        for (int end = start + 1; end <= s.length(); end++) {
            String candidate = s.substring(start, end);

            if (isPalindrome(candidate)) {
                current.add(candidate);
                backtrack(s, result, end, current);
                current.removeLast(); // Backtrack
            }
        }
    }

    /**
     * @param str
     * Checks if string is palindrome using two pointers.
     *
     * <p>Single chars and empty are trivially true.</p>
     */
    private boolean isPalindrome(String str) {
        if (str.length() <= 1) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
