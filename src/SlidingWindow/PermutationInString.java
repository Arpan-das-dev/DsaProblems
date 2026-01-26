package SlidingWindow;
/**
 * Utility class to check if a permutation of one string exists as a substring in another string.
 *
 * <p>Given two strings s and t, return true if s is a substring of t, otherwise return false.
 * A substring of t is considered a permutation of s if it contains the same characters with the same frequencies.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use sliding window technique with fixed window size equal to s.length().</li>
 *   <li>Precompute frequency array for the pattern string s (windowFreq).</li>
 *   <li>Maintain frequency array for current window in t (stringFreq) of size s.length().</li>
 *   <li>For each position i in t:
 *     <ul>
 *       <li>Add t[i] to the window frequency.</li>
 *       <li>If window size exceeds s.length(), remove t[i-s.length()] from the window.</li>
 *       <li>Check if current window matches the pattern frequency.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>This sliding window approach efficiently checks all possible substrings of length s.length() in t.</p>
 *
 * <p><b>Time Complexity:</b> O(n + m), where n = s.length(), m = t.length().<br>
 * <b>Space Complexity:</b> O(1), using fixed-size arrays of 26 characters.</p>
 *
 * @author Arpan Das
 * @since 21/01/2026
 */
public class PermutationInString {

    /**
     * Checks if s is a permutation (anagram) of any substring in t.
     *
     * <p>Uses sliding window with character frequency comparison. The window size is fixed
     * at s.length(), and we slide it across t while maintaining frequency counts.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input:  s = "ab", t = "eidbaooo"
     * Output: true
     * Explanation: "ba" in t is a permutation of "ab".
     *
     * Input:  s = "ab", t = "eidboaoo"
     * Output: false
     *
     * Input:  s = "abc", t = "cbaebabacd"
     * Output: true
     * Explanation: "cba" or "bac" in t are permutations of "abc".
     *
     * Input:  s = "hello", t = "ooolleoooleh"
     * Output: false
     * </pre>
     *
     * @param s the pattern string (shorter string)
     * @param t the text string (longer string containing potential permutation)
     * @return true if s is a permutation of any substring in t, false otherwise
     */
    public boolean checkInclusion(String s, String t) {
        // Early return if s is longer than t (impossible to contain)
        if (s.length() > t.length()) return false;

        // Precompute frequency of pattern string s
        int[] windowFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Frequency array for current window in t
        int[] stringFreq = new int[26];

        // Slide window across t
        for (int i = 0; i < t.length(); i++) {
            // Add current character to window
            stringFreq[t.charAt(i) - 'a']++;

            // Remove character that slides out of window (when window is full size)
            if (i >= s.length()) {
                stringFreq[t.charAt(i - s.length()) - 'a']--;
            }

            // Check if current window matches pattern
            if (matches(windowFreq, stringFreq)) return true;
        }
        return false;
    }

    /**
     * Helper method to check if two frequency arrays are identical.
     *
     * <p>Compares each of the 26 character frequencies to determine if the current
     * window in t matches the pattern s exactly.</p>
     *
     * @param windowFreq frequency array of pattern string s
     * @param stringFreq frequency array of current window in t
     * @return true if frequencies match exactly, false otherwise
     */
    private boolean matches(int[] windowFreq, int[] stringFreq) {
        for (int i = 0; i < 26; i++) {
            if (windowFreq[i] != stringFreq[i]) return false;
        }
        return true;
    }
}
