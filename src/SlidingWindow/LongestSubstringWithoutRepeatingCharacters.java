package SlidingWindow;

import java.util.HashSet;
import java.util.Set;
/**
 * Utility class to find the length of the longest substring without repeating characters.
 *
 * <p>Given a string, compute the length of the longest substring that contains no duplicate characters.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use a sliding window (left, right) and a HashSet to track characters in the current window.</li>
 *   <li>Expand the window by moving the right pointer and adding characters to the set.</li>
 *   <li>When a duplicate character is encountered, shrink the window from the left until the duplicate is removed.</li>
 *   <li>At each step, update the maximum length of the valid window.</li>
 * </ul>
 *
 * <p>This sliding window technique ensures each character is processed at most twice (left/right),
 * giving an efficient linear-time solution.</p>
 *
 * <p><b>Time Complexity:</b> O(n), where n is the length of the string.<br>
 * <b>Space Complexity:</b> O(min(m, n)), where m is the size of the character set (e.g., 26 for lowercase letters).</p>
 *
 * @author Arpan Das
 * @since 17/01/2026
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Returns the length of the longest substring without repeating characters.
     *
     * <p>Uses a sliding window technique with a character set to maintain the current window
     * of non-repeating characters.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  "abcabcbb"
     * Output: 3
     * Explanation: The longest substring without repeating characters is "abc" (length 3).
     *
     * Input:  "bbbbb"
     * Output: 1
     * Explanation: The longest substring is "b" (length 1).
     *
     * Input:  "pwwkew"
     * Output: 3
     * Explanation: The longest substring is "wke" (length 3).
     *
     * Input:  ""
     * Output: 0
     * Explanation: Empty string has length 0.
     * </pre>
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int length = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character ch = s.charAt(right);
            // Shrink window from the left while the current character is already in the set
            while (characterSet.contains(ch)) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            // Expand the window by adding the current character
            characterSet.add(ch);
            // Update the maximum length of non-repeating substring
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
