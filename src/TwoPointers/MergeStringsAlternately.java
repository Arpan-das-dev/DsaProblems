package TwoPointers;

/**
 * Utility class to merge two strings alternately.
 *
 * <p>Given two strings word1 and word2, merge them by taking characters alternately
 * from each string. If one string is longer than the other, append the remaining characters
 * of the longer string at the end.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Determine the length of the shorter string using Math.min.</li>
 *   <li>Use a StringBuilder to build the result by appending characters from word1 and word2
 *       alternately up to the length of the shorter string.</li>
 *   <li>Identify the longer string and append any remaining characters from its end.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(m + n) where m = word1.length(), n = word2.length().<br>
 * <b>Space Complexity:</b> O(m + n) for the StringBuilder (result).</p>
 *
 * @author Arpan Das
 * @since 10/04/2026
 */
public class MergeStringsAlternately {

    /**
     * Merges two strings alternately and returns the result.
     *
     * <p>Characters are taken from word1 and word2 alternately (word1[0], word2[0], word1[1], word2[1], ...).
     * If one string is longer, the remaining characters of the longer string are appended at the end.
     * If either string is null, treat it as an empty string.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: word1 = "abc", word2 = "pqr"
     * Output: "apbqcr"
     * Explanation:
     *   Alternately take characters from word1 and word2.
     *
     * Input: word1 = "ab", word2 = "pqrs"
     * Output: "apbqrs"
     * Explanation:
     *   After "apbq", append remaining "rs" from word2.
     * </pre>
     *
     * @param word1 first non‑null string (maybe empty)
     * @param word2 second non‑null string (maybe empty)
     * @return merged string with alternated characters and remaining tail
     */
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null) word1 = "";
        if (word2 == null) word2 = "";

        int min = Math.min(word1.length(), word2.length());
        String bigger = word1.length() > word2.length() ? word1 : word2;

        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < min) {
            res.append(word1.charAt(idx));
            res.append(word2.charAt(idx));
            idx++;
        }

        if (idx < bigger.length()) {
            res.append(bigger.substring(idx));
        }
        return res.toString();
    }
}