package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to generate all permutations of given array.
 *
 * <p>Given array {@code nums} of distinct integers, return all permutations as list of lists.</p>
 *
 * <p><b>Approach:</b> Backtracking with Used Array</p>
 * <ul>
 *   <li>{@code used[]}: tracks which indices used in current permutation</li>
 *   <li>For each position, try all unused elements</li>
 *   <li>Mark used→add→recurse→backtrack (unmark+remove)</li>
 *   <li>Base case: when permutation complete, add copy to result</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(n! × n), n! permutations × n copy time.<br>
 * <b>Space Complexity:</b> O(n) recursion depth + O(n! × n) result.</p>
 *
 * @author Arpan Das
 * @since 06/03/2026
 */

public class PermutationsOfNumber {

    /**
     * Returns all possible permutations of nums.
     *
     * <p>Backtracking generates permutations by trying all unused elements at each position.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * All 3!=6 permutations ✓
     *
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]] ✓
     *
     * Input: nums = [1]
     * Output: [[1]] ✓
     *
     * Input: nums = []
     * Output: [[]] ✓
     * </pre>
     *
     * @param nums array of distinct integers
     * @return all permutations as list of lists
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        boolean[] used = new boolean[nums.length];
        backTrack(nums, result, used, new ArrayList<>());
        return result;
    }

    /**
     * Backtracking: builds permutation position by position.
     */
    private void backTrack(int[] nums, List<List<Integer>> result,
                           boolean[] used, List<Integer> currPerm) {
        // Base case: complete permutation found
        if (currPerm.size() == nums.length) {
            result.add(new ArrayList<>(currPerm));
            return;
        }

        // Try each unused number
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // Skip used indices

            // Choose: mark used and add to permutation
            used[i] = true;
            currPerm.add(nums[i]);

            backTrack(nums, result, used, currPerm);  // Recurse

            // Backtrack: unmark and remove
            used[i] = false;
            currPerm.removeLast();
        }
    }
}

