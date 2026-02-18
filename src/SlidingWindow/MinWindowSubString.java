package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to find minimum window substring containing all characters of another string.
 *
 * <p>Given strings {@code s} and {@code t}, return shortest substring of {@code s} containing
 * all characters of {@code t} (including duplicates). If none exists, return empty string.</p>
 *
 * <p><b>Approach:</b> Sliding Window with Character Frequency Counter</p>
 * <ul>
 *   <li>Count required frequencies of {@code t} characters in {@code requirement} map</li>
 *   <li>Two pointers {@code left, right} form window in {@code s}</li>
 *   <li>Expand right until window satisfies all requirements ({@code required == 0})</li>
 *   <li>Contract left while valid, tracking minimum window size/position</li>
 *   <li>Repeat until full scan</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(|s| + |t|), each character processed at most 2x.<br>
 * <b>Space Complexity:</b> O(|t| + charset size) for frequency map.</p>
 *
 * @author Arpan Das
 * @since 18/02/2026
 */

public class MinWindowSubString {

    /**
     * Returns minimum window substring of s containing all characters of t.
     *
     * <p>Uses sliding window: expand right pointer to satisfy requirements, shrink left
     * pointer to minimize while maintaining validity.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: Smallest window containing A,B,C
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * </pre>
     *
     * @param s source string
     * @param t target characters (with duplicates)
     * @return minimum window or empty string
     */
    public String minWindow(String s, String t) {
        // Edge cases
        if (s.equals(t)) return s;
        if (s.length() < t.length()) return "";

        // Count required character frequencies from t
        Map<Character, Integer> requirement = new HashMap<>();
        for (char ch : t.toCharArray()) {
            requirement.put(ch, requirement.getOrDefault(ch, 0) + 1);
        }

        int left = 0, start = 0;
        int required = t.length();  // Characters still needed
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Process right character
            if (requirement.containsKey(rightChar)) {
                if (requirement.get(rightChar) > 0) {
                    required--;  // One less character needed
                }
                requirement.put(rightChar, requirement.get(rightChar) - 1);
            }

            // Shrink window while valid (all characters satisfied)
            while (required == 0 && left <= right) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                if (requirement.containsKey(leftChar)) {
                    requirement.put(leftChar, requirement.get(leftChar) + 1);
                    if (requirement.get(leftChar) > 0) {
                        required++;  // Need this character again
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

