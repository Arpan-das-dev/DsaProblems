package DynamicProgramming;
/**
 * Utility class for finding the longest palindromic substring in a given string.
 *
 * <p>Given a string, this class returns the longest contiguous substring that reads
 * the same forwards and backwards (a palindrome).</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>For each possible center in the string, expand outwards while characters match.</li>
 *   <li>Consider both odd-length palindromes (single center) and even-length palindromes (two adjacent centers).</li>
 *   <li>Track the starting index and length of the longest palindrome found so far.</li>
 *   <li>Finally, return the substring corresponding to the longest palindrome.</li>
 * </ul>
 *
 * <p>This “expand around center” technique avoids the O(n³) brute force and runs in O(n²) time.</p>
 *
 * <p><b>Time Complexity:</b> O(n²), where n is the length of the string.<br>
 * <b>Space Complexity:</b> O(1), only a few variables used (excluding the returned substring).</p>
 *
 * @author Arpan Das
 * @since 14/01/2026
 */
public class LongestPalindromicSubstring {

    /**
     * Returns the longest palindromic substring in the given string.
     *
     * <p>Uses the expand-around-center technique: for each index, treat it as the center
     * of an odd-length palindrome and as the left center of an even-length palindrome,
     * then expand while characters match.</p>
     *
     * @param s the input string
     * @return the longest palindromic substring; if the string is null, empty, or length 1, returns s itself
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;

        int start = 0, maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindromes (center at i)
            int oddLength = expandStringIfPalindrome(s, i, i);
            // Expand for even-length palindromes (center between i and i+1)
            int evenLength = expandStringIfPalindrome(s, i, i + 1);

            int current = Math.max(oddLength, evenLength);
            if (current > maxLength) {
                maxLength = current;
                start = i - (current - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    /**
     * Helper method to expand around a center and return the length of the longest palindrome.
     *
     * <p>Expands outward from the given left and right indices as long as:
     * <ul>
     *   <li>indices are within bounds</li>
     *   <li>characters at both ends are equal</li>
     * </ul>
     * Returns the length of the palindrome found.</p>
     *
     * @param s     the input string
     * @param left  left boundary index (start)
     * @param right right boundary index (end)
     * @return length of the palindromic substring centered at (left, right)
     */
    private int expandStringIfPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

