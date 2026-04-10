package Greedy;

import java.util.Arrays;

/**
 * Utility class to reorganize a string so that no two adjacent characters are the same.
 *
 * <p>Given a string s, rearrange the characters so that no two identical characters
 * are adjacent. If no such arrangement is possible, return an empty string.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Count the frequency of each character using a 26‑element array (assuming lowercase letters).</li>
 *   <li>If the maximum frequency is more than (n + 1)/2, where n is the string length,
 *       it’s impossible to reorganize without adjacent duplicates.</li>
 *   <li>Repeatedly pick the two most frequent unused characters and append them to the result,
 *       decrementing their frequencies each time.</li>
 *   <li>If only one character remains, append it last.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = s.length, since the alphabet is fixed size (26 letters).<br>
 * <b>Space Complexity:</b> O(1) for the frequency array plus O(n) for the StringBuilder.</p>
 *
 * @author Arpan Das
 * @since 10/04/2026
 */
public class ReOrganizeString {

    /**
     * Returns a reorganized version of the string where no two adjacent characters are the same.
     *
     * <p>If the input is null or empty, an empty string is returned. If the reorganization
     * is impossible (e.g., one character appears more than half the string length),
     * an empty string is returned. Otherwise, characters are arranged greedily by picking
     * the most frequent available character at each step, interleaving with the next most frequent.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "aab"
     * Output: "aba"
     * Explanation:
     *   'a' appears twice, so we alternate between 'a' and 'b' to avoid adjacent 'a's.
     *
     * Input: s = "aaab"
     * Output: ""
     * Explanation:
     *   'a' appears 3 times in a string of length 4 → 3 > (4 + 1)/2 → impossible.
     * </pre>
     *
     * @param s non‑null string of lowercase letters; may be empty
     * @return reorganized string with no adjacent identical characters, or "" if impossible
     */
    public String reorganizeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if (maxFreq > (s.length() + 1) / 2) {
            return ""; // Impossible to reorganize without adjacent duplicates
        }

        StringBuilder res = new StringBuilder();
        while (res.length() < s.length()) {
            int maxFrequent = findMax(freq);
            appendAndDecrement(res, maxFrequent, freq);

            if (freq[maxFrequent] == 0) {
                continue; // Skip if no more of this character
            }

            int temp = freq[maxFrequent];
            freq[maxFrequent] = Integer.MIN_VALUE;
            int nextFrequent = findMax(freq);
            appendAndDecrement(res, nextFrequent, freq);

            freq[maxFrequent] = temp;
        }
        return res.toString();
    }

    /**
     * Appends the character corresponding to the given index to the StringBuilder and decrements its frequency.
     *
     * <p>The index is expected to be in the range 0–25, representing 'a'–'z'.</p>
     *
     * @param sb non‑null StringBuilder to append to
     * @param idx index of the character (0 = 'a', 25 = 'z')
     * @param freq frequency array of length 26
     */
    private void appendAndDecrement(StringBuilder sb, int idx, int[] freq) {
        char toAppend = (char) (idx + 'a');
        sb.append(toAppend);
        freq[idx]--;
    }

    /**
     * Returns the index of the character with the highest frequency in the array.
     *
     * <p>If all frequencies are -MIN_VALUE (removed), this returns an arbitrary index.</p>
     *
     * @param freq frequency array of length 26
     * @return index of the character with maximum frequency
     */
    private int findMax(int[] freq) {
        int index = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > freq[index]) {
                index = i;
            }
        }
        return index;
    }
}
