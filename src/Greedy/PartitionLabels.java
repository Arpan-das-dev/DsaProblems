package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to partition string into max non-overlapping substrings (NeetCode 150 sheet).
 *
 * <p>LeetCode 763: Given {@code s}, partition into max substrings where each letter appears in at most
 * one part. Return list of substring lengths.</p>
 *
 * <p><b>Approach:</b> Greedy Last Index Tracking</p>
 * <ul>
 *   <li>Track last index of each character</li>
 *   <li>For each position, extend partition to max last index</li>
 *   <li>Cut when current index catches up</li>
 * </ul>
 *
 * <p>{@code @code Time: O(n), Space: O(1) (fixed charset)}<p>
 *
 * @author Arpan Das
 * @since 27/03/2026
 * <p><b>Part of NeetCode 150 study plan</b></p>
 */

public class PartitionLabels {

    /**
     * Returns lengths of greedy partitions.
     *
     * <p>Each partition extends to cover all occurrences of its characters.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: s = "ababcbacadefegdehijhklij"
     * Partitions: [0-6:"ababcb a"], [8-14:"defegde"], [15-21:"hijhklij"]
     * Output: [7,7,7] ✓
     *
     * Input: s = "eccbcc"
     * "e"→1, "c"→5, "b"→3 → [0-5] → Output: [6]
     * </pre>
     *
     * @param s lowercase string
     * @return partition lengths
     */
    public List<Integer> partitionLabels(String s) {
        // Track last index of each char (O(1) space possible with array[26])
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // Extend partition end to cover all occurrences
            end = Math.max(end, lastIndex[currChar - 'a']);

            // Can partition here
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }

        return partitions;
    }
}
