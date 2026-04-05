package HorizontalScanningAKAPrefixScanning;

/**
 * Utility class to find the longest common prefix among an array of strings.
 *
 * <p>Given an array of strings, find the longest common prefix string amongst them. If there is
 * no common prefix, return an empty string.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>If the array is null or empty, return an empty string.</li>
 *   <li>If the array has only one string, that string is the longest common prefix.</li>
 *   <li>Use the first string as the initial candidate prefix.</li>
 *   <li>For each subsequent string, compare character‑by‑character with the current prefix
 *       up to the minimum length of the two strings.</li>
 *   <li>Truncate the prefix to the last matching index, then repeat with the next string.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(S) where S is the sum of all characters in the input array.<br>
 * <b>Space Complexity:</b> O(1) if we don’t count the returned string; otherwise O(m) for the longest prefix.</p>
 *
 * @author Arpan Das
 * @since 05/04/2026
 */
public class LongestCommonPrefix {

    /**
     * Returns the longest common prefix among an array of strings.
     *
     * <p>The prefix is defined as the maximal substring starting from index 0 that appears
     * in all strings. If the array is null, empty, or no character is common at index 0,
     * an empty string is returned.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Explanation:
     *   "fl" is the longest prefix that appears in all three strings.
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation:
     *   No common prefix exists among the three strings.
     * </pre>
     *
     * @param strs array of non‑null strings; may be empty
     * @return the longest common prefix, or "" if none exists
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            int minLength = Math.min(pre.length(), strs[i].length());
            while (j < minLength) {
                if (pre.charAt(j) == strs[i].charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            pre = pre.substring(0, j);
        }
        return pre;
    }
}
