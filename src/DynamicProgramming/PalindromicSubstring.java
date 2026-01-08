package DynamicProgramming;
/**
 * Utility class for counting all palindromic substrings in a given string.
 *
 * <p>A palindromic substring is a contiguous sequence of characters that reads
 * the same forward and backward. Every single character is considered a palindrome.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> Generate all possible substrings and verify each (O(n³)).</li>
 *   <li><b>Expand Around Center:</b> For each possible center, expand outwards
 *       while characters match, counting all valid palindromes (O(n²)).</li>
 * </ul>
 *
 * <p>The optimal solution recognizes that palindromes have either a single center
 * (odd length) or two adjacent centers (even length), enabling efficient expansion.</p>
 *
 * <p><b>Time Complexity:</b> O(n²) for optimal solution, O(n³) for brute force.<br>
 * <b>Space Complexity:</b> O(1) auxiliary space for both approaches.</p>
 *
 * @author Arpan Das
 * @since 08/01/2026
 */
public class PalindromicSubstring {

    /**
     * Brute force solution that generates all substrings and checks each.
     *
     * <p>Uses nested loops to create all possible substrings, then verifies
     * each with a helper palindrome check function.</p>
     *
     * @param s the input string
     * @return total count of all palindromic substrings
     */
    public int countSubstringsBrute(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) count++;
            }
        }
        return count;
    }

    /**
     * Helper method to check if substring s[i..j] is a palindrome.
     *
     * <p>Compares characters from both ends moving toward the center.</p>
     *
     * @param s the input string
     * @param i start index
     * @param j end index
     * @return true if the substring is a palindrome
     */
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Optimal expand-around-center solution for counting palindromic substrings.
     *
     * <p>For each index, treats it as center for odd-length palindromes and
     * as left/center for even-length palindromes, expanding while characters match.</p>
     *
     * @param s the input string
     * @return total count of all palindromic substrings
     */
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (single center)
            count += countPalindrome(s, i, i);
            // Even length palindromes (two adjacent centers)
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    /**
     * Expands around given center coordinates to count all valid palindromes.
     *
     * <p>While boundaries are valid and characters match, increment count and expand.</p>
     *
     * @param s the input string
     * @param left left boundary index
     * @param right right boundary index
     * @return number of palindromic substrings found around this center
     */
    private int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}