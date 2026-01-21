package SlidingWindow;

/**
 * Utility class to find the length of the longest substring containing the same letter
 * that can be obtained by replacing at most k characters.
 *
 * <p>Given a string s and an integer k, the goal is to find the longest substring
 * such that all characters in it are the same after replacing at most k characters
 * with any uppercase English letter.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a sliding window (left, right) and an array to count frequency of each character in the window.</li>
 *   <li>In each window, the maximum frequency character is preserved, and all other characters are considered for replacement.</li>
 *   <li>The window is valid if the number of characters to replace (window size - max freq) is ≤ k.</li>
 *   <li>Expand the window by moving right; if the window becomes invalid, shrink from the left until it becomes valid again.</li>
 * </ul>
 *
 * <p>The algorithm keeps track of the maximum window size seen so far, which corresponds to the answer.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the length of the string (each character visited at most twice).<br>
 * <b>Space Complexity:</b> O(1), since the charCount array is of fixed size 26 (for 'A'-'Z').</p>
 *
 * @author Arpan Das
 * @since 21/01/2026
 */
public class LongestRepeatingCharReplacement {

    /**
     * Returns the length of the longest substring with all same characters after at most k replacements.
     *
     * <p>Uses a variable-size sliding window and the insight that the longest valid substring is:
     * <pre>
     *   length = max frequency character in the window + (≤ k allowed replacements)
     * </pre>
     * The window is expanded from the right, and if replacements needed (windowSize - maxFreq) exceed k,
     * the window is shrunk from the left.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace both 'A' and 'B' → "AAAA" or "BBBB", length = 4.
     *
     * Input:  s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Change one 'B' to 'A' → "AAAABBA" → longest repeating segment is "AAAA" (length 4).
     *
     * Input:  s = "ABBB", k = 2
     * Output: 4
     * Explanation: Change 'A' and one 'B' → "BBBB" (length 4).
     * </pre>
     *
     * @param s a string of uppercase English letters
     * @param k maximum number of characters that can be replaced
     * @return the length of the longest substring with all same characters after at most k replacements
     */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;      // Max frequency of any character in the current window
        int maxLength = 0;    // Length of the longest valid window seen so far
        int[] charCount = new int[26]; // Count of each character ('A'-'Z') in the current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++; // Increment count for the current char
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'A']); // Update max frequency

            int window = right - left + 1; // Current window size

            // If replacements needed (window - maxFreq) > k, shrink window from left
            if (window - maxFreq > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // The current valid window has size (right - left + 1)
            // (Note: some implementations use maxFreq as the “best possible length” but here we use actual window size)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

