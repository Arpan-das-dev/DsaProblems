package Greedy;

/**
 * Utility class to determine whether a target triplet can be formed by merging given triplets.
 *
 * <p>Given a list of triplets where each triplet contains three integers, determine whether it is
 * possible to select some of them and merge them to form the target triplet. When merging triplets,
 * the resulting triplet is formed by taking the maximum value at each index.</p>
 *
 * <p>This problem is part of <b>{@code NeetCode 150}</b>.</p>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Iterate through each triplet in the input array.</li>
 *   <li>Ignore any triplet that has a value greater than the corresponding target value,
 *       because such a triplet can never contribute to a valid merge.</li>
 *   <li>Track whether each target position can be matched exactly by at least one valid triplet.</li>
 *   <li>If all three positions can be matched, return {@code true}.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n) where n = triplets.length.<br>
 * <b>Space Complexity:</b> O(1).</p>
 *
 * @author Arpan Das
 * @since 29/03/2026
 */
public class MergeTripletToFormTriplet {

    /**
     * Returns whether the target triplet can be formed by merging selected triplets.
     *
     * <p>A triplet is considered usable only if each of its values is less than or equal to the
     * corresponding value in the target triplet. The target can be formed if there exists at least
     * one valid triplet contributing each target position exactly.</p>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
     * Output: true
     * Explanation:
     *   [2,5,3] contributes target[0] = 2
     *   [1,7,5] contributes target[1] = 7 and target[2] = 5
     *   Merging them forms [2,7,5]
     *
     * Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
     * Output: false
     * Explanation:
     *   Every valid merge exceeds the target at index 1, so the target cannot be formed
     * </pre>
     *
     * @param triplets the list of available triplets
     * @param target the required target triplet
     * @return {@code true} if the target triplet can be formed; {@code false} otherwise
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean firstMax = false, secondMax = false, thirdMax = false;

        for (int[] trip : triplets) {
            if (trip[0] > target[0] || trip[1] > target[1] || trip[2] > target[2]) {
                continue;
            }

            if (trip[0] == target[0]) firstMax = true;
            if (trip[1] == target[1]) secondMax = true;
            if (trip[2] == target[2]) thirdMax = true;

            if (firstMax && secondMax && thirdMax) return true;
        }
        return firstMax && secondMax && thirdMax;
    }
}
