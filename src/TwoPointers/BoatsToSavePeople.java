package TwoPointers;

import java.util.Arrays;

/**
 * Utility class to determine the minimum number of boats required to save people.
 *
 * <p>Given an array of people's weights and a boat limit (maximum weight per boat),
 * each boat can carry at most two people if their combined weight does not exceed the limit.
 * Find the minimum number of boats required to carry all people.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 250}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Sort the array so that lightest and heaviest people can be paired efficiently.</li>
 *   <li>Use a two‑pointer technique: left at the start (lightest remaining) and right at the end (heaviest).</li>
 *   <li>Always place the heaviest person on a new boat, then check if the lightest remaining person can
 *       share that boat (i.e., if their weight is ≤ the remaining capacity).</li>
 *   <li>Move the left pointer forward if the lightest person can share; move the right pointer
 *       in all cases since the heaviest is always placed on a boat.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n log n) due to sorting; the two‑pointer pass is O(n).<br>
 * <b>Space Complexity:</b> O(1) extra space if sorting is in place.</p>
 *
 * @author Arpan Das
 * @since 06/04/2026
 */
public class BoatsToSavePeople {

    /**
     * Returns the minimum number of rescue boats required to save all people.
     *
     * <p>Each boat can carry at most two people, provided their combined weight does not exceed the
     * given limit. The method aims to minimize the number of boats used.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: people = [1,2], limit = 3
     * Output: 1
     * Explanation:
     *   [1,2] can share a single boat (1 + 2 = 3 ≤ limit).
     *
     * Input: people = [3,2,2,1], limit = 3
     * Output: 3
     * Explanation:
     *   [3], [2,1], [2] → three boats.
     * </pre>
     *
     * @param people non‑null array of person weights (all ≥ 1)
     * @param limit the maximum weight capacity per boat
     * @return the minimum number of boats required
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int remain = limit - people[right--]; // Place the heaviest person on a boat
            res++;
            if (left <= right && remain >= people[left]) {
                left++; // Lightest person shares this boat
            }
        }
        return res;
    }
}